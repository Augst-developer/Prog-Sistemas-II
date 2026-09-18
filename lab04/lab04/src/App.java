import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App {

    public static void main(String[] args) throws Exception {

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://aws-0-us-west-2.pooler.supabase.com:5432/postgres";
        String username = "postgres.uxarmekrcexqhksekalu";
        String password = "/ctd.49f7Yy9m%A";

        Connection con = DriverManager.getConnection(url, username, password);

        System.out.println("Conectado ao banco!");

        
        //INSERIR FUNCIONÁRIO
        

        String sqlInsertFuncionario =
                "INSERT INTO Funcionario (nome, cargo) VALUES (?, ?)";

        PreparedStatement pstmtFuncionario =
                con.prepareStatement(sqlInsertFuncionario);

        pstmtFuncionario.setString(1, "João Silva");
        pstmtFuncionario.setString(2, "Analista");

        int qte = pstmtFuncionario.executeUpdate();

        if (qte >= 1) {
            System.out.println("Funcionário inserido com sucesso!");
        }

        
        //LISTAR FUNCIONÁRIOS
        
        String sqlSelect =
                "SELECT * FROM Funcionario";

        PreparedStatement pstmtSelect =
                con.prepareStatement(sqlSelect);

        ResultSet rs = pstmtSelect.executeQuery();

        System.out.println("\nFuncionários cadastrados:");

        while (rs.next()) {

            System.out.println(
                    "ID: " + rs.getInt("id") +
                            " | Nome: " + rs.getString("nome") +
                            " | Cargo: " + rs.getString("cargo")
            );
        }

        
        //ATUALIZAR FUNCIONÁRIO
        

        String sqlUpdate =
                "UPDATE Funcionario SET nome = ?, cargo = ? WHERE id = ?";

        PreparedStatement pstmtUpdate =
                con.prepareStatement(sqlUpdate);

        pstmtUpdate.setString(1, "João Santos");
        pstmtUpdate.setString(2, "Desenvolvedor");
        pstmtUpdate.setInt(3, 1);

        int atualizado = pstmtUpdate.executeUpdate();

        if (atualizado >= 1) {
            System.out.println("\nFuncionário atualizado com sucesso!");
        }

        
        //REMOVER FUNCIONÁRIO
        

        String sqlDelete =
                "DELETE FROM Funcionario WHERE id = ?";

        PreparedStatement pstmtDelete =
                con.prepareStatement(sqlDelete);

        pstmtDelete.setInt(1, 1);

        int removido = pstmtDelete.executeUpdate();

        if (removido >= 1) {
            System.out.println("Funcionário removido com sucesso!");
        }

        con.close();
    }
}
