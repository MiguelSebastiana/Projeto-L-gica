package Exception;

public class ESPECIALIDADEException extends RuntimeException {
    public ESPECIALIDADEException(String message) {
        super(message);
    }

    // -- MENSAGEM PADRAO -- //
    public ESPECIALIDADEException(){
        super("ERRO - ESPECIALIDADE INVÁLIDA!");
    }

    // -- ESPECIALIDADE NULA -- //
    public static ESPECIALIDADEException vazia(){
        return new ESPECIALIDADEException("ERRO - ESPECIALIDADE NÃO PODE SER VAZIA!");
    }
}
