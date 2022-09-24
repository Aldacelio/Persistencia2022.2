/*2. Crie uma classe Java de nome Serializa para instanciar objetos da classe definida na Questão 1
e adicionar esses objetos em uma Lista. Depois, percorrer a lista e Serializar os objetos em disco/ssd.
Serialize usando JSON através da biblioteca Jackson (Serialization and Deserialization in Java using 
Jackson A practical guide on how to serialize and deserialize objects to JSON in Java using Jackson). */


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Serializa {
    public static void main(String[] args) throws Exception {
        Filme f1 = new Filme(1,"O incrivel hulk","O cientista Bruce Banner se esconde no Brasil enquanto busca desesperadamente a cura da mutação que o transforma em um monstro incontrolável. Só assim ele poderá novamente levar uma vida normal e ficar ao lado da mulher que ama. Porém, durante este processo, ele precisa lutar contra o Abominável, um novo inimigo que quer capturá-lo.","Louis Leterrier");
        Filme f2 = new Filme(2,"Como Eu Era Antes de Você","De origem modesta e sem grandes aspirações, a peculiar Louisa Clark é contratada para ser cuidadora de Will, um jovem tetraplégico depressivo e cínico.","Thea Sharrock");
        List<Filme> lista = new ArrayList<Filme>();
        lista.add(f1);
        lista.add(f2);

        Filmes filmes = new Filmes(lista);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("Filmes.json"), filmes);
        
    }
    
}
