package Projeto_Base;

public class MODEL_Administrador {

    // ---- ATRIBUTOS PRIVADOS ---- //
    private String cpf;
    private String senha;

    // ---- CONSTRUTOR ---- //
    public MODEL_Administrador(String cpf, String senha){
        this.cpf = cpf;
        this.senha = senha;
    }

    // ---- GETTERS E SETTERS ---- //
    public String getCpf(){
        return cpf;
    }

    public String getSenha(){
        return senha;
    }
}
