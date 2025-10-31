package Model;

import Repository.DAO_Setor;

import java.util.ArrayList;

public class SERVICE_Setor {
    static DAO_Setor daoSetor;
    //--Atributos--//



    //--Métodos--//

    //Read

    public ArrayList<MODEL_Setor> All_Setores(){
        return daoSetor.find_All_Setores();

    }

    public MODEL_Setor Find_by_Id(int id){
        return daoSetor.find_By_Id(id);
    }

    //Outros
}
