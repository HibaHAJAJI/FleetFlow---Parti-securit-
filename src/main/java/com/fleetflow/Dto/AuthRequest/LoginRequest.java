package com.fleetflow.Dto.AuthRequest;


import lombok.Data;

@Data
public class LoginRequest {

    private String username;

    private String password;
}
