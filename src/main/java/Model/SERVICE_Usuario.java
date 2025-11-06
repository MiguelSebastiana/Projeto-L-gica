package Model;

import Repository.DAO_Usuario;
import Util.Validator_Geral;
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
        try {
            return daoUsuario.find_All_Users();
        }catch (RuntimeException re){
            throw new RuntimeException(re.getMessage());
        }
    }

    public MODEL_Usuario Find_By_ID(int id){
        try {
            Validator_Usuario.verificarID(id);
            MODEL_Usuario usuario = daoUsuario.find_by_id(id);
            return usuario;
        }catch (RuntimeException ru){
            throw new RuntimeException(ru.getMessage());
        }
    }

    //Update

    public void Update_Telefone(String telefone, int id)
    {
        try {
            Validator_Usuario.verificarID(id);
            Validator_Geral.ValidarTelefone(telefone);
            MODEL_Usuario usuario = daoUsuario.find_by_id(id);
            daoUsuario.update_Telefone(id,telefone);
            usuario.setTelefone(telefone);
        }
        catch(RuntimeException ru)
        {
            throw new RuntimeException(ru.getMessage());
        }
    }

    public void Update_Email(int id, String email)
    {
        try
        {
            Validator_Usuario.verificarID(id);
            Validator_Geral.ValidarEmail(email);
            MODEL_Usuario usuario = daoUsuario.find_by_id(id);
            daoUsuario.update_Email(id,email);
            usuario.setEmail(email);
        }
        catch(RuntimeException ru)
        {
            throw new RuntimeException(ru.getMessage());
        }
    }

    public void Update_CargaHoraria(int id, int cargaHoraria)
    {
        try
        {
            Validator_Usuario.verificarID(id);
            Validator_Usuario.validarCargaHoraria(cargaHoraria);
            MODEL_Usuario usuario = daoUsuario.find_by_id(id);
            daoUsuario.update_Carga_Horaria(id,cargaHoraria);
            usuario.setCargahoraria(cargaHoraria);
        }
        catch(RuntimeException ru)
        {
            throw new RuntimeException(ru.getMessage());
        }
    }

    public void Update_Formacao(int id, String formacao) {
        try
        {
            Validator_Usuario.verificarID(id);
            Validator_Usuario.formacao(formacao);
            MODEL_Usuario usuario = daoUsuario.find_by_id(id);
            daoUsuario.update_Formacao(id,formacao);
            usuario.setFormacao(formacao);
        }
        catch(RuntimeException ru)
        {
            throw new RuntimeException(ru.getMessage());
        }
    }
    public void Update_Setor(int id, int setor)
    {
        try
        {
            Validator_Usuario.verificarID(id);
            Validator_Usuario.validarSetor(setor);
            MODEL_Usuario usuario = daoUsuario.find_by_id(id);
            daoUsuario.update_Setor(id,setor);
            usuario.setSetor(setor);
        }
        catch(RuntimeException ru)
        {
            throw new RuntimeException(ru.getMessage());
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
            throw new CPFException(ce.getMessage());
        }
        catch(SENHAException se)
        {
            throw new SENHAException(se.getMessage());
        }
        catch (RuntimeException ru){
            throw new RuntimeException(ru.getMessage());
        }
        return null;
    }

    public int verificarIdFuncao(int id)
    {
        try {
            Validator_Usuario.verificarID(id);
            MODEL_Usuario usuario = daoUsuario.find_by_id(id);
            return usuario.getNivelacesso();
        }catch (RuntimeException re){
            throw new RuntimeException(re.getMessage());
        }
    }
}
