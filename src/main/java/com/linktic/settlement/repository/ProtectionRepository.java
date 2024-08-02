package com.linktic.settlement.repository;

import com.linktic.settlement.entity.Protection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtectionRepository extends JpaRepository<Protection, Long> {

}
