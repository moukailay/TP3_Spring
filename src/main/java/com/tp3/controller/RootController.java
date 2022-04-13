package com.tp3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping(value = { "" , "/" , "/index" , "/index.html" })
    public String registerClient() {
        return "index";
    }
}
