package Model;

import Repository.DAO_Servico;

import java.util.ArrayList;
import Exception.STRINGException;


public class SERVICE_Servico {

    static DAO_Servico daoServico = new DAO_Servico();


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
        return daoServico.find_By_Id(id);
    }

    public ArrayList<MODEL_Servico> Find_by_Pendente(){
        return daoServico.find_By_Aberta();
    }


    //Update
    static MODEL_Servico modelServico;
    public void Update_Status(){
    modelServico.setStatus_aberto_ordem_servico(modelServico.getStatus_aberto_ordem_servico());
    }

    public void Update_Descricao(MODEL_Servico servico, String Descricao, int id)
    {
        try
        {
            daoServico.update_Descricao(id, modelServico.getDescricao_ordem_servico());
        }
        catch (STRINGException se)
        {
            System.out.println(se.getMessage());
        }

    }

    public void Update_Id_Tecnico(MODEL_Servico servico, int id, int idt){
        daoServico.update_Id_Tecnico(id, idt);
    }

    public void Update_Id_Maquina(int id, int idm){
        daoServico.update_Id_Maquina(id, idm);
    }

    //Delete

    public void Delete_Servico(int id){
        daoServico.delete_Servico(id);
    }

    //Outros
}
