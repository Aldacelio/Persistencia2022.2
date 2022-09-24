/*2. Crie uma classe Java para cadastrar dados relacionados à entidade definida na questão 1. 
A classe deve receber dados via teclado e os salvar em um arquivo JSON.*/

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CadastraFilme {
    public void cadastrar() throws Exception {
        int aux = 0, id = 0,auxsn = 0;
        String titulo, sinopse, genero,diretor,confirm;
        Scanner scanner = new Scanner(System.in);
        List<Filmes> lista = new ArrayList<Filmes>();

        while(aux == 0){
            System.out.println("Digite o titulo do filme: ");
            titulo = scanner.nextLine();

            System.out.println("Digite o sinopse do filme: ");
            sinopse = scanner.nextLine();

            System.out.println("Digite o genero do filme: ");
            genero = scanner.nextLine();
        
            System.out.println("Digite o diretor do filme: ");
            diretor = scanner.nextLine();

            Filmes elemento = new Filmes(id,titulo,sinopse,genero,diretor);

            lista.add(elemento);
           
            while(auxsn == 0){
                System.out.println("Você deseja cadastrar um novo filme: ");
                confirm = scanner.nextLine();
                if(confirm.toLowerCase().equals("sim")){
                    id += 1;
                    auxsn = 1;
                }else if(confirm.toLowerCase().equals("não") || confirm.toLowerCase().equals("nao")){
                    auxsn = 1;
                    aux = 1;
                    break;
                }else{
                    System.out.println("Digite apenas sim ou não !!!");
                }
            }
            auxsn = 0;
        }
        
        

        ArrayFilmes filmes = new ArrayFilmes(lista);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("Filmes.json"), filmes);
    }     
}
