package Projeto_Base;

import java.sql.*;
import java.util.ArrayList;

public class DAO_Maquina
{

    public ArrayList<MODEL_Maquina> findAllMaquinas()
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
                String nome_setor = resultSet.getString("nome_setor");
                String descricao_setor = resultSet.getString("descricao_setor");

                MODEL_Setor setor = new MODEL_Setor(id_setor, nome_setor, descricao_setor);

                MODEL_Maquina maquina = new MODEL_Maquina(id_maquina, descricao_maquina, modelo_maquina, status_funcionamento_maquina, setor);


                listaMaquinas.add(maquina);
            }

        } catch (SQLException e) {

            System.err.println("Não foi possível buscar todos os setores: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return listaMaquinas;
    }


}