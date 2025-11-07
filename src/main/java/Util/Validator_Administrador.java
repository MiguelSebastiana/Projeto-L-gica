package Util;
import Exception.*;
public class Validator_Administrador {

    // ---- VALIDAÇÃO DE CPF ---- //

    public static String validarCodigo(String codigo) {
        if (codigo.length() < 5){
            throw CODIGOException.tamanho();
        }

        return codigo;
    }
}
