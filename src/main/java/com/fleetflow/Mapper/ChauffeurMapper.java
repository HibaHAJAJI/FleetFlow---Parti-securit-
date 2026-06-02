package com.fleetflow.Mapper;

import com.fleetflow.Dto.ChauffeurDTO;
import com.fleetflow.Dto.ClientDto;
import com.fleetflow.Entity.Chauffeur;
import com.fleetflow.Entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChauffeurMapper {
    ChauffeurDTO toDTO(Chauffeur chauffeur);
    Chauffeur toEntity(ChauffeurDTO chauffeurDTO);

    List<ChauffeurDTO> toDTOs(List<Chauffeur> chauffeurs);

    @Mapping(target = "id", ignore = true)
    void updateChauffeurDto(ChauffeurDTO dto, @MappingTarget Chauffeur chauffeur);
}