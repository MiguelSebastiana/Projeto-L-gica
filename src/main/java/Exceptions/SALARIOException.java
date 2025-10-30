package Exceptions;

public class SALARIOException extends RuntimeException {
    public SALARIOException(String message) {
        super(message);
    }

    public SALARIOException(){
      super("ERRO - SALARIO INCORRETO!");
    }

    public static SALARIOException inferior(){
      return new SALARIOException("SÁLARIO NÃO PODE SER INFERIOR A R$1518,00!");
    }
}
