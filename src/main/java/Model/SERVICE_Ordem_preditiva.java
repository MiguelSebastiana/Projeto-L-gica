package Model;

import Repository.DAO_Ordem_preditiva;

import java.util.ArrayList;
import Exception.STRINGException;
import Util.Validator_Geral;
import Util.Validator_Usuario;


public class SERVICE_Ordem_preditiva implements SERVICE_Ordens{

    static DAO_Ordem_preditiva daoOp= new DAO_Ordem_preditiva();


    //--Atributos--//

    //--Métodos--//

    //Create

    public void Insert_Servico(MODEL_Ordem_Preditiva op){
        if(op != null)
        {
            daoOp.insert_Servico(op);
        }
    }

    //Read

    public ArrayList<MODEL_Ordem_Preditiva> All_Ordens_preditiva(){
        return daoOp.find_All_Ordens_Preditiva();
    }

    public MODEL_Ordem_Preditiva Find_by_Id(int id){
        Validator_Usuario.verificarID(id);
        return daoOp.find_By_Id(id);
    }

    public ArrayList<MODEL_Ordem_Preditiva> Find_by_Pendente(){
        return daoOp.find_By_Aberta();
    }


    //Update
    static MODEL_Ordem_Preditiva ordemPreditiva;
    public DAO_Ordem_preditiva daoOrdemPreditiva;

    @Override
    public void Update_Status(int id, String status){
        Validator_Usuario.verificarID(id);
        Validator_Geral.validarString(status);
        ordemPreditiva.setStatus_aberto_ordem_preditiva(ordemPreditiva.getStatus_aberto_ordem_preditiva());
    }

    @Override
    public void Update_Descricao(String Descricao, int id)
    {
        try
        {
            daoOp.update_Descricao(id, ordemPreditiva.getDescricao_ordem_preditiva());
        }
        catch (STRINGException se)
        {
            System.out.println(se.getMessage());
        }

    }

    @Override
    public void Update_Id_Tecnico(int id, int idt){
        Validator_Usuario.verificarID(idt);
        daoOp.update_Id_Tecnico(id, idt);
    }

    @Override
    public void Update_Id_Maquina(int id, int idm){
        Validator_Usuario.verificarID(idm);
        daoOp.update_Id_Maquina(id, idm);
    }

    @Override
    public void Update_Custo(int id, double custo){
        Validator_Geral.ValidarNumeroNegativoDouble(custo);
        daoOp.update_Custo(id,custo);
    }

    //Delete

    @Override
    public void Delete_Servico(int id){
        Validator_Usuario.verificarID(id);
        daoOp.delete_Ordem_Preditiva(id);
    }

    //Outros
}