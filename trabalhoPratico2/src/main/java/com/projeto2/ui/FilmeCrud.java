package com.projeto2.ui;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.expression.ParseException;

import com.projeto2.dao.FilmeDAO;
import com.projeto2.entity.Filme;

@SpringBootApplication
@ComponentScan("com.projeto2")
public class FilmeCrud implements CommandLineRunner {

    @Autowired
    private FilmeDAO baseFilmes;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(FilmeCrud.class);
        builder.headless(false).run(args);
    }

    public void inserirFilme(Filme cl) throws ParseException {
        String titulo = JOptionPane.showInputDialog("Nome", cl.getTitulo());
        String ano = JOptionPane.showInputDialog("Digite o ano de lançamento", cl.getAnoLancamento());

        cl.setTitulo(titulo);
        cl.setAnoLancamento(converte(ano));

    }

    public void obterFilmes(Filme cl) throws ParseException {
        String titulo = JOptionPane.showInputDialog("Nome", cl.getTitulo());
        String ano = JOptionPane.showInputDialog("Ano de lançamento", cl.getAnoLancamento());

        cl.setTitulo(titulo);
        cl.setAnoLancamento(converte(ano));
    }

    public static void imprimir(Filme cl) {
        if(cl != null){   
            JOptionPane.showMessageDialog(null, "{Titulo: "+cl.getTitulo()+ ", Ano de lançamento: "+cl.getAnoLancamento()+"}");
        }else{
            JOptionPane.showMessageDialog(null,"Nenhum filme encontrado");
        }
    }

    public int converte(String ano) {
        int convertido = Integer.parseInt(ano);
        return convertido;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(baseFilmes.findByTituloStartingWith("773362552"));

        String menu = "Escolha uma opção:\n" +
                "1 - Inserir filme\n" +
                "2 - Atualizar por id\n" +
                "3 - Remover por id\n" +
                "4 - Exibir por id\n" +
                "5 - Exibir todos\n" +
                "x - Para sair";
        char opcao;

        do {
            Filme cl;
            int id;
            opcao = JOptionPane.showInputDialog(menu).charAt(0);
            switch (opcao) {
                case '1'://adicionar filme
                    cl = new Filme();
                    inserirFilme(cl);
                    baseFilmes.save(cl);
                    break;
                case '2': // Atualizar por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do filme a ser alterado"));
                    cl = baseFilmes.findFistByid(id);
                    obterFilmes(cl);
                    baseFilmes.save(cl);
                    break;
                case '3'://remover por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do filme a ser removido"));
                    cl = baseFilmes.findFistByid(id);
                    if (cl != null) {
                        baseFilmes.deleteById(cl.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o filme não encontrado.");
                    }
                    break;
                case '4':// Exibir por id
                    id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    cl = baseFilmes.findById(id).orElse(null);
                    imprimir(cl);
                    break;
            }

        } while (opcao != 'x');

    }

}
