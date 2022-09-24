/*4. Crie uma classe Java que recebe como entrada de teclado o nome de um arquivo qualquer 
e o compacta para o formato ZIP ou outro formato de compressão à sua escolha. */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compactar {

    public void zip() throws Exception{
        int tam_buffer = 4096, cont;
        byte[] dados = new byte[tam_buffer];
        String arquivo;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo: ");
        arquivo = scanner.nextLine();

        BufferedInputStream origem = null;
        FileInputStream streamDeEntrada = null;
        FileOutputStream destino = null;
        ZipOutputStream saida = null;
        ZipEntry entry = null;

        destino = new FileOutputStream(new File("Filmes.zip"));
        saida = new ZipOutputStream(new BufferedOutputStream(destino));
        File file = new File(arquivo);
        streamDeEntrada = new FileInputStream(file);
        origem = new BufferedInputStream(streamDeEntrada, tam_buffer);
        entry = new ZipEntry(file.getName());
        saida.putNextEntry(entry);

        while((cont = origem.read(dados, 0, tam_buffer)) != -1) {
            saida.write(dados, 0, cont);
        }
        
        origem.close();
        saida.close();
    }
}
