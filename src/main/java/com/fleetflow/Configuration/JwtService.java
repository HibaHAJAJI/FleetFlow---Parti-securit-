package com.fleetflow.Configuration;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public class JwtService {

    private final static String secret_Key="4f7a9c2e8d1b6a3f9e5c7d2a8b1f6e9c4a7d3b8e1f5c9a2d6e8b4f7a1c3d5e9";


    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims,T>claimsResolver){
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }


    private String generateToken(HashMap<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+60*60*1000*24))
                .signWith(getSignInKey(),SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username =extractUsername(token);
        return username.equals(userDetails.getUsername() )&& !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    private Key getSignInKey() {
        return Keys.hmacShaKeyFor(secret_Key.getBytes());
    }

}
