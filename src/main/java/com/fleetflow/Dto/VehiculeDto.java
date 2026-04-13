package com.fleetflow.Dto;

import com.fleetflow.enums.StatutVehicule;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class VehiculeDto {
    private Long id;
    @NotBlank(message = "Le matricul est obligatoire")
    private String matricule;
    @NotBlank(message = "Le type est obligatoire")
    private String type;
    @NotNull(message = "La capacite est obligatoire")
    @Positive(message = "la capacite doit etre positive")
    private Double capacite;
    @NotNull(message = "Le statut est obligatoire")
    private StatutVehicule statut;
}
