package com.fleetflow.Controller;

import com.fleetflow.Dto.LivraisonDTO;
import com.fleetflow.Service.LivraisonService;
import com.fleetflow.enums.StatutLivraison;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/livraisons")
@RequiredArgsConstructor
@Tag(name = "Livraisons", description = "Gestion des livraisons")
public class LivraisonController {

    private final LivraisonService livraisonService;

    @GetMapping
    @Operation(summary = "Lister toutes les livraisons")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER','CHAUFFEUR')")
    public ResponseEntity<Page<LivraisonDTO>> getAllLivraisons(Pageable pageable) {
        return ResponseEntity.ok(livraisonService.getAllLivraisons(pageable));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @Operation(summary = "Trouver une livraison par ID")
    public ResponseEntity<LivraisonDTO> getLivraisonById(@PathVariable Long id) {
        return ResponseEntity.ok(livraisonService.getLivraisonById(id));
    }

    @PostMapping
    @Operation(summary = "Créer une livraison")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<LivraisonDTO> createLivraison(@Valid @RequestBody LivraisonDTO livraisonDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(livraisonService.createLivraison(livraisonDTO));
    }

    @PutMapping("/{id}/assigner")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @Operation(summary = "Assigner un chauffeur et un véhicule à une livraison")
    public ResponseEntity<LivraisonDTO> assigner(@PathVariable Long id, @RequestParam Long chauffeurId, @RequestParam Long vehiculeId) {
        return ResponseEntity.ok(livraisonService.assignerChauffeurEtVehicule(id, chauffeurId, vehiculeId));
    }

    @PutMapping("/{id}/statut")
    @Operation(summary = "Modifier le statut d'une livraison")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER','CHAUFFEUR')")
    public ResponseEntity<LivraisonDTO> modifierStatut(
            @PathVariable Long id,
            @RequestParam StatutLivraison statut) {
        return ResponseEntity.ok(livraisonService.modifierStatut(id, statut));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une livraison")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Void> deleteLivraison(@PathVariable Long id) {
        livraisonService.deleteLivraison(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/dates")
    @Operation(summary = "Livraisons entre deux dates")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Page<LivraisonDTO>> getByDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate debut,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin,
            Pageable pageable) {
        return ResponseEntity.ok(livraisonService.getLivraisonsBetweenDates(debut, fin, pageable));
    }

    @GetMapping("/ville")
    @Operation(summary = "Livraisons par ville de destination")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Page<LivraisonDTO>> getByVille(@RequestParam String ville,Pageable pageable) {
        return ResponseEntity.ok(livraisonService.getLivraisonsByVille(ville,pageable));
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Livraisons par client")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Page<LivraisonDTO>> getByClient(@PathVariable Long clientId,Pageable pageable) {
        return ResponseEntity.ok(livraisonService.getLivraisonsByClient(clientId,pageable));
    }

    @GetMapping("/statut")
    @Operation(summary = "Livraisons par statut")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Page<LivraisonDTO>> getByStatut(@RequestParam StatutLivraison statut,Pageable pageable) {
        return ResponseEntity.ok(livraisonService.getLivraisonsByStatut(statut,pageable));
    }
}