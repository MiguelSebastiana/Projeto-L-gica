package View;

import Model.MODEL_Servico;
import Model.MODEL_Tecnico;
import Model.SERVICE_Servico;
import Model.SERVICE_Tecnico;
import Repository.DAO_Servico;
import Repository.DAO_Tecnico;
import Util.Ferramentas;
import Util.Validator_Usuario;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Menu_Tecnico {
    static DAO_Servico Dservicos = new DAO_Servico();
    static DAO_Tecnico Dtecnicos = new DAO_Tecnico();

    public static void Menu(MODEL_Tecnico tecnico){
        boolean continuar = true;
        SERVICE_Servico serviceServico = new SERVICE_Servico();
        SERVICE_Tecnico serviceTecnico = new SERVICE_Tecnico();

        do{
            System.out.println("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│        ███╗   ███╗███████╗███╗   ██╗██╗   ██╗    ████████╗███████╗ ██████╗███╗   ██╗██╗ ██████╗ ██████╗        │");
            System.out.println("│        ████╗ ████║██╔════╝████╗  ██║██║   ██║    ╚══██╔══╝██╔════╝██╔════╝████╗  ██║██║██╔════╝██╔═══██╗       │");
            System.out.println("│        ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║       ██║   █████╗  ██║     ██╔██╗ ██║██║██║     ██║   ██║       │");
            System.out.println("│        ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║       ██║   ██╔══╝  ██║     ██║╚██╗██║██║██║     ██║   ██║       │");
            System.out.println("│        ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝       ██║   ███████╗╚██████╗██║ ╚████║██║╚██████╗╚██████╔╝       │");
            System.out.println("│        ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝        ╚═╝   ╚══════╝ ╚═════╝╚═╝  ╚═══╝╚═╝ ╚═════╝ ╚═════╝        │");
            System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
            Ferramentas.limpaTerminalOpcional(2);

            System.out.println("┌──────────────────────────────────────────┐");
            System.out.println("│                  \uD835\uDCDE\uD835\uDCDF\uD835\uDCD2\uD835\uDCDE\uD835\uDCD4\uD835\uDCE2:                 │");
            System.out.println("│       1 ➔ Ver as ordens atribuidas       │");
            System.out.println("│     2 ➔ Alterar os Status das ordens     │");
            System.out.println("│  3 ➔ Alterar Status de Disponibilidade:  │");
            System.out.println("│                 4 ➔ Sair                 │");
            System.out.println("└──────────────────────────────────────────┘");
            System.out.print("➤ Digite a opção desejada: ");

            int escolha = 0;
            try {
                escolha = Ferramentas.lInteiro();
            } catch (InputMismatchException e) {
                System.err.println("VALOR DIGITADO  INVALIDO!");
            }

            switch (escolha) {
                case 1:{
                    verOrdensAtribuidas(tecnico.getId());
                    break;
                }
                case 2:{
                    alterarStatusOrdem(serviceServico,tecnico.getId());
                    break;
                }
                case 3:{
                    alterarStatusDisponibilidade(serviceTecnico,tecnico);
                    break;
                }
                case 4:{
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

    public static void verOrdensAtribuidas(int id_tecnico){

        Ferramentas.limpaTerminal();
        ArrayList<MODEL_Servico> servicos = Dservicos.find_All_Ordens_Servico();
        boolean existe = false;

        System.out.println("      +---------------------------+");
        System.out.println("      |       Minhas Ordens       |");
        System.out.println("      +---------------------------+");

        for (MODEL_Servico s : servicos){
            if (s.getTecnico() == id_tecnico){
                existe = true;
                System.out.println("----| Ordem De Serviço |----\n");
                System.out.println("| ID Ordem:  "+s.getId_Ordem_servico());
                System.out.println("| Técnico:   "+s.getTecnico());
                System.out.println("| Custo:     "+s.getPreco());
                System.out.println("| Máquina:   "+s.getMaquina());
                System.out.println("| Descrição: "+s.getDescricao_ordem_servico());
                System.out.println("| Status:    "+s.getStatus_aberto_ordem_servico());
                System.out.println("----------------------------------------");
                System.out.println("");
            }
        }

        if (!existe){
            System.err.println("ERRO - NENHUMA ORDEM DE SERVIÇO ATRELADA AO TÉCNICO!");
            Menu_Voltar.voltar();
            Ferramentas.Delay(1500);
            return;
        }

        System.out.println("+------------------------------------+");
        System.out.println("|           Fim das Ordens.          |");
        System.out.println("+------------------------------------+");

        Menu_Voltar.voltar();
        Ferramentas.Delay(1500);
    }

    public static void alterarStatusOrdem(SERVICE_Servico serviceServico , int id_tecnico){

        Ferramentas.limpaTerminal();

        ArrayList<MODEL_Servico> servicos = Dservicos.find_All_Ordens_Servico();
        boolean existe = false;

        System.out.println("      +---------------------------+");
        System.out.println("      |       Minhas Ordens       |");
        System.out.println("      +---------------------------+");

        for (MODEL_Servico s : servicos){
            if (s.getTecnico() == id_tecnico){
                existe = true;
                System.out.println("----| Ordem De Serviço |----\n");
                System.out.println("| ID Ordem:  "+s.getId_Ordem_servico());
                System.out.println("| Técnico:   "+s.getTecnico());
                System.out.println("| Custo:     "+s.getPreco());
                System.out.println("| Máquina:   "+s.getMaquina());
                System.out.println("| Descrição: "+s.getDescricao_ordem_servico());
                System.out.println("| Status:    "+s.getStatus_aberto_ordem_servico());
                System.out.println("----------------------------------------");
                System.out.println("");
            }
        }

        if (!existe){
            System.err.println("ERRO - NENHUMA ORDEM DE SERVIÇO ATRELADA AO TÉCNICO!");
            Menu_Voltar.voltar();
            Ferramentas.Delay(1500);
            return;
        }

        System.out.println("+------------------------------------+");
        System.out.println("|           Fim das Ordens.          |");
        System.out.println("+------------------------------------+");

        boolean continuar = false;
        int id_ordem = 0;
        do {
            System.out.print("> Digite o Id da Ordem que deseja alterar status: ");
            try {
                id_ordem = Ferramentas.lInteiro();
                continuar = true;
            } catch (InputMismatchException erro) {
                System.err.println("ERRO - DIGITE UM NÚMERO!");
            }
        }while(continuar);

        for (MODEL_Servico s : servicos){
            if (s.getTecnico() == id_tecnico){
                String status = s.getStatus_aberto_ordem_servico();
                if (status.equals("Em Andamento")){
                    s.setStatus_aberto_ordem_servico("Concluido");
                }else if(status.equals("Concluido")){
                    s.setStatus_aberto_ordem_servico("Em Andamento");
                }
            }
        }
    }

    public static void alterarStatusDisponibilidade(SERVICE_Tecnico serviceTecnico, MODEL_Tecnico tecnico){
        Ferramentas.limpaTerminal();
        System.out.println("+---------------------------------------------+");
        System.out.println("|           Alterar Disponibilidade.          |");
        System.out.println("+---------------------------------------------+");

        boolean statusAtual = tecnico.isStatus_disponibilidade_tecnico();
        System.out.println("Status Atual :"+(statusAtual ? "Disponivel ":"Indisponivel"));
        boolean statusNovo = !statusAtual;
        tecnico.setStatus_disponibilidade_tecnico(statusNovo);

        try{
            serviceTecnico.Update_Disponibilidade(tecnico.getId(),statusNovo);
            System.out.println("Seu status foi alterado com sucesso!");
        }catch (Exception e){
            System.err.println("ERRO - NÃO FOI POSSIVEL SALVAR NO BANCO DE DADOS!");
            System.out.println(e.getMessage());
            tecnico.setStatus_disponibilidade_tecnico(statusAtual);
        }

        System.out.println("-------------------------------------------------------------------");
        Menu_Voltar.voltar();
        Ferramentas.Delay(1500);
    }
}
