package com.tp3.DTO;

import lombok.Data;

@Data
public class clientDTO extends UsersDTO {
    private String adresse;

    public clientDTO ( String nom , String prenom , String adresse ) {
        super( nom , prenom );
        this.adresse = adresse;
    }
}
