package Model;


import java.util.ArrayList;


public interface SERVICE_Ordens {


    //--Atributos--//

    //--Métodos--//

    //Create

    public void Insert_Servico();


    //Read

    public ArrayList All_Servicos();


    public void Find_by_Id (int id);


    public ArrayList Find_by_Pendente();


    //Update

    public void Update_Status(int id, String status);

    public void Update_Descricao(String Descricao, int id);


    public void Update_Id_Tecnico(int id, int idt);

    public void Update_Id_Maquina(int id, int idm);

    public void Update_Custo(int id, double custo);

    //Delete

    public void Delete_Servico(int id);

    //Outros
}
