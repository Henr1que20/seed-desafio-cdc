package com.livraria.desafio1.repo;

import com.livraria.desafio1.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
