package com.projeto2.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projeto2.entity.Filme;

@Repository
public interface FilmeDAO extends JpaRepository<Filme,Integer> {
    public Filme findFirstById(int id);
    
}
