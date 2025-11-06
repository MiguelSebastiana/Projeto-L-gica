package Model;

import Repository.DAO_Servico;

import java.util.ArrayList;
import Exception.STRINGException;
import Util.Validator_Geral;
import Util.Validator_Servico;
import Util.Validator_Usuario;


public class SERVICE_Servico {

    static DAO_Servico daoServico = new DAO_Servico();
    static SERVICE_Servico serviceServico = new SERVICE_Servico();

    //--Atributos--//

    //--Métodos--//

    //Create

    public void Insert_Servico(MODEL_Servico servico){
        if(servico != null)
        {
            daoServico.insert_Servico(servico);
        }
    }

    //Read

    public ArrayList<MODEL_Servico> All_Servicos(){
        return daoServico.find_All_Ordens_Servico();
    }

    public MODEL_Servico Find_by_Id(int id){
        Validator_Usuario.verificarID(id);
        return daoServico.find_By_Id(id);
    }

    public ArrayList<MODEL_Servico> Find_by_Pendente(){
        return daoServico.find_By_Aberta();
    }


    //Update

    public void Update_Status(int id, String status){
        Validator_Servico.validarID(id);
        Validator_Geral.validarString(status);
        MODEL_Servico modelServico = serviceServico.Find_by_Id(id);
        modelServico.setStatus_aberto_ordem_servico(modelServico.getStatus_aberto_ordem_servico());
    }

    public void Update_Descricao(String Descricao, int id)
    {
        try
        {
            daoServico.update_Descricao(id,Descricao);
        }
        catch (STRINGException se)
        {
            System.out.println(se.getMessage());
        }

    }

    public void Update_Id_Tecnico(int id, int idt){
        Validator_Usuario.verificarID(idt);
        daoServico.update_Id_Tecnico(id, idt);
    }

    public void Update_Id_Maquina(int id, int idm){
        Validator_Usuario.verificarID(idm);
        daoServico.update_Id_Maquina(id, idm);
    }

    public void Update_Custo(int id, double custo){
        Validator_Geral.ValidarNumeroNegativoDouble(custo);
        daoServico.update_Custo(id,custo);
    }

    //Delete

    public void Delete_Servico(int id){
        Validator_Usuario.verificarID(id);
        daoServico.delete_Servico(id);
    }

    //Outros
}
