package com.example.lab10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/multiverso")
public class MultiversoController {


    @GetMapping("")
    public String mostrarMultiverso(Model model, RedirectAttributes redirectAttributes) {



        return "multiverso";
    }



}
