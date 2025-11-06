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

    public void Update_Especialidade(int id_tecnico, String especialidade)
    {
       try{
           Validator_Usuario.verificarID(id_tecnico);
           Validator_Geral.validarString(especialidade);
           MODEL_Tecnico modelTecnico = daoTecnico.find_By_Id(id_tecnico);
           daoTecnico.update_Especialidade(id_tecnico,especialidade);
           modelTecnico.setEspecialidade_tecnico(especialidade);
       }catch (RuntimeException rte){
           throw new RuntimeException(rte.getMessage());
       }
    }

    public void Update_Disponibilidade(int id_tecnico, boolean disponibilidade)
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
