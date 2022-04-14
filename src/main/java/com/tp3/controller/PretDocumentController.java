package com.tp3.controller;

import com.tp3.DTO.ClientDTO;
import com.tp3.execeptions.ClientNotFoundException;
import com.tp3.model.Client;
import com.tp3.model.Document;
import com.tp3.model.LivreDTO;
import com.tp3.model.PretDocument;
import com.tp3.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
public class PretDocumentController {

    private EmployeService employeService;

    @Autowired
    public PretDocumentController ( EmployeService employeService ) {
        this.employeService = employeService;
    }

    @GetMapping("/pretDocument")
    public String afficherListePret ( Model model ) {
        List<PretDocument> listePret = employeService.findAllPretDocumentEnCours();
        model.addAttribute( "listePret" , listePret );
        return "pretDocument";
    }

    @GetMapping("/pretDocument/nouveau")
    public String afficherFormulairePret ( Model model ) {
        List<LivreDTO> livres = employeService.listeLivre();
        List<Client> clients = employeService.listeClient();

        model.addAttribute( "listeLivre" , livres );
        model.addAttribute( "listeClient" , clients );

        model.addAttribute( "titrePage" , "Ajout nouveau emprunt" );
        return "formulairePretDocument";
    }

    @PostMapping("/pretDocument/enregistrer")
    private String EnregistrerLivre ( RedirectAttributes ra ,
                                      @RequestParam(name = "idLivre", defaultValue = "") String idLivre ,
                                      @RequestParam(name = "idClient", defaultValue = "") String idClient )
                                      throws ClientNotFoundException, ParseException {
        Document doc = employeService.getDocument( Integer.parseInt( idLivre ) );
        if ( doc.getNbExemplaire() > 0 ) {
            employeService.enregistrerPret( new Date() ,
                    employeService.getClient( Integer.parseInt( idClient ) ) ,
                    employeService.getDocument( Integer.parseInt( idLivre ) ) ,
                    "non retourné" );
            ra.addFlashAttribute( "message" , "L'emprunt a été sauvegardé" );
        } else {
            ra.addFlashAttribute( "message" , "Le document n'est pas disponible pour un emprunt !" );
        }
        return "redirect:/pretDocument";
    }

    @GetMapping("/pretDocument/confirmerRetour/{id}")
    public String supprimerClient ( @PathVariable("id") Long id , RedirectAttributes ra ) {
        try {
            PretDocument pretDoc = employeService.getPretDocument( id );
            Document doc = pretDoc.getDocument();
            doc.setNbExemplaire( doc.getNbExemplaire() + 1 );
            employeService.enregistrerDocument( doc );
            employeService.supprimerPret( id );
            ra.addFlashAttribute( "message" , "Retour d'un livre enregistré" );
        } catch (ClientNotFoundException e) {
            ra.addFlashAttribute( "message" , e.getMessage() );
        }
        return "redirect:/pretDocument";
    }

}
