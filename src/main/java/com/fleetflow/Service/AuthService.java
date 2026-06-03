package com.fleetflow.Service;


import com.fleetflow.Dto.AuthRequest.AuthResponse;
import com.fleetflow.Dto.AuthRequest.LoginRequest;
import com.fleetflow.Dto.UserDto;

public interface AuthService {

    AuthResponse register(UserDto dto);

    AuthResponse login(LoginRequest dto);
}
