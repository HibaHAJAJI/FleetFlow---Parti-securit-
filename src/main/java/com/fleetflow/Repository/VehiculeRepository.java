package com.fleetflow.Repository;


import com.fleetflow.Entity.Vehicule;
import com.fleetflow.enums.StatutVehicule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    Page<Vehicule> findByStatut(StatutVehicule statut, Pageable pageable);
    Page<Vehicule> findByCapaciteGreaterThan(double seuil,Pageable pageable);

}
