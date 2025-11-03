package Repository;

import DataBase.ConnectionFactory;
import Model.MODEL_Gerente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class DAO_Gerente {



    // Create

    public void insert_User_Gerente(MODEL_Gerente gerente){

        String querySql = "insert into Gerente(nome_usuario,cpf_usuario,senha_usuario, nivel_acesso_usuario,telefone_usuario,salario_usuario,data_nasc_usuario," +
                "email_usuario,carga_horaria_minutos_usuario,formacao_usuario,Setor_id_setor,tempo_na_funcao_anos_gerente) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?);";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql);
             ResultSet resultSet = stmt.executeQuery()){

            java.sql.Date dataParaSQL = java.sql.Date.valueOf(gerente.getDatanasci());

            stmt.setString(1, gerente.getNome());
            stmt.setString(2, gerente.getCpf());
            stmt.setString(3, gerente.getSenha());
            stmt.setInt(4, gerente.getNivelacesso());
            stmt.setString(5, gerente.getTelefone());
            stmt.setDouble(6, gerente.getSalario());
            stmt.setDate(7,  dataParaSQL);
            stmt.setString(8, gerente.getEmail());
            stmt.setInt(9, gerente.getCargahoraria());
            stmt.setString(10, gerente.getFormacao());
            stmt.setInt(11, gerente.getSetor());
            stmt.setInt(12,gerente.getTempo_na_funcao_anos_gerente());
            stmt.executeQuery();

            String querySql2 = "select u.id_usuario " +
                    "from Usuario as u " +
                    "inner join Gerente g on u.id_usuario = g.id_usuario " +
                    "where u.cpf_usuario = ?";

            try{

                stmt.setString(1, gerente.getCpf());
                stmt.executeQuery();

                int idUsuario = resultSet.getInt("id_usuario");

                MODEL_Gerente gerente1 = new MODEL_Gerente(idUsuario,gerente.getNome(), gerente.getCpf(), gerente.getSenha(),
                        3, gerente.getTelefone(), gerente.getSalario(), gerente.getDatanasci(),
                        gerente.getEmail(),gerente.getCargahoraria(),gerente.getFormacao(),gerente.getSetor(),gerente.getTempo_na_funcao_anos_gerente());

            }
            catch (SQLException e){
                System.err.println("Não foi possível inserir o Gerente: " + e.getMessage());

                throw new RuntimeException("Erro ao consultar o banco de dados.", e);
            }

        }
        catch (SQLException e){
            System.err.println("Não foi possível inserir o Gerente: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }


    }

    // Read

    public ArrayList<MODEL_Gerente> find_All_Gerentes(){

        ArrayList<MODEL_Gerente> listaGerentes = new ArrayList<>();

        String querySql = "select u.*, g.tempo_na_funcao " +
                "from Usuario u " +
                "inner join Gerente g on u.id_usuario = g.Usuario_id_usuario " +
                "order by u.id_usuario ";

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
                Date dataNasciment = resultSet.getDate("data_nasc_usuario");
                String emailUsuario = resultSet.getString("email_usuario");
                int cargaHoraria = resultSet.getInt("carga_horaria_minutos_usuario");
                String formacaoUsuario = resultSet.getString("formacao_usuario");
                int idSetor = resultSet.getInt("Setor_id_setor");
                int tempoFuncao = resultSet.getInt("tempo_na_funcao");

                LocalDate dataNascimento = LocalDate.ofInstant(dataNasciment.toInstant(), ZoneId.systemDefault());

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

    public MODEL_Gerente find_By_Id(int id){

        String idgerente = String.valueOf(id);
        MODEL_Gerente gerente = null;

        String querySql = "select u.*, g.tempo_na_funcao " +
                "from Usuario u " +
                "inner join Gerente g on u.id_usuario = g.Usuario_id_usuario " +
                "order by u.id_usuario " +
                "where u.id_usuario = ?;";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql)) {

            stmt.setInt(1,id);

            try(ResultSet resultSet = stmt.executeQuery()) {

                while (resultSet.next()) {
                    int idUsuario = resultSet.getInt("id_usuario");
                    String nomeUsuario = resultSet.getString("nome_usuario");
                    String cpfUsuario = resultSet.getString("cpf_usuario");
                    String senhaUsuario = resultSet.getString("senha_usuario");
                    int nivelAcesso = resultSet.getInt("nivel_acesso_usuario");
                    String telefoneUsuario = resultSet.getString("telefone_usuario");
                    Double salarioUsuario = resultSet.getDouble("salario_usuario");
                    Date dataNasciment = resultSet.getDate("data_nasc_usuario");
                    String emailUsuario = resultSet.getString("email_usuario");
                    int cargaHoraria = resultSet.getInt("carga_horaria_minutos_usuario");
                    String formacaoUsuario = resultSet.getString("formacao_usuario");
                    int idSetor = resultSet.getInt("Setor_id_setor");
                    int tempoFuncao = resultSet.getInt("tempo_na_funcao");

                    LocalDate dataNascimento = LocalDate.ofInstant(dataNasciment.toInstant(), ZoneId.systemDefault());

                    gerente = new MODEL_Gerente(idUsuario, nomeUsuario, cpfUsuario, senhaUsuario, nivelAcesso, telefoneUsuario,
                            salarioUsuario, dataNascimento, emailUsuario, cargaHoraria, formacaoUsuario, idSetor, tempoFuncao);
                }
            }
        }
        catch (SQLException e) {
            System.err.println("Não foi possível buscar o Gerente: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return gerente;
    }

    // Update

    public void update_Tempo_Funcao(MODEL_Gerente gerente, int tempo){

        String querySql = "update Usuario as u " +
                "inner join Gerente g on u.id_usuario = g.id_usuarios " +
                "set g.tempo_na_funcao = ? " +
                "where u.id_usuario = ?";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql)) {

            stmt.setInt(1,tempo);
            stmt.setInt(2,gerente.getId());
            stmt.executeQuery();

        }
        catch (SQLException e){
            System.err.println("Não foi possível alterar o tempo de experiencia do Gerente: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

    }

    // Delete

    public void delete_User_Gerente(MODEL_Gerente gerente){

        String querySql = "delete from Usuario as u " + "where u.id_usuario = ?;";

        String querySql2 = "delete from Gerente as g " + "where g.id_usuario = ?;";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql)) {

            stmt.setInt(1,gerente.getId());
            stmt.executeQuery();

            try(PreparedStatement stmt2 = conexao.prepareStatement(querySql2)){

                stmt2.setInt(2,gerente.getId());
                stmt2.executeQuery();

            }catch (SQLException e){
                System.err.println("Não foi possível excluir o Gerente: " + e.getMessage());

                throw new RuntimeException("Erro ao consultar o banco de dados.", e);
            }

        }
        catch (SQLException e){
            System.err.println("Não foi possível excluir o Gerente: " + e.getMessage());

            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

    }
}
