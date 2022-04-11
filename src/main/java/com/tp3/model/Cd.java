package com.tp3.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)

public class Cd extends Document {
    private int duree;

    public Cd ( String titre ,
                String auteur ,
                String editeur ,
                int nbExemplaire ,
                Date datePub ,
                String genre ,
                int dureeMaxPret ,
                int duree ) {
        super( titre ,
                auteur ,
                editeur ,
                nbExemplaire ,
                datePub ,
                genre ,
                dureeMaxPret );
        this.duree = duree;
    }
}