package Projeto_Base;

import java.sql.SQLData;
import java.util.Date;

public class MODEL_Supervisor extends MODEL_Usuario {

    // Atributos exclusivos Super Visor //
    private int experiencia_anos_supervisor;

    // Construtor Super Visor //
    public MODEL_Supervisor(int id, String nome, String cpf, String senha, int nivelacesso, String telefone, double salario,
                            Date datanasci, String email, int cargahoraria, String formacao, int id_setor, int experiencia_anos_supervisor){
        super(id,nome,cpf,senha,nivelacesso,telefone,salario,datanasci,email,cargahoraria,formacao,id_setor);
        this.experiencia_anos_supervisor = experiencia_anos_supervisor;
    }

    // Construtor sem Id //
    public MODEL_Supervisor(String nome, String cpf,String senha, int nivelacesso, String telefone, double salario, Date datanasci,
                            String email, int cargahoraria, String formacao, int id_setor, int experiencia_anos_supervisor){
        super(nome,cpf,senha,nivelacesso,telefone,salario,datanasci,email,cargahoraria,formacao,id_setor);
        this.experiencia_anos_supervisor = experiencia_anos_supervisor;
    }

    // Getters e Setters Super Visor //
    public int getExperiencia_anos_supervisor() {
        return experiencia_anos_supervisor;
    }

    public void setExperiencia_anos_supervisor(int experiencia_anos_supervisor) {
        this.experiencia_anos_supervisor = experiencia_anos_supervisor;
    }
}
