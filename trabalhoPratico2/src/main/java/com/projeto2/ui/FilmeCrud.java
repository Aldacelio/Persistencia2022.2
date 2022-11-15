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
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.expression.ParseException;

import com.projeto2.dao.AtorDAO;
import com.projeto2.dao.FilmeDAO;
import com.projeto2.entity.Filme;
import com.projeto2.entity.Ator;

@SpringBootApplication
@ComponentScan("com.projeto2")
public class FilmeCrud implements CommandLineRunner {

    @Autowired
    private FilmeDAO baseFilmes;

    @Autowired
    private AtorDAO baseAtores;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(FilmeCrud.class);
        builder.headless(false).run(args);
    }

    //CRUD FILMES INICIO

    //CADASTRA FILME
    public void inserirFilme(Filme cl) throws ParseException {
        String titulo = JOptionPane.showInputDialog("Nome", cl.getTitulo());
        String ano = JOptionPane.showInputDialog("Digite o ano de lançamento", cl.getAnoLancamento());

        cl.setTitulo(titulo);
        cl.setAnoLancamento(converte(ano));

    }

    //ALTERAR FILME
    public void obterFilmes(Filme cl) throws ParseException {
        String titulo = JOptionPane.showInputDialog("Nome", cl.getTitulo());
        String ano = JOptionPane.showInputDialog("Ano de lançamento", cl.getAnoLancamento());

        cl.setTitulo(titulo);
        cl.setAnoLancamento(converte(ano));
    }

    //IMPRIMIR FILME
    public static void imprimir_filme(Filme cl) {
        JOptionPane.showMessageDialog(null, cl == null ? "Nenhum aluno encontrado" : cl);
    }

    //IMPRIMIR LISTA DE FILMES
    public static void listaFilmes(List<Filme> filmes) {
        StringBuilder listagem = new StringBuilder();
        for(Filme cl : filmes) {
            listagem.append(cl).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum filme encontrado" : listagem);
    }

    //METODO DE CONVERTER STRING PARA INTEIRO
    public int converte(String ano) {
        int convertido = Integer.parseInt(ano);
        return convertido;
    }

    //CRUD FILMES FIM

    //CRUD ATORES INICIO

    //CADASTRAR ATOR
    public void inserirAtor(Ator cl) throws ParseException {
        String nome = JOptionPane.showInputDialog("Nome", cl.getNome());
        String data = JOptionPane.showInputDialog("Digite a data de nascimento do ator", cl.getDataNascimento());

        cl.setNome(nome);
        cl.setDataNascimento(alterarData(data)); 

    }

    //ALTERAR ATOR
    public void obterAtores(Ator cl) throws ParseException {
        String titulo = JOptionPane.showInputDialog("Nome", cl.getNome());
        String data = JOptionPane.showInputDialog("Data de nascimento", cl.getDataNascimento());

        cl.setNome(titulo);
        cl.setDataNascimento(alterarData(data));
    }

    //IMPRIMIR ATOR
    public static void imprimir_ator(Ator cl) {
        JOptionPane.showMessageDialog(null, cl == null ? "Nenhum ator encontrado" : cl);
    }

    //IMPRIMIR LISTA DE ATORES
    public static void listaAtores(List<Ator> atores) {
        StringBuilder listagem = new StringBuilder();
        for(Ator cl : atores) {
            listagem.append(cl).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum ator encontrado" : listagem);
    }

    //CONVERTE STRING EM LOCAL DATE TIME
    public LocalDateTime alterarData(String data){
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        // faz o parsing e setar o horário para meia-noite
        LocalDateTime dateTime = LocalDate.parse(data, parser).atStartOfDay();
        return dateTime;
    }

    //CRUD ATORES FIM 

    //ASSOCIANDO ATORES E FILME
    public void associa(int id_filme){
        Filme filme = baseFilmes.findFistByid(id_filme);
        if(filme != null){
            List <Ator> atores = new ArrayList<>();
            int aux = 1;
            while(aux == 1){
                int id_ator = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do ator "));
                Ator ator = baseAtores.findFistByid(id_ator);
                if(ator != null){
                    atores.add(ator);
                    aux = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para adicionar mais um ator ou 0 para finalizar"));
                    if(aux == 0){
                        filme.setAtores(atores);
                        baseFilmes.save(filme);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Você digitou um id inexistente, tente novamente.");
                }

            }
            
        }
    }

    public void imprimir_atores_de_um_filme(Filme filmes){
        StringBuilder listagem = new StringBuilder();
        for(Ator atores : filmes.getAtores()) {
            listagem.append(atores).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum ator associado ao filme" : listagem);
    }

    @Override
    public void run(String... args) throws Exception {

        String menu = "Escolha uma opção:\n" +
                "1 - Inserir filme\n" +
                "2 - Inserir ator\n" +
                "3 - Atualizar filme por id\n" +
                "4 - Atualizar ator por id\n" +
                "5 - Remover filme por id\n" +
                "6 - Remover ator por id\n" +
                "7 - Exibir filme por id\n" +
                "8 - Exibir ator por id\n" +
                "9 - Exibir todos os filmes\n" +
                "10 - Exibir todos os atores\n" +
                "11 - Associar atores a um filme\n"+
                "12 - Exibir os nomes de todos os atores de um filme\n"+//nao feito ainda
                "13 - Exibir os nomes de todos os filmes de um ator\n"+//nao feito ainda 
                "14 - Exibir os títulos de filmes lançados no ano\n"+// nao feito ainda
                "15 - Exibir os títulos de filmes cujo título contém determinada a palavra\n"+// nao feito ainda
                "16 - Exibir os nomes de atores nascidos em determinado ano\n"+// nao feito ainda
                "17 - Exibir a quantidade total de filmes cadastrados.\n"+// nao feito ainda
                "0 - Para sair";          
                
        int opcao;

        do {
            Filme cf;
            Ator ca;
            int id;
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcao) {
                case 1://adicionar filme
                    cf = new Filme();
                    inserirFilme(cf);
                    baseFilmes.save(cf);
                    break;
                case 2 ://adicionar ator
                    ca = new Ator();
                    inserirAtor(ca);
                    baseAtores.save(ca);
                    break;
                case 3: // Atualizar filme por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do filme a ser alterado"));
                    cf = baseFilmes.findFistByid(id);
                    obterFilmes(cf);
                    baseFilmes.save(cf);
                    break;
                case 4: // Atualizar ator por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do ator a ser alterado"));
                    ca = baseAtores.findFistByid(id);
                    obterAtores(ca);
                    baseAtores.save(ca);
                    break;
                case 5://remover filme por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do filme a ser removido"));
                    cf = baseFilmes.findFistByid(id);
                    if (cf != null) {
                        baseFilmes.deleteById(cf.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o filme não encontrado.");
                    }
                    break;
                case 6://remover ator por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do ator a ser removido"));
                    ca = baseAtores.findFistByid(id);
                    if (ca != null) {
                        baseAtores.deleteById(ca.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o ator não encontrado.");
                    }
                    break;
                case 7:// Exibir filme por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    cf = baseFilmes.findById(id).orElse(null);
                    imprimir_filme(cf);
                    break;
                case 8:// Exibir ator por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    ca = baseAtores.findById(id).orElse(null);
                    imprimir_ator(ca);
                    break;
                case 9://Exibir todos os filmes
                    listaFilmes(baseFilmes.findAll());
                    break;
                case 10://Exibir todos os atores
                    listaAtores(baseAtores.findAll());
                    break;
                case 11://associar
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do filme ao qual deseja adicionar atores "));
                    associa(id);
                    break;
                case 12:
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do filme"));
                    cf = baseFilmes.findFistByid(id);
                    imprimir_atores_de_um_filme(cf);
                    break;
                case 13:
                    break;
                case 14:
                    int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de lançamento do filme"));
                    cf = baseFilmes.findFirstByAno(ano);
                    imprimir_filme(cf);
                    break;

            }

        } while (opcao != 0);

    }

}
