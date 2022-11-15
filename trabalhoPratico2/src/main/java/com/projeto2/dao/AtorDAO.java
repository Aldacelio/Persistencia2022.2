package com.projeto2.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projeto2.entity.Ator;

@Repository
public interface AtorDAO extends JpaRepository<Ator,Integer>{
    @Query("select a from ator a where a.id = :id")
    public Ator findFistByid(int id);
}
