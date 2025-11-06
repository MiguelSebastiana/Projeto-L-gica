package View;
import Model.MODEL_Servico;
import Model.MODEL_Supervisor;
import Model.MODEL_Usuario;
import Model.SERVICE_Servico;
import Util.Ferramentas;
import Util.Validator_Geral;

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
                Menu_Default.Default();
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
        int idTecnico = 0;
        String descricao = null;
        boolean feito = false;

        System.out.println("=== Criar Novo Serviço ===");



        do{
            System.out.print("Digite a descrição da ordem de serviço: ");
            try {
                descricao = Ferramentas.lString();
                Validator_Geral.validarString(descricao);
                feito = true;
            }catch (RuntimeException e){
                Menu_Default.Default();
            }
        while (feito);

        feito = false;


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

        double preco = 0;
        boolean precoValdio = false;

        do {
            System.out.print("Digite o ID da máquina associada: ");
            try {
                preco = Ferramentas.lDouble();
                if (preco <= 0) {
                    System.err.println("O preço do serviço deve ser maior que zero!");
                    Ferramentas.Delay(1500);
                } else {
                    precoValdio = true;
                }
            } catch (InputMismatchException e) {
                System.err.println("Valor inválido! Digite um número inteiro.");
                Ferramentas.Delay(1500);
            }
        } while (!maquinaValida);

        System.out.println("\nOrdem de Serviço criada com sucesso!");
        Ferramentas.Delay(1500);

<<<<<<< Updated upstream
        MODEL_Servico servico1 = new MODEL_Servico(status, descricao, idTecnico, idMaquina, preco);

        servico.Insert_Servico(servico1);
        }
=======
>>>>>>> Stashed changes
    }
