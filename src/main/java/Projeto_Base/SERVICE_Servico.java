package Projeto_Base;

import java.util.ArrayList;
import java.util.List;


public class SERVICE_Servico {

    static DAO_Servico daoServico = new DAO_Servico();


    //--Atributos--//



    //--Métodos--//

    //Create

    public void Insert_Servico(){

    }

    //Read

    public ArrayList<MODEL_Servico> All_Servicos(){
        return daoServico.find_All_Ordens_Servico();
    }

    public MODEL_Servico Find_by_Id(int id){
        return daoServico.find_By_Id(id);
    }

    public ArrayList<MODEL_Servico> Find_by_Pendente(){
        return daoServico.find_By_Pendente();
    }

    //Update

    public void Update_Status(){

    }

    public void Update_Descricao(){

    }

    public void Update_Id_Tecnico(){

    }

    public void Update_Id_Maquina(){

    }

    //Delete

    public void Delete_Servico(){

    }

    //Outros
}
