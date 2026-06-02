package com.fleetflow.Service;


import com.fleetflow.Dto.VehiculeDto;
import com.fleetflow.enums.StatutVehicule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface VehiculeService {

    VehiculeDto addVehicule(VehiculeDto dto);

    void deleteVehicule(Long id);

    VehiculeDto updateVehicule(Long id,VehiculeDto vehiculeDto);

    Page<VehiculeDto> getVehiculesDisponible(StatutVehicule status, Pageable pageable);

    Page<VehiculeDto>getVehiculeByStatut(StatutVehicule statut,Pageable pageable);

    Page<VehiculeDto>getVehiculeCapaciteGreaterThan(double seuil, Pageable pageable);

}
