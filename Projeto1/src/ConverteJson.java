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
    public void converte(Scanner scanner) throws Exception{
        String arquivo;
        System.out.println("Digite o nome do arquivo json: ");
        arquivo = scanner.next();
        String arquivoSemExtensao = arquivo.substring(0, arquivo.lastIndexOf('.'));
        File file = new File(arquivoSemExtensao+".json");
        ArrayFilmes filmes = new ObjectMapper().readValue(file, ArrayFilmes.class);

        converteXml(filmes,arquivoSemExtensao);
        converteCsv(filmes,arquivoSemExtensao);

    }

    public void converteXml(ArrayFilmes filmes, String arquivoSemExtensao) throws Exception{
        File f = new File(arquivoSemExtensao+".xml");
        XmlMapper xm = new XmlMapper();
        xm.enable(SerializationFeature.INDENT_OUTPUT);
        xm.writeValue(f,filmes);
    }

    public void converteCsv(ArrayFilmes filmes, String arquivoSemExtensao) throws Exception{
        Writer writer = Files.newBufferedWriter(Paths.get(arquivoSemExtensao+".csv"));
        StatefulBeanToCsv<ArrayFilmes> beanToCsv = new StatefulBeanToCsvBuilder<ArrayFilmes>(writer).build();


        beanToCsv.write(filmes);

        writer.flush();
        writer.close();

    }

}
