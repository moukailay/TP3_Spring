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
public class UsersDTO {
    private Long idUser;

    @NotNull
    @NotBlank
    @Size(min=5)
    private String nom;

    @NotNull
    @NotBlank
    @Size(min=5)
    private String prenom;



    public UsersDTO ( String nom , String prenom ) {
        this.nom = nom;
        this.prenom = prenom;
    }

}
