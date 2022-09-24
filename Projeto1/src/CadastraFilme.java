/*2. Crie uma classe Java para cadastrar dados relacionados à entidade definida na questão 1. 
A classe deve receber dados via teclado e os salvar em um arquivo JSON.*/

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CadastraFilme {

    public void cadastrar(Scanner scanner, String novo) throws Exception {
        int aux = 0, id = 0, auxsn = 0, confirm;
        String titulo, sinopse, genero, diretor;
        List<Filmes> lista = new ArrayList<Filmes>();

        while (aux == 0) {

            System.out.println("Digite o titulo do filme: ");
            titulo = scanner.next();

            System.out.println("Digite o sinopse do filme: ");
            sinopse = scanner.next();

            System.out.println("Digite o genero do filme: ");
            genero = scanner.next();

            System.out.println("Digite o diretor do filme: ");
            diretor = scanner.next();

            Filmes elemento = new Filmes(id, titulo, sinopse, genero, diretor);

            lista.add(elemento);

            while (auxsn == 0) {
                System.out.println("1 - Cadastrar mais um filme.");
                System.out.println("2 - Voltar para o menu principal.");
                System.out.println("3 - Sair.");
                confirm = scanner.nextInt();
                if (confirm == 1) {
                    id += 1;
                    auxsn = 1;
                } else if (confirm == 2) {
                    auxsn = 1;
                    aux = 1;
                    break;
                } else if (confirm == 3) {
                    System.exit(0);
                } else {
                    System.out.println("Digite apenas sim ou não !!!");
                }
            }
            auxsn = 0;
        }

        ArrayFilmes filmes = new ArrayFilmes(lista);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File(novo+".json"), filmes);
    }
}
