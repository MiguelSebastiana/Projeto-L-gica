package Util;
import Exception.*;
public class Validator_Gerente{

    public static int validarTempoFuncao(int tempo){
        if (tempo <= 10){
            throw TEMPOFUNException.inferior();
        }

        return tempo;
    }
}
