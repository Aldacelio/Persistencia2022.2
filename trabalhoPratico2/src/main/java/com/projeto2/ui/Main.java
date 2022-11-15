package com.projeto2.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.expression.ParseException;

import com.projeto2.dao.AtorDAO;
import com.projeto2.dao.FilmeDAO;
import com.projeto2.entity.Filme;
import com.projeto2.entity.Ator;

@SpringBootApplication
@ComponentScan("com.projeto2")
@EntityScan("com.projeto2.entity")
@EnableJpaRepositories("com.projeto2.dao")
public class Main implements CommandLineRunner {

    @Autowired
    private FilmeDAO baseFilmes;

    @Autowired
    private AtorDAO baseAtores;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
        builder.headless(false).run(args);
    }

    // CRUD FILMES INICIO

    // CADASTRA FILME
    public void inserirFilme(Filme cl) throws ParseException {
        String titulo = JOptionPane.showInputDialog("Nome", cl.getTitulo());
        String ano = JOptionPane.showInputDialog("Digite o ano de lançamento", cl.getAno());

        cl.setTitulo(titulo);
        cl.setAno(converte(ano));

    }

    // ALTERAR FILME
    public void obterFilmes(Filme cl) throws ParseException {
        String titulo = JOptionPane.showInputDialog("Nome", cl.getTitulo());
        String ano = JOptionPane.showInputDialog("Ano de lançamento", cl.getAno());

        cl.setTitulo(titulo);
        cl.setAno(converte(ano));
    }

    // IMPRIMIR FILME
    public static void imprimir_filme(Filme cl) {
        JOptionPane.showMessageDialog(null, cl == null ? "Nenhum filme encontrado" : cl);
    }

    // IMPRIMIR LISTA DE FILMES
    public static void listaFilmes(List<Filme> filmes) {
        StringBuilder listagem = new StringBuilder();
        for (Filme cl : filmes) {
            listagem.append(cl).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum filme encontrado" : listagem);
    }

    //CONTAR LISTA DE FILMES
    public static void listaFilmesCont(List<Filme> filmes) {
        int cont = 0;
        for (Filme cl : filmes) {
            cont ++;
        }
        JOptionPane.showMessageDialog(null, cont == 0 ? "Nenhum filme encontrado" : cont);
    }

    // METODO DE CONVERTER STRING PARA INTEIRO
    public int converte(String ano) {
        int convertido = Integer.parseInt(ano);
        return convertido;
    }

    // CRUD FILMES FIM

    // CRUD ATORES INICIO

    // CADASTRAR ATOR
    public void inserirAtor(Ator cl) throws ParseException {
        String nome = JOptionPane.showInputDialog("Nome", cl.getNome());
        String data = JOptionPane.showInputDialog("Digite a data de nascimento do ator", cl.getDataNascimento());

        cl.setNome(nome);
        cl.setDataNascimento(alterarData(data));

    }

    // ALTERAR ATOR
    public void obterAtores(Ator cl) throws ParseException {
        String titulo = JOptionPane.showInputDialog("Nome", cl.getNome());
        String data = JOptionPane.showInputDialog("Data de nascimento", cl.getDataNascimento());

        cl.setNome(titulo);
        cl.setDataNascimento(alterarData(data));
    }

    // IMPRIMIR ATOR
    public static void imprimir_ator(Ator cl) {
        JOptionPane.showMessageDialog(null, cl == null ? "Nenhum ator encontrado" : cl);
    }

    // IMPRIMIR LISTA DE ATORES
    public static void listaAtores(List<Ator> atores) {
        StringBuilder listagem = new StringBuilder();
        for (Ator cl : atores) {
            listagem.append(cl).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum ator encontrado" : listagem);
    }

    // CONVERTE STRING EM LOCAL DATE TIME
    public LocalDateTime alterarData(String data) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        // faz o parsing e setar o horário para meia-noite
        LocalDateTime dateTime = LocalDate.parse(data, parser).atStartOfDay();
        return dateTime;
    }

    // CRUD ATORES FIM

    // ASSOCIANDO ATORES E FILME
    public void associa(int id_filme) {
        Filme filme = baseFilmes.findFistByid(id_filme);
        if (filme != null) {
            List<Ator> atores = new ArrayList<>();
            int aux = 1;
            while (aux == 1) {
                int id_ator = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do ator "));
                Ator ator = baseAtores.findFistByid(id_ator);
                if (ator != null) {
                    atores.add(ator);
                    aux = Integer.parseInt(
                            JOptionPane.showInputDialog("Digite 1 para adicionar mais um ator ou 0 para finalizar"));
                    if (aux == 0) {
                        filme.setAtores(atores);
                        baseFilmes.save(filme);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Você digitou um id inexistente, tente novamente.");
                }

            }

        }
    }

    // Atores de um filme
    public void imprimir_atores_de_um_filme(Filme filmes) {
        StringBuilder listagem = new StringBuilder();
        for (Ator atores : filmes.getAtores()) {
            listagem.append(atores).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum ator associado ao filme" : listagem);
    }

    // Filmes de um ator
    public void imprimir_filmes_de_um_ator(Ator atores) {
        StringBuilder listagem = new StringBuilder();
        for (Filme filmes : atores.getFilmes()) {
            listagem.append(filmes).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum filme associado ao filme" : listagem);
    }

    public void menuFilme(){
        String menu = "Escolha uma opção:\n" +
                "1 - Inserir filme\n" +
                "2 - Atualizar filme por id\n" +
                "3 - Remover filme por id\n" +
                "4 - Exibir filme por id\n" +
                "5 - Exibir todos os filmes\n" +
                "6 - Associar atores a um filme\n" +
                "7 - Exibir os nomes de todos os atores de um filme\n" + // nao feito ainda
                "8 - Exibir os títulos de filmes lançados no ano\n" +
                "9 - Exibir os títulos de filmes cujo título contém determinada a palavra\n" + // nao feito ainda
                "10 - Exibir a quantidade total de filmes cadastrados.\n" + // nao feito ainda
                "0 - Voltar menu principal";

        int opcao;

        do {
            Filme cf;
            int id;
            List<Filme> filmes = new ArrayList<>();
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcao) {
                case 1:// adicionar filme
                    cf = new Filme();
                    inserirFilme(cf);
                    baseFilmes.save(cf);
                    break;
                case 2: // Atualizar filme por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do filme a ser alterado"));
                    cf = baseFilmes.findFistByid(id);
                    obterFilmes(cf);
                    baseFilmes.save(cf);
                    break;
                case 3:// remover filme por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do filme a ser removido"));
                    cf = baseFilmes.findFistByid(id);
                    if (cf != null) {
                        baseFilmes.deleteById(cf.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o filme não encontrado.");
                    }
                    break;
                case 4:// Exibir filme por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    cf = baseFilmes.findById(id).orElse(null);
                    imprimir_filme(cf);
                    break;
                case 5:// Exibir todos os filmes
                    listaFilmes(baseFilmes.findAll());
                    break;
                case 6:// associar
                    id = Integer.parseInt(
                            JOptionPane.showInputDialog("Digite o id do filme ao qual deseja adicionar atores "));
                    associa(id);
                    break;
                case 7:// exibir atores de um filme
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do filme"));
                    cf = baseFilmes.findFistByid(id);
                    imprimir_atores_de_um_filme(cf);
                    break;
                case 8:// filmes lançados no ano
                    int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de lançamento do filme"));
                    filmes = baseFilmes.findAllByAno(ano);
                    listaFilmes(filmes);
                    break;
                case 9:// filme por string
                    String palavra = JOptionPane.showInputDialog(null, "Digite a palavra");
                    filmes = baseFilmes.findByTituloContains(palavra);
                    listaFilmes(filmes);
                    break;
                case 10://Contar filmes
                    listaFilmesCont(baseFilmes.findAll());
                    break;
            }

        } while (opcao != 0);

    }
    
    public void menuAtor(){
        String menu = "Escolha uma opção:\n" +
                "1 - Inserir ator\n" +
                "2 - Atualizar ator por id\n" +
                "3 - Remover ator por id\n" +
                "4 - Exibir ator por id\n" +
                "5 - Exibir todos os atores\n" +
                "6 - Exibir os nomes de todos os filmes de um ator\n" + // nao feito ainda
                "7 - Exibir os nomes de atores nascidos em determinado ano\n" + // nao feito ainda
                "0 - Voltar menu principal";

        int opcao;

        do {
            Ator ca;
            int id;
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcao) {
                case 1:// adicionar ator
                    ca = new Ator();
                    inserirAtor(ca);
                    baseAtores.save(ca);
                    break;
                case 2: // Atualizar ator por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do ator a ser alterado"));
                    ca = baseAtores.findFistByid(id);
                    obterAtores(ca);
                    baseAtores.save(ca);
                    break;
                case 3:// remover ator por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do ator a ser removido"));
                    ca = baseAtores.findFistByid(id);
                    if (ca != null) {
                        baseAtores.deleteById(ca.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o ator não encontrado.");
                    }
                    break;
                case 4:// Exibir ator por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    ca = baseAtores.findById(id).orElse(null);
                    imprimir_ator(ca);
                    break;
                case 5:// Exibir todos os atores
                    listaAtores(baseAtores.findAll());
                    break;
                case 6:// exibir filmes de um ator
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do ator"));
                    ca = baseAtores.findFistByid(id);
                    imprimir_filmes_de_um_ator(ca);
                    break;
                case 7://atores por data
                    break;
            }

        } while (opcao != 0);
    }
    
    @Override
    public void run(String... args) throws Exception {

        String menu = "Escolha uma opção:\n" +
                "1 - Menu Filmes\n" +
                "2 - Menu Atores.\n" + // nao feito ainda
                "0 - Para sair";

        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcao) {
                case 1:// adicionar filme
                    menuFilme();
                    break;
                case 2:// adicionar ator
                    menuAtor();
                    break;
            }

        } while (opcao != 0);

    }

}
