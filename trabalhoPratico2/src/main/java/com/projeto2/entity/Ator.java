package com.projeto2.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "Ator")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @NonNull
    @Getter
    @Setter
    private String nome;
    
    @NonNull
    @Getter
    @Setter
    private LocalDateTime dataNascimento;

    @ToString.Exclude
    @ManyToMany(mappedBy = "Ator")
    @Getter
    @Setter
    private List<Filme> filmes;

}
