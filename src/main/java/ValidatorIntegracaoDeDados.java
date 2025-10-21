//---- MENSAGEM PERSONALIZADA DE ERRO NA INTEGRAÇÃO DE DADOS ----//
public class ValidatorIntegracaoDeDados extends RuntimeException {
    public ValidatorIntegracaoDeDados() {
        throw new IllegalArgumentException("ERRO - VOCÊ NÃO POSSUI O CARGO PARA ISSO!");
    }
}
