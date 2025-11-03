package Model;

import java.util.ArrayList;
import Repository.DAO_Tecnico;
import Util.*;
import Exception.ESPECIALIDADEException;

public class SERVICE_Tecnico {

    //--Atributos--//
    static DAO_Tecnico daoTecnico;


    //--Métodos--//

    //Create

    public void Inserir_Tecnico(MODEL_Tecnico tecnico)
    {
        try {
            if (tecnico != null) {
                daoTecnico.insert_Tecnico(tecnico);
            }
        }catch(RuntimeException rte)
        {
            System.out.println(rte.getMessage());
        }
    }

    //Read

    public ArrayList<MODEL_Tecnico> All_Tecnicos()
    {
        try {
            return daoTecnico.find_All_Tecnico();
        }
        catch(RuntimeException rte)
        {
            System.out.println(rte.getMessage());
        }
        return null;
    }

    public MODEL_Tecnico Find_By_Id(int id)
    {
        try {
            return daoTecnico.find_By_Id(id);
        }catch (RuntimeException rte)
        {
            System.out.println(rte.getMessage());
        }

        return null;
    }

    //Update

    public void Update_Especialidade(MODEL_Tecnico tecnico, String especialidade)
    {
        try {
            daoTecnico.update_Especialidade(tecnico, Validator_Tecnico.validarEspecialidade(especialidade));
        }catch(ESPECIALIDADEException ee)
        {
            System.out.println(ee.getMessage());
        }
    }

    public void Update_Disponibilidade(MODEL_Tecnico tecnico, boolean disponibilidade)
    {
        try{
            daoTecnico.update_Disponibilidade(tecnico, disponibilidade);
        }catch(RuntimeException re)
        {
            System.out.println(re.getMessage());
        }
    }

    //Delete

    public void Delete_Tecnico(MODEL_Tecnico tecnico)
    {
        try
        {
            if (tecnico != null)
            {
                daoTecnico.delete_Tecnico(tecnico);
            }

        }
        catch(RuntimeException re)
        {
            System.out.println(re.getMessage());
        }
    }

    //Outros
}
