package com.Projec.CRUD.Biblioteca.repository;

import com.Projec.CRUD.Biblioteca.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}