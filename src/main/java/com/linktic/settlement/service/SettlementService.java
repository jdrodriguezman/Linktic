package com.linktic.settlement.service;

import com.linktic.settlement.dto.InsuredRequest;
import com.linktic.settlement.dto.ProtectionDTO;
import com.linktic.settlement.dto.SettlementResponse;
import com.linktic.settlement.entity.Insured;
import com.linktic.settlement.entity.Premium;
import com.linktic.settlement.entity.Protection;
import com.linktic.settlement.exception.ExcepcionSettlement;
import com.linktic.settlement.repository.InsuredRepository;
import com.linktic.settlement.repository.PremiumRepository;
import com.linktic.settlement.repository.ProtectionRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.linktic.settlement.util.DateUtils.calculateAge;

@Service
@RequiredArgsConstructor
public class SettlementService {


    private final InsuredRepository insuredRepository;

    private final ProtectionRepository protectionRepository;

    private final PremiumRepository premiumRepository;

    @Transactional(readOnly = true)
    public List<SettlementResponse> calculateSettlement(List<InsuredRequest> requestList) {
        List<SettlementResponse> responseList = new ArrayList<>();

        for (@Valid InsuredRequest request : requestList) {

            Optional<Insured> insuredOptional = insuredRepository
                    .findByIdentificationTypeAndIdentificationNumber(Integer.parseInt(request.getIdentificationType()), request.getIdentificationNumber());
            try {
                if (insuredOptional.isPresent()) {
                    Insured insured = insuredOptional.get();
                    double insuredValue = Double.parseDouble(request.getInsuredValue());
                    double totalValue = 0.0;
                    List<ProtectionDTO> applicableProtections = new ArrayList<>();
                    int insuredAge = calculateAge(insured.getBirthDate());
                    List<Protection> availableProtections = protectionRepository.findAll();
                    for (Protection protection : availableProtections) {
                        List<Premium> premiumOptional = premiumRepository
                                .findPremiumByCodeAndAge(protection.getCode(), insuredAge);
                        for (Premium premium : premiumOptional) {
                            double premiumValue = insuredValue * premium.getPremiumPercentage();
                            applicableProtections.add(new ProtectionDTO(protection.getCode(), protection.getName(), premiumValue));
                            totalValue += premiumValue;
                        }
                    }

                    SettlementResponse response = new SettlementResponse(
                            insured.getIdentificationType(),
                            insured.getIdentificationNumber(),
                            insuredValue,
                            applicableProtections.isEmpty() ? null : applicableProtections,
                            totalValue
                    );
                    responseList.add(response);
                }
            } catch (Exception e) {
                throw new ExcepcionSettlement("Documento " + insuredOptional.get().getIdentificationNumber() + " No Encontrado");
            }
        }

        return responseList;
    }
}
