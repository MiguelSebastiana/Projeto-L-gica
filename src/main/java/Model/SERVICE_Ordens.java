package Model;


import java.util.ArrayList;


public interface SERVICE_Ordens {


    //--Atributos--//

    //--Métodos--//

    //Create




    //Read


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
