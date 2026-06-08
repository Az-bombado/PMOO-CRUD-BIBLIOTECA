package com.Projec.CRUD.Biblioteca.controller;

import org.springframework.ui.Model;
import com.Projec.CRUD.Biblioteca.repository.EmprestimoRepository;
import com.Projec.CRUD.Biblioteca.repository.LivroRepository;
import com.Projec.CRUD.Biblioteca.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

//    @Autowired
//    private EmprestimoRepository emprestimoRepository;

    @GetMapping("/home")
    public String home(HttpSession session, Model model){

        Object usuarioLogado =
                session.getAttribute("usuarioLogado");

        if(usuarioLogado == null){
            return "redirect:/login";
        }

        model.addAttribute(
                "totalLivros",
                livroRepository.count()
        );

        model.addAttribute(
                "totalUsuarios",
                usuarioRepository.count()
        );

        model.addAttribute(
               "totalEmprestimos",
                emprestimoRepository.count()
        );

        return "/home/home";
    }

}