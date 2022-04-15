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
public class ClientDTO extends UsersDTO {
    private String adresse;

    public ClientDTO ( String nom , String prenom , String adresse ) {
        super( nom , prenom );
        this.adresse = adresse;
    }

}
