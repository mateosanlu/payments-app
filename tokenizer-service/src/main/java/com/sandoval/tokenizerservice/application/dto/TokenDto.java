package com.sandoval.tokenizerservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TokenDto {
    private String token;
    private String maskedCardNumber;
}
