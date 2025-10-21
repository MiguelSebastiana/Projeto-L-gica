import java.util.Date;

public class ClasseSupervisor extends ClasseUsuario{

    int experiencia_anos_supervisor;

    public ClasseSupervisor(int id, String nome, String cpf, int nivelacesso, String telefone, double salario, Date datanasci, String email, int cargahoraria, String formacao, ClasseSetor setor,int experiencia_anos_supervisor){
        super(id,nome,cpf,nivelacesso,telefone,salario,datanasci,email,cargahoraria,formacao,setor);
        this.experiencia_anos_supervisor = experiencia_anos_supervisor;
    }
}
