package Exception;

public class IDException extends RuntimeException {
    public IDException(String message) {
        super(message);
    }

    public IDException(){
        super("ERRO - ID INVÁLIDO!");
    }
}
