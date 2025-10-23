public class MODEL_Servico {

        //Atributos ordens de Serviço//
        private int ordem_servico;
        private String status_aberto_ordem_servico;
        private String descricao_ordem_servico;
        private MODEL_Tecnico tecnico;
        private MODEL_Maquina maquina;

        //Construtor ordens de Serviço//
    public MODEL_Servico(int ordem_servico, String status_aberto_ordem_servico, String descricao_ordem_servico, MODEL_Tecnico tecnico, MODEL_Maquina maquina) {

        this.ordem_servico = ordem_servico;
        this.status_aberto_ordem_servico = status_aberto_ordem_servico;
        this.descricao_ordem_servico = descricao_ordem_servico;
        this.tecnico = tecnico;
        this.maquina = maquina;
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

    public MODEL_Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(MODEL_Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public MODEL_Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(MODEL_Maquina maquina) {
        this.maquina = maquina;
    }
}
