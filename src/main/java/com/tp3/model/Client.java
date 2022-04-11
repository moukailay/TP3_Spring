package com.tp3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Client extends Users {

    private String adresse;

    @OneToMany(targetEntity = Amende.class, mappedBy = "client")
    @ToString.Exclude
    private List<Amende> amendes;

    @OneToMany(targetEntity = PretDocument.class, mappedBy = "client")

    @ToString.Exclude
    private List<PretDocument> pretDocuments;

    public Client(String nom, String prenom, String adresse) {
        super(nom, prenom);
        this.adresse = adresse;
    }
}