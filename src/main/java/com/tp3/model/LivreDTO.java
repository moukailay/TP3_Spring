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
@ToString(callSuper = true, includeFieldNames = true)
public class LivreDTO extends Document {
    private int nbPages;

    public LivreDTO ( String titre ,
                      String auteur ,
                      String editeur ,
                      int nbExemplaire ,
                      Date datePub ,
                      String genre ,
                      int dureeMaxPret ,
                      int nbPages ) {
        super( titre ,
                auteur ,
                editeur ,
                nbExemplaire ,
                datePub ,
                genre ,
                dureeMaxPret );
        this.nbPages = nbPages;
    }
}