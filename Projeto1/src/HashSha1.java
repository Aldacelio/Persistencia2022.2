/*5. Crie uma classe Java que recebe via linha de comando o nome de um arquivo qualquer 
e exibe no console o hash SHA1 desse arquivo. Dica: você pode se basear no exemplo a seguir, 
que gera o hash md5 e adaptá-lo para gerar o hash SHA1: https://www.baeldung.com/java-md5  */

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;

public class HashSha1 {
    public void gerar(Scanner scanner) throws Exception{
        String arquivo,hexa;
        System.out.println("Digite o nome do arquivo: ");
        arquivo = scanner.next();
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(arquivo.getBytes(),0,arquivo.length());
        byte[] digest = md.digest();
        hexa = new BigInteger(1,digest).toString(16);
        System.out.println("A HASH SHA-1 do arquivo é : "+hexa);
    }
}
