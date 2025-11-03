package Exception;

public class FORMACAOException extends RuntimeException {
    public FORMACAOException(String message) {
        super(message);
    }


    public static FORMACAOException vazio() {
        return new FORMACAOException("ERRO - A FORMAÇÃO NÃO PODE SER VAZIA!");
    }

    public static FORMACAOException invalida() {
        return new FORMACAOException("ERRO - ESCOLHA UMA FORMAÇÃO VALIDA!");
    }
}
