import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/alunos",
                    "postgres","admin");
            System.out.println("Conectado com SUCESSO ao Postgres");
            return conn;

        } catch (ClassNotFoundException e) {
            System.out.println("Conection FAIL");
            throw new SQLException(e.getMessage());

        }
    }

}