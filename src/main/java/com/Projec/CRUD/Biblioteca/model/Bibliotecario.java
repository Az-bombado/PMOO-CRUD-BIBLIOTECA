package com.Projec.CRUD.Biblioteca.model;

import jakarta.persistence.Entity;

@Entity
public class Bibliotecario extends Usuario {

    @Override
    public String getPermissao() {
        return "BIBLIOTECARIO";
    }
}