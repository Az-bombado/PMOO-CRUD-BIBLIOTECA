package com.Projec.CRUD.Biblioteca.controller;

import com.Projec.CRUD.Biblioteca.model.Livro;
import com.Projec.CRUD.Biblioteca.repository.LivroRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    // LISTAR LIVROS

    @GetMapping
    public String mostrarPagina(Model model,
                                HttpSession session){

        Object usuario =
                session.getAttribute("usuarioLogado");

        if(usuario == null){
            return "redirect:/login";
        }

        List<Livro> livros =
                livroRepository.findAll();

        model.addAttribute("livros", livros);

        return "livros/livros";
    }

    // SALVAR LIVRO

    @PostMapping("/salvar")
    public String salvarLivro(Livro livro){

        livroRepository.save(livro);

        return "redirect:/livros";
    }

    // EXCLUIR LIVRO

    @GetMapping("/deletar/{id}")
    public String deletarLivro(@PathVariable Long id){

        livroRepository.deleteById(id);

        return "redirect:/livros";
    }

    @GetMapping("/editar/{id}")
    public String editarLivro(@PathVariable Long id, Model model){

        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        model.addAttribute("livro", livro);

        return "livros/editar";
    }
    @PostMapping("/atualizar")
    public String atualizarLivro(Livro livro){

        livroRepository.save(livro);

        return "redirect:/livros";
    }
}