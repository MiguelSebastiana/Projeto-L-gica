//---- MENSAGEM PERSONALIZADA DE ERRO NA SENHA ----//
public class ValidatorSenha extends RuntimeException {
    public ValidatorSenha(String message) {
        throw new IllegalArgumentException("ERRO - SENHA INCORRETA!");
    }
}
