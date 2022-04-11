package com.tp3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class Amende {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAmande;

    private double montant;
    private boolean statut;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Client client;
}
