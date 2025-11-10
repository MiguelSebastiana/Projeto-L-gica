package Model;

import Util.Validator_Geral;

public class MODEL_Ordem_Preditiva {

    //Atributos ordens de Serviço//
    private int id_ordem_preditiva;
    private String status_aberto_ordem_preditiva;
    private String descricao_ordem_preditiva;
    private int tecnico;
    private int maquina;
    private double preco;
    private String horario;
    private int gerente;

    //Construtor ordens de Serviço//
    public MODEL_Ordem_Preditiva(int id_ordem_preditiva, String status_aberto_ordem_preditiva, String descricao_ordem_preditiva, int tecnico, int maquina, int gerente, double preco, String horario) {

        setId_ordem_preditiva(id_ordem_preditiva);
        setStatus_aberto_ordem_preditiva(status_aberto_ordem_preditiva);
        setDescricao_ordem_preditiva(descricao_ordem_preditiva);
        setTecnico(tecnico);
        setMquina(maquina);
        setPreco(preco);
        setHorario(horario);
        setGerente(gerente);
    }

    // Construtor sem Id //
    public MODEL_Ordem_Preditiva(String status_aberto_ordem_preditiva, String descricao_ordem_preditiva, int tecnico, int maquina,int gerente, double preco, String horario) {

        setStatus_aberto_ordem_preditiva(status_aberto_ordem_preditiva);
        setDescricao_ordem_preditiva(descricao_ordem_preditiva);
        setTecnico(tecnico);
        setMaquina(maquina);
        setPreco(preco);
        setHorario(horario);
        setGerente(gerente);
    }


    //Getters e Setters//


    public int getId_ordem_preditiva() {
        return id_ordem_preditiva;
    }

    public void setId_ordem_preditiva(int id_ordem_preditiva) {
        this.id_ordem_preditiva = id_ordem_preditiva;
    }

    public String getStatus_aberto_ordem_preditiva() {
        return status_aberto_ordem_preditiva;
    }

    public void setStatus_aberto_ordem_preditiva(String status_aberto_ordem_preditiva) {
        this.status_aberto_ordem_preditiva = status_aberto_ordem_preditiva;
    }

    public String getDescricao_ordem_preditiva() {
        return descricao_ordem_preditiva;
    }

    public void setDescricao_ordem_preditiva(String descricao_ordem_preditiva) {
        this.descricao_ordem_preditiva = descricao_ordem_preditiva;
    }

    public int getTecnico() {
        return tecnico;
    }

    public void setTecnico(int tecnico) {
        this.tecnico = tecnico;
    }

    public int getMaquina() {
        return maquina;
    }

    public void setMaquina(int maquina) {
        this.maquina = maquina;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getGerente() {
        return gerente;
    }

    public void setGerente(int gerente) {
        this.gerente = gerente;
    }
}
}
