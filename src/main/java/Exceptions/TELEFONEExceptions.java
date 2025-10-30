package Exceptions;

public class TELEFONEExceptions extends RuntimeException {
    public TELEFONEExceptions(String message) {
        super(message);
    }

    public TELEFONEExceptions(){
      super("ERRO - TAMANHO DE TELEFONE INCORRETO!");
    }
}
