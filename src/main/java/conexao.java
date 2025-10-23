import java.sql.*;

public class conexao
{
    private static final String url = "jdbc:mysql://sa-diego2-80f1.d.aivencloud.com:12675/SA_PROJETO";
    private static final String user = "avnadmin";
    private static final String password = "AVNS_B-s0a1jGg_ik3viwPtJ";

    private static Connection conn;

    public static Connection getConn()
    {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }
            else
            {
                return conn;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String sql = "SELECT * FROM Usuario";

        try (Connection conn = getConn();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (conn != null && !conn.isClosed()) {
                System.out.println("✅ Conexão estabelecida com sucesso!");
            }

            boolean achou = false;
            while (rs.next()) {
                achou = true;
                System.out.println("ID: " + rs.getInt("id_usuario"));
                System.out.println("Nome: " + rs.getString("nome_usuario"));
                System.out.println("Email: " + rs.getString("email-usuario"));
                System.out.println("-------------------");
            }

            if (!achou) {
                System.out.println("⚠️ Nenhum registro encontrado na tabela Usuario.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
