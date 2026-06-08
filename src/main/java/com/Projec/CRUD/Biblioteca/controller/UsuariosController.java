package com.Projec.CRUD.Biblioteca.controller;

import com.Projec.CRUD.Biblioteca.model.Usuario;
import com.Projec.CRUD.Biblioteca.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // LISTAR USUÁRIOS
    @GetMapping
    public String listarUsuarios(Model model,
                                 HttpSession session) {

        Object usuarioLogado =
                session.getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            return "redirect:/login";
        }

        List<Usuario> usuarios = usuarioRepository.findAll();

        model.addAttribute("usuarios", usuarios);

        return "home/usuarios.html";
    }
    @GetMapping("/buscar")
    public String buscarUsuarios(@RequestParam("nome") String nome,
                                 Model model,
                                 HttpSession session) {

        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }

        model.addAttribute("usuarios",
                usuarioRepository.findByNomeContainingIgnoreCase(nome));

        return "home/usuarios.html";
    }
}