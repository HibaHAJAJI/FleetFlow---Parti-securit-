package com.fleetflow.Controller;


import com.fleetflow.Dto.VehiculeDto;
import com.fleetflow.Service.VehiculeService;
import com.fleetflow.enums.StatutVehicule;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/vehicule")
@RequiredArgsConstructor
public class VehiculeController {

    private final VehiculeService vehiculeService;

    @GetMapping("/disponibles")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @Operation(summary = "Lister les véhicules disponibles")
    public ResponseEntity<Page<VehiculeDto>> afficherVehiculDisponible(Pageable pageable){
        Page<VehiculeDto>disponibles=vehiculeService.getVehiculesDisponible(StatutVehicule.DISPONIBLE,pageable);
        return ResponseEntity.ok(disponibles);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Ajouter un nouveau véhicule")
    public ResponseEntity<VehiculeDto> ajouterVehicule(@Valid @RequestBody VehiculeDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculeService.addVehicule(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Modifier un véhicule par ID")
    public ResponseEntity<VehiculeDto>  modifierVehicule(@PathVariable Long id,@Valid @RequestBody VehiculeDto dto){
        return new ResponseEntity<>(vehiculeService.updateVehicule(id,dto), HttpStatus.OK) ;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Supprimer un véhicule par ID")
    public ResponseEntity<Void>  supprimerVehicule(@PathVariable Long id){
        vehiculeService.deleteVehicule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/statut")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @Operation(summary = "Filtrer les véhicules par statut")
    public ResponseEntity<Page<VehiculeDto>> findbyStatut(@RequestParam StatutVehicule status,Pageable pageable){
        return ResponseEntity.ok(vehiculeService.getVehiculeByStatut(status,pageable));
    }

    @GetMapping("/capacite/{seuil}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @Operation(summary = "Filtrer les véhicules ayant une capacité supérieure au seuil")
    public ResponseEntity<Page<VehiculeDto>>  findByCapaciteGreaterThan(@PathVariable double seuil,Pageable pageable){
        return ResponseEntity.ok(vehiculeService.getVehiculeCapaciteGreaterThan(seuil,pageable));
    }
}
