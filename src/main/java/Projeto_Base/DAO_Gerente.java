package Projeto_Base;

import java.util.ArrayList;
import java.util.Date;

public class DAO_Gerente {



    // Create

    public void insert_User_Gerente(int id, String nome, String cpf, int nivelacesso, String telefone, double salario,
                                    Date datanasci, String email, int cargahoraria, String formacao, int id_setor, int tempoFuncao){



    }

    // Read

    public ArrayList<DAO_Gerente> find_All_Gerentes(){

        ArrayList<DAO_Gerente> listaGerentes = new ArrayList<>();



        return listaGerentes;
    }

    // Update

    public void update_Tempo_Funcao(MODEL_Gerente gerente, int tempo){

    }

    // Delete

    public void delete_User_Gerente(MODEL_Gerente gerente){

    }
}
