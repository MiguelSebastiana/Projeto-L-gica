package Model;

import Repository.DAO_Maquina;

import java.util.ArrayList;

public class SERVICE_Maquina {

    //--Atributos--//

    static DAO_Maquina daoMaquina;

    //--Métodos--//

    //Read

    public ArrayList<MODEL_Maquina> All_Maquinas()
    {
        try {
            return daoMaquina.find_All_Maquinas();
        }
        catch (RuntimeException re)
        {
            throw new RuntimeException(re.getMessage());
        }

    }

    public MODEL_Maquina Find_by_Id(int id){
        try {
        return daoMaquina.find_By_Id(id);
        }
        catch (RuntimeException re)
        {
            throw new RuntimeException(re.getMessage());
        }
    }

    //Outros
}
