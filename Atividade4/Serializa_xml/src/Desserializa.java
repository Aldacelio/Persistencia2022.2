/*3. Crie uma classe java de nome Desserializa para ler / desserializar os objetos Serializados na Questão 2 e exibi-los também através do uso da bilbioteca Jackson
 (XML Serialization and Deserialization with Jackson | Baeldung).  */
 
import java.io.File;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Desserializa {
    public static void main(String[] args) throws Exception{
        File file = new File("Filmes.xml");
        XmlMapper xmlMapper = new XmlMapper();
        Filmes f = xmlMapper.readValue(file, Filmes.class);
        System.out.println(f);
    }
}