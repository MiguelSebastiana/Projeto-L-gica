package Repository;

import DataBase.ConnectionFactory;
import Model.MODEL_Supervisor;
import Model.MODEL_Tecnico;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;


public class DAO_Tecnico {

    // Create

    public void insert_Tecnico(MODEL_Tecnico tecnico){
        String sql = "INSERT INTO TECNICO (nome_usuario, cpf_usuario, senha_usuario, nivelacesso_usuario, " +
                "telefone_usuario, salario_usuario, " + "data_nasc_usuario, email_usuario, cargahoraria_minutos, formacao_usuario, Setor_id_setor," +
                " especialidade_tecnico, status_disponibilidade_tecnico ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {

            java.sql.Date dataParaSQL = java.sql.Date.valueOf(tecnico.getDatanasci());

            stmt.setString(1, tecnico.getNome());
            stmt.setString(2, tecnico.getCpf());
            stmt.setString(3, tecnico.getSenha());
            stmt.setInt(4, tecnico.getNivelacesso());
            stmt.setString(5, tecnico.getTelefone());
            stmt.setDouble(6, tecnico.getSalario());
            stmt.setDate(7, dataParaSQL);
            stmt.setString(8, tecnico.getEmail());
            stmt.setInt(9, tecnico.getCargahoraria());
            stmt.setString(10, tecnico.getFormacao());
            stmt.setInt(11, tecnico.getSetor());
            stmt.setString(12, tecnico.getEspecialidade_tecnico());
            stmt.setBoolean(13, tecnico.isStatus_disponibilidade_tecnico());
            stmt.executeQuery();

            String sql2 = "select u.id_usuario " +
                    "from Usuario u " +
                    "inner join Tecnico t on u.id_usuario = t.Usuario_id_usuario " +
                    "where u.cpf_usuario = ?";

            try {
                stmt.setString(1, tecnico.getCpf());
                stmt.executeQuery();

                int idUsuario = resultSet.getInt("id_usuario");

                MODEL_Tecnico tecnico1 = new MODEL_Tecnico(idUsuario, tecnico.getNome(), tecnico.getCpf(), tecnico.getSenha(), tecnico.getNivelacesso(),
                        tecnico.getTelefone(), tecnico.getSalario(),tecnico.getDatanasci(), tecnico.getEmail(), tecnico.getCargahoraria(),
                        tecnico.getFormacao(), tecnico.getSetor(), tecnico.getEspecialidade_tecnico(), tecnico.isStatus_disponibilidade_tecnico());

            } catch (SQLException e) {

                System.err.println("Não foi possível criar o técnico: " + e.getMessage());

                throw new RuntimeException("Erro ao consultar o banco de dados.", e);
            }
        }catch (SQLException e) {

            System.err.println("Não foi possível criar o técnico: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }
    }

    // Read

    public ArrayList<MODEL_Tecnico> find_All_Tecnico(){
        ArrayList<MODEL_Tecnico> tecnicos = new ArrayList<>();

        String querySql = "SELECT u.*, t.especialidade_tecnico, t.status_disponibilidade_tecnico " +
                "FROM Usuario u " +
                "inner JOIN Tecnico t ON u.id_usuario = t.Usuario_id_usuario";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql);
             ResultSet resultSet = stmt.executeQuery())
        {
            while(resultSet.next())
            {
                int idUsuario = resultSet.getInt("id_usuario");
                String nomeUsuario = resultSet.getString("nome_usuario");
                String cpfUsuario = resultSet.getString("cpf_usuario");
                String senhaUsuario = resultSet.getString("senha_usuario");
                int nivelAcesso = resultSet.getInt("nivel_acesso_usuario");
                String telefoneUsuario = resultSet.getString("telefone_usuario");
                double salarioUsuario = resultSet.getDouble("salario_usuario");
                Date dataNasciment = resultSet.getDate("data_nasc_usuario");
                String emailUsuario = resultSet.getString("email_usuario");
                int cargaHoraria = resultSet.getInt("carga_horaria_minutos_usuario");
                String formacaoUsuario = resultSet.getString("formacao_usuario");
                int idSetor = resultSet.getInt("Setor_id_setor");
                String especialidadeTecnico = resultSet.getString("especialidade_tecnico");
                boolean statusDisponibilidadeTecnico = resultSet.getBoolean("status_disponibilidade_tecnico");

                LocalDate dataNascimento = LocalDate.ofInstant(dataNasciment.toInstant(),ZoneId.systemDefault());

                MODEL_Tecnico tecnico = new MODEL_Tecnico(idUsuario,nomeUsuario,cpfUsuario,senhaUsuario,nivelAcesso,
                        telefoneUsuario,salarioUsuario,dataNascimento,emailUsuario,cargaHoraria,formacaoUsuario,idSetor,especialidadeTecnico,statusDisponibilidadeTecnico);

                tecnicos.add(tecnico);
            }
        }
        catch (SQLException e){
            System.err.println("Não foi possível buscar todos os Tecnicos: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return tecnicos;
    }

    public MODEL_Tecnico find_By_Id(int id){
        MODEL_Tecnico tecnico = null;

        String querySql = "SELECT u.*, t.especialidade_tecnico, t.status_disponibilidade_tecnico " +
                "FROM Usuario u " +
                "INNER JOIN Tecnico t ON u.id_usuario = t.Usuario_id_usuario " +
                "WHERE t.id_tecnico = ?";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql)) {

            stmt.setInt(1, id);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) { // aqui é if, pois esperamos apenas 1 técnico
                    int idUsuario = resultSet.getInt("id_usuario");
                    String nomeUsuario = resultSet.getString("nome_usuario");
                    String cpfUsuario = resultSet.getString("cpf_usuario");
                    String senhaUsuario = resultSet.getString("senha_usuario");
                    int nivelAcesso = resultSet.getInt("nivel_acesso_usuario");
                    String telefoneUsuario = resultSet.getString("telefone_usuario");
                    double salarioUsuario = resultSet.getDouble("salario_usuario");
                    Date dataNasciment = resultSet.getDate("data_nasc_usuario");
                    String emailUsuario = resultSet.getString("email_usuario");
                    int cargaHoraria = resultSet.getInt("carga_horaria_minutos_usuario");
                    String formacaoUsuario = resultSet.getString("formacao_usuario");
                    int idSetor = resultSet.getInt("Setor_id_setor");
                    String especialidadeTecnico = resultSet.getString("especialidade_tecnico");
                    boolean statusDisponibilidadeTecnico = resultSet.getBoolean("status_disponibilidade_tecnico");

                    LocalDate dataNascimento = LocalDate.ofInstant(dataNasciment.toInstant(), ZoneId.systemDefault());

                    tecnico = new MODEL_Tecnico(
                            idUsuario, nomeUsuario, cpfUsuario, senhaUsuario, nivelAcesso,
                            telefoneUsuario, salarioUsuario, dataNascimento, emailUsuario,
                            cargaHoraria, formacaoUsuario, idSetor,
                            especialidadeTecnico, statusDisponibilidadeTecnico
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar técnico por ID: " + e.getMessage());
            throw new RuntimeException("Erro ao consultar técnico por ID.", e);
        }

        return tecnico;
    }


