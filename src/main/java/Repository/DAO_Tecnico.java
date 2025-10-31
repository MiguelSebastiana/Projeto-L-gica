package Repository;


import DataBase.ConnectionFactory;
import Model.MODEL_Tecnico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DAO_Tecnico {

    // Create

    public void insert_Tecnico(int id, String nome, String cpf, int nivelacesso, String telefone, double salario,
                               Date datanasci, String email, int cargahoraria, String formacao, int id_setor,String especialidade_tecnico, boolean status_disponibilidade_tecnico){

    }

    // Read

    public ArrayList<MODEL_Tecnico> find_All_Tecnico(){
        ArrayList<MODEL_Tecnico> tecnicos = new ArrayList<>();

        String querySql = "SELECT u.*, t.especialidade_tecnico, t.status_disponibilidade_tecnico\n" +
                "FROM Usuario u\n" +
                "inner JOIN Tecnico t ON u.id_usuario = t.Usuario_id_usuario;";

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
                Date dataNascimento = resultSet.getDate("data_nasc_usuario");
                String emailUsuario = resultSet.getString("email_usuario");
                int cargaHoraria = resultSet.getInt("carga_horaria_minutos_usuario");
                String formacaoUsuario = resultSet.getString("formacao_usuario");
                int idSetor = resultSet.getInt("Setor_id_setor");
                String especialidadeTecnico = resultSet.getString("especialidade_tecnico");
                boolean statusDisponibilidadeTecnico = resultSet.getBoolean("status_disponibilidade_tecnico");

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
                "WHERE t.id_tecnico = ?;";

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
                    Date dataNascimento = resultSet.getDate("data_nasc_usuario");
                    String emailUsuario = resultSet.getString("email_usuario");
                    int cargaHoraria = resultSet.getInt("carga_horaria_minutos_usuario");
                    String formacaoUsuario = resultSet.getString("formacao_usuario");
                    int idSetor = resultSet.getInt("Setor_id_setor");
                    String especialidadeTecnico = resultSet.getString("especialidade_tecnico");
                    boolean statusDisponibilidadeTecnico = resultSet.getBoolean("status_disponibilidade_tecnico");

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

    }

    public void update_Disponibilidade(MODEL_Tecnico tecnico, boolean disponibilidade){

    }

    // Delete

    public void delete_Tecnico(MODEL_Tecnico tecnico){

    }

}
