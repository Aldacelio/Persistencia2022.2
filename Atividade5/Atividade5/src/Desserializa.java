/*3. Crie uma classe java de nome Desserializa para ler / desserializar os objetos Serializados 
na Questão 2 e exibi-los também através do uso da bilbioteca Jackson (Serialization and Deserialization
 in Java using Jackson A practical guide on how to serialize and deserialize objects to JSON in Java 
 using Jackson). 
 */

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Desserializa {
    public static void main(String[] args) throws Exception{
        File file = new File("Filmes.json");
        Filmes filmes = new ObjectMapper().readValue(file, Filmes.class);
        System.out.println(filmes);
    }
}
