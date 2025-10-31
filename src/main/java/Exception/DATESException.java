package Exception;

public class DATESException extends RuntimeException {
    public DATESException(String message) {
        super(message);
    }

    // -- MENSAGEM PADRÃO -- //
    public DATESException(){
      super("ERRO - DATA INCORRETA!");
    }

    // -- DATA NULA -- //
    public static DATESException vazio(){
      return new DATESException("ERRO - A DATA NÃO PODE SER VAZIA!");
    }

    // -- DATA FUTUTA -- //
    public static DATESException futuro(){
      return new DATESException("ERRO - A DATA NÃO PODE SER NO FUTURO!");
    }

    // -- IDADE MINIMA -- //
    public static DATESException maiorIdade(){
      return new DATESException("ERRO - USÚARIO DEVE TER NO MÍNIMO 18 ANOS!");
    }

    // -- ANO INVALIDO -- //
    public static DATESException anoInvalido(){
      return new DATESException("ERRO - ANO INVÁLIDO! O ANO DEVE ESTAR ENTRE 1900 E O ANO ATUAL!");
    }

    // -- MES INVALIDO -- //
    public static DATESException mesInvalido(){
      return new DATESException("ERRO - MÊS INVÁLIDO! O MÊS DEVE ESTAR ENTRE 1 E 12!");
    }

    // -- DIA INVALIDO -- //
    public static DATESException diaInvalido(){
      return new DATESException("ERRO - DIA INVÁLIDO!");
    }
}
