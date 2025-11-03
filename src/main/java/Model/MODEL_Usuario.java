package Model;

import Util.Validator_Geral;
import Util.Validator_Usuario;

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
    private Date datanasci;
    private String email;
    private int cargahoraria;
    private String formacao;
    private int id_setor;

    // Construtor Usuário //
    public MODEL_Usuario(int id, String nome, String cpf, String senha, int nivelacesso, String telefone, double salario,
                         Date datanasci, String email, int cargahoraria, String formacao, int id_setor) {
        this.id = id;
        setNome(nome);
        setCpf(cpf);
        setSenha(senha);
        setNivelacesso(nivelacesso);
        setTelefone(telefone);
        setSalario(salario);
        setDatanasci(datanasci);
        setEmail(email);
        setCargahoraria(cargahoraria);
        setFormacao(formacao);
        setSetor(id_setor);
    }

    // Construtor sem Id //
    public MODEL_Usuario(String nome, String cpf, String senha, int nivelacesso, String telefone, double salario,
                         Date datanasci, String email, int cargahoraria, String formacao, int id_setor) {
        setNome(nome);
        setCpf(cpf);
        setSenha(senha);
        setNivelacesso(nivelacesso);
        setTelefone(telefone);
        setSalario(salario);
        setDatanasci(datanasci);
        setEmail(email);
        setCargahoraria(cargahoraria);
        setFormacao(formacao);
        setSetor(id_setor);
    }


    // Getter e Setters //
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = Validator_Geral.nome(nome);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = Validator_Usuario.validarCpf(cpf);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = Validator_Usuario.senha(senha);
    }

    public int getNivelacesso() {
        return nivelacesso;
    }

    public void setNivelacesso(int nivelacesso) {
        this.nivelacesso = Validator_Usuario.validarNivelAcesso(nivelacesso);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = Validator_Usuario.ValidarTelefone(telefone);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = Validator_Usuario.validarSalario(salario);
    }

    public Date getDatanasci() {
        return datanasci;
    }

    public void setDatanasci(Date datanasci) {
        this.datanasci = Validator_Usuario.validarDataNascimento(datanasci);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = Validator_Usuario.ValidarEmail(email);
    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = Validator_Usuario.validarCargaHoraria(cargahoraria);
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = Validator_Usuario.formacao(formacao);
    }

    public int getSetor() {
        return id_setor;
    }

    public void setSetor(int setor) {
        this.id_setor = Validator_Usuario.validarSetor(setor);
    }

}
