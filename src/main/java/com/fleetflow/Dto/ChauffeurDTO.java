package com.fleetflow.Dto;
import jakarta.validation.constraints.NotBlank;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChauffeurDTO extends UserDto {

    @NotBlank(message = "Le telephone est obligatoire")
    private String telephone;

    @NotBlank(message = "Le permisType est obligatoire")
    private String permisType;

    private Boolean disponible;
}