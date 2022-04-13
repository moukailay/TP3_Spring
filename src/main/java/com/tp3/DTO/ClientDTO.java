package com.tp3.DTO;

import lombok.Data;

@Data
public class ClientDTO extends UsersDTO {
    private String adresse;

    public ClientDTO ( String nom , String prenom , String adresse ) {
        super( nom , prenom );
        this.adresse = adresse;
    }
    public ClientDTO() {}
}
