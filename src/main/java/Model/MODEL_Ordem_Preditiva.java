package Model;

import Util.Validator_Geral;

public class MODEL_Ordem_Preditiva {

    //Atributos ordens de Serviço//
    private int id_ordem_servico;
    private String status_aberto_ordem_servico;
    private String descricao_ordem_servico;
    private int id_tecnico;
    private int id_maquina;
    private double preco;
    private String horario;

    //Construtor ordens de Serviço//
    public MODEL_Ordem_Preditiva(int id_ordem_servico, String status_aberto_ordem_servico, String descricao_ordem_servico, int tecnico, int maquina, double preco, String horario) {

        setId_ordem_servico(id_ordem_servico);
        setStatus_aberto_ordem_servico(status_aberto_ordem_servico);
        setDescricao_ordem_servico(descricao_ordem_servico);
        setTecnico(tecnico);
        setMaquina(maquina);
        setPreco(preco);
    }

    // Construtor sem Id //
    public MODEL_Ordem_Preditiva(String status_aberto_ordem_servico, String descricao_ordem_servico, int tecnico, int maquina,double preco, String horario) {

        setStatus_aberto_ordem_servico(status_aberto_ordem_servico);
        setDescricao_ordem_servico(descricao_ordem_servico);
        setTecnico(tecnico);
        setMaquina(maquina);
        setPreco(preco);
    }


    //Getters e Setters//
    public int getId_Ordem_servico() {
        return id_ordem_servico;
    }

    public void setId_ordem_servico(int ordem_servico) {
        this.id_ordem_servico = Validator_Geral.ValidarNumeroNegativoInt(ordem_servico);
    }

    public String getStatus_aberto_ordem_servico() {
        return status_aberto_ordem_servico;
    }

    public void setStatus_aberto_ordem_servico(String status_aberto_ordem_servico) {
        this.status_aberto_ordem_servico = Validator_Geral.validarString(status_aberto_ordem_servico);
    }

    public String getDescricao_ordem_servico() {
        return descricao_ordem_servico;
    }

    public void setDescricao_ordem_servico(String descricao_ordem_servico) {
        this.descricao_ordem_servico = Validator_Geral.validarString(status_aberto_ordem_servico);
    }

    public int getTecnico() {
        return id_tecnico;
    }

    public void setTecnico(int tecnico) {
        this.id_tecnico = Validator_Geral.ValidarNumeroNegativoInt(tecnico);
    }

    public int getMaquina() {
        return id_maquina;
    }

    public void setMaquina(int maquina) {
        this.id_maquina = Validator_Geral.ValidarNumeroNegativoInt(maquina);
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = Validator_Geral.ValidarNumeroNegativoDouble(preco);
    };

    public int getId_ordem_servico() {
        return id_ordem_servico;
    }

    public int getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(int id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public int getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(int id_maquina) {
        this.id_maquina = id_maquina;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
