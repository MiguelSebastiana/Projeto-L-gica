package Exception;

public class TEMPOFUNException extends RuntimeException {
    public TEMPOFUNException(String message) {
        super(message);
    }

    // -- MENSAGEM PADRAO -- //
    public TEMPOFUNException(){
      super("ERRO - TEMPO INVÁLIDO!");
    }

    public static TEMPOFUNException inferior(){
      return new TEMPOFUNException("ERRO - GERENTE DEVE TER NO MÍNIMO 10 ANOS DE FUNÇÃO!");
    }
}
