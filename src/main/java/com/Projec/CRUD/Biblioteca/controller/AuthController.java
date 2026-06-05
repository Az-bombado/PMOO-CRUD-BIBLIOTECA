package com.Projec.CRUD.Biblioteca.controller;

import com.Projec.CRUD.Biblioteca.model.CadastroDTO;
import com.Projec.CRUD.Biblioteca.model.LoginDTO;
import com.Projec.CRUD.Biblioteca.service.UsuarioService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/cadastro")
    public String cadastroPage() {
        return "auth/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(CadastroDTO dto) {

        service.cadastrar(dto);

        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(LoginDTO dados,
                        HttpSession session) {

        boolean valido =
                service.logar(
                        dados.getEmail(),
                        dados.getSenha()
                );

        if (valido) {

            session.setAttribute(
                    "usuarioLogado",
                    dados.getEmail()
            );

            return "redirect:/home";
        }

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
}