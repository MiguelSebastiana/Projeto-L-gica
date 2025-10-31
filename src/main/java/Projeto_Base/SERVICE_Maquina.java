package Projeto_Base;

import java.util.ArrayList;

public class SERVICE_Maquina {

    static DAO_Maquina daoMaquina;
    //--Atributos--//



    //--Métodos--//

    //Read

    public ArrayList<MODEL_Maquina> All_Maquinas(){
        return daoMaquina.find_All_Maquinas();
    }

    public MODEL_Maquina Find_by_Id(int id){
        return daoMaquina.find_By_Id(id);
    }

    //Outros
}
