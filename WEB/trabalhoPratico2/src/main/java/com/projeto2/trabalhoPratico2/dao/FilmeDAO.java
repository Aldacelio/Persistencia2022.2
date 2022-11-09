package com.projeto2.trabalhoPratico2.dao;

import org.springframework.data.repository.CrudRepository;

import com.projeto2.trabalhoPratico2.models.Filme;

public interface FilmeDAO extends CrudRepository<Filme,String> {
    
}
