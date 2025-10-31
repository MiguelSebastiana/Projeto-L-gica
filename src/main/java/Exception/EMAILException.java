package Exception;

public class EMAILException extends RuntimeException {
      public EMAILException(String message) {
      super(message);
    }

      // -- MENSAGEM PADRAO -- //
      public EMAILException(){
        super("ERRO - EMAIL INVÁLIDO!");
      }

      // -- EMAIL NULO -- //
      public static EMAILException vazio(){
        return new EMAILException("ERRO - EMAIL NULO OU NÃO CONTÉM @ OU .");
      }

      // -- @ NO LOCAL ERRADO OU NÃO CONTEM -- //
      public static EMAILException caracteres(){
        return new EMAILException("ERRO - @ VEM DEPOIS DE PONTO OU NÃO CONTÉM!");
      }

      // -- EMAIL CONTEM ESPACOS -- //
      public static EMAILException espaco(){
        return new EMAILException("ERRO - EMAIL NÃO PODE CONTER ESPAÇOS!");
      }


}
