import java.sql.Connection;

public interface DAO {

    public void insert(Aluno aluno, Connection connection);

    public void list(Connection connection);

    public void delete(Connection connection, int id);

    public void update(Connection connection, Aluno aluno);

}
