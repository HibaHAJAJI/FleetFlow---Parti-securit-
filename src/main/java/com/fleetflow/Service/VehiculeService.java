package com.fleetflow.Service;


import com.fleetflow.Dto.VehiculeDto;
import com.fleetflow.enums.StatutVehicule;

import java.util.List;

public interface VehiculeService {

    VehiculeDto addVehicule(VehiculeDto dto);

    void deleteVehicule(Long id);

    VehiculeDto updateVehicule(Long id,VehiculeDto vehiculeDto);

    List<VehiculeDto> getVehiculesDisponible(StatutVehicule status);

    List<VehiculeDto>getVehiculeByStatut(StatutVehicule statut);

    List<VehiculeDto>getVehiculeCapaciteGreaterThan(double seuil);

}
