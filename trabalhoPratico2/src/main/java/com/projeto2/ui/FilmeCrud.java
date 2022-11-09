package com.projeto2.ui;

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
public class FilmeCrud implements CommandLineRunner{
    
    @Autowired
    private  FilmeDAO baseFilmes;  

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

    public int converte(String ano){
        int convertido = Integer.parseInt(ano);
        return convertido;
    }

    @Override
    public void run(String... args) throws Exception {

        String menu = "Escolha uma opção:\n" +
                "1 - Inserir filme\n" +
                "x - Para sair";
        char opcao;

        do{
            Filme cl;
            int id;
            opcao = JOptionPane.showInputDialog(menu).charAt(0);
            switch(opcao){
                case '1' :
                    cl = new Filme();
                    inserirFilme(cl);
                    baseFilmes.save(cl);
                    break;
            }

        }while(opcao != 'x');
        
    }


}
