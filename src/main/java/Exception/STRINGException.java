package Exception;

public class STRINGException extends RuntimeException {
    // -- MENSAGEM PADRAO -- //
    public STRINGException(){
        super("ERRO - NOME NÃO PODE SER VAZIO!");
    }

    public STRINGException(String message){
        super(message);
    }
}
