//---- MENSAGEM PERSONALIZADA DE ERRO EM VALOR NÚMERICO ----//
public class ValidatorValorNegativo extends RuntimeException {
    public ValidatorValorNegativo(String message) {
        super(message);
    }
}
