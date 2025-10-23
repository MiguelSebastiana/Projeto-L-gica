import java.util.Date;

public class MODEL_Gerente extends MODEL_Usuario {

    private int tempo_na_funcao_anos_gerente;

    public MODEL_Gerente(int id, String nome, String cpf, int nivelacesso, String telefone, double salario, Date datanasci, String email, int cargahoraria, String formacao, MODEL_Setor setor, int tempo_na_funcao_anos_gerente){
        super(id,nome,cpf,nivelacesso,telefone,salario,datanasci,email,cargahoraria,formacao,setor);
        this.tempo_na_funcao_anos_gerente = tempo_na_funcao_anos_gerente;
    }



    public int getTempo_na_funcao_anos_gerente() {
        return tempo_na_funcao_anos_gerente;
    }

    public void setTempo_na_funcao_anos_gerente(int tempo_na_funcao_anos_gerente) {
        this.tempo_na_funcao_anos_gerente = tempo_na_funcao_anos_gerente;
    }
}
