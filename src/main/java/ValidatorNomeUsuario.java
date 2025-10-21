//---- MENSAGEM PERSONALIZADA DE ERRO NO NOME ----//
public class ValidatorNomeUsuario extends RuntimeException {
    public ValidatorNomeUsuario(String message) {
        super(message);
    }
}
