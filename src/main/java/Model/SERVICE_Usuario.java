package Model;

import Repository.DAO_Usuario;
import Util.Validator_Usuario;
import Exception.EMAILException;
import Exception.CARGAHORARIAException;
import Exception.FORMACAOException;
import Exception.SETORException;
import Exception.SENHAException;
import Exception.CPFException;

import java.util.ArrayList;
import java.util.Date;

public class SERVICE_Usuario {


    //--Atributos--//

    static DAO_Usuario daoUsuario;
    static SERVICE_Usuario serviceUsuario;

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
        }
        catch(IllegalArgumentException iae)
        {
            System.out.println(iae.getMessage());
        }
    }

    public void Update_Email(MODEL_Usuario usuario, String email)
    {
        try
        {
            if(usuario != null) {
                daoUsuario.update_Email(usuario.getId(), Validator_Usuario.ValidarEmail(email));
            }
        }
        catch(EMAILException ee)
        {
            System.out.println(ee.getMessage());
        }
    }

    public void Update_CargaHoraria(MODEL_Usuario usuario, int cargaHoraria)
    {
        try
        {
            daoUsuario.update_Carga_Horaria(usuario.getId(), Validator_Usuario.validarCargaHoraria(cargaHoraria));
        }
        catch(CARGAHORARIAException che)
        {
            System.out.println(che.getMessage());
        }
    }

    public void Update_Formacao(MODEL_Usuario usuario, String formacao) {
        try
        {
            daoUsuario.update_Formacao(usuario.getId(), Validator_Usuario.formacao(formacao));
        }
        catch(FORMACAOException fe)
        {
            System.out.println(fe.getMessage());
        }
    }
    public void Update_Setor(MODEL_Usuario usuario, int setor)
    {
        try
        {
            daoUsuario.update_Setor(usuario.getId(), Validator_Usuario.validarSetor(setor));
        }
        catch(SETORException se)
        {
            System.out.println(se.getMessage());
        }
    }

    //Outros

    public MODEL_Usuario Verificar_Login(String cpf,String senha)
    {
        try
        {
            for (MODEL_Usuario u : daoUsuario.find_All_Users())
            {
                if (Validator_Usuario.validarCpf(cpf).equals(cpf) && Validator_Usuario.senha(senha).equals(senha))
                {
                    return u;
                }
            }
        }catch(CPFException ce)
        {
            System.out.println(ce.getMessage());
        }
        catch(SENHAException se)
        {
            System.out.println(se.getMessage());
        }

        return null;
    }

    public int verificarIdFuncao(int usuario)
    {
        Validator_Usuario.verificarID(usuario);

        ArrayList<>
        return usuario();
    }


}
