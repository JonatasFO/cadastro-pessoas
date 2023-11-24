import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    private Connection conexao;

    public BancoDeDados() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/faculdade", "root", "root");
        } catch (Exception exception) {
            throw new Exception("Ocorreu um erro na conexao");
        }
    }

    public void fecharConexao() {
        try {
            this.conexao.close();
        } catch (Exception exception) {
            throw new RuntimeException("Ocorreu um erro no encerramento da conexão");
        }
    }

    private void liberar(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (Exception exception) {
            throw new RuntimeException("Ocorreu um erro na liberação do cursor");
        }
    }

    public void cadastrar(Aluno aluno) {
        PreparedStatement psCadastrar = null;

        try {
            psCadastrar = conexao.prepareStatement("INSERT INTO alunos (nome, idade, faculdade) VALUES (?,?,?)");
            psCadastrar.setString(1, aluno.getNome());
            psCadastrar.setInt(2, aluno.getIdade());
            psCadastrar.setString(3, aluno.getFaculdade());
            psCadastrar.executeUpdate();
        } catch (Exception exception) {
            throw new RuntimeException("Ocorreu um erro no cadastro");
        } finally {
            this.liberar(psCadastrar);
        }
    }

    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        PreparedStatement psListar = null;

        try {
            psListar = conexao.prepareStatement("SELECT * FROM alunos ORDER BY nome");
            ResultSet resultSet = psListar.executeQuery();
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                Integer idade = resultSet.getInt("idade");
                String faculdade = resultSet.getString("faculdade");
                alunos.add(new Aluno(nome, idade, faculdade));
            }
        } catch (Exception exception) {
            throw new RuntimeException("Ocorreu um erro para listar os alunos");
        } finally {
            this.liberar(psListar);
            this.fecharConexao();
        }

        return alunos;
    }

}
