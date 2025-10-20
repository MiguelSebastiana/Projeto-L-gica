//---- MENSAGEM PERSONALIZADA DE ERRO NO NOME ----//
public class ValidatorNomeUsuario extends RuntimeException {
    public ValidatorNomeUsuario(String message) {
        throw new IllegalArgumentException("ERRO - NOME NÃO PODE SER VAZIO!");
    }
}
