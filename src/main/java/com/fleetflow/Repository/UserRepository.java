package com.fleetflow.Repository;

import com.fleetflow.Entity.Users;

import java.util.Optional;

public interface UserRepository {

    Optional<Users> findByUsername(String username);

    Optional<Users> findByEmail(String email);
}
