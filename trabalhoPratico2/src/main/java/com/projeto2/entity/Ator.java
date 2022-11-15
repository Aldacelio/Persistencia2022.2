package com.projeto2.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @NonNull
    @Getter
    @Setter
    private String nome;
    
    @NonNull
    @Getter
    @Setter
    private LocalDateTime dataNascimento;

    @ToString.Exclude
    @ManyToMany(mappedBy = "atores")
    @Getter
    @Setter
    private List<Filme> filmes;

}
