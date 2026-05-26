package com.Projec.CRUD.Biblioteca.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(HttpSession session){

        Object usuarioLogado =
                session.getAttribute("usuarioLogado");

        if(usuarioLogado == null){
            return "redirect:/login";
        }

        return "/home/home";
    }

}