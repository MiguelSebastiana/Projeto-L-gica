package View;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class Menu_Inicial {

        public static void Menu() {

            boolean continuar = true;

            do {

                Ferramentas.limpaTerminal();
            System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│                                                    ██╗    ██╗███████╗ ██████╗     ██████╗ ███████╗                                                   │");
            System.out.println("│                                                    ██║    ██║██╔════╝██╔════╝    ██╔═══██╗██╔════╝                                                   │");
            System.out.println("│                                                    ██║ █╗ ██║█████╗  ██║  ███╗   ██║   ██║███████╗                                                   │");
            System.out.println("│                                                    ██║███╗██║██╔══╝  ██║   ██║   ██║   ██║╚════██║                                                   │");
            System.out.println("│                                                    ╚███╔███╔╝███████╗╚██████╔╝   ╚██████╔╝███████║                                                   │");
            System.out.println("│                                                     ╚══╝╚══╝ ╚══════╝ ╚═════╝     ╚═════╝ ╚══════╝                                                   │");
            System.out.println("└──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
                Ferramentas.limpaTerminalOpcional(3);

                System.out.println("Este projeto . . .");

                Ferramentas.limpaTerminalOpcional(2);

                System.out.println("┌───────────────────────────────────────┐");
                System.out.println("│ \uD835\uDCDE\uD835\uDCDF\uD835\uDCD2\uD835\uDCDE\uD835\uDCD4\uD835\uDCE2                               │");
                System.out.println("│ 1 ➔ Login:                            │");
                System.out.println("│ 2 ➔ Sair:                             │");
                System.out.println("└───────────────────────────────────────┘");
                System.out.print("➤ Digite a opção desejada: ");

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
