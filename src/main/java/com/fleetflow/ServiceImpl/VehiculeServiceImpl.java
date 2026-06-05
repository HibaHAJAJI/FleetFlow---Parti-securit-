package com.fleetflow.ServiceImpl;

import com.fleetflow.Dto.VehiculeDto;
import com.fleetflow.Entity.Vehicule;
import com.fleetflow.Mapper.VehiculeMapper;
import com.fleetflow.Repository.VehiculeRepository;
import com.fleetflow.Service.VehiculeService;
import com.fleetflow.enums.StatutVehicule;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements VehiculeService {
    private final VehiculeMapper mapper;
    private final VehiculeRepository repos;


    @Override
    @Transactional
    public VehiculeDto addVehicule(VehiculeDto dto){
        Vehicule vehicule=mapper.toEntity(dto);
        return mapper.toDto(repos.save(vehicule));
    }

    @Override
    @Transactional
    public void deleteVehicule(Long id){
        Vehicule vehicule=repos.findById(id)
                .orElseThrow(()->new RuntimeException("Vehicule introvable !!!"));
        repos.delete(vehicule);
    }

    @Override
    @Transactional
    public VehiculeDto updateVehicule(Long id,VehiculeDto vehiculeDto){
        Vehicule vehicule=repos.findById(id)
                .orElseThrow(()->new RuntimeException("Vehicule introvble !!!"));
        mapper.updateVehiculeDto(vehiculeDto,vehicule);
        return mapper.toDto(repos.save(vehicule));
    }

    @Override
    @Transactional
    public Page<VehiculeDto> getVehiculesDisponible(StatutVehicule status, Pageable pageable){
        Page<Vehicule>vehicules=repos.findByStatut(StatutVehicule.DISPONIBLE,pageable);
        return vehicules.map(mapper::toDto);
    }

    @Override
    @Transactional
    public Page<VehiculeDto>getVehiculeByStatut(StatutVehicule statut,Pageable pageable){
        Page<Vehicule>vehicule=repos.findByStatut(statut,pageable);
        return vehicule.map(mapper::toDto);
    }

    @Override
    @Transactional
    public Page<VehiculeDto>getVehiculeCapaciteGreaterThan(double seuil,Pageable pageable){
        Page<Vehicule>vehiculeList=repos.findByCapaciteGreaterThan(seuil,pageable);
        return vehiculeList.map(mapper::toDto);
    }
}
