package com.linktic.settlement.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProtectionDTO {

    private Integer protectionCode;
    private String protectionName;
    private Double premiumValue;

    public ProtectionDTO(Integer code, String name, double valorPrima) {
    }
}
