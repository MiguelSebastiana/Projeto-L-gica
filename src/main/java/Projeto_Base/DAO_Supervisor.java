package Projeto_Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DAO_Supervisor {


    // Create

    public void insert_Supervisor(int id, String nome, String cpf, int nivelacesso, String telefone, double salario,
                                  Date datanasci, String email, int cargahoraria, String formacao, int id_setor,int experiencia){

        String sql = "INSERT INTO SUPER_VISOR (id, nome, cpf, nivelacesso, telefone, salario, datanasci, email, cargahoraria, formacao, id_setor, experiencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

    }

    // Read

    public ArrayList<MODEL_Supervisor> find_All_Supervisores(){
        ArrayList<MODEL_Supervisor> listaSuperVisores = new ArrayList<>();

        String querySql = "select u.*,s.experiencia_anos_superVisor\n" +
                "from Usuario u \n" +
                "inner join Supervisor s on u.id_usuario = s.id_supervisor\n" +
                "order by u.id_usuario;";



    }

    public MODEL_Supervisor find_By_Id(int id) {
        String id_supervisor = String.valueOf(id);
        MODEL_Supervisor supervisor = null;

        String querySql = "select * from Supervisor s\n" +
                "join Usuario u on s.Usuario_id_usuario = u.id_usuario\n" +
                "where id_usuario = " + "id_supervisor";

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

                supervisor = new MODEL_Supervisor(id,nomeSupervisor,cpfSupervisor,senhaSupervisor,nivelAcesso,
                        telefoneSupervisor,salarioSupervisor,dataNascimento,emailSupervisor,cargaHoraria,formacaoSupervisor,idSetor,anosExperiencia);
            }


        } catch (SQLException e) {

            System.err.println("Não foi possível buscar todos os usuários: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return supervisor;

    }

    // Update

    public void update_Experiencia(MODEL_Supervisor supervisor, int experiencia){



    }

    // Delete

    public void delete_Supervisor(MODEL_Supervisor supervisor){

    }


}
