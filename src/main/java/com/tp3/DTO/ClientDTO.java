package com.tp3.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class ClientDTO extends UsersDTO {

    @NotNull
    @NotBlank
    @Size(min=5)
    private String adresse;

    public ClientDTO ( String nom , String prenom , String adresse ) {
        super( nom , prenom );
        this.adresse = adresse;
    }

}
