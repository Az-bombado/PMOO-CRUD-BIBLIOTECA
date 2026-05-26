package com.Projec.CRUD.Biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LivroController {

    @GetMapping("livro")
    public String livro(){



        return "livros.html";
    }
}