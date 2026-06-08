package com.Projec.CRUD.Biblioteca.repository;

import com.Projec.CRUD.Biblioteca.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    List<Usuario> findByNomeContainingIgnoreCase(String nome);
    
    List<Usuario> findByPermissao(String permissao);
}