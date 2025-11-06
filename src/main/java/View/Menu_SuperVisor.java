package View;
import Model.*;
import Util.Ferramentas;
import Util.Validator_Geral;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Menu_SuperVisor {

    static SERVICE_Tecnico serviceTecnico = new SERVICE_Tecnico();

    static SERVICE_Servico serviceServico = new SERVICE_Servico();

    static SERVICE_Maquina serviceMaquina = new SERVICE_Maquina();

    public static void Menu(MODEL_Supervisor supervisor) {

        boolean continuar = true;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("      =====================");
            System.out.println("      == Menu SuperVisor ==");
            System.out.println("      =====================");

            Ferramentas.limpaTerminalOpcional(3);

            System.out.println("1 - Ver todos os técnicos");
            System.out.println("2 - Criar ordens de serviço");
            System.out.println("3 - Visualizar todas as ordens de serviço");
            System.out.println("4 - Visualizar todas as maquínas");
            System.out.println("5 - Sair");

            int escolha = 0;

            try {
                escolha = Ferramentas.lInteiro();
            } catch (InputMismatchException e) {
                Menu_Default.Default();
            }

            switch (escolha) {
                case 1: {
                    verTecnicos(supervisor);
                    break;
                }
                case 2: {
                    criarOrdens(supervisor);
                    break;
                }
                case 3: {
                    visualizarOrdens(supervisor);
                    break;
                }
                case 4: {
                    verMaquinas(supervisor);
                    break;
                }
                case 5: {
                    continuar = false;
                    break;
                }
                default: {
                    Menu_Default.Default();
                }
            }
        } while (continuar);
        Menu_Inicial.Menu();
    }

    public static void verTecnicos(MODEL_Supervisor supervisor) {

        ArrayList<MODEL_Tecnico> tecnicos = serviceTecnico.All_Tecnicos();

        try {

            Ferramentas.limpaTerminal();

            System.out.println("      ------------");
            System.out.println("      - Tecnicos -");
            System.out.println("      ------------");

            Ferramentas.Delay(1500);

            if (tecnicos == null || tecnicos.isEmpty()) {
                System.err.println("Não há nenhum técnico para ser listado!");
            } else {
                System.out.println("--- Lista de técnicos ---");

                for (MODEL_Tecnico tecnico : tecnicos) {
                    System.out.println("");
                    System.out.println("ID: " + tecnico.getId());
                    System.out.println("Nome: " + tecnico.getNome());
                    System.out.println("Especialidade: " + tecnico.getEspecialidade_tecnico());
                    System.out.println("Status: " + (tecnico.isStatus_disponibilidade_tecnico() ? "Disponível" : "Em Atendimento"));
                    System.out.println("-------------------------");
                    }
                }
        }catch (RuntimeException e) {
        System.err.println("ERRO - FALHA AO MOSTRAR TODOS OS TECNICOS");
        }
    }

    public static void criarOrdens(MODEL_Supervisor supervisor) {

        Ferramentas.limpaTerminal();

        System.out.println("      ---------------------------");
        System.out.println("      - Criar Ordens de Serviço -");
        System.out.println("      ---------------------------");

        Menu_Servicos.Criar(supervisor);

    }

    public static void visualizarOrdens(MODEL_Supervisor supervisor) {

        ArrayList<MODEL_Servico> servicos = serviceServico.All_Servicos();

        try {

        Ferramentas.limpaTerminal();

        System.out.println("      ------------");
        System.out.println("      - Serviços -");
        System.out.println("      ------------");

        Ferramentas.Delay(1500);

        if (servicos == null || servicos.isEmpty()) {
            System.err.println("Não há nenhum serviço para ser listado!");
        } else {
            System.out.println("--- Lista de serviços ---");

            for (MODEL_Servico servico : servicos) {

                System.out.println("");
                System.out.println("ID: " + servico.getId_Ordem_servico());
                System.out.println("Status: " + servico.getStatus_aberto_ordem_servico());
                System.out.println("Descrição: " + servico.getDescricao_ordem_servico());
                System.out.println("Id do técnico: " + servico.getTecnico());
                System.out.println("Id da máquina: " + servico.getMaquina());
                System.out.println("-------------------------");

                }

            }
        }catch (RuntimeException e) {
            System.err.println("ERRO - FALHA AO MOSTRAR TODOS OS SERVIÇOS");
        }
    }

    public static void verMaquinas(MODEL_Supervisor supervisor) {

        ArrayList<MODEL_Maquina> modelMaquinas = serviceMaquina.All_Maquinas();

        try {

            Ferramentas.limpaTerminal();

            System.out.println("      ------------");
            System.out.println("      - Máquinas -");
            System.out.println("      ------------");

            Ferramentas.Delay(1500);

            if (modelMaquinas == null || modelMaquinas.isEmpty()) {
                System.err.println("Não há nenhuma máquina para ser listado");
            } else {
                System.out.println("--- Lista de Máquinas ---");
                for (MODEL_Maquina maquina : modelMaquinas) {

                    System.out.println("");
                    System.out.println("ID: " + maquina.getId_maquina());
                    System.out.println("Modelo: " + maquina.getModeloMaquina());
                    System.out.println("Status: " + maquina.getStatusFuncionamentoMaquina());
                    System.out.println("Descrição: " + maquina.getDescricaoMaquina());
                    System.out.println("-------------------------");

                }
            }
        }catch (RuntimeException e) {
        System.err.println("ERRO - FALHA AO MOSTRAR TODAS AS MAQUINAS");
    }

    }
}
