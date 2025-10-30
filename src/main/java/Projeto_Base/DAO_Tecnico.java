package Projeto_Base;

import java.util.ArrayList;
import java.util.Date;

public class DAO_Tecnico {

    // Create

    public void insert_Tecnico(int id, String nome, String cpf, int nivelacesso, String telefone, double salario,
                               Date datanasci, String email, int cargahoraria, String formacao, int id_setor,String especialidade_tecnico, boolean status_disponibilidade_tecnico){

    }

    // Read

    public ArrayList<MODEL_Tecnico> find_All_Tecnico(){

    }

    public MODEL_Tecnico find_By_Id(int id){

    }

    // Update

    public void update_Especialidade(MODEL_Tecnico tecnico, String especialidade){

    }

    public void update_Disponibilidade(MODEL_Tecnico tecnico, boolean disponibilidade){

    }

    // Delete

    public void delete_Tecnico(MODEL_Tecnico tecnico){

    }

}
