//---- MENSAGEM PERSONALIZADA DE ERRO NO CPF ----//
public class ValidatorCPF extends RuntimeException {
  public ValidatorCPF(String message) {
    throw new IllegalArgumentException("ERRO - CPF INVÁLIDO");
  }
}
