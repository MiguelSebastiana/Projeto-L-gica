package Projeto_Base;

public class  MODEL_Maquina{

    // Atributos maquina //
    private int id_maquina;
    private String DescricaoMaquina;
    private String ModeloMaquina;
    private String StatusFuncionamentoMaquina;
    private MODEL_Setor setor;

    // Construtor Model Maquina //
    public MODEL_Maquina(int id_maquina, String DescricaoMaquina, String ModeloMaquina, String StatusFuncionamentoMaquina, MODEL_Setor setor) {
        this.id_maquina = id_maquina;
        this.DescricaoMaquina = DescricaoMaquina;
        this.ModeloMaquina = ModeloMaquina;
        this.StatusFuncionamentoMaquina = StatusFuncionamentoMaquina;
        this.setor = setor;
    }

    // Getter e Setters maquina //
    public int getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(int id_maquina) {
        this.id_maquina = id_maquina;
    }

    public String getDescricaoMaquina() {
        return DescricaoMaquina;
    }

    public void setDescricaoMaquina(String descricaoMaquina) {
        DescricaoMaquina = descricaoMaquina;
    }

    public String getModeloMaquina() {
        return ModeloMaquina;
    }

    public void setModeloMaquina(String modeloMaquina) {
        ModeloMaquina = modeloMaquina;
    }

    public String getStatusFuncionamentoMaquina() {
        return StatusFuncionamentoMaquina;
    }

    public void setStatusFuncionamentoMaquina(String statusFuncionamentoMaquina) {
        StatusFuncionamentoMaquina = statusFuncionamentoMaquina;
    }

    public MODEL_Setor getSetor() {
        return setor;
    }

    public void setSetor(MODEL_Setor setor) {
        this.setor = setor;
    }
}
