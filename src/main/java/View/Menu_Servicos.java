package View;
import Model.MODEL_Servico;
import Model.MODEL_Supervisor;
import Model.MODEL_Usuario;
import Model.SERVICE_Servico;
import Util.Ferramentas;

import java.util.InputMismatchException;
public class Menu_Servicos {

    static SERVICE_Servico servico = new SERVICE_Servico();

    public static void Criar(MODEL_Supervisor supervisor) {

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

                    Adicionar(supervisor);

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

    public static void Adicionar(MODEL_Supervisor supervisor){

        Ferramentas.limpaTerminal();

        System.out.println("=== Criar Novo Serviço ===");
        String nome = "";
        String status = "";
        do {
            System.out.print("Digite o status da ordem de serviço : ");
            try {
                status = Ferramentas.lString().trim();
                if (status.isEmpty()) {
                    System.err.println("O status não pode estar vazio!");
                    Ferramentas.Delay(1500);
                    Ferramentas.limpaTerminal();
                }
            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida!");
                Ferramentas.Delay(1500);
                Ferramentas.limpaTerminal();
            }
        } while (status.isEmpty());


        System.out.print("Digite a descrição da ordem de serviço: ");
        String descricao = Ferramentas.lString();


        int idTecnico = 0;
        boolean tecnicoValido = false;

        do {
            System.out.print("Digite o ID do técnico responsável: ");
            try {
                idTecnico = Ferramentas.lInteiro();
                if (idTecnico <= 0) {
                    System.err.println("O ID do técnico deve ser maior que zero!");
                    Ferramentas.Delay(1500);
                } else {
                    tecnicoValido = true;
                }
            } catch (InputMismatchException e) {
                System.err.println("Valor inválido! Digite um número inteiro.");
                Ferramentas.Delay(1500);
            }
        } while (!tecnicoValido);

        
        int idMaquina = 0;
        boolean maquinaValida = false;

        do {
            System.out.print("Digite o ID da máquina associada: ");
            try {
                idMaquina = Ferramentas.lInteiro();
                if (idMaquina <= 0) {
                    System.err.println("O ID da máquina deve ser maior que zero!");
                    Ferramentas.Delay(1500);
                } else {
                    maquinaValida = true;
                }
            } catch (InputMismatchException e) {
                System.err.println("Valor inválido! Digite um número inteiro.");
                Ferramentas.Delay(1500);
            }
        } while (!maquinaValida);

        System.out.println("\nOrdem de Serviço criada com sucesso!");
        Ferramentas.Delay(1500);
    }
    }
