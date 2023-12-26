package com.motalib.springsecurity.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RefreshTokenRequest {

    private String token;
}
