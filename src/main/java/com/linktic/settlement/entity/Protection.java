package com.linktic.settlement.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "protections")
@Getter
@Setter
public class Protection {

    @Id
    @Column(name = "code")
    private Integer code;

    @Column(name = "name", nullable = false)
    private String name;
}
