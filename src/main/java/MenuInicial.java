import java.util.InputMismatchException;

public class MenuInicial {



        public static void Menu() {

            boolean continuar = true;

            do {

                Ferramentas.limpaTerminal();

                System.out.println("      ===================");
                System.out.println("      ====   WEG OS  ====");
                System.out.println("      ===================");


                System.out.println("\n\n\n Este projeto . . .");

                System.out.println("\n\n\nDigite");
                System.out.println("1-Login");
                System.out.println("2-Sair");

                int escolha = 0;

                try {
                    escolha = Ferramentas.lInteiro();
                } catch (InputMismatchException e) {
                    System.err.println("VALOR DIGITADO  INVALIDO!");
                }

                if (escolha == 1){
                    MenuLogin.Menu();
                } else if (escolha == 2) {
                    continuar = false;
                }else {
                    Default.Default();
                }

            }while (continuar);
        }
}
