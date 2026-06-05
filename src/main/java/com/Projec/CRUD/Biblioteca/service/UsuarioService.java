package com.Projec.CRUD.Biblioteca.service;

import com.Projec.CRUD.Biblioteca.model.Administrador;
import com.Projec.CRUD.Biblioteca.model.Bibliotecario;
import com.Projec.CRUD.Biblioteca.model.CadastroDTO;
import com.Projec.CRUD.Biblioteca.model.Usuario;
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
        } else {
            usuario = new Bibliotecario();
        }

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

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