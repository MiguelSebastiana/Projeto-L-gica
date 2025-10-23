import java.sql.*;
import java.util.ArrayList;

public class DAO_Setor
{

    public ArrayList<MODEL_Setor> findAllSetores()
    {
        ArrayList<MODEL_Setor> listaSetores = new ArrayList<>();
        String querySql = "SELECT * FROM Setor;";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql);
             ResultSet resultSet = stmt.executeQuery())
        {

            while (resultSet.next())
            {
                int id_setor = resultSet.getInt("id_setor");
                String nome_setor = resultSet.getString("nome_setor");
                String descricao_setor = resultSet.getString("descricao_setor");

                MODEL_Setor setor = new MODEL_Setor(id_setor, nome_setor, descricao_setor);


                listaSetores.add(setor);
            }

        } catch (SQLException e) {

            System.err.println("Não foi possível buscar todos os setores: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return listaSetores;
    }


}