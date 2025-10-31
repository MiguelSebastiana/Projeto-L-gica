package Util;

public class Validator_Supervisor{

    public static int validarAnosExperiencia(int anos){
        if (anos <= 4){
            throw new IllegalArgumentException("ERRO - SUPERVISOR DEVE TER NO MÍNIMO 4 ANOS DE EXPERIÊNCIA!");
        }

        return anos;
    }
}
