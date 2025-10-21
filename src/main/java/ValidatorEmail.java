//---- MENSAGEM PERSONALIZADA DE ERRO NO EMAIL ----//
public class ValidatorEmail extends RuntimeException {
    public ValidatorEmail() {
        throw new IllegalArgumentException("ERRO - EMAIL INVÁLIDO");
    }
}
