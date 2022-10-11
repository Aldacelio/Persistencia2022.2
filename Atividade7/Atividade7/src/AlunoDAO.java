import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO implements DAO{

    public void insert(Aluno aluno, Connection connection) {
        try {
            Class.forName("org.postgresql.Driver");

            String insert = "insert into aluno (id, matricula ,cpf ,nome ,email ,telefone ) values (?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            
            preparedStatement.setInt(1, aluno.getId());
            preparedStatement.setString(2, aluno.getMatricula());
            preparedStatement.setString(3, aluno.getCpf());
            preparedStatement.setString(4, aluno.getNome());
            preparedStatement.setString(5, aluno.getEmail());
            preparedStatement.setString(6, aluno.getTelefone());

            preparedStatement.execute();
            preparedStatement.close(); 

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void list(Connection connection){
        try {
            String select = "select * from aluno";
            PreparedStatement preparedStatement = connection.prepareStatement(select);

            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()){
                Aluno aluno = new Aluno();
                aluno.setId(result.getInt("id"));
                aluno.setMatricula(result.getString("matricula"));
                aluno.setCpf(result.getString("cpf"));
                aluno.setNome(result.getString("nome"));
                aluno.setEmail(result.getString("email"));
                aluno.setTelefone(result.getString("telefone"));
                
                System.out.println("+--------------------  ----- ---- --- -- -    -      -");
                System.out.println("|" + aluno);
                System.out.println("+----------------------------------------  -- ---  ------ -- -  - -  -");
            }
            

            result.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Connection connection, int id){
        try {
            String delete = "delete from aluno where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        }
        
    }

    public void update(Connection connection, Aluno aluno){
        try {
            String update = "update aluno set matricula = ?, cpf = ?, nome = ?, email = ?, telefone = ? where id = ?";
            PreparedStatement preparedStatement;
            if(aluno.getId() == 0){
                System.out.println("Este Id não existe");
                return;
            }else{
                preparedStatement = connection.prepareStatement(update);
                preparedStatement.setInt(6, aluno.getId());
            }
            preparedStatement.setString(1, aluno.getMatricula());
            preparedStatement.setString(2, aluno.getCpf());
            preparedStatement.setString(3, aluno.getNome());
            preparedStatement.setString(4, aluno.getEmail());
            preparedStatement.setString(5, aluno.getTelefone());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        }
    }



}