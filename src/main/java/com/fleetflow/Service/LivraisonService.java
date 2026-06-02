package com.fleetflow.Service;


import com.fleetflow.Dto.LivraisonDTO;
import com.fleetflow.enums.StatutLivraison;

import java.time.LocalDate;
import java.util.List;


public interface LivraisonService {

    List<LivraisonDTO> getAllLivraisons();

    LivraisonDTO getLivraisonById(Long id);

    LivraisonDTO createLivraison(LivraisonDTO livraisonDTO);

    LivraisonDTO assignerChauffeurEtVehicule(Long livraisonId, Long chauffeurId, Long vehiculeId);

    LivraisonDTO modifierStatut(Long id, StatutLivraison nouveauStatut);

    void deleteLivraison(Long id);

    List<LivraisonDTO> getLivraisonsBetweenDates(LocalDate debut, LocalDate fin);

    List<LivraisonDTO> getLivraisonsByVille(String ville);

    List<LivraisonDTO> getLivraisonsByClient(Long clientId);

    List<LivraisonDTO> getLivraisonsByStatut(StatutLivraison statut);

}