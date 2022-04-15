package com.tp3.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class DocumentDTO {
    private long idDoc;

    @NotNull
    @NotBlank
    @Size(min=5, max = 100)
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
