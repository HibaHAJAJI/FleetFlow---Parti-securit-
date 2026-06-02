package com.fleetflow.Service;


import com.fleetflow.Dto.ChauffeurDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ChauffeurService {

    Page<ChauffeurDTO> getAllChauffeurs(Pageable pageable);

    ChauffeurDTO getChauffeurById(Long id);

    ChauffeurDTO createChauffeur(ChauffeurDTO dto);

    ChauffeurDTO updateChauffeur(Long id, ChauffeurDTO dto);

    void deleteChauffeur(Long id);

    Page<ChauffeurDTO> getChauffeursdisponibles(Pageable pageable);


}