package com.tp3.controller;

import com.tp3.model.LivreDTO;
import com.tp3.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LivreController {

    private EmployeService employeService;

    @Autowired
    public LivreController ( EmployeService employeService ) {
        this.employeService = employeService;
    }

    @GetMapping("/livre")
    public String afficherListeLivre(Model model) {

        List<LivreDTO> listeLivre = employeService.listeLivre();
        model.addAttribute("listeLivre", listeLivre);
        return "livre";
    }

    @GetMapping("/livre/nouveau")
    public String afficherFormulaireLivre ( Model model ) {
        model.addAttribute("livre", new com.tp3.DTO.LivreDTO());
        model.addAttribute("titrePage", "Ajout nouveau LivreDTO");
        return "formulaireLivre";
    }

    @PostMapping("/livre/enregistrer")
    private String EnregistrerLivre( LivreDTO livreDTO, RedirectAttributes ra) {
        employeService.enregistrerLivre(livreDTO.getTitre(),
                livreDTO.getAuteur(),
                livreDTO.getEditeur(),
                livreDTO.getNbExemplaire(),
                livreDTO.getDatePub(),
                livreDTO.getGenre(),
                livreDTO.getDureeMaxPret(),
                livreDTO.getNbPages());
        ra.addFlashAttribute("message", "Le livre a été sauvegardé");
        return "redirect:/livre";
    }
}
