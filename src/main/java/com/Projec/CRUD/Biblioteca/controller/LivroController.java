package com.Projec.CRUD.Biblioteca.controller;

import com.Projec.CRUD.Biblioteca.model.Livro;
import com.Projec.CRUD.Biblioteca.repository.LivroRepository;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @ResponseBody
    public Livro salvarLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @GetMapping
    public String mostrarPagina(Model model){

        List<Livro> livros = livroRepository.findAll();

        model.addAttribute("livros", livros);

        return "livros/livros";
    }
}