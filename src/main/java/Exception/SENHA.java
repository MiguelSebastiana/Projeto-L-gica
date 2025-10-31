package Exception;

public class SENHA extends RuntimeException {
    public SENHA(String message) {
        super(message);
    }

    // -- MENSAGEM PADRAO -- //
    public SENHA(){
      super("ERRO - SENHA INCORRETA!");
    }

    // -- SENHA VAZIA -- //
    public static SENHA vazia(){
      return new SENHA("ERRO - SENHA NÃO PODE SER VAZIA!");
    }

    // -- TAMANHO INCORRETO -- //
    public static SENHA tamanho(){
      return new SENHA("ERRO - SENHA NÃO PODE CONTER MENOS DE 5 DÍGITOS!");
    }
}
