package com.fleetflow.Dto;
import jakarta.validation.constraints.NotBlank;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChauffeurDTO {
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    private String telephone;
    private String permisType;
    private Boolean disponible;
}