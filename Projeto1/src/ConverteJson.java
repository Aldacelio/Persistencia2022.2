/*3. Crie uma classe Java que recebe via linha de comando o nome de um arquivo qualquer 
em formato JSON e o converte para os formatos CSV e XML. */

import java.io.File;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class ConverteJson {
    public void converte() throws Exception{
        String arquivo;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo json: ");
        arquivo = scanner.nextLine();
        File file = new File(arquivo);
        ArrayFilmes filmes = new ObjectMapper().readValue(file, ArrayFilmes.class);
        

        converteXml(filmes);
        converteCsv(filmes);

    }

    public void converteXml(ArrayFilmes filmes) throws Exception{
        File f = new File("Filmes.xml");
        XmlMapper xm = new XmlMapper();
        xm.enable(SerializationFeature.INDENT_OUTPUT);
        xm.writeValue(f,filmes);
    }

    public void converteCsv(ArrayFilmes filmes) throws Exception{
        Writer writer = Files.newBufferedWriter(Paths.get("Filmes.csv"));
        StatefulBeanToCsv<ArrayFilmes> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

        beanToCsv.write(filmes);

        writer.flush();
        writer.close();
    }

}
