package com.linktic.settlement.repository;

import com.linktic.settlement.entity.Premium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PremiumRepository extends JpaRepository<Premium, Integer> {

    @Query("SELECT p FROM Premium p " +
            "WHERE p.codeProtections = :code " +
            "AND :age BETWEEN p.minimumAge AND p.maximumAge")
    List<Premium> findPremiumByCodeAndAge(int code, int age);
}
