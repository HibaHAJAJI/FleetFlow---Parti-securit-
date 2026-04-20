package com.fleetflow.Dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDto {

    private Long id;
    @NotBlank(message = "Le nom est obligatoire")
    private String name;
    @NotBlank(message = "L'Email est obligatoire")
    @Email(message = "Format email invalide")
    private String email;
    @NotBlank(message = "Le ville est obligatoire")
    private String ville;
    @NotBlank(message = "Le Telephone est obligatoire")
    @Size(min=2,max=12,message = "Le telephone doit contenir entre 2 et 12 chiffres")
    private String telephone;
}
