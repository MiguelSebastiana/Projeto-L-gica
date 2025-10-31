package Repository;

import DataBase.ConnectionFactory;
import Model.MODEL_Supervisor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

            stmt.setString(1, supervisor.getNome());
            stmt.setString(2, supervisor.getCpf());
            stmt.setString(3, supervisor.getSenha());
            stmt.setInt(4, supervisor.getNivelacesso());
            stmt.setString(5, supervisor.getTelefone());
            stmt.setDouble(6, supervisor.getSalario());
            stmt.setDate(7, (java.sql.Date) supervisor.getDatanasci());
            stmt.setString(8, supervisor.getEmail());
            stmt.setInt(9, supervisor.getCargahoraria());
            stmt.setString(10, supervisor.getFormacao());
            stmt.setInt(11, supervisor.getSetor());
            stmt.setInt(12, supervisor.getExperiencia_anos_supervisor());
            stmt.executeQuery();

            String sql2 = "select u.id_usuario\n" +
                    "from Usuario u\n" +
                    "inner join Supervisor s on u.id_usuario = s.Usuario_id_usuario\n" +
                    "where u.cpf_usuario = ?";

            try {
                    stmt.setString(1, supervisor.getCpf());
                    stmt.executeQuery();

                    int idUsuario = resultSet.getInt("id_usuario");

                    MODEL_Supervisor supervisor1 = new MODEL_Supervisor(idUsuario,supervisor.getNome(),supervisor.getCpf(),supervisor.getSenha(),
                            supervisor.getNivelacesso(),supervisor.getTelefone(),supervisor.getSalario(),(java.sql.Date) supervisor.getDatanasci(),
                            supervisor.getEmail(), supervisor.getCargahoraria(), supervisor.getFormacao(), supervisor.getSetor(),
                            supervisor.getExperiencia_anos_supervisor());

            } catch (SQLException e) {

                System.err.println("Não foi possível buscar todos os supervisores: " + e.getMessage());

                throw new RuntimeException("Erro ao consultar o banco de dados.", e);
            }
        }catch (SQLException e) {

        System.err.println("Não foi possível buscar todos os supervisores: " + e.getMessage());

        throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }
    }


    // Read

    public ArrayList<MODEL_Supervisor> find_All_Supervisores(){
        ArrayList<MODEL_Supervisor> listaSuperVisores = new ArrayList<>();

        MODEL_Supervisor supervisor = null;

        String querySql = "select u.*,s.experiencia_anos_superVisor\n" +
                "from Usuario u \n" +
                "inner join Supervisor s on u.id_usuario = s.id_supervisor\n" +
                "order by u.id_usuario;";

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
                Date dataNascimento = resultSet.getDate("data_nasc_usuario");
                String emailSupervisor = resultSet.getString("email_usuario");
                int cargaHoraria = resultSet.getInt("carga_horaria_minutos_usuario");
                String formacaoSupervisor = resultSet.getString("formacao_usuario");
                int idSetor = resultSet.getInt("Setor_id_setor");
                int anosExperiencia = resultSet.getInt("experiencia_anos_supervisor");

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

        String querySql = "select * from Supervisor s\n" +
                "join Usuario u on s.Usuario_id_usuario = u.id_usuario\n" +
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
                     Date dataNascimento = resultSet.getDate("data_nasc_usuario");
                     String emailSupervisor = resultSet.getString("email_usuario");
                     int cargaHoraria = resultSet.getInt("carga_horaria_minutos_usuario");
                     String formacaoSupervisor = resultSet.getString("formacao_usuario");
                     int idSetor = resultSet.getInt("Setor_id_setor");
                     int anosExperiencia = resultSet.getInt("experiencia_anos_supervisor");

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


        String querySql = "update Usuario as u\n" +
                "inner join Supervisor s on u.id_usuario = s.Usuario_id_usuario\n" +
                "set experiencia_anos_supervisor = ?\n" +
                "where id_usuario = ?";

        try (
                Connection conexao = ConnectionFactory.getConn();
                PreparedStatement stmt = conexao.prepareStatement(querySql))
        {
            stmt.setInt(1, experiencia);
            stmt.setInt(2, supervisor.getId());
            stmt.executeQuery();

        } catch (SQLException e) {

            System.err.println("Não foi possível buscar o supervisor: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }
    }

    // Delete

    public void delete_Supervisor(MODEL_Supervisor supervisor){

    }


}
