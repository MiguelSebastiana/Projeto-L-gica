package View;
import Util.Ferramentas;

import java.util.InputMismatchException;
public class Menu_Servicos {


    public static void Criar() {

        boolean continuar = true;
        int escolha = 0;

        do {
            Ferramentas.limpaTerminal();
            Ferramentas.limpaTerminal();
            System.out.println("      =======================");
            System.out.println("      ==   Criar Serviços  ==");
            System.out.println("      =======================");
            System.out.println("\n\n\n");
            System.out.println("--- Adicione um novo Serviço ---");
            System.out.println("\n\n");
            System.out.println("1 - Criar");
            System.out.println("2 - Sair");
            try {
                escolha = Ferramentas.lInteiro();
            } catch (InputMismatchException e) {
                Ferramentas.limpaTerminal();
                System.err.println("VALOR DIGITADO  INVALIDO!");
                Ferramentas.Delay(1500);
            }

            switch (escolha) {
                case 1: {

                    Ferramentas.limpaTerminal();

                    System.out.println("");

                    break;
                }
                case 2: {
                    continuar = false;
                    break;
                }
                default:{
                    Menu_Default.Default();
                    break;
                }
            }
        }while(!continuar);
    }
}