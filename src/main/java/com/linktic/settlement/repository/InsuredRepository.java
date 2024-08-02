package com.linktic.settlement.repository;

import com.linktic.settlement.entity.Insured;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InsuredRepository extends JpaRepository<Insured, Long> {

    Optional<Insured> findByIdentificationTypeAndIdentificationNumber(Integer identificationType, String identificationNumber);
}
