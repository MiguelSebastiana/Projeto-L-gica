package Exceptions;

public class TELEFONEException extends RuntimeException {
    public TELEFONEException(String message) {
        super(message);
    }

    // -- MENSAGEM PADRAO -- //
    public TELEFONEException(){
      super("ERRO - TAMANHO DE TELEFONE INCORRETO!");
    }
}
