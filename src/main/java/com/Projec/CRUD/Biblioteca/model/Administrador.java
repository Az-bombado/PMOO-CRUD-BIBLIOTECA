package com.Projec.CRUD.Biblioteca.model;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Usuario {

    @Override
    public String getPermissao() {
        return "ADMIN";
    }
}