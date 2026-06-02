package com.fleetflow.Controller;


import com.fleetflow.Dto.VehiculeDto;
import com.fleetflow.Service.VehiculeService;
import com.fleetflow.enums.StatutVehicule;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicule")
public class VehiculeController {
    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @GetMapping("/disponibles")
    public ResponseEntity<Page<VehiculeDto>> afficherVehiculDisponible(Pageable pageable){
        Page<VehiculeDto>disponibles=vehiculeService.getVehiculesDisponible(StatutVehicule.DISPONIBLE,pageable);
        return ResponseEntity.ok(disponibles);
    }

    @PostMapping("/ajouter")
    public VehiculeDto ajouterVehicule(@Valid @RequestBody VehiculeDto dto){
        return vehiculeService.addVehicule(dto);
    }
    @PutMapping("/modifier/{id}")
    public ResponseEntity<VehiculeDto>  modifierVehicule(@Valid @PathVariable Long id,@RequestBody VehiculeDto dto){
        return new ResponseEntity<>(vehiculeService.updateVehicule(id,dto), HttpStatus.CREATED) ;
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerVehicule(@PathVariable Long id){
        vehiculeService.deleteVehicule(id);
    }

    @GetMapping("/statut")
    public Page<VehiculeDto>findbyStatut(@RequestParam StatutVehicule status,Pageable pageable){
        return vehiculeService.getVehiculeByStatut(status,pageable);
    }

    @GetMapping("/capacite/{seuil}")
    public Page<VehiculeDto> findByCapaciteGreaterThan(@PathVariable double seuil,Pageable pageable){
        return vehiculeService.getVehiculeCapaciteGreaterThan(seuil,pageable);
    }
}
