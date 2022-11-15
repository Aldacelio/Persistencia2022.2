package com.projeto2.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
// import com.projeto2.dao.FilmeDAO;
import com.projeto2.entity.Ator;


@SpringBootApplication
@ComponentScan("com.projeto2")
@EntityScan("com.projeto2.entity")
@EnableJpaRepositories("com.projeto2.dao")
public class AtorCrud implements CommandLineRunner{
    
    //O autowired cria uma nova instancia toda vez que preciasa utilizar a interface
    @Autowired
    private AtorDAO baseAtores;

    // @Autowired
    // private  FilmeDAO baseFilmes;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(AtorCrud.class);
        builder.headless(false).run(args);
    }

    public void inserirAtor(Ator cl) throws ParseException {
        String nome = JOptionPane.showInputDialog("Nome", cl.getNome());
        String data = JOptionPane.showInputDialog("Digite a data de nascimento do ator", cl.getDataNascimento());

        cl.setNome(nome);
        cl.setDataNascimento(alterarData(data)); 

    }

    public void obterAtores(Ator cl) throws ParseException {
        String titulo = JOptionPane.showInputDialog("Nome", cl.getNome());
        String data = JOptionPane.showInputDialog("Data de nascimento", cl.getDataNascimento());

        cl.setNome(titulo);
        cl.setDataNascimento(alterarData(data));
    }

    public static void imprimir(Ator cl) {
        JOptionPane.showMessageDialog(null, cl == null ? "Nenhum aluno encontrado" : cl);
    }

    public static void listaAtores(List<Ator> atores) {
        StringBuilder listagem = new StringBuilder();
        for(Ator cl : atores) {
            listagem.append(cl).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum ator encontrado" : listagem);
    }

    public LocalDateTime alterarData(String data){
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        // faz o parsing e setar o horário para meia-noite
        LocalDateTime dateTime = LocalDate.parse(data, parser).atStartOfDay();
        return dateTime;
    }

    @Override
    public void run(String... args) throws Exception {

        String menu = "Escolha uma opção:\n" +
                "1 - Inserir ator\n" +
                "2 - Atualizar por id\n" +
                "3 - Remover por id\n" +
                "4 - Exibir por id\n" +
                "5 - Exibir todos\n" +
                "x - Para sair";
        char opcao;

        do{
            Ator cl;
            int id;
            opcao = JOptionPane.showInputDialog(menu).charAt(0);
            switch(opcao){
                case '1' :
                    cl = new Ator();
                    inserirAtor(cl);
                    baseAtores.save(cl);
                    break;
                case '2': // Atualizar por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do ator a ser alterado"));
                    cl = baseAtores.findFistByid(id);
                    obterAtores(cl);
                    baseAtores.save(cl);
                    break;
                case '3'://remover por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do ator a ser removido"));
                    cl = baseAtores.findFistByid(id);
                    if (cl != null) {
                        baseAtores.deleteById(cl.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o ator não encontrado.");
                    }
                    break;
                case '4':// Exibir por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    cl = baseAtores.findById(id).orElse(null);
                    imprimir(cl);
                    break;
                case '5':
                    listaAtores(baseAtores.findAll());
                    break;
                    
            }

        }while(opcao != 'x');
        
    }
}
