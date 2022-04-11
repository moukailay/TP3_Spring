package com.tp3.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)

public class Employe extends Users {
    private String adresse;

    public Employe ( String nom , String prenom , String adresse ) {
        super( nom , prenom );
        this.adresse = adresse;
    }
}
