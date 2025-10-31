package Exception;

public class NIVELACESSOException extends RuntimeException {
    public NIVELACESSOException(String message) {
        super(message);
    }

    // -- MENSAGEM PADRAO -- //
    public NIVELACESSOException(){
      super("ERRO - NIVEL INVÁLIDO!");
    }

    // -- NIVEL DIFERENTE DE 1,2,3 -- //
    public static NIVELACESSOException errado(){
      return new NIVELACESSOException("ERRO - NIVEL NÃO PODE SER DIFERENTE DE 1 , 2 , 3!");
    }
}
