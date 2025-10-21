//---- MENSAGEM PERSONALIZADA DE ERRO EM VALOR NÚMERICO ----//
public class ValidatorValorNegativo extends RuntimeException {
    public ValidatorValorNegativo(String message) {
        throw new IllegalArgumentException("ERRO - NÃO SÃO ACEITOS NÚMEROS NEGATIVOS!");
    }
}
