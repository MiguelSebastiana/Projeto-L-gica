package Exceptions;

public class DATESExceptions extends RuntimeException {
    public DATESExceptions(String message) {
        super(message);
    }

    public DATESExceptions(){
      super("ERRO - DATA INCORRETA!");
    }

    public static DATESExceptions vazio(){
      return new DATESExceptions("ERRO - A DATA NÃO PODE SER VAZIA!");
    }

    public static DATESExceptions futuro(){
      return new DATESExceptions("ERRO - A DATA NÃO PODE SER NO FUTURO!");
    }

    public static DATESExceptions maiorIdade(){
      return new DATESExceptions("ERRO - USÚARIO DEVE TER NO MÍNIMO 18 ANOS!");
    }

    public static DATESExceptions anoInvalido(){
      return new DATESExceptions("ERRO - ANO INVÁLIDO! O ANO DEVE ESTAR ENTRE 1900 E O ANO ATUAL!");
    }

    public static DATESExceptions mesInvalido(){
      return new DATESExceptions("ERRO - MÊS INVÁLIDO! O MÊS DEVE ESTAR ENTRE 1 E 12!");
    }
}
