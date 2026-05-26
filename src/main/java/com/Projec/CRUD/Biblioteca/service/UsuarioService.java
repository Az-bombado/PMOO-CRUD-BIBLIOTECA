package com.Projec.CRUD.Biblioteca.service;

import com.Projec.CRUD.Biblioteca.model.Usuario;
import com.Projec.CRUD.Biblioteca.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public void cadastrar(Usuario usuario) {

        Usuario existente =
                repository.findByEmail(usuario.getEmail());

        if (existente == null) {

            repository.save(usuario);
        }
    }
    public boolean logar(Usuario usuario) {

        Usuario existe =
                repository.findByEmail(usuario.getEmail());

        if(existe == null){
            return false;
        }

        return existe.getSenha()
                .equals(usuario.getSenha());
    }
}
//
//    public boolean logar(Usuario usuario) {
//
//        Usuario existente =
//                repository.findByEmail(usuario.getEmail());
//
//        if (usuario == null) {
//        }
//    return }}
//        if (input == repository.findByEmail(usuario.getEmail());
//){
//
//        }else{
//
//        }