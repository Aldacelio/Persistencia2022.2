package com.projeto2.trabalhoPratico2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
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

    @Getter
    @Setter
    private int  anoLancamento;

    @NonNull
    @Getter
    @Setter
    private String titulo;

}
