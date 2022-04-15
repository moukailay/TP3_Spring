package com.tp3.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class UsersDTO {
    private Long idUser;
    private String nom;
    private String prenom;



    public UsersDTO ( String nom , String prenom ) {
        this.nom = nom;
        this.prenom = prenom;
    }

}
