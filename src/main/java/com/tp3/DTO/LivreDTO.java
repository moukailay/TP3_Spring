package com.tp3.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class LivreDTO extends DocumentDTO{
  private int nbPages;

   public LivreDTO ( int nbPages,
                     String titre,
                     String auteur,
                     String editeur,
                     int nbExemplaires,
                     Date datePub,
                     String genre,
                     int dureeMaxPret
                     ) {
      super(titre,
              auteur,
              editeur,
              nbExemplaires,
              datePub,
              genre,
              dureeMaxPret);
      this.nbPages = nbPages;
   }
}
