package Util;
import Exception.*;

public class Validator_Tecnico {

    // ---- VALIDAÇÃO DE ESPECIALIDADE DO TECNICO ---- //
    public static String validarEspecialidade(String especialidade){
        if (especialidade == null || especialidade.trim().isEmpty()){
            throw ESPECIALIDADEException.vazia();
        }

        return especialidade.trim();
    }
}
