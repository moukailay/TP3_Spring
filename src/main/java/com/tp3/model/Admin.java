package com.tp3.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)

public class Admin extends Users {

    private String login;
    private String password;

    public Admin ( String nom , String prenom , String login , String password ) {
        super( nom , prenom );
        this.login = login;
        this.password = password;
    }
}