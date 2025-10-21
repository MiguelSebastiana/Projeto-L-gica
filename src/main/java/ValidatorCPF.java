//---- MENSAGEM PERSONALIZADA DE ERRO NO CPF ----//
public class ValidatorCPF extends RuntimeException {
  public ValidatorCPF() {
    throw new IllegalArgumentException("ERRO - CPF INVÁLIDO");
  }
}
