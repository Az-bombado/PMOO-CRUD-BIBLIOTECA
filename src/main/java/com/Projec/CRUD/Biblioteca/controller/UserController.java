package com.Projec.CRUD.Biblioteca.controller;

import com.Projec.CRUD.Biblioteca.model.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;

public class UserController {
    @GetMapping("/usuarios")
    public String usuarios(HttpSession session){

        Usuario usuario =
                (Usuario) session.getAttribute("usuarioLogado");

        if(usuario == null){
            return "redirect:/login";
        }

        if(!usuario.getPermissao().equals("ADMIN")){
            return "redirect:/home";
        }

        return "usuarios";
    }
}
