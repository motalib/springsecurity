package com.motalib.springsecurity.services;

import com.motalib.springsecurity.dto.JwtAuthenticationResponse;
import com.motalib.springsecurity.dto.RefreshTokenRequest;
import com.motalib.springsecurity.dto.SigninRequest;
import com.motalib.springsecurity.dto.SignupRequest;
import com.motalib.springsecurity.entity.User;

public interface AuthenticationService {

    User signUp(SignupRequest signupRequest);

    JwtAuthenticationResponse signin(SigninRequest signinRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
