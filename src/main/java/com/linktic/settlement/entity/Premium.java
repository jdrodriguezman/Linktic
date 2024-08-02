package com.linktic.settlement.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "premium")
@Getter
@Setter
public class Premium {

    @Id
    @Column(name = "code_protections")
    private int codeProtections;

    @Column(name = "minimum_age")
    private int minimumAge;

    @Column(name = "maximum_age")
    private int maximumAge;

    @Column(name = "premium_percentage", nullable = false)
    private double premiumPercentage;
}

