package com.tp3.DTO;

import lombok.Data;

@Data
public class UsersDTO {
    private Long idUser;
    private String nom;
    private String prenom;

    public UsersDTO () {
    }

    public UsersDTO ( String nom , String prenom ) {
        this.nom = nom;
        this.prenom = prenom;
    }

}
