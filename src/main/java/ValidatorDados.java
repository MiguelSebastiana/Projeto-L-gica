//---- MENSAGEM PERSONALIZADA DE ERRO NA INTEGRAÇÃO DE DADOS ----//
public class ValidatorDados extends RuntimeException {
    public ValidatorDados(String message) {
        throw new IllegalArgumentException("ERRO - ESSE DADOS JÁ FOI CADASTRADO!");
    }
}
