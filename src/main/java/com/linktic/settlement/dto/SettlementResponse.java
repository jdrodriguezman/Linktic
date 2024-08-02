package com.linktic.settlement.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettlementResponse {

    private Integer identificationType;
    private String identificationNumber;
    private Double insuredValue;
    private List<ProtectionDTO> settlement;
    private Double totalValue;


    public SettlementResponse(Integer identificationType, String identificationNumber, double insuredValue, List<ProtectionDTO> settlement, double totalValue) {
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.insuredValue = insuredValue;
        this.settlement = settlement;
        this.totalValue = totalValue;
    }

}
