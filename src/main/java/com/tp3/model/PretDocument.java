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
public class PretDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPret;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datePret;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRetour;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "idDoc")
    private Document document;

    private String statutRetour;

    public PretDocument ( Date datePret ,
                          Date dateRetour ,
                          Client client ,
                          Document document ,
                          String statutRetour ) {
        this.datePret = datePret;
        this.dateRetour = dateRetour;
        this.client = client;
        this.document = document;
        this.statutRetour = statutRetour;
    }

    public PretDocument ( Date datePret ,
                          Client client ,
                          Document document ,
                          String statutRetour ) {
        this.datePret = datePret;
        this.client = client;
        this.document = document;
        this.statutRetour = statutRetour;
    }
}

