package Exception;

public class NOMEException extends RuntimeException {
    // -- MENSAGEM PADRAO -- //
    public NOMEException(){
        super("ERRO - NOME NÃO PODE SER VAZIO!");
    }

    public NOMEException(String message){
        super(message);
    }
}
