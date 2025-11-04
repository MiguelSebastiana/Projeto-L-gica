package Repository;

import DataBase.ConnectionFactory;
import Model.MODEL_Supervisor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class DAO_Supervisor {

    // Create


    public void insert_Supervisor(MODEL_Supervisor supervisor){

        String sql = "INSERT INTO SUPER_VISOR (nome_usuario, cpf_usuario, senha_usuario, nivelacesso_usuario, " +
                "telefone_usuario, salario_usuario, " + "data_nasc_usuario, email_usuario, cargahoraria_minutos, formacao_usuario, Setor_id_setor," +
                " experiencia_anos_supervisor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {

            java.sql.Date dataParaSQL = java.sql.Date.valueOf(supervisor.getDatanasci());

            stmt.setString(1, supervisor.getNome());
            stmt.setString(2, supervisor.getCpf());
            stmt.setString(3, supervisor.getSenha());
            stmt.setInt(4, supervisor.getNivelacesso());
            stmt.setString(5, supervisor.getTelefone());
            stmt.setDouble(6, supervisor.getSalario());
            stmt.setDate(7, dataParaSQL);
            stmt.setString(8, supervisor.getEmail());
            stmt.setInt(9, supervisor.getCargahoraria());
            stmt.setString(10, supervisor.getFormacao());
            stmt.setInt(11, supervisor.getSetor());
            stmt.setInt(12, supervisor.getExperiencia_anos_supervisor());
            stmt.executeUpdate();

            String sql2 = "select u.id_usuario " +
                    "from Usuario u " +
                    "inner join Supervisor s on u.id_usuario = s.Usuario_id_usuario " +
                    "where u.cpf_usuario = ?";

            try {
                    stmt.setString(1, supervisor.getCpf());
                    stmt.executeQuery();

                    int idUsuario = resultSet.getInt("id_usuario");

                    MODEL_Supervisor supervisor1 = new MODEL_Supervisor(idUsuario,supervisor.getNome(),supervisor.getCpf(),supervisor.getSenha(),
                            supervisor.getNivelacesso(),supervisor.getTelefone(),supervisor.getSalario(), supervisor.getDatanasci(),
                            supervisor.getEmail(), supervisor.getCargahoraria(), supervisor.getFormacao(), supervisor.getSetor(),
                            supervisor.getExperiencia_anos_supervisor());

            } catch (SQLException e) {

                System.err.println("Não foi possível criar o Supervisor: " + e.getMessage());

                throw new RuntimeException("Erro ao consultar o banco de dados.", e);
            }
        }catch (SQLException e) {

        System.err.println("Não foi possível criar o Supervisor: " + e.getMessage());

        throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }
    }


    // Read

    public ArrayList<MODEL_Supervisor> find_All_Supervisores(){
        ArrayList<MODEL_Supervisor> listaSuperVisores = new ArrayList<>();

        MODEL_Supervisor supervisor = null;

        String querySql = "select u.*,s.experiencia_anos_superVisor " +
                "from Usuario u " +
                "inner join Supervisor s on u.id_usuario = s.id_supervisor " +
                "order by u.id_usuario ";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {

                int idSupervisor = resultSet.getInt("id_usuario");
                String nomeSupervisor = resultSet.getString("nome_usuario");
                String cpfSupervisor = resultSet.getString("cpf_usuario");
                String senhaSupervisor = resultSet.getString("senha_usuario");
                int nivelAcesso = resultSet.getInt("nivel_acesso_usuario");
                String telefoneSupervisor = resultSet.getString("telefone_usuario");
                Double salarioSupervisor = resultSet.getDouble("salario_usuario");
                Date dataNasciment = resultSet.getDate("data_nasc_usuario");
                String emailSupervisor = resultSet.getString("email_usuario");
                int cargaHoraria = resultSet.getInt("carga_horaria_minutos_usuario");
                String formacaoSupervisor = resultSet.getString("formacao_usuario");
                int idSetor = resultSet.getInt("Setor_id_setor");
                int anosExperiencia = resultSet.getInt("experiencia_anos_supervisor");

                LocalDate dataNascimento = LocalDate.ofInstant(dataNasciment.toInstant(),ZoneId.systemDefault());

                supervisor = new MODEL_Supervisor(idSupervisor,nomeSupervisor,cpfSupervisor,senhaSupervisor,nivelAcesso,
                        telefoneSupervisor,salarioSupervisor,dataNascimento,emailSupervisor,cargaHoraria,formacaoSupervisor,idSetor,anosExperiencia);

                listaSuperVisores.add(supervisor);
            }

        } catch (SQLException e) {

            System.err.println("Não foi possível buscar todos os supervisores: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return listaSuperVisores;

    }

    public MODEL_Supervisor find_By_Id(int id) {

        String id_supervisor = String.valueOf(id);
        MODEL_Supervisor supervisor = null;

        String querySql = "select * from Supervisor s " +
                "join Usuario u on s.Usuario_id_usuario = u.id_usuario " +
                "where id_usuario = ?";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql)) {

             stmt.setInt(1, id);

             try(ResultSet resultSet = stmt.executeQuery()) {

                 while (resultSet.next()) {
                     int idSupervisor = resultSet.getInt("id_usuario");
                     String nomeSupervisor = resultSet.getString("nome_usuario");
                     String cpfSupervisor = resultSet.getString("cpf_usuario");
                     String senhaSupervisor = resultSet.getString("senha_usuario");
                     int nivelAcesso = resultSet.getInt("nivel_acesso_usuario");
                     String telefoneSupervisor = resultSet.getString("telefone_usuario");
                     Double salarioSupervisor = resultSet.getDouble("salario_usuario");
                     Date dataNasciment = resultSet.getDate("data_nasc_usuario");
                     String emailSupervisor = resultSet.getString("email_usuario");
                     int cargaHoraria = resultSet.getInt("carga_horaria_minutos_usuario");
                     String formacaoSupervisor = resultSet.getString("formacao_usuario");
                     int idSetor = resultSet.getInt("Setor_id_setor");
                     int anosExperiencia = resultSet.getInt("experiencia_anos_supervisor");

                     LocalDate dataNascimento = LocalDate.ofInstant(dataNasciment.toInstant(), ZoneId.systemDefault());

                     supervisor = new MODEL_Supervisor(idSupervisor, nomeSupervisor, cpfSupervisor, senhaSupervisor, nivelAcesso,
                             telefoneSupervisor, salarioSupervisor, dataNascimento, emailSupervisor, cargaHoraria, formacaoSupervisor, idSetor, anosExperiencia);
                 }
             }

        } catch (SQLException e) {

            System.err.println("Não foi possível buscar o supervisor: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return supervisor;

    }

    // Update

    public void update_Experiencia(MODEL_Supervisor supervisor, int experiencia) {


        String querySql = "update Usuario as u " +
                "inner join Supervisor s on u.id_usuario = s.Usuario_id_usuario " +
                "set experiencia_anos_supervisor = ? " +
                "where id_usuario = ?";

        try (
                Connection conexao = ConnectionFactory.getConn();
                PreparedStatement stmt = conexao.prepareStatement(querySql))
        {
            stmt.setInt(1, experiencia);
            stmt.setInt(2, supervisor.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Não foi possível buscar o supervisor: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }
    }

    // Delete

    public void delete_Supervisor(MODEL_Supervisor supervisor){

        String querySql = "delete from Usuario as u " + "where u.id_usuario = ?";

        String querySql2 = "delete from Supervisor as s " + "where s.id_usuario = ?";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql)) {

            stmt.setInt(1,supervisor.getId());
            stmt.executeUpdate();

            try(PreparedStatement stmt2 = conexao.prepareStatement(querySql2)){

                stmt2.setInt(2,supervisor.getId());
                stmt2.executeUpdate();

            }catch (SQLException e){
                System.err.println("Não foi possível excluir o Supervisor: " + e.getMessage());

                throw new RuntimeException("Erro ao consultar o banco de dados.", e);
            }

        }
        catch (SQLException e){
            System.err.println("Não foi possível excluir o Supervisor: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

    }


}
