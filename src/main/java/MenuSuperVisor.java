import java.util.InputMismatchException;

public class MenuSuperVisor {

    public static void Menu(){

        boolean continuar = true;

        do{
            System.out.println("      =====================");
            System.out.println("      == Menu SuperVisor ==");
            System.out.println("      =====================");

            System.out.println("1 - Ver status de todos OS");
            System.out.println("2 - Criar ordens de serviço");
            System.out.println("3 - Sair");

            int escolha = 0;

            try {
                escolha = Ferramentas.lInteiro();
            } catch (InputMismatchException e) {
                System.err.println("VALOR DIGITADO  INVALIDO!");
            }

            switch (escolha) {
                case 1:{
                }

                case 3:{
                    MenuInicial.Menu();
                }
            }

        }while (!continuar);


    }




}
