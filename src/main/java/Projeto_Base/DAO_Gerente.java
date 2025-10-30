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

    public ArrayList<DAO_Gerente> find_All_Gerentes(){


        ArrayList<DAO_Gerente> listaGerentes = new ArrayList<>();

        String querySql = "select u.*, g.tempo_na_funcao\n" +
                "from Usuario u\n" +
                "inner join Gerente g on u.id_usuario = g.Usuario_id_usuario\n" +
                "order by u.id_usuario;";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql);
             ResultSet resultSet = stmt.executeQuery())
        {

            int idUsuario = resultSet.getInt("id_usuario");


        }catch (SQLException e){

            System.err.println("Não foi possível buscar todos os Gerentes: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return listaGerentes;
    }

    // Update

    public void update_Tempo_Funcao(MODEL_Gerente gerente, int tempo){

    }

    // Delete

    public void delete_User_Gerente(MODEL_Gerente gerente){

    }
}
