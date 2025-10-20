//---- MENSAGEM PERSONALIZADA DE ERRO NO EMAIL ----//
public class ValidatorEmail extends RuntimeException {
    public ValidatorEmail(String message) {
        throw new IllegalArgumentException("ERRO - EMAIL INVÁLIDO");
    }
}
