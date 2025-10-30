package Projeto_Base;

import java.util.Date;

public class MODEL_Gerente extends MODEL_Usuario {

    // Atributos exclusivos de Gerente //
    private int tempo_na_funcao_anos_gerente;

    // Construtor de Gerente //
    public MODEL_Gerente(int id, String nome, String cpf,String senha, int nivelacesso, String telefone, double salario, Date datanasci, String email, int cargahoraria, String formacao, int id_setor, int tempo_na_funcao_anos_gerente){
        super(id,nome,cpf,senha,nivelacesso,telefone,salario,datanasci,email,cargahoraria,formacao,id_setor);
        this.tempo_na_funcao_anos_gerente = tempo_na_funcao_anos_gerente;
    }

    // Construtor sem Id //
    public MODEL_Gerente(String nome, String cpf,String senha, int nivelacesso, String telefone, double salario, Date datanasci, String email, int cargahoraria, String formacao, int id_setor, int tempo_na_funcao_anos_gerente){
        super(nome,cpf,senha,nivelacesso,telefone,salario,datanasci,email,cargahoraria,formacao,id_setor);
        this.tempo_na_funcao_anos_gerente = tempo_na_funcao_anos_gerente;
    }

    // Getters e Setters Gerente //
    public int getTempo_na_funcao_anos_gerente() {
        return tempo_na_funcao_anos_gerente;
    }

    public void setTempo_na_funcao_anos_gerente(int tempo_na_funcao_anos_gerente) {
        this.tempo_na_funcao_anos_gerente = tempo_na_funcao_anos_gerente;
    }
}
