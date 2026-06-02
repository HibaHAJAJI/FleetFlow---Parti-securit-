package com.fleetflow.ServiceImpl;

import com.fleetflow.Dto.VehiculeDto;
import com.fleetflow.Entity.Vehicule;
import com.fleetflow.Mapper.VehiculeMapper;
import com.fleetflow.Repository.VehiculeRepository;
import com.fleetflow.Service.VehiculeService;
import com.fleetflow.enums.StatutVehicule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements VehiculeService {
    private final VehiculeMapper mapper;
    private final VehiculeRepository repos;


    public VehiculeDto addVehicule(VehiculeDto dto){
        Vehicule vehicule=mapper.toEntity(dto);
        return mapper.toDto(repos.save(vehicule));
    }

    public void deleteVehicule(Long id){
        Vehicule vehicule=repos.findById(id)
                .orElseThrow(()->new RuntimeException("Vehicule introvable !!!"));
        repos.delete(vehicule);
    }

    public VehiculeDto updateVehicule(Long id,VehiculeDto vehiculeDto){
        Vehicule vehicule=repos.findById(id)
                .orElseThrow(()->new RuntimeException("Vehicule introvble !!!"));
        mapper.updateVehiculeDto(vehiculeDto,vehicule);
        return mapper.toDto(repos.save(vehicule));
    }

    public List<VehiculeDto> getVehiculesDisponible(StatutVehicule status){
        List<Vehicule>vehicules=repos.findByStatut(StatutVehicule.DISPONIBLE);
        return mapper.toDto(vehicules);
    }
    public List<VehiculeDto>getVehiculeByStatut(StatutVehicule statut){
        List<Vehicule>vehicule=repos.findByStatut(statut);
        return mapper.toDto(vehicule);
    }
    public List<VehiculeDto>getVehiculeCapaciteGreaterThan(double seuil){
        List<Vehicule>vehiculeList=repos.findByCapaciteGreaterThan(seuil);
        return mapper.toDto(vehiculeList);
    }
}
