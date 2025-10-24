package Projeto_Base;

public class Validator_Tecnico {

    // ---- VALIDAÇÃO DE ESPECIALIDADE DO TECNICO ---- //
    public static String validarEspecialidade(String especialidade){
        if (especialidade == null || especialidade.trim().isEmpty()){
            throw new IllegalArgumentException("ERRO - ESPECIALIDADE NÃO PODE SER VAZIA!");
        }

        return especialidade.trim();
    }
}
