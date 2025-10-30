package Projeto_Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DAO_Gerente {



    // Create

    public void insert_User_Gerente(int id, String nome, String cpf, int nivelacesso, String telefone, double salario,
                                    Date datanasci, String email, int cargahoraria, String formacao, int id_setor, int tempoFuncao){


    }

    // Read

    public ArrayList<MODEL_Gerente> find_All_Gerentes(){


        ArrayList<MODEL_Gerente> listaGerentes = new ArrayList<>();

        String querySql = "select u.*, g.tempo_na_funcao\n" +
                "from Usuario u\n" +
                "inner join Gerente g on u.id_usuario = g.Usuario_id_usuario\n" +
                "order by u.id_usuario;";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                int idUsuario = resultSet.getInt("id_usuario");
                String nomeUsuario = resultSet.getString("nome_usuario");
                String cpfUsuario = resultSet.getString("cpf_usuario");
                String senhaUsuario = resultSet.getString("senha_usuario");
                int nivelAcesso = resultSet.getInt("nivel_acesso_usuario");
                String telefoneUsuario = resultSet.getString("telefone_usuario");
                Double salarioUsuario = resultSet.getDouble("salario_usuario");
                Date dataNascimento = resultSet.getDate("data_nasc_usuario");
                String emailUsuario = resultSet.getString("email_usuario");
                int cargaHoraria = resultSet.getInt("carga_horaria_minutos_usuario");
                String formacaoUsuario = resultSet.getString("formacao_usuario");
                int idSetor = resultSet.getInt("Setor_id_setor");
                int tempoFuncao = resultSet.getInt("tempo_na_funcao");

                MODEL_Gerente gerente = new MODEL_Gerente(idUsuario, nomeUsuario, cpfUsuario, senhaUsuario, nivelAcesso, telefoneUsuario,
                        salarioUsuario, dataNascimento, emailUsuario, cargaHoraria, formacaoUsuario, idSetor, tempoFuncao);

                listaGerentes.add(gerente);

            }
        }
        catch(SQLException e){

            System.err.println("Não foi possível buscar todos os Gerentes: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return listaGerentes;
    }

    public void find_By_Id(int id){


    }

    // Update

    public void update_Tempo_Funcao(MODEL_Gerente gerente, int tempo){




    }

    // Delete

    public void delete_User_Gerente(MODEL_Gerente gerente){

    }
}
