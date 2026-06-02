package com.fleetflow.Configuration;


import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final static String secret_Key="my-healthcare-secret-key-1234567890";




    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }


}
