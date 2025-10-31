package Util;
import Exception.*;
public class Validator_Supervisor{

    public static int validarAnosExperiencia(int anos){
        if (anos <= 4){
            throw ANOSEXPERIENCIAException.inferior();
        }

        return anos;
    }
}
