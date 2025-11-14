package com.example.lab10.controller;

import com.example.lab10.entity.Practicante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/practicantes/")
public class PractiController {

    @GetMapping
    public String listar(Model model) {

        return "practicantes/lista";
    }



}
