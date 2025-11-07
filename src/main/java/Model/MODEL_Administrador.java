package Model;

import Util.Validator_Administrador;

public class MODEL_Administrador {

    // ---- ATRIBUTOS PRIVADOS ---- //
    private String codigo;

    // ---- CONSTRUTOR ---- //
    public MODEL_Administrador(String codigo) {
       setCodigo(codigo);
    }

    // ---- GETTERS E SETTERS ---- //

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = Validator_Administrador.validarCodigo(codigo);
    }
}
