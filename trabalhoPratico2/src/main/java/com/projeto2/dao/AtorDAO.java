package com.projeto2.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projeto2.entity.Ator;

@Repository
public interface AtorDAO extends JpaRepository<Ator,Integer>{
}
