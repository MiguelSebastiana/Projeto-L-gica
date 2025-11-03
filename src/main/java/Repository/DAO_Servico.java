package Repository;

import DataBase.ConnectionFactory;
import Model.MODEL_Servico;

import java.sql.*;
import java.util.ArrayList;

public class DAO_Servico
{

    // Create

    public void insert_Servico(MODEL_Servico servico){

        String querySql = "insert into Ordem_servico(status_aberto_ordem_servico,descricao_ordem_servico," +
                "Tecnico_id_tecnico, Maquina_id_maquina) values(?,?,?,?);";

        try(Connection conexao = ConnectionFactory.getConn();
            PreparedStatement stmt = conexao.prepareStatement(querySql);
            ResultSet resultSet = stmt.executeQuery())
        {

            stmt.setString(1,servico.getStatus_aberto_ordem_servico());
            stmt.setString(2,servico.getDescricao_ordem_servico());
            stmt.setInt(3,servico.getTecnico());
            stmt.setInt(4,servico.getMaquina());
            stmt.executeQuery();

            String querySql2 = "";

            try
            {

                int id= resultSet.getInt("id_ordem_servico");

                MODEL_Servico servico1 = new MODEL_Servico(id,servico.getStatus_aberto_ordem_servico(),servico.getDescricao_ordem_servico(),servico.getTecnico(),servico.getMaquina());

            }catch (Exception e){

                System.err.println("Não foi possível buscar a orden de serviço: " + e.getMessage());

                throw new RuntimeException("Erro ao consultar o banco de dados.", e);
            }

        }catch (SQLException e){

            System.err.println("Não foi possível inserir a orden de serviço: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }
    }

    // Read

    public ArrayList<MODEL_Servico> find_All_Ordens_Servico()
    {
        ArrayList<MODEL_Servico> listaOrdens = new ArrayList<>();

        String querySql = "SELECT " +
                "    os.id_ordem_servico, " +
                "    os.status_aberto_ordem_servico, " +
                "    os.descricao_ordem_servico, " +

                "    m.id_maquina, " +
                "    m.descricao_maquina, " +
                "    m.modelo_maquina, " +
                "    m.status_funcionamento_maquina, " +

                "    t.id_tecnico, " +
                "    t.especialidade_tecnico, " +

                "    u.id_usuario, " +
                "    u.nome_usuario, " +
                "    u.cpf_usuario, " +
                "    u.nivel_acesso_usuario, " +
                "    u.telefone_usuario, " +
                "    u.salario_usuario, " +
                "    u.data_nasc_usuario, " +
                "    u.email_usuario, " +
                "    u.carga_horaria_minutos_usuario, " +
                "    u.formacao_usuario, " +
                "    u.Setor_id_setor " +

                "FROM " +
                "    Ordem_servico os " +
                "JOIN " +
                "    Tecnico t ON os.Tecnico_id_tecnico = t.id_tecnico " +
                "JOIN " +
                "    Maquina m ON os.Maquina_id_maquina = m.id_maquina " +
                "JOIN " +

                "    Usuario u ON t.id_tecnico = u.id_usuario;";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql);
             ResultSet resultSet = stmt.executeQuery())
        {

            while (resultSet.next())
            {
                int id_ordem_servico = resultSet.getInt("id_ordem_servico");
                String status_aberto_ordem_servico = resultSet.getString("status_aberto_ordem_servico");
                String descricao_ordem_servico = resultSet.getString("descricao_ordem_servico");

                int id_usuario = resultSet.getInt("id_usuario");
                String nome_usuario = resultSet.getString("nome_usuario");
                String cpf_usuario = resultSet.getString("cpf_usuario");
                int nivel_acesso_usuario = resultSet.getInt("nivel_acesso_usuario");
                String telefone_usuario = resultSet.getString("telefone_usuario");

               double salario_usuario = resultSet.getDouble("salario_usuario");

                java.sql.Date data_nasc_usuario = resultSet.getDate("data_nasc_usuario");
                String email_usuario = resultSet.getString("email_usuario");
                int carga_horaria_minutos_usuario = resultSet.getInt("carga_horaria_minutos_usuario");
                String formacao_usuario = resultSet.getString("formacao_usuario");
                int Setor_id_setor = resultSet.getInt("Setor_id_setor");


                int id_tecnico = resultSet.getInt("id_tecnico");
                String especialidade_tecnico = resultSet.getString("especialidade_tecnico");


                int id_maquina = resultSet.getInt("id_maquina");
                String descricao_maquina = resultSet.getString("descricao_maquina");
                String modelo_maquina = resultSet.getString("modelo_maquina");
                String status_funcionamento_maquina = resultSet.getString("status_funcionamento_maquina");
                boolean status_disponibilidade_tecnico = resultSet.getBoolean("status_disponibilade_tecnico");


                MODEL_Servico ordemServico = new MODEL_Servico
                        (
                        id_ordem_servico,
                        status_aberto_ordem_servico,
                        descricao_ordem_servico,
                        id_tecnico,
                        id_maquina
                );

                listaOrdens.add(ordemServico);
            }


        } catch (SQLException e) {

            System.err.println("Não foi possível buscar todas as ordens de serviço: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return listaOrdens;
    }

    public MODEL_Servico find_By_Id(int id){

        MODEL_Servico servico = null;

        String querySql = "select os.status_aberto_ordem_servico, os.descricao_ordem_servico, os.Tecnico_id_tecnico, os.Maquina_id_maquina\n" +
                "from Ordem_servico os\n" +
                "where os.id_ordem_servico = ?;";

        try(Connection conexao = ConnectionFactory.getConn();
        PreparedStatement stmt = conexao.prepareStatement(querySql);
        ResultSet resultSet = stmt.executeQuery())
        {

            stmt.setInt(1,id);

            String status = resultSet.getString("status_aberto_ordem_servico");
            String descricao = resultSet.getString("descricao_ordem_servico");
            int tecnico_id = resultSet.getInt("Tecnico_id_tecnico");
            int maquina_id = resultSet.getInt("Maquina_id_maquina");

            MODEL_Servico servico1 = new MODEL_Servico(id,status,descricao,tecnico_id,maquina_id);

        }catch (SQLException e){

            System.err.println("Não foi possível buscar a orden de serviço: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return servico;
    }

    public ArrayList<MODEL_Servico> find_By_Pendente(){


    }

    // Update

    public void update_Status(MODEL_Servico servico, int status){

    }

    public void update_Descricao(MODEL_Servico servico, String descricao){

    }

    public void update_Id_Tecnico(MODEL_Servico servico, int id){

    }

    public void update_Id_Maquina(MODEL_Servico servico, int id){

    }

    // Delete

    public void delete_Servico(MODEL_Servico servico){
        String querySql = "delete from Ordem_servico as o\n" + "where o.id_ordem_servico = ?";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql)) {

            stmt.setInt(1,servico.getId_Ordem_servico());
            stmt.executeQuery();

        }
        catch (SQLException e){
            System.err.println("Não foi possível excluir o Serviço: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }
    }
}

