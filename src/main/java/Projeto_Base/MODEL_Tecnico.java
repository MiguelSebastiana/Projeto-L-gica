package Projeto_Base;

import java.util.Date;

public class MODEL_Tecnico extends MODEL_Usuario {

    // Atributos exclusivos Tecnico //
    private String especialidade_tecnico;
    private boolean status_disponibilidade_tecnico;

    // Construtor Tecnico //
    public MODEL_Tecnico(int id, String nome, String cpf, int nivelacesso, String telefone, double salario, Date datanasci, String email, int cargahoraria, String formacao, int setor, String especialidade_tecnico, boolean status_disponibilidade_tecnico){
        super(id,nome,cpf,nivelacesso,telefone,salario,datanasci,email,cargahoraria,formacao,setor);
        this.especialidade_tecnico = especialidade_tecnico;
        this.status_disponibilidade_tecnico = status_disponibilidade_tecnico;
    }

    // Getters e Setters Tecnico //
    public String getEspecialidade_tecnico() {
        return especialidade_tecnico;
    }

    public void setEspecialidade_tecnico(String especialidade_tecnico) {
        this.especialidade_tecnico = especialidade_tecnico;
    }

    public boolean isStatus_disponibilidade_tecnico() {
        return status_disponibilidade_tecnico;
    }

    public void setStatus_disponibilidade_tecnico(boolean status_disponibilidade_tecnico) {
        this.status_disponibilidade_tecnico = status_disponibilidade_tecnico;
    }
}
