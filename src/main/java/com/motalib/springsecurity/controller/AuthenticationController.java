package com.motalib.springsecurity.controller;

import com.motalib.springsecurity.dto.JwtAuthenticationResponse;
import com.motalib.springsecurity.dto.RefreshTokenRequest;
import com.motalib.springsecurity.dto.SigninRequest;
import com.motalib.springsecurity.dto.SignupRequest;
import com.motalib.springsecurity.entity.User;
import com.motalib.springsecurity.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignupRequest signupRequest) {
     return ResponseEntity.ok(authenticationService.signUp(signupRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SigninRequest signupRequest) {
        return ResponseEntity.ok(authenticationService.signin(signupRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }

}
