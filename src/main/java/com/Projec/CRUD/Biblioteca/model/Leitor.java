package com.Projec.CRUD.Biblioteca.model;

import jakarta.persistence.Entity;

@Entity
public class Leitor extends Usuario {

    @Override
    public String getPermissao() {
        return "LEITOR";
    }
}