    // Update

    public void update_Especialidade(MODEL_Tecnico tecnico, String especialidade){
        String querySql = "update Usuario as u " +
                "inner join Tecnico t on u.id_usuario = t.Usuario_id_usuario " +
                "set especialidade_tecnico = ? " +
                "where id_usuario = ?";
        try (
                Connection conexao = ConnectionFactory.getConn();
                PreparedStatement stmt = conexao.prepareStatement(querySql))
        {
            stmt.setString(1, especialidade);
            stmt.setInt(2, tecnico.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Não foi possível fazer o update de especialidade: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }
    }

    public void update_Disponibilidade(MODEL_Tecnico tecnico, boolean disponibilidade) {
        String status;

        String querySql = "update Usuario as u " +
                "          inner join Tecnico t on u.id_usuario = t.Usuario_id_usuario " +
                "          set status_disponibilidade_tecnico = ? " +
                "          where id_usuario = ?";

        try (
                Connection conexao = ConnectionFactory.getConn();
                PreparedStatement stmt = conexao.prepareStatement(querySql)) {
            if (disponibilidade == false) {
                status = "Em atendimento";
            } else {
                status = "Diponivel";
            }

            stmt.setString(1, status);
            stmt.setInt(2, tecnico.getId());
            stmt.executeUpdate();


        } catch (SQLException e) {

            System.err.println("Não foi possível realizar o update de disponibilidade: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }
    }


    // Delete

    public void delete_Tecnico(MODEL_Tecnico tecnico){
        String querySql = "delete from Usuario as u " + "where u.id_usuario = ?";

        String querySql2 = "delete from Tecnico as t " + "where t.id_usuario = ?";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql)) {

            stmt.setInt(1,tecnico.getId());
            stmt.executeQuery();

            try(PreparedStatement stmt2 = conexao.prepareStatement(querySql2)){

                stmt2.setInt(2,tecnico.getId());
                stmt2.executeQuery();

            }catch (SQLException e){
                System.err.println("Não foi possível excluir o Tecnico: " + e.getMessage());

                throw new RuntimeException("Erro ao consultar o banco de dados.", e);
            }

        }
        catch (SQLException e){
            System.err.println("Não foi possível excluir o Tecnico: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }
    }

}
