package Model;

import Repository.DAO_Gerente;

import java.util.ArrayList;

public class SERVICE_Gerente {

    static DAO_Gerente daoGerente;
    //--Atributos--//



    //--Métodos--//

    //Create

    public void Inserir_Gerente() {

    }

    //Read

    public ArrayList<MODEL_Gerente> All_Gerentes(){
        return daoGerente.find_All_Gerentes();
    }

    public MODEL_Gerente Find_By_Id(int id){
        return daoGerente.find_By_Id(id);
    }

    //Update

    public void Update_TempoFuncao(){

    }

    //Delete

    public void Delete_Gerente(){

    }

    //Outros
}
