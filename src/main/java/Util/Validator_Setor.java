package Util;

import Model.MODEL_Setor;
import Repository.DAO_Setor;

import java.util.ArrayList;
import java.util.Arrays;
import Exception.*;

public class Validator_Setor {

    static DAO_Setor daoSETOR = new DAO_Setor();

    // ---- LISTA DE SETORES DISPONÍVEIS POR STRING ----
    public static final ArrayList<String> setoresValidos = new ArrayList<>(Arrays.asList(
            "Manutenção",
            "Produção",
            "TI",
            "Fundição",
            "Usinagem",
            "Bobinagem",
            "Montagem",
            "Controle de Qualidade"
    ));

    // ---- VALIDAÇÃO DO SETOR ----
    public static String validarSetor(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("ERRO - NOME DE SETOR NÃO PODE SER VAZIO!");
        }

        String setor = nome.trim();

        if (!setoresValidos.contains(setor)) {
            throw new IllegalArgumentException("ERRO - SETOR INVÁLIDO!");
        }

        return setor;
    }

    public static void validarId(int id_setor){

        ArrayList<MODEL_Setor> setores = daoSETOR.find_All_Setores();

        for (MODEL_Setor s : setores){
            if (s.getId_setor() == id_setor){
                return;
            }
        }

        throw new IDException();
    }
}
