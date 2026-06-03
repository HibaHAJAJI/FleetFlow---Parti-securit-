package com.fleetflow.Controller;


import com.fleetflow.Dto.AuthRequest.AuthResponse;
import com.fleetflow.Dto.AuthRequest.LoginRequest;
import com.fleetflow.Dto.UserDto;
import com.fleetflow.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse>  register(@Valid @RequestBody UserDto dto){
      return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest login){
      return ResponseEntity.ok(authService.login(login));
    }
}
