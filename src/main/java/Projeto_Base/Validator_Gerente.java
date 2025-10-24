package Projeto_Base;

public class Validator_Gerente{

    public static int validarTempoFuncao(int tempo){
        if (tempo <= 10){
            throw new IllegalArgumentException("ERRO - GERENTE DEVE TER NO MÍNIMO 10 ANOS DE FUNÇÃ0!");
        }

        return tempo;
    }
}
