package com.tp3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idDoc;

    private String titre;
    private String auteur;
    private String editeur;
    private int nbExemplaire;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datePub;
    private String genre;
    private int dureeMaxPret;

    public Document ( String titre ,
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