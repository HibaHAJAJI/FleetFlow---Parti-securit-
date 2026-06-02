package com.fleetflow.Service;


import com.fleetflow.Dto.ChauffeurDTO;

import java.util.List;


public interface ChauffeurService {

    List<ChauffeurDTO> getAllChauffeurs();

    ChauffeurDTO getChauffeurById(Long id);

    ChauffeurDTO createChauffeur(ChauffeurDTO dto);

    ChauffeurDTO updateChauffeur(Long id, ChauffeurDTO dto);

    void deleteChauffeur(Long id);

    List<ChauffeurDTO> getChauffeursdisponibles();


}