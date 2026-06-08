package com.Projec.CRUD.Biblioteca.repository;

import com.Projec.CRUD.Biblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository
        extends JpaRepository<Emprestimo, Long> {

}