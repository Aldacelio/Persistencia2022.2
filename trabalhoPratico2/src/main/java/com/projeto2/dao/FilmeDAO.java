package com.projeto2.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto2.entity.Filme;

@Repository
public interface FilmeDAO extends JpaRepository<Filme,Integer> {
    @Query("select f from filme f where f.id = :id")
    public Filme findFistByid(int id);

    public List<Filme> findByTituloStartingWith(String str);

    @Query("Filme.AnoLancamento")
    public List<Filme> findAllByAno(int ano);

    @Query("stringTitulo")
    public List<Filme> findByTituloContains(String titulo);
    

}
