package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ferramentas {


    // Atributos Estáticos
    private static Scanner ler = new Scanner(System.in);

    // Construtor privado
    private Ferramentas() {

    }

    // Métodos

    // ------ APLICA DELAY EM MILISEGUNDOS ------ //
    public static void Delay(int ms) {
        try{Thread.sleep(ms);}catch(InterruptedException e){}
    }

    // ------ FAZ INPUT DE DOUBLE E RETORNA ------ //
    public static double lDouble() {
        while (true) {
            try {
                double num = ler.nextDouble();
                ler.nextLine();
                return num;
            } catch (InputMismatchException e) {
                System.err.print("Entrada inválida. Digite um número decimal: ");
                ler.nextLine();
            }
        }
    }

    // ------ FAZ INPUT DE STRING E RETORNA ------ //
    public static String lString() {
        return ler.nextLine();
    }

    // ------ FAZ INPUT DE INTEIRO E RETORNA ------ //
    public static int lInteiro() {
        while (true) {
            try {
                int num = ler.nextInt();
                ler.nextLine(); // limpa o buffer
                return num;
            } catch (InputMismatchException e) {
                System.err.print("Entrada inválida. Digite um número inteiro: ");
                ler.nextLine(); // limpa o buffer de novo
            }
        }
    }

    // ------ PULA MUITAS LINHAS DO TERMINAL ------ //
    public static void limpaTerminal() {
        for(int i = 0; i < 50; i ++) {
            System.out.println();
        }
    }

    public static void limpaTerminalOpcional(int valor){
        for (int i = 0; i < valor;i++){
            System.out.println();
        }
    }

}
