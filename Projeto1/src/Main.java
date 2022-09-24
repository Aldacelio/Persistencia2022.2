import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int opcao,aux = 0;
        String novo;
        Scanner scanner = new Scanner(System.in);

        while(aux == 0){
            
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Filmes.");
            System.out.println("2 - Converter Json em XML e CSV.");
            System.out.println("3 - Compactar um arquivo.");
            System.out.println("4 - Gerar o HASH SHA1 de um arquivo.");
            System.out.println("5 - Sair.");
            opcao = scanner.nextInt();

            if(opcao == 1){
                System.out.println("Digite o nome da sua nova lista de filmes: ");
                scanner.nextLine(); 
                novo = scanner.nextLine();
                if(new File(novo+".json").exists()){
                    System.out.println("Nome de lista ja existe");
                }else{
                    CadastraFilme cadastraFilme = new CadastraFilme();
                    cadastraFilme.cadastrar(scanner,novo);
                }
            }else if(opcao == 2){
                ConverteJson converteJson = new ConverteJson();
                converteJson.converte(scanner);
            }else if(opcao == 3){
                Compactar compactar = new Compactar();
                compactar.zip(scanner);
            }else if(opcao == 4){
                HashSha1 hashSha1 = new HashSha1();
                hashSha1.gerar(scanner);    
            }else if(opcao == 5){
                aux = 1;
            }else{
                System.out.println("Digite uma opção válida!!");
            }
        }

        scanner.close();
    }
}
