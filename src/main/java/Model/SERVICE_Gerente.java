package Model;

import Repository.DAO_Gerente;
import Util.Validator_Gerente;
import Util.Validator_Usuario;

import java.util.ArrayList;

public class SERVICE_Gerente {

    //--Atributos--//

    static DAO_Gerente daoGerente;

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
        try {
            Validator_Usuario.verificarID(id);
            return daoGerente.find_By_Id(id);
        }catch(RuntimeException re)
        {
            throw new RuntimeException(re.getMessage());
        }
    }

    //Update

    public void Update_TempoFuncao(int id, int tempoFuncao) {
        try {
            Validator_Usuario.verificarID(id);
            Validator_Gerente.validarTempoFuncao(tempoFuncao);
            MODEL_Gerente modelGerente = SERVICE_Gerente.daoGerente.find_By_Id(id);
            modelGerente.setTempo_na_funcao_anos_gerente(tempoFuncao);
            daoGerente.update_Tempo_Funcao(id, tempoFuncao);
        }catch(RuntimeException rte)
        {
            throw new RuntimeException(rte.getMessage());
        }
    }

    //Delete

    public void Delete_Gerente(int id)
    {
        try
        {
            Validator_Usuario.verificarID(id);
            daoGerente.delete_User_Gerente(id);
        }
        catch(RuntimeException re)
        {
            throw new RuntimeException(re.getMessage());
        }
    }

    //Outros
}
