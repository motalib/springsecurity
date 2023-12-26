package com.motalib.springsecurity.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class JwtAuthenticationResponse {

    private String token;
    private String  refreshToken;
}
