package View;
import Util.Ferramentas;

import java.util.InputMismatchException;
public class Menu_Tecnico {

    public static void Menu(){

        boolean continuar = true;

        do{
            System.out.println("      ====================");
            System.out.println("      ==  Menu Técnico  ==");
            System.out.println("      ====================");

            System.out.println("1 - Ver as ordens atribuidas");
            System.out.println("2 - Alterar os Status das ordens");
            System.out.println("3 - Sair");

            int escolha = 0;

            try {
                escolha = Ferramentas.lInteiro();
            } catch (InputMismatchException e) {
                System.err.println("VALOR DIGITADO  INVALIDO!");
            }

            switch (escolha) {
                case 1:{

                    break;
                }
                case 2:{

                    break;
                }
                case 3:{
                    continuar = false;
                    break;
                }
                default:{
                    Menu_Default.Default();
                }
            }
        }while (continuar);

        Menu_Inicial.Menu();
    }
}
