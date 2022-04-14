package com.tp3.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class DocumentDTO {
    private long idDoc;

    private String titre;
    private String auteur;
    private String editeur;
    private int nbExemplaire;

    private Date datePub;

    private String genre;
    private int dureeMaxPret;

    public DocumentDTO () {
    }

    public DocumentDTO ( String titre ,
                         String auteur ,
                         String editeur ,
                         int nbExemplaire ,
                         Date datePub ,
                         String genre ,
                         int dureeMaxPret ) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.nbExemplaire = nbExemplaire;
        this.datePub = datePub;
        this.genre = genre;
        this.dureeMaxPret = dureeMaxPret;
    }
}
