package com.linktic.settlement.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class InsuredRequest {

    @NotNull
    private String identificationType;

    @NotBlank
    private String identificationNumber;

    @NotNull
    private String insuredValue;

}
