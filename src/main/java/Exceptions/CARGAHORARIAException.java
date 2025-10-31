package Exceptions;

public class CARGAHORARIAException extends RuntimeException {
    public CARGAHORARIAException(String message) {
        super(message);
    }

    // -- PADRAO -- //
    public CARGAHORARIAException(){
      super("CARGA HORÁRIA INVÁLIDA!");
    }

    // -- CARGA HORARIA INFERIOR A 13200m -- //
    public static CARGAHORARIAException inferior(){
      return new CARGAHORARIAException("ERRO - CARGA HORÁRIA NÃO PODE SER INFERIOR A 13200 MINUTOS!");
    }
}
