package Menus;

import Ferramentas.Ferramentas;

import java.util.InputMismatchException;

public class MenuInicial {



        public static void Menu() {

            Ferramentas.limpaTerminal();

            System.out.println("      =================");
            System.out.println("      ==    WEG OS   ==");
            System.out.println("      =================");


            System.out.println("\n\n\n Este projeto . . .");

            System.out.println("\n\n\nDigite");
            System.out.println("1-Login");
            System.out.println("2-Cadastro");
            System.out.println("3-Sair");

            int escolha = 0;

            try {
                escolha = Ferramentas.lInteiro();
            }catch (InputMismatchException e){
                System.err.println("VALOR DIGITADO  INVALIDO!");
            }

            switch (escolha){

            }
        }

}
