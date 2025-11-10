package Repository;

import DataBase.ConnectionFactory;
import Model.MODEL_Ordem_Preditiva;

import java.sql.*;
import java.util.ArrayList;
// ADICIONAR GERENTE EM CONSULTAS


public class DAO_Ordem_preditiva
{

    // Create

    public void insert_Servico(MODEL_Ordem_Preditiva op){

        String querySql = "insert into Ordem_Preditiva(status_aberto_ordem_preditiva,descricao_ordem_preditiva, horario_ordem_preditiva" +
                "Tecnico_id_tecnico, Maquina_id_maquina, Custo, Gerente_id_gerente) values(?,?,?,?,?,?,?) ";

        try(Connection conexao = ConnectionFactory.getConn();
            PreparedStatement stmt = conexao.prepareStatement(querySql);
            ResultSet resultSet = stmt.executeQuery())
        {

            stmt.setString(1,op.getStatus_aberto_ordem_preditiva());
            stmt.setString(2,op.getDescricao_ordem_preditiva());
            stmt.setInt(3,op.getTecnico());
            stmt.setInt(4,op.getMaquina());
            stmt.setDouble(5,op.getPreco());
            stmt.setInt(4,op.getGerente());
            stmt.executeQuery();

            String querySql2 = "select os.id_ordem_preditiva " +
                    "from Ordem_preditiva op" +
                    "where op.descricao_ordem_preditiva = ?";

            try
            {


                stmt.executeQuery(querySql2);

                stmt.setString(1,op.getDescricao_ordem_preditiva());

                int id = resultSet.getInt("id_ordem_servico");


                MODEL_Ordem_Preditiva op1 = new MODEL_Ordem_Preditiva(id,op.getStatus_aberto_ordem_preditiva(),op.getDescricao_ordem_preditiva(),op.getTecnico(),op.getMaquina(), op.getGerente(),op.getPreco(), op.getHorario());

            }catch (Exception e){

                System.err.println("Não foi possível buscar a ordem preditiva: " + e.getMessage());

                throw new RuntimeException("Erro ao consultar o banco de dados.", e);
            }

        }catch (SQLException e){

            System.err.println("Não foi possível inserir a ordem de preditiva: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }
    }

    // Read

    public ArrayList<MODEL_Ordem_Preditiva> find_All_Ordens_Preditiva()
    {
        ArrayList<MODEL_Ordem_Preditiva> listaOrdens = new ArrayList<>();

        String querySql = "SELECT " +
                "    op.id_ordem_preditiva, " +
                "    op.status_aberto_ordem_preditiva, " +
                "    op.descricao_ordem_preditiva," +
                "    op.Custo," +
                "    op.horario_ordem_preditiva " +

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
                "    Ordem_preditiva op " +
                "JOIN " +
                "    Tecnico t ON op.Tecnico_id_tecnico = t.id_tecnico " +
                "JOIN " +
                "    Maquina m ON op.Maquina_id_maquina = m.id_maquina " +
                "JOIN " +

                "    Usuario u ON t.id_tecnico = u.id_usuario ";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql);
             ResultSet resultSet = stmt.executeQuery())
        {

            // ADICIONAR GERENTE EM CONSULTAS
            while (resultSet.next())
            {
                int id_ordem_preditiva = resultSet.getInt("id_ordem_preditiva");
                String status_aberto_ordem_preditiva = resultSet.getString("status_aberto_ordem_preditiva");
                String descricao_ordem_preditiva = resultSet.getString("descricao_ordem_preditiva");
                String horario_ordem_preditiva = resultSet.getString("horario_ordem_preditiva");
                double custo = resultSet.getDouble("Custo");

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


                MODEL_Ordem_Preditiva ordemPreditiva = new MODEL_Ordem_Preditiva(id_ordem_preditiva, status_aberto_ordem_preditiva, descricao_ordem_preditiva, id_tecnico, id_maquina, id_gerente,custo, horario_ordem_preditiva);

                listaOrdens.add(ordemPreditiva);
            }


        } catch (SQLException e) {

            System.err.println("Não foi possível buscar todas as ordens preditivas: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return listaOrdens;
    }

    public MODEL_Ordem_Preditiva find_By_Id(int id){

        MODEL_Ordem_Preditiva op = null;

        String querySql = "select op.status_aberto_ordem_Preditiva, op.descricao_ordem_preditiva, op.Tecnico_id_tecnico, op.Maquina_id_maquina, op.Custo, op.horario_ordem_preditiva" +
                "from Ordem_preditiva op " +
                "where op.id_ordem_servico = ? ";

        try(Connection conexao = ConnectionFactory.getConn();
        PreparedStatement stmt = conexao.prepareStatement(querySql);
        ResultSet resultSet = stmt.executeQuery())
        {

            stmt.setInt(1,id);

            String status = resultSet.getString("status_aberto_ordem_preditiva");
            String descricao = resultSet.getString("descricao_ordem_preditiva");
            int tecnico_id = resultSet.getInt("Tecnico_id_tecnico");
            int maquina_id = resultSet.getInt("Maquina_id_maquina");
            String horario = resultSet.getString("horario_ordem_preditiva");
            double custo = resultSet.getDouble("Custo");

            MODEL_Ordem_Preditiva op1 = new MODEL_Ordem_Preditiva(id,status,descricao,tecnico_id,maquina_id, id_gerente,custo, horario);

        }catch (SQLException e){

            System.err.println("Não foi possível buscar a ordem preditiva: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return op;
    }

    public ArrayList<MODEL_Ordem_Preditiva> find_By_Aberta(){

        ArrayList<MODEL_Ordem_Preditiva> ordemPreditivas = new ArrayList<>();

        String querySql = "select op.id_ordem_preditiva,op.status_aberto_ordem_preditiva, op.descricao_ordem_preditiva, op.Tecnico_id_tecnico, op.Maquina_id_maquina, op.Custo, op.horario_ordem_preditiva " +
                "from Ordem_preditiva op " +
                "where  op.status_aberto_ordem_servico = 'Aberta' ";

        try(Connection conexao = ConnectionFactory.getConn();
        PreparedStatement stmt = conexao.prepareStatement(querySql);
        ResultSet resultSet = stmt.executeQuery())
        {

            while (resultSet.next()) {

                int id = resultSet.getInt("id_ordem_preditiva");
                String status = resultSet.getString("status_aberto_ordem_preditiva");
                String descricao = resultSet.getString("descricao_ordem_preditiva");
                int id_tecnico = resultSet.getInt("Tecnico_id_tecnico");
                int id_maquina = resultSet.getInt("Maquina_id_maquina");
                double custo = resultSet.getDouble("Custo");
                String horario = resultSet.getString("horario_ordem_preditiva");

                MODEL_Ordem_Preditiva op = new MODEL_Ordem_Preditiva(id,status,descricao,id_tecnico,id_maquina, id_gerente,custo, horario);

                ordemPreditivas.add(op);
            }

        }catch (SQLException e){

            System.err.println("Não foi possível buscar a ordem preditiva: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return ordemPreditivas;
    }

    // Update

    public void update_Status(int id, String status){

        String querySql = "update Ordem_preditiva op " +
                "set op.status_ordem_preditiva = ? " +
                "where op.id_ordem_preditiva = ?";

        try(Connection conexao = ConnectionFactory.getConn();
        PreparedStatement stmt = conexao.prepareStatement(querySql))
        {
            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeQuery();

        }catch (SQLException e){

            System.err.println("Não foi possível modificar a ordem preditiva: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }
    }

    public void update_Descricao(int id, String descricao){

        String querySql = "update Ordem_preditiva op " +
                "set op.descricao_ordem_preditiva = ?" +
                "where op.id_ordem_preditiva = ? ";

        try(Connection conexao = ConnectionFactory.getConn();
            PreparedStatement stmt = conexao.prepareStatement(querySql))
        {
            stmt.setString(1, descricao);
            stmt.setInt(2, id);
            stmt.executeQuery();

        }catch (SQLException e){

            System.err.println("Não foi possível modificar a ordem preditiva: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

    }

    public void update_Id_Tecnico(int id, int idT){

        String querySql = "update Ordem_preditiva op " +
                "set op.descricao_ordem_preditiva = ? " +
                "where op.Tecnico_id_tecnico = ? ";

        try(Connection conexao = ConnectionFactory.getConn();
            PreparedStatement stmt = conexao.prepareStatement(querySql))
        {
            stmt.setInt(1, idT);
            stmt.setInt(2, id);
            stmt.executeQuery();

        }catch (SQLException e){

            System.err.println("Não foi possível modificar a ordem preditiva: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }
    }

    public void update_Id_Maquina(int id, int idM){

        String querySql = "update Ordem_preditiva op " +
                "set op.descricao_ordem_preditiva = ? " +
                "where op.Maquina_id_maquina = ? ";

        try(Connection conexao = ConnectionFactory.getConn();
            PreparedStatement stmt = conexao.prepareStatement(querySql))
        {
            stmt.setInt(1, idM);
            stmt.setInt(2, id);
            stmt.executeQuery();

        }catch (SQLException e){

            System.err.println("Não foi possível modificar a ordem preditiva: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }
    }

    public void update_Custo(int id, double custo){

        String querySql = "update Ordem_preditiva op " +
                "set op.Custo = ? " +
                "where op.Maquina_id_maquina = ? ";

        try(Connection conexao = ConnectionFactory.getConn();
            PreparedStatement stmt = conexao.prepareStatement(querySql))
        {
            stmt.setDouble(1, custo);
            stmt.setInt(2, id);
            stmt.executeQuery();

        }catch (SQLException e){

            System.err.println("Não foi possível modificar a ordem preditiva: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

    }

    // Delete

    public void delete_Ordem_Preditiva(int id){
        String querySql = "delete from Ordem_preditiva as op " + "where op.id_ordem_preditiva = ?";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql)) {

            stmt.setInt(1,id);
            stmt.executeQuery();

        }
        catch (SQLException e){
            System.err.println("Não foi possível excluir a ordem_preditiva: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }
    }
}

