package com.Projec.CRUD.Biblioteca.controller;

import com.Projec.CRUD.Biblioteca.model.Usuario;
import com.Projec.CRUD.Biblioteca.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public String index(){
        return "redirect:/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(Usuario usuario) {
        service.cadastrar(usuario);

        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(Usuario usuario,
                        HttpSession session) {

        boolean valido = service.logar(usuario);

        if(valido){

            session.setAttribute(
                    "usuarioLogado",
                    usuario.getEmail()
            );

            return "redirect:/home";
        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/cadastro"  )
    public String cadastro() {
        return "auth/cadastro";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){

        session.invalidate();

        return "redirect:/login";
    }

}