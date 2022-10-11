import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner ler = new Scanner(System.in);
        Connection connection = ConnectionFactory.getConnection();
        AlunoDAO alunos = new AlunoDAO();
        int esc = 0;
        int aux = 0;
        
        
        while(aux == 0){
            String id = "", matricula = "", cpf = "", nome = "", email = "", telefone = "";

            System.out.println("+------------------------+");
            System.out.println("|          MENU          |");
            System.out.println("+------------------------+");
            System.out.println("| DIGITE [1] para Insert |");
            System.out.println("| DIGITE [2] para List   |");
            System.out.println("| DIGITE [3] para Sair   |");
            System.out.println("+------------------------+");

            esc = ler.nextInt();
            System.out.print("\033[H\033[2J");
            if(esc == 1){
                System.out.println("+------------------------+\n|       Digite o id      |\n+------------------------+");
                id = ler.next();
                System.out.print("\033[H\033[2J");
                System.out.println("+------------------------+\n|   Digite a Matricula   |\n+------------------------+");
                matricula = ler.next();
                System.out.print("\033[H\033[2J");
                System.out.println("+------------------------+\n|       Digite o CPF     |\n+------------------------+");
                cpf = ler.next();
                System.out.print("\033[H\033[2J");
                System.out.println("+------------------------+\n|      Digite o Nome     |\n+------------------------+");
                nome = ler.next();
                System.out.print("\033[H\033[2J");
                System.out.println("+------------------------+\n|      Digite o email    |\n+------------------------+");
                email = ler.next();
                System.out.print("\033[H\033[2J");
                System.out.println("+------------------------+\n|    Digite o Telefone   |\n+------------------------+");
                telefone = ler.next();

                alunos.insert(new Aluno(id, matricula, cpf, nome, email, telefone), connection);
                System.out.print("\033[H\033[2J");
            }

            if(esc == 2){
                System.out.print("\033[H\033[2J");
                alunos.list(connection);
            }

            if(esc == 3){
                aux = 1;
                System.out.print("\033[H\033[2J");
            }

        }
        ler.close();
        connection.close();
    }
}