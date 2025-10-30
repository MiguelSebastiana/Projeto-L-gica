package Projeto_Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DAO_Usuario
{

    // Read

    public ArrayList<MODEL_Usuario> find_All_Users()
    {

        ArrayList<MODEL_Usuario> listaUsuarios = new ArrayList<>();

        String querySql = "select u.id_usuario, u.nome_usuario, u.cpf_usuario, u.nivel_acesso_usuario,\n" +
                "u.telefone_usuario, u.salario_usuario,u.data_nasc_usuario,u.email_usuario, \n" +
                "u.carga_horaria_minutos_usuario,u.formacao_usuario,\n" +
                " u.Setor_id_setor, g.tempo_na_funcao_anos_gerente,sp.experiencia_anos_supervisor, \n" +
                " t.especialidade_tecnico,t.status_disponibilidade_tecnico\n" +
                "from Usuario u\n" +
                "left join Gerente g on u.id_usuario = g.Usuario_id_usuario\n" +
                "left join Supervisor sp on u.id_usuario = sp.Usuario_id_usuario \n" +
                "left join Tecnico t on u.id_usuario = t.Usuario_id_usuario\n" +
                "order by u.id_usuario;";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql);
             ResultSet resultSet = stmt.executeQuery())
        {
            while (resultSet.next())
            {
                int idUsuario = resultSet.getInt("id_usuario");
                String nomeUsuario = resultSet.getString("nome_usuario");
                String cpfUsuario = resultSet.getString("cpf_usuario");
                int nivelAcesso = resultSet.getInt("nivel_acesso_usuario");
                String telefoneUsuario = resultSet.getString("telefone_usuario");
                Double salarioUsuario = resultSet.getDouble("salario_usuario");
                Date dataNascimento = resultSet.getDate("data_nasc_usuario");
                String emailUsuario = resultSet.getString("email_usuario");
                int cargaHoraria = resultSet.getInt("carga_horaria_minutos_usuario");
                String formacaoUsuario = resultSet.getString("formacao_usuario");
                int idSetor = resultSet.getInt("Setor_id_setor");


                if (nivelAcesso == 1) {
                    String especialidadeTecnico = resultSet.getString("especialidade_tecnico");
                    boolean status;

                    if (resultSet.getString("status_disponibilidade_tecnico").equals("Disponível")) {
                        status = true;
                    } else {
                        status = false;
                    }

                    MODEL_Usuario tecnico = new MODEL_Tecnico(idUsuario, nomeUsuario, cpfUsuario, nivelAcesso, telefoneUsuario, salarioUsuario,
                            dataNascimento, emailUsuario, cargaHoraria, formacaoUsuario, idSetor, especialidadeTecnico, status);

                    listaUsuarios.add(tecnico);
                } else if (nivelAcesso == 2) {
                    int anosSupervisor = resultSet.getInt("experiencia_anos_supervisor");

                    MODEL_Usuario supervisor = new MODEL_Supervisor(idUsuario, nomeUsuario, cpfUsuario, nivelAcesso, telefoneUsuario, salarioUsuario,
                            dataNascimento, emailUsuario, cargaHoraria, formacaoUsuario, idSetor, anosSupervisor);

                    listaUsuarios.add(supervisor);
                } else if (nivelAcesso == 3) {
                    int anosGerente = resultSet.getInt("tempo_na_funcao_anos_gerente");

                    MODEL_Usuario gerente = new MODEL_Gerente(idUsuario, nomeUsuario, cpfUsuario, nivelAcesso, telefoneUsuario, salarioUsuario,
                            dataNascimento, emailUsuario, cargaHoraria, formacaoUsuario, idSetor, anosGerente);

                    listaUsuarios.add(gerente);
                }
            }
        }
        catch (SQLException e)
        {

            System.err.println("Não foi possível buscar todos os usuários: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return listaUsuarios;
    }

    // Update

    public void update_Telefone(MODEL_Usuario usuario, String telefone){

    }

    public void update_Email(MODEL_Usuario usuario, String email){

    }

    public void update_Carga_Horaria(MODEL_Usuario usuario, int carga){

    }

    public void update_Formacao(MODEL_Usuario usuario, String formacao){

    }

    public void update_Setor(MODEL_Usuario usuario, int setor){

    }

    // Outros

    public static void verificar_Login(String cpf, String senha){

    }
}