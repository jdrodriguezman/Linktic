package com.linktic.settlement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "insured")
@Getter
@Setter
public class Insured {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identification_type", nullable = false)
    private Integer identificationType;

    @Column(name = "identification_number", nullable = false)
    private String identificationNumber;

    @Column(name = "surnames", nullable = false)
    private String surnames;

    @Column(name = "names", nullable = false)
    private String names;

    @Column(name = "gender", nullable = false)
    private Integer gender;

    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;




}
