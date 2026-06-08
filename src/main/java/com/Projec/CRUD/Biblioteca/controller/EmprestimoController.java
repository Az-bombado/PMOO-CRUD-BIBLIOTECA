package com.Projec.CRUD.Biblioteca.controller;

import com.Projec.CRUD.Biblioteca.model.Emprestimo;
import com.Projec.CRUD.Biblioteca.model.Leitor;
import com.Projec.CRUD.Biblioteca.model.Livro;
import com.Projec.CRUD.Biblioteca.model.Usuario;

import com.Projec.CRUD.Biblioteca.repository.EmprestimoRepository;
import com.Projec.CRUD.Biblioteca.repository.LivroRepository;
import com.Projec.CRUD.Biblioteca.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @GetMapping("/novo/{id}")
    public String novoEmprestimo(
            @PathVariable Long id,
            Model model){

        Livro livro = livroRepository
                .findById(id)
                .orElseThrow();

        System.out.println(
                usuarioRepository.findByPermissao("LEITOR")
        );

        model.addAttribute("livro", livro);

        model.addAttribute(
                "usuarios",
                usuarioRepository.findByPermissao("LEITOR")
        );

        return "livros/emprestimos.html";
    }


    @PostMapping("/salvar")
    public String salvarEmprestimo(
            @RequestParam Long livroId,
            @RequestParam Long usuarioId) {

        Livro livro = livroRepository
                .findById(livroId)
                .orElseThrow();

        Usuario usuario = usuarioRepository
                .findById(usuarioId)
                .orElseThrow();

        if (!"LEITOR".equals(usuario.getPermissao())) {
            throw new RuntimeException(
                    "Somente leitores podem receber empréstimos."
            );
        }

        Emprestimo emprestimo = new Emprestimo();

        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);

        LocalDate hoje = LocalDate.now();

        emprestimo.setDataEmprestimo(hoje);
        emprestimo.setDataDevolucao(hoje.plusDays(14));

        emprestimoRepository.save(emprestimo);

        return "redirect:/livros";
    }
}