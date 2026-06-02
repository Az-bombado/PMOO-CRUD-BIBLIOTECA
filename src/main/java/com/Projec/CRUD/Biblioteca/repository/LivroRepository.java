package com.Projec.CRUD.Biblioteca.repository;

import com.Projec.CRUD.Biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository
        extends JpaRepository<Livro, Long> {
}