package Exception;

public class SENHAException extends RuntimeException {
    public SENHAException(String message) {
        super(message);
    }

    // -- MENSAGEM PADRAO -- //
    public SENHAException(){
      super("ERRO - SENHA INCORRETA!");
    }

    // -- SENHA VAZIA -- //
    public static SENHAException vazia(){
      return new SENHAException("ERRO - SENHA NÃO PODE SER VAZIA!");
    }

    // -- TAMANHO INCORRETO -- //
    public static SENHAException tamanho(){
      return new SENHAException("ERRO - SENHA NÃO PODE CONTER MENOS DE 5 DÍGITOS!");
    }
}
