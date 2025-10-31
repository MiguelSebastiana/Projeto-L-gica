package View;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class Menu_Administrador {

    public static void Menu(){

        boolean continuar = false;

        do{

            Ferramentas.limpaTerminal();

            System.out.println("      ==========================");
            System.out.println("      ==  Menu Administrador  ==");
            System.out.println("      ==========================");

            System.out.println("1 - Cadastrar Gerente");
            System.out.println("2 - Atualizar Gerente");
            System.out.println("3 - Excluir Gerente");
            System.out.println("4 - Sair");

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

                    break;
                }
                case 4:{
                    continuar = true;
                    break;
                }
                default:{
                    Menu_Default.Default();
                    break;
                }
            }

        }while (continuar);

        Menu_Inicial.Menu();
    }
}
