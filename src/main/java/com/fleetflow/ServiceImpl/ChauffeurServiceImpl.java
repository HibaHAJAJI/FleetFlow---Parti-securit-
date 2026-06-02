package com.fleetflow.ServiceImpl;

import com.fleetflow.Dto.ChauffeurDTO;
import com.fleetflow.Entity.Chauffeur;
import com.fleetflow.Mapper.ChauffeurMapper;
import com.fleetflow.Repository.ChauffeurRepository;
import com.fleetflow.Service.ChauffeurService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChauffeurServiceImpl implements ChauffeurService {

    private final ChauffeurRepository chauffeurRepository;
    private final ChauffeurMapper chauffeurMapper;

    public Page<ChauffeurDTO> getAllChauffeurs(Pageable pageable) {
        Page<Chauffeur> chauffeurs = chauffeurRepository.findAll(pageable);
        return chauffeurs.map(chauffeurMapper::toDTO);
    }


    public ChauffeurDTO getChauffeurById(Long id) {
        Chauffeur chauffeur = chauffeurRepository.findById(id).orElseThrow();
        return chauffeurMapper.toDTO(chauffeur);
    }

    public ChauffeurDTO createChauffeur(ChauffeurDTO dto) {
        Chauffeur chauffeur = chauffeurMapper.toEntity(dto);
        chauffeur = chauffeurRepository.save(chauffeur);
        return chauffeurMapper.toDTO(chauffeur);
    }

    public ChauffeurDTO updateChauffeur(Long id, ChauffeurDTO dto) {

        Chauffeur chauffeur = chauffeurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chauffeur introuvable"));

        chauffeurMapper.updateChauffeurDto(dto, chauffeur);

        Chauffeur updatedChauffeur = chauffeurRepository.save(chauffeur);

        return chauffeurMapper.toDTO(updatedChauffeur);
    }

    public void deleteChauffeur(Long id) {
        if (!chauffeurRepository.existsById(id)) {
            throw new RuntimeException("Chauffeur non trouvé");
        }
        chauffeurRepository.deleteById(id);
    }

    public Page<ChauffeurDTO> getChauffeursdisponibles(Pageable pageable) {
        Page<Chauffeur> chauffeurs = chauffeurRepository.findByDisponibleTrue(pageable);
        return chauffeurs.map(chauffeurMapper::toDTO);
    }
}
