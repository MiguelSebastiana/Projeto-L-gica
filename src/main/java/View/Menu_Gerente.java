package View;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class Menu_Gerente {

    public static void Menu(){

        boolean continuar = false;

        do{
            Ferramentas.limpaTerminal();

            System.out.println("      ====================");
            System.out.println("      ==  Menu Gerente  ==");
            System.out.println("      ====================");

            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Visualizar relatórios gerais");
            System.out.println("3 - Criar ordens de serviço");
            System.out.println("4 - Sair");

            int escolha = 0;

            try {
                escolha = Ferramentas.lInteiro();
            } catch (InputMismatchException e) {
                System.err.println("VALOR DIGITADO  INVALIDO!");
            }

            switch (escolha) {
                case 1:{
                    Menu_Cadastro.Menu();
                    break;
                }
                case 2:{
                    Relatorios();
                    break;
                }
                case 3:{
                    Menu_Servicos.Criar();
                    break;
                }
                case 4:{
                    continuar = true;
                }
                default:{
                    Menu_Default.Default();
                }
            }

        }while (continuar);

        Menu_Inicial.Menu();
    }

    public static void Relatorios(){


    }
}
