import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner ler = new Scanner(System.in);
        Connection connection = ConnectionFactory.getConnection();
        DAO alunos = new AlunoDAO();
        int esc = 0;
        int aux = 0;
        
        
        while(aux == 0){
            String matricula = "", cpf = "", nome = "", email = "", telefone = "";
            int id = 0;
            System.out.println("+------------------------+");
            System.out.println("|          MENU          |");
            System.out.println("+------------------------+");
            System.out.println("| DIGITE [1] para Insert |");
            System.out.println("| DIGITE [2] para List   |");
            System.out.println("| DIGITE [3] para Update |");
            System.out.println("| DIGITE [4] para Delete |");
            System.out.println("| DIGITE [5] para Sair   |");
            System.out.println("+------------------------+");

            esc = ler.nextInt();
            if(esc == 1){
                System.out.println("+------------------------+\n|       Digite o id      |\n+------------------------+");
                id = ler.nextInt();
    
                System.out.println("+------------------------+\n|   Digite a Matricula   |\n+------------------------+");
                matricula = ler.next();
                
                System.out.println("+------------------------+\n|       Digite o CPF     |\n+------------------------+");
                cpf = ler.next();
                
                System.out.println("+------------------------+\n|      Digite o Nome     |\n+------------------------+");
                nome = ler.next();
                
                System.out.println("+------------------------+\n|      Digite o email    |\n+------------------------+");
                email = ler.next();
                
                System.out.println("+------------------------+\n|    Digite o Telefone   |\n+------------------------+");
                telefone = ler.next();

                alunos.insert(new Aluno(id, matricula, cpf, nome, email, telefone), connection);
                System.out.print("\033[H\033[2J");
            }

            if(esc == 2){
                System.out.print("\033[H\033[2J");
                System.out.println("+------------------------+\n|          List          |\n+------------------------+");
                alunos.list(connection);

            }

            if(esc == 3){
                System.out.println("+------------------------+\n|         UPDATE         |\n+------------------------+");
                System.out.println("+------------------------+\n|       Digite o id      |\n+------------------------+");
                id = ler.nextInt();
    
                System.out.println("+------------------------+\n|   Digite a Matricula   |\n+------------------------+");
                matricula = ler.next();
                
                System.out.println("+------------------------+\n|       Digite o CPF     |\n+------------------------+");
                cpf = ler.next();
                
                System.out.println("+------------------------+\n|      Digite o Nome     |\n+------------------------+");
                nome = ler.next();
                
                System.out.println("+------------------------+\n|      Digite o email    |\n+------------------------+");
                email = ler.next();
                
                System.out.println("+------------------------+\n|    Digite o Telefone   |\n+------------------------+");
                telefone = ler.next();
                
                alunos.update(connection, new Aluno(id, matricula, cpf, nome, email, telefone));
                System.out.print("\033[H\033[2J");
            }

            if(esc == 4){
                System.out.println("+------------------------+\n|       Digite o id      |\n+------------------------+");
                alunos.delete(connection, ler.nextInt());
            }

            if(esc == 5){
                aux = 1;
                System.out.print("\033[H\033[2J");
            }

        }
        ler.close();
        connection.close();
    }
}
