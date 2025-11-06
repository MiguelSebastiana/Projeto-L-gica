package Util;

import Model.MODEL_Servico;
import Repository.DAO_Servico;
import Exception.*;

import java.util.ArrayList;

public class Validator_Servico {

    static DAO_Servico daoSERVICO = new DAO_Servico();

    public static void validarID(int id_servico){

        ArrayList<MODEL_Servico> servicos = daoSERVICO.find_All_Ordens_Servico();

        for (MODEL_Servico s : servicos){
            if (s.getId_Ordem_servico() == id_servico){
                return;
            }
        }

        throw new IDException();
    }
}
