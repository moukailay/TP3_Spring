package com.tp3.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    @NotNull
    @NotBlank
    @Size(min=5)
    private String nom;

    @NotNull
    @NotBlank
    @Size(min=5)
    private String prenom;

    public Users ( String nom , String prenom ) {
        this.nom = nom;
        this.prenom = prenom;
    }
}