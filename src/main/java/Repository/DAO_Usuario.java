package Repository;

import DataBase.ConnectionFactory;
import Model.*;

import java.time.LocalDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.Date;


public class DAO_Usuario
{

    // Read

    // Read
    public ArrayList<MODEL_Usuario> find_All_Users() {

        ArrayList<MODEL_Usuario> listaUsuarios = new ArrayList<>();


        String querySql = "SELECT " +
                "    u.*, " +
                "    na.nome_nivel_acesso, " +
                "    t.especialidade_tecnico, t.status_disponibilidade_tecnico, t.Setor_id_setor, " +
                "    s.experiencia_supervisor, " +
                "    g.anos_funcao_gerente, " +
                "    a.id_administrador " +
                "FROM " +
                "    Usuario u " +
                "LEFT JOIN Nivel_Acesso na ON u.Nivel_Acesso_id_nivel_acesso = na.id_nivel_acesso " +
                "LEFT JOIN Tecnico t ON u.id_usuario = t.Usuario_id_usuario " +
                "LEFT JOIN Supervisor s ON u.id_usuario = s.Usuario_id_usuario " +
                "LEFT JOIN Gerente g ON u.id_usuario = g.Usuario_id_usuario " +
                "LEFT JOIN Administrador a ON u.id_usuario = a.Usuario_id_usuario " +
                "ORDER BY u.id_usuario;";

        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql);
             ResultSet resultSet = stmt.executeQuery()) {


            while (resultSet.next()) {
                int idUsuario = resultSet.getInt("id_usuario");
                String nomeUsuario = resultSet.getString("nome_usuario");
                String cpfUsuario = resultSet.getString("cpf_usuario");
                String senhaUsuario = resultSet.getString("senha_usuario");
                String telefoneUsuario = resultSet.getString("telefone_usuario");
                double salarioUsuario = resultSet.getDouble("salario_usuario");
                Date dataNascimentoSQL = resultSet.getDate("data_nascimento_usuario");
                String emailUsuario = resultSet.getString("email_usuario");
                int cargaHorariaUsuario = resultSet.getInt("carga_horaria_usuario");
                String formacaoUsuario = resultSet.getString("formacao_usuario");
                int nivelAcessoID = resultSet.getInt("Nivel_Acesso_id_nivel_acesso");

                LocalDate dataNascimento = LocalDate.ofInstant(dataNascimentoSQL.toInstant(),ZoneId.systemDefault());

                if (nivelAcessoID == 4) {
                    String especialidadeTecnico = resultSet.getString("especialidade_tecnico");
                    boolean status = "Disponível".equals(resultSet.getString("status_disponibilidade_tecnico"));
                    int idSetor = resultSet.getInt("Setor_id_setor");

                    MODEL_Usuario tecnico = new MODEL_Tecnico(idUsuario, nomeUsuario, cpfUsuario, senhaUsuario, nivelAcessoID, telefoneUsuario, salarioUsuario,
                            dataNascimento, emailUsuario, cargaHorariaUsuario, formacaoUsuario, idSetor, especialidadeTecnico, status);
                    listaUsuarios.add(tecnico);

                } else if (nivelAcessoID == 3) {
                    int anosSupervisor = resultSet.getInt("experiencia_supervisor");
                    MODEL_Usuario supervisor = new MODEL_Supervisor(idUsuario, nomeUsuario, cpfUsuario, senhaUsuario, nivelAcessoID, telefoneUsuario, salarioUsuario,
                            dataNascimento, emailUsuario, cargaHorariaUsuario, formacaoUsuario, anosSupervisor);
                    listaUsuarios.add(supervisor);

                } else if (nivelAcessoID == 2) {
                    int anosGerente = resultSet.getInt("anos_funcao_gerente");
                    MODEL_Usuario gerente = new MODEL_Gerente(idUsuario, nomeUsuario, cpfUsuario, senhaUsuario, nivelAcessoID, telefoneUsuario, salarioUsuario,
                            dataNascimento, emailUsuario, cargaHorariaUsuario, formacaoUsuario, anosGerente);
                    listaUsuarios.add(gerente);

                } else if (nivelAcessoID == 1) {
                    MODEL_Usuario admin = new MODEL_Administrador(idUsuario, nomeUsuario, cpfUsuario, senhaUsuario, nivelAcessoID, telefoneUsuario, salarioUsuario,
                            dataNascimento, emailUsuario, cargaHorariaUsuario, formacaoUsuario);
                    listaUsuarios.add(admin);
                }
            }
        } catch (SQLException e) {
            System.err.println("Não foi possivel visualizar todos os usuarios :" + e.getMessage());
            throw new RuntimeException("Erro ao consultar o banco de dados.", e);
        }

        return listaUsuarios;
    }

    // Update

    public void update_Telefone(MODEL_Usuario usuario, String telefone){

        String querySql = "update Usuario set telefone_usuario = ? where id_usuario = ?";

        try(Connection conexao = ConnectionFactory.getConn();
        PreparedStatement stmt = conexao.prepareStatement(querySql)){

            stmt.setString(1,telefone);
            stmt.setInt(2,usuario.getId());
            stmt.executeUpdate();

            usuario.setTelefone(telefone);
        }catch (SQLException e){
            System.err.println("Erro ao atualizar o telefone "+ e.getMessage());
            throw new RuntimeException("Erro ao atualizar telefone no banco de dados. "+e);
        }
    }

    public void update_Email(MODEL_Usuario usuario, String email){

        String querySql = "update Usuario set email_usuario = ? where id_usuario = ?";

        try(Connection conexao = ConnectionFactory.getConn();
            PreparedStatement stmt = conexao.prepareStatement(querySql)){

                stmt.setString(1,email);
                stmt.setInt(2,usuario.getId());
                stmt.executeUpdate();

                usuario.setEmail(email);
        }catch (SQLException e){
            System.err.println("Erro ao atualizar o email "+e.getMessage());
            throw new RuntimeException("Erro ao atualizar email no banco de dados. "+e);
        }
    }

    public void update_Carga_Horaria(MODEL_Usuario usuario, int carga){

        String querySql = "update Usuario set carga_horaria_usuario = ? where id_usuario = ?";

        try(Connection conexao = ConnectionFactory.getConn();
            PreparedStatement stmt = conexao.prepareStatement(querySql)){

            stmt.setInt(1,carga);
            stmt.setInt(2,usuario.getId());
            stmt.executeUpdate();

            usuario.setCargahoraria(carga);
        }catch (SQLException e){
            System.err.println("Erro ao atualizar a carga horaria "+e.getMessage());
            throw new RuntimeException("Erro ao atualizar a carga horaria no banco de dados. "+e);
        }
    }

    public void update_Formacao(MODEL_Usuario usuario, String formacao){

        String querySql = "update Usuario set formacao_usuario = ? where id_usuario = ?";

        try(Connection conexao = ConnectionFactory.getConn();
            PreparedStatement stmt = conexao.prepareStatement(querySql)){

            stmt.setString(1,formacao);
            stmt.setInt(2,usuario.getId());
            stmt.executeUpdate();

            usuario.setFormacao(formacao);
        }catch (SQLException e){
            System.err.println("Erro ao atualizar a formação "+e.getMessage());
            throw new RuntimeException("Erro ao atualizar a formação no banco de dados. "+e);
        }
    }

    public void update_Senha(MODEL_Usuario usuario, String senha){

        String querySql = "update Usuario set senha_usuario = ? where id_usuario = ?";

        try(Connection conexao = ConnectionFactory.getConn();
            PreparedStatement stmt = conexao.prepareStatement(querySql)){

            stmt.setString(1,senha);
            stmt.setInt(2,usuario.getId());
            stmt.executeUpdate();

            usuario.setSenha(senha);
        }catch (SQLException e){
            System.err.println("Erro ao atualizar a senha "+e.getMessage());
            throw new RuntimeException("Erro ao atualizar a senha no banco de dados. "+e);
        }
    }
    // Outros

    public boolean verificar_Login(String cpf, String senha) {
        String querySql = "select u.senha_usuario " +
                "From Usuario u " +
                "where u.cpf_usuario = ?";


        try (Connection conexao = ConnectionFactory.getConn();
             PreparedStatement stmt = conexao.prepareStatement(querySql)){

             stmt.setString( 1, cpf);

             try (ResultSet resultSet = stmt.executeQuery()){
                if(resultSet.next()) {
                    String senhaSql = resultSet.getString("senha_usuario");

                    if (senhaSql.equals(senha)) {
                        return true;
                    } else {
                        return false;
                    }
                }else {
                    return false;
                }
             }

        } catch (SQLException e) {
            System.err.println("Erro ao verificar login: " + e.getMessage());
            throw new RuntimeException("Erro ao buscar senha no banco de dados. " + e);
        }
    }

}