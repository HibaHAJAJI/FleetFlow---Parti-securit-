package com.fleetflow.Repository;


import com.fleetflow.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Boolean findByEmail(String Email);
}
