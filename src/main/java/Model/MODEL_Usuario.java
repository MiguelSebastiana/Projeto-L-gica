package Model;

import java.sql.SQLData;
import java.util.Date;

public abstract class MODEL_Usuario {

    // Atributos Usuário //
    private int id;
    private String nome;
    private String cpf;
    private String senha;
    private int nivelacesso;
    private String telefone;
    private double salario;
    private SQLData datanasci;
    private String email;
    private int cargahoraria;
    private String formacao;
    private int id_setor;

    // Construtor Usuário //
    public MODEL_Usuario(int id, String nome, String cpf, String senha, int nivelacesso, String telefone, double salario,
                         SQLData datanasci, String email, int cargahoraria, String formacao, int id_setor) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.nivelacesso = nivelacesso;
        this.telefone = telefone;
        this.salario = salario;
        this.datanasci = datanasci;
        this.email = email;
        this.cargahoraria = cargahoraria;
        this.formacao = formacao;
        this.id_setor = id_setor;
    }

    // Construtor sem Id //
    public MODEL_Usuario(String nome, String cpf, String senha, int nivelacesso, String telefone, double salario,
                         SQLData datanasci, String email, int cargahoraria, String formacao, int id_setor) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.nivelacesso = nivelacesso;
        this.telefone = telefone;
        this.salario = salario;
        this.datanasci = datanasci;
        this.email = email;
        this.cargahoraria = cargahoraria;
        this.formacao = formacao;
        this.id_setor = id_setor;
    }


    // Getter e Setters //
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getNivelacesso() {
        return nivelacesso;
    }

    public void setNivelacesso(int nivelacesso) {
        this.nivelacesso = nivelacesso;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public SQLData getDatanasci() {
        return datanasci;
    }

    public void setDatanasci(SQLData datanasci) {
        this.datanasci = datanasci;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public int getSetor() {
        return id_setor;
    }

    public void setSetor(int setor) {
        this.id_setor = setor;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
}
