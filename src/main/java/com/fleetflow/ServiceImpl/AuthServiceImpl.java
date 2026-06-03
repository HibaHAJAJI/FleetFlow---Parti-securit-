package com.fleetflow.ServiceImpl;


import com.fleetflow.Configuration.JwtService;
import com.fleetflow.Dto.AuthRequest.AuthResponse;
import com.fleetflow.Dto.AuthRequest.LoginRequest;
import com.fleetflow.Dto.UserDto;
import com.fleetflow.Entity.Users;
import com.fleetflow.Mapper.UserMapper;
import com.fleetflow.Repository.UserRepository;
import com.fleetflow.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl  implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;


    @Override
    public AuthResponse register(UserDto dto){
        if(userRepository.findByUsername(dto.getUsername()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT,("Username déjà exists"));
        }
        if(userRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT,("Email déjà exists"));
        }
        Users user =userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());

        Users saved = userRepository.save(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(saved.getUsername());
        String token = jwtService.generateToken(userDetails);

        return new AuthResponse(token);
    }


    @Override
    public AuthResponse login(LoginRequest dto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                                                        )
        );

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(dto.getUsername());

        String token = jwtService.generateToken(userDetails);
        return new AuthResponse(token);

    }
}
