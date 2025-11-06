package Model;

import java.util.ArrayList;
import Repository.DAO_Supervisor;
import Util.*;
import Exception.ANOSEXPERIENCIAException;

public class SERVICE_Supervisor {

    //--Atributos--//
    static DAO_Supervisor daoSupervisor;


    //--Métodos--//

    //Create

    public void Insert_Supervisor(MODEL_Supervisor supervisor)
    {
        try
        {
            if(supervisor != null)
            {
                daoSupervisor.insert_Supervisor(supervisor);
            }
        }
        catch(RuntimeException re)
        {
            System.out.println(re.getMessage());
        }
    }

    //Read

    public ArrayList<MODEL_Supervisor> Find_All_Supervisores()
    {
        try {
            return daoSupervisor.find_All_Supervisores();
        }catch(RuntimeException re)
        {
            System.out.println(re.getMessage());
        }

        return null;
    }

    public MODEL_Supervisor Find_By_Id(int id)
    {
        try
        {
            return daoSupervisor.find_By_Id(id);
        }
        catch(RuntimeException re)
        {
            System.out.println(re.getMessage());
        }

        return null;
    }

    //Update

    public void Update_Experiencia(int id, int experiencia)
    {
        Validator_Usuario.verificarID(id);
        Validator_Supervisor.validarAnosExperiencia(experiencia);
        MODEL_Supervisor modelSupervisor = daoSupervisor.find_By_Id(id);
        modelSupervisor.setExperiencia_anos_supervisor(modelSupervisor.getExperiencia_anos_supervisor());
        daoSupervisor.update_Experiencia(id,experiencia);
    }



    //Delete

    public void Delete_Supervisor(MODEL_Supervisor supervisor)
    {
        try
        {
            if(supervisor != null)
            {
                daoSupervisor.delete_Supervisor(supervisor);
            }
        }catch(RuntimeException re)
        {
            System.out.println(re.getMessage());
        }
    }

    //Outros
}
