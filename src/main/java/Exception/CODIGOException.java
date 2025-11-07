package Exception;

public class CODIGOException extends RuntimeException {
    public CODIGOException(String message) {
        super(message);
    }

    public CODIGOException(){
        super("ERRO - CÓDIGO INVÁLIDO!");
    }

    public static CODIGOException tamanho(){
        return new CODIGOException("ERRO - CÓDIGO DEVE CONTER NO MINIMO 7 DIGITOS!");
    }
}
