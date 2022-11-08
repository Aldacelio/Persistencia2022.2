package com.projeto2.entity;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Filme")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @NonNull
    @Getter
    @Setter
    private String titulo;

    @NonNull
    @Getter
    @Setter
    private int anoLancamento;

    @ToString.Exclude
    @ManyToMany(mappedBy = "Filme")
    @Getter
    @Setter
    private List<Ator> ator;
    
}
