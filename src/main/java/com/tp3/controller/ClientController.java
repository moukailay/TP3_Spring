package com.tp3.controller;

import com.tp3.DTO.ClientDTO;
import com.tp3.model.Client;
import com.tp3.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClientController {

    private final EmployeService employeService;

    @Autowired
    public ClientController ( EmployeService employeService ) {
        this.employeService = employeService;
    }

    @GetMapping("/client")
    public String afficherListeClient(Model model) {
        List<Client> listeClient = employeService.listeClient();
        model.addAttribute("listeClient", listeClient);
        return "client";
    }

    @GetMapping("/client/nouveau")
    public String afficherFormulaireClient(Model model) {
        model.addAttribute("client", new ClientDTO());
        model.addAttribute("titrePage", "Ajout nouveau Client");
        return "formulaireClient";
    }

    @PostMapping("/client/enregistrer")
    private String EnregistrerClient(Client client, RedirectAttributes ra) {
        employeService.enregistrerClient(client.getNom(), client.getPrenom(), client.getAdresse());
        ra.addFlashAttribute("message", "Le client a été sauvegardé");
        return "redirect:/client";
    }

}
