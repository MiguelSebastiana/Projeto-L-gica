package Exceptions;

public class NomeException extends RuntimeException {
    public NomeException(){
        super("ERRO - NOME NÃO PODE SER VAZIO!");
    }

    public NomeException(String message){
        super(message);
    }
}
