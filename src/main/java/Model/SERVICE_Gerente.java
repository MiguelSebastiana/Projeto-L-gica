package Model;

import Repository.DAO_Gerente;
import Util.Validator_Gerente;
import Util.Validator_Usuario;

import java.util.ArrayList;

public class SERVICE_Gerente {

    static DAO_Gerente daoGerente;
    //--Atributos--//



    //--Métodos--//

    //Create

    public void Inserir_Gerente(MODEL_Gerente gerente)
    {
        try {
            if (gerente != null) {
                daoGerente.insert_User_Gerente(gerente);
            }
        }catch(RuntimeException re)
        {
            System.out.println(re.getMessage());
        }

    }
    //Read

    public ArrayList<MODEL_Gerente> All_Gerentes(){
        return daoGerente.find_All_Gerentes();
    }

    public MODEL_Gerente Find_By_Id(int id){
        Validator_Usuario.verificarID(id);
        return daoGerente.find_By_Id(id);
    }

    //Update

    public void Update_TempoFuncao(MODEL_Gerente gerente, int tempoFuncao) {
        if (gerente != null)
        {
            daoGerente.update_Tempo_Funcao(gerente, Validator_Gerente.validarTempoFuncao(tempoFuncao));
        }
    }

    //Delete

    public void Delete_Gerente(MODEL_Gerente gerente )
    {
        try {
            if (gerente != null) {
                daoGerente.delete_User_Gerente(gerente);
            }
        }catch(RuntimeException re)
        {
            System.out.println(re.getMessage());
        }
    }

    //Outros
}
