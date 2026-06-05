package com.fleetflow.Mapper;

import com.fleetflow.Dto.ChauffeurDTO;
import com.fleetflow.Entity.Chauffeur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ChauffeurMapper {

    ChauffeurDTO toDTO(Chauffeur chauffeur);

    @Mapping(target = "id", ignore = true)
    Chauffeur toEntity(ChauffeurDTO chauffeurDTO);

    @Mapping(target = "id", ignore = true)
    void updateChauffeurDto(ChauffeurDTO dto, @MappingTarget Chauffeur chauffeur);
}