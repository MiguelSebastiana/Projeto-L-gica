package Util;
import Exception.*;
import Model.MODEL_Administrador;
import Model.MODEL_Usuario;
import Repository.DAO_Usuario;

import java.util.ArrayList;

public class Validator_Administrador {

    static DAO_Usuario dao_Usuario = new DAO_Usuario();

    // ---- VALIDAÇÃO DE CPF ---- //
   public static MODEL_Administrador validarAdm(String cpf , String senha ){

       MODEL_Administrador usuarios = dao_Usuario.buscarAdm(cpf, senha);

       return usuarios;
   }
}
