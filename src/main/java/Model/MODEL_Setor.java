package Model;

import Util.Validator_Geral;
import Util.Validator_Setor;

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
        if(id_setor > 0 && id_setor < 10)
        {
            this.id_setor = id_setor;
        }
        else
        {
            throw new IllegalArgumentException("ID INVÁLIDO!");
        }
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = Validator_Setor.validarSetor(nomeSetor );
    }

    public String getDescricaoSetor() {
        return descricaoSetor;
    }

    public void setDescricaoSetor(String descricaoSetor) {
        this.descricaoSetor = Validator_Geral.validarString(descricaoSetor);
    }


}
