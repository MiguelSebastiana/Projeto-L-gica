package Projeto_Base;

public class MODEL_Servico {

        //Atributos ordens de Serviço//
        private int ordem_servico;
        private String status_aberto_ordem_servico;
        private String descricao_ordem_servico;
        private int id_tecnico;
        private int id_maquina;

        //Construtor ordens de Serviço//
    public MODEL_Servico(int ordem_servico, String status_aberto_ordem_servico, String descricao_ordem_servico, int tecnico, int maquina) {

        this.ordem_servico = ordem_servico;
        this.status_aberto_ordem_servico = status_aberto_ordem_servico;
        this.descricao_ordem_servico = descricao_ordem_servico;
        this.id_tecnico = tecnico;
        this.id_maquina = maquina;
    }

    //Getters e Setters//
    public int getOrdem_servico() {
        return ordem_servico;
    }

    public void setOrdem_servico(int ordem_servico) {
        this.ordem_servico = ordem_servico;
    }

    public String getStatus_aberto_ordem_servico() {
        return status_aberto_ordem_servico;
    }

    public void setStatus_aberto_ordem_servico(String status_aberto_ordem_servico) {
        this.status_aberto_ordem_servico = status_aberto_ordem_servico;
    }

    public String getDescricao_ordem_servico() {
        return descricao_ordem_servico;
    }

    public void setDescricao_ordem_servico(String descricao_ordem_servico) {
        this.descricao_ordem_servico = descricao_ordem_servico;
    }

    public int getTecnico() {
        return id_tecnico;
    }

    public void setTecnico(int tecnico) {
        this.id_tecnico = tecnico;
    }

    public int getMaquina() {
        return id_maquina;
    }

    public void setMaquina(int maquina) {
        this.id_maquina = maquina;
    }
}
