package Model;

import Repository.DAO_Usuario;
import Util.Validator_Usuario;

import java.util.ArrayList;

public class SERVICE_Usuario {

    static DAO_Usuario daoUsuario;
    //--Atributos--//



    //--Métodos--//

    //READ

    public ArrayList<MODEL_Usuario> All_Users()
    {

        return daoUsuario.find_All_Users();
    }

    //Update

    public void Update_Telefone(String telefone, MODEL_Usuario usuario)
    {
        try {
            Validator_Usuario.ValidarTelefone(telefone);
            usuario.setTelefone(telefone);
        }catch(IllegalArgumentException iae)
        {
            System.out.println(iae.getMessage());
        }
    }

    public void Update_Email(){

    }

    public void Update_CargaHoraria(){

    }

    public void Update_Formacao(){

    }

    public void Update_Setor(){

    }

    //Outros

    public void Verificar_Login(String cpf,String senha){

    }

}
