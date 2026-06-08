package com.Projec.CRUD.Biblioteca.service;

import com.Projec.CRUD.Biblioteca.model.*;
import com.Projec.CRUD.Biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public void cadastrar(CadastroDTO dto) {

        Usuario usuario;

        if(dto.getPermissao().equals("ADM")){
            usuario = new Administrador();
        } if(dto.getPermissao().equals("BIBLIOTECARIO")){
            usuario = new Bibliotecario();
        }else{
            usuario = new Leitor();
        }

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setPermissao(dto.getPermissao());
        repository.save(usuario);
    }

    public boolean logar(String email, String senha) {

        Usuario existe =
                repository.findByEmail(email);

        if (existe == null) {
            return false;
        }

        return existe.getSenha().equals(senha);
    }

    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }
}