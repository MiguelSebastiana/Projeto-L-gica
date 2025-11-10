package Model;

import java.time.LocalDate;

public class MODEL_Administrador extends MODEL_Usuario {

    public MODEL_Administrador(int id, String nome, String cpf, String senha, int nivelacesso, String telefone, double salario,
                               LocalDate datanasci, String email, int cargahoraria, String formacao) {
        super(id, nome, cpf, senha, nivelacesso, telefone, salario, datanasci, email, cargahoraria, formacao);


    }

    public MODEL_Administrador(String nome, String cpf, String senha, int nivelacesso, String telefone, double salario,
                               LocalDate datanasci, String email, int cargahoraria, String formacao) {
        super(nome, cpf, senha, nivelacesso, telefone, salario, datanasci, email, cargahoraria, formacao);
    }

}