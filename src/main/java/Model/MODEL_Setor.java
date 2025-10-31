package Model;

public class MODEL_Setor {

    // Atributos Setor //
    private int id_setor;
    private String nomeSetor;
    private String descricaoSetor;

    // Construtor Setor //
    public MODEL_Setor(int id_setor, String nomeSetor, String descricaoSetor){
        this.id_setor = id_setor;
        this.nomeSetor = nomeSetor;
        this.descricaoSetor = descricaoSetor;
    }

    // Construtor sem Id //
    public MODEL_Setor(String nomeSetor, String descricaoSetor){
        this.nomeSetor = nomeSetor;
        this.descricaoSetor = descricaoSetor;
    }

    // Getters e Setters Setor //
    public int getId_setor() {
        return id_setor;
    }

    public void setId_setor(int id_setor) {
        this.id_setor = id_setor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getDescricaoSetor() {
        return descricaoSetor;
    }

    public void setDescricaoSetor(String descricaoSetor) {
        this.descricaoSetor = descricaoSetor;
    }
}
