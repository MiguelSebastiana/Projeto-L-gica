package Model;

import Util.Validator_Administrador;

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

    public void setCpf(String cpf)
    {
        this.cpf = Validator_Administrador.validarCpf(cpf);
    }

    public void setSenha(String senha) {
        this.senha = Validator_Administrador.validarSenha(senha);
    }
}
