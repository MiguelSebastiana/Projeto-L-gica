package View;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class Menu_Inicial {



        public static void Menu() {

            boolean continuar = true;

            do {

                Ferramentas.limpaTerminal();

                System.out.println("      +--------------------+");
                System.out.println("      |       WEG OS       |");
                System.out.println("      +--------------------+");

                System.out.println("\n\n\n Este projeto . . .");

                System.out.println("      --- Opções ---");

                System.out.println("1-Login");
                System.out.println("2-Sair");
                System.out.println("\n ----------------------------------");
                System.out.print("> Digite a opção desejada: ");

                int escolha = 0;

                try {
                    escolha = Ferramentas.lInteiro();
                } catch (InputMismatchException e) {
                    System.err.println("VALOR DIGITADO  INVALIDO!");
                }

                if (escolha == 1){
                    Menu_Login.Menu();
                } else if (escolha == 2) {
                    continuar = false;
                }else {
                    Menu_Default.Default();
                }

            }while (continuar);
        }
}
