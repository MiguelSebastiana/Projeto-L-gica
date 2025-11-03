package Exception;

public class SETORException extends RuntimeException {
    public SETORException(String message) {
        super(message);
    }

    public static SETORException vazio(){
      return new SETORException("ERRO - ID DE SETOR NÃO PODE SER VAZIO!");
    }

    public static SETORException invalido(){
        return new SETORException("ERRO - SETOR DEVE SER EXISTENTE!");
    }
}
