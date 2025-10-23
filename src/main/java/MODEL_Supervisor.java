import java.util.Date;

public class MODEL_Supervisor extends MODEL_Usuario {

    int experiencia_anos_supervisor;

    public MODEL_Supervisor(int id, String nome, String cpf, int nivelacesso, String telefone, double salario, Date datanasci, String email, int cargahoraria, String formacao, MODEL_Setor setor, int experiencia_anos_supervisor){
        super(id,nome,cpf,nivelacesso,telefone,salario,datanasci,email,cargahoraria,formacao,setor);
        this.experiencia_anos_supervisor = experiencia_anos_supervisor;
    }
}
