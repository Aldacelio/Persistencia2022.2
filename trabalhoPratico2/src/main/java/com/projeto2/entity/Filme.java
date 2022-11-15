package com.projeto2.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "filme")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@NamedQueries({
        @NamedQuery(name = "Filme.AnoLancamento", query = "select f from Filme f where f.ano = :ano")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "stringTitulo", query = "SELECT * FROM filme WHERE titulo LIKE %titulo%"),
})
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

    @Getter
    @Setter
    private int ano;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "filme_atores", joinColumns = @JoinColumn(name = "filme_fk"), inverseJoinColumns = @JoinColumn(name = "ator_fk"))
    @Getter
    @Setter
    private List<Ator> atores;
}
