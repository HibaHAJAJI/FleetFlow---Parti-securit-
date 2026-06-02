package com.fleetflow.Service;


import com.fleetflow.Dto.LivraisonDTO;
import com.fleetflow.enums.StatutLivraison;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;
import java.util.List;


public interface LivraisonService {

    Page<LivraisonDTO> getAllLivraisons(Pageable pageable);

    LivraisonDTO getLivraisonById(Long id);

    LivraisonDTO createLivraison(LivraisonDTO livraisonDTO);

    LivraisonDTO assignerChauffeurEtVehicule(Long livraisonId, Long chauffeurId, Long vehiculeId);

    LivraisonDTO modifierStatut(Long id, StatutLivraison nouveauStatut);

    void deleteLivraison(Long id);

    Page<LivraisonDTO> getLivraisonsBetweenDates(LocalDate debut, LocalDate fin,Pageable pageable);

    Page<LivraisonDTO> getLivraisonsByVille(String ville,Pageable pageable);

    Page<LivraisonDTO> getLivraisonsByClient(Long clientId,Pageable pageable);

    Page<LivraisonDTO> getLivraisonsByStatut(StatutLivraison statut,Pageable pageable);

}