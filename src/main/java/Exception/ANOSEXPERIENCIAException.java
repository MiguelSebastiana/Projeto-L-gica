package Exception;

public class ANOSEXPERIENCIAException extends RuntimeException {
    public ANOSEXPERIENCIAException(String message) {
        super(message);
    }

    // -- MENSAGEM PADRAO -- //
    public ANOSEXPERIENCIAException(){
      super("ERRO - ANO INVÁLIDO!");
    }

    // -- SUPERVISOR COM MENOS DE 4 ANOS DE EXPERIENCIA -- //
    public static ANOSEXPERIENCIAException inferior(){
      return new ANOSEXPERIENCIAException("ERRO - SUPERVISOR DEVE TER NO MÍNIMO 4 ANOS DE EXPERIÊNCIA!");
    }
}
