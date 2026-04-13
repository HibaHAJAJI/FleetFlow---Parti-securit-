package com.fleetflow.Dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientDto {

    private Long id;
    @NotBlank(message = "Le nom est obligatoire")
    private String name;
    @NotBlank(message = "Le Email est obligatoire")
    @Email(message = "Format email invalide")
    private String email;
    @NotBlank(message = "Le ville est obligatoire")
    private String ville;
    @NotBlank(message = "Le Telephone est obligatoire")
    @Size()
    private String telephone;
}
