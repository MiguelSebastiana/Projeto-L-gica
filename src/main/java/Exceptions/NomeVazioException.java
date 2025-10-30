package Exceptions;

public class NomeVazioException extends RuntimeException {
    public NomeVazioException(){
        super("ERRO - NOME NÃO PODE SER VAZIO!");
    }

    public NomeVazioException(String message){
        super(message);
    }
}
