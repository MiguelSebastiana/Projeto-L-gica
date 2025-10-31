package Repository;

import DataBase.ConnectionFactory;
import Model.MODEL_Maquina;

import java.sql.*;
import java.util.ArrayList;

public class DAO_Maquina
{

    // Read

    public ArrayList<MODEL_Maquina> find_All_Maquinas()
    {
        ArrayList<MODEL_Maquina> listaMaquinas = new ArrayList<>();
        String querySql = "SELECT " +
                "    m.id_maquina, " +
                "    m.descricao_maquina, " +
                "    m.modelo_maquina, " +
                "    m.status_funcionamento_maquina, " +
                "    s.id_setor, " +
                "    s.nome_setor, " +
                "    s.descricao_setor " +
                "FROM " +
                "    Maquina m " +
                "JOIN " +
                "    Setor s ON m.id_setor = s.id_setor;";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql);
             ResultSet resultSet = stmt.executeQuery())
        {

            while (resultSet.next())
            {
                int id_maquina = resultSet.getInt("id_maquina");
                String descricao_maquina = resultSet.getString("descricao_maquina");
                String modelo_maquina = resultSet.getString("modelo_maquina");
                String status_funcionamento_maquina = resultSet.getString("status_funcionamento_maquina");
                int id_setor = resultSet.getInt("id_setor");

                MODEL_Maquina maquina = new MODEL_Maquina(id_maquina, descricao_maquina, modelo_maquina, status_funcionamento_maquina, id_setor);


                listaMaquinas.add(maquina);
            }

        } catch (SQLException e) {

            System.err.println("Não foi possível buscar todos os setores: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return listaMaquinas;
    }

    public MODEL_Maquina find_By_Id(int id){

        String id_maquina = String.valueOf(id);
        MODEL_Maquina maquina = null;

        String querySql = "select m.id_maquina, m.descricao_maquina, m.modelo_maquina, m.status_funcionamento_maquina, m.Setor_id_setor\n" +
                "from Maquina m\n" +
                "where m.id_maquina = ?";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql);
             ResultSet resultSet = stmt.executeQuery()){

             stmt.setInt(1,id);

            while (resultSet.next()){

                int idMaquina = resultSet.getInt("id_maquina");
                String descricao = resultSet.getString("descricao_maquina");
                String modelo = resultSet.getString("modelo_maquina");
                String status = resultSet.getString("status_funcionamento_maquina");
                int setor = resultSet.getInt("Setor_id_setor");

                maquina = new MODEL_Maquina(idMaquina,descricao,modelo,status,setor);

            }
        }
        catch (SQLException e){
            System.err.println("Não foi possível buscar o Gerente: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return maquina;
    }


}