package Util;

import Model.MODEL_Maquina;
import Repository.DAO_Maquina;
import Exception.*;

import java.util.ArrayList;

public class Validator_Maquina {

    static DAO_Maquina daoMAQUINA = new DAO_Maquina();

    public static void validarId(int id_maquina){


        ArrayList<MODEL_Maquina> maquinas = daoMAQUINA.find_All_Maquinas();

        for (MODEL_Maquina m : maquinas){
            if (m.getId_maquina() == id_maquina){
                return;
            }
        }

        throw new IDException();
    }
}
