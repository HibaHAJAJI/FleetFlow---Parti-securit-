package com.fleetflow.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chauffeur")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Chauffeur extends Users {

    private String telephone;

    private String permisType;

    private Boolean disponible;
}