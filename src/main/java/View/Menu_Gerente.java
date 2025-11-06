package View;
import Model.MODEL_Gerente;
import Model.MODEL_Servico;
import Model.MODEL_Supervisor;
import Model.SERVICE_Servico;
import Util.Ferramentas;

import java.util.InputMismatchException;
import java.util.List;

public class Menu_Gerente {

    public static void Menu(MODEL_Gerente gerente){

        boolean continuar = false;

        do{
            Ferramentas.limpaTerminal();

            System.out.println("      +--------------------------+");
            System.out.println("      |       Menu Gerente       |");
            System.out.println("      +--------------------------+");

            Ferramentas.limpaTerminalOpcional(2);

            System.out.println("--- Opções ---");
            System.out.println("\n1 - Cadastrar Funcionário");
            System.out.println("2 - Visualizar relatórios gerais");
            System.out.println("3 - Criar ordens de serviço");
            System.out.println("4 - Sair");
            System.out.println("\n ----------------------------------");
            System.out.print("> Digite a opção desejada: ");

            int escolha = 0;

            try {
                escolha = Ferramentas.lInteiro();
            } catch (InputMismatchException e) {
                System.err.println("VALOR DIGITADO  INVALIDO!");
            }

            switch (escolha) {
                case 1:{
                    Ferramentas.Delay(1500);
                    Menu_Cadastro.Menu();
                    break;
                }
                case 2:{
                    Relatorios();
                    break;
                }
                case 3:{
                    Ferramentas.Delay(1500);
                    Menu_Servicos.Criar(gerente);
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

        System.out.println("Voltando ao menu inicial...");
        Ferramentas.Delay(1500);
        Menu_Inicial.Menu();
    }

    public static void Relatorios(){
        SERVICE_Servico servico = new SERVICE_Servico();

        List<MODEL_Servico>ordensServico = servico.All_Servicos();

        System.out.println("      +--------------------------------+");
        System.out.println("      |       Relatório Serviços       |");
        System.out.println("      +--------------------------------+");
        Ferramentas.Delay(1500);

        if (ordensServico.isEmpty()) {
            System.out.println("Nenhuma Ordem de Serviço cadastrada.");
        }
        for (MODEL_Servico ordem : ordensServico) {
            System.out.println("\n-------------- Relatório --------------");
            System.out.println("| ID da Ordem: " + ordem.getId_Ordem_servico());
            System.out.println("| Técnico:     " + ordem.getTecnico());
            System.out.println("| Máquina:     " + ordem.getMaquina());
            System.out.println("| Descrição:   " + ordem.getDescricao_ordem_servico());
            System.out.println("| Status:      " + ordem.getStatus_aberto_ordem_servico());
            System.out.println("----------------------------------------");
            System.out.println("\n");
        }

        System.out.println("+--------------------------------------+");
        System.out.println("|           Fim do Relatório.          |");
        System.out.println("+--------------------------------------+");
        Ferramentas.Delay(1500);
        Menu_Cadastro.Menu();
    }
}
