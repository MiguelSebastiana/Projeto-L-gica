package Exceptions;

public class CPFException extends RuntimeException {

      // -- CPF INVÁLIDO (mensagem genérica) -- //
      public CPFException() {
        super("ERRO - CPF INVÁLIDO!");
      }

      // -- MENSAGEM PERSONALIZADA (opcional) -- //
      public CPFException(String message) {
        super(message);
      }

      // -- CPF NULO / VAZIO -- //
      public static CPFException vazio() {
        return new CPFException("ERRO - CPF NÃO PODE SER VAZIO!");
      }

      // -- CPF DE TAMANHO INVÁLIDO OU SEQUÊNCIA (ex: 11111111111) -- //
      public static CPFException tamanhoInvalido() {
        return new CPFException("ERRO - CPF DE TAMANHO INVÁLIDO OU SEQUÊNCIA DE DÍGITOS IGUAIS!");
      }

      // -- DÍGITOS VERIFICADORES INCORRETOS -- //
      public static CPFException digitoInvalido() {
        return new CPFException("ERRO - CPF INVÁLIDO (DÍGITOS VERIFICADORES INCORRETOS)!");
    }
}
