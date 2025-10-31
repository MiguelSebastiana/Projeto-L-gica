package Exceptions;

public class SALARIOException extends RuntimeException {
    public SALARIOException(String message) {
        super(message);
    }

    // -- MENSAGEM PADRAO -- //
    public SALARIOException(){
      super("ERRO - SALARIO INCORRETO!");
    }

    // -- SALARIO INFERIOR AO SALARIO MINIMO -- //
    public static SALARIOException inferior(){
      return new SALARIOException("SÁLARIO NÃO PODE SER INFERIOR A R$1518,00!");
    }
}
