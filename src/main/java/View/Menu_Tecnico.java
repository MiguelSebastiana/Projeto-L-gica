package View;
import Model.MODEL_Servico;
import Model.MODEL_Tecnico;
import Model.SERVICE_Servico;
import Model.SERVICE_Tecnico;
import Repository.DAO_Servico;
import Util.Ferramentas;

import java.util.ArrayList;
import java.util.InputMismatchException;
public class Menu_Tecnico {

    static DAO_Servico Dservicos = new DAO_Servico();

    public static void Menu(MODEL_Tecnico tecnico){

        boolean continuar = true;

        SERVICE_Servico serviceServico = new SERVICE_Servico();
        SERVICE_Tecnico serviceTecnico = new SERVICE_Tecnico();

        do{
            System.out.println("      ====================");
            System.out.println("      ==  Menu Técnico  ==");
            System.out.println("      ====================");

            System.out.println("1 - Ver as ordens atribuidas");
            System.out.println("2 - Alterar os Status das ordens");
            System.out.println("3 - Alterar Status de Disponibilidade: ");
            System.out.println("4 - Sair");

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
                    alterarStatusOrdem(serviceServico,tecnico);
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

        SERVICE_Servico servico = new SERVICE_Servico();
        ArrayList<MODEL_Servico> servicos = Dservicos.find_All_Ordens_Servico();
        boolean existe = false;

        System.out.println("----| Minhas Ordens De Serviço |----\n");

        for (MODEL_Servico s : servicos){
            if (s.getTecnico() == id_tecnico){
                existe = true;

                System.out.println("\n----------------------------------------");
                System.out.println("ID Ordem: "+s.getId_Ordem_servico());
                System.out.println("Técnico: "+s.getTecnico());
                System.out.println("Custo: "+s.getPreco());
                System.out.println("Máquina: "+s.getMaquina());
                System.out.println("Descrição: "+s.getDescricao_ordem_servico());
                System.out.println("Status: "+s.getStatus_aberto_ordem_servico());
            }
        }

        if (existe){
            System.err.println("ERRO - NENHUMA ORDEM DE SERVIÇO ATRELADA AO TÉCNICO!");
            return;
        }

        System.out.println("--------------------------------------");
        System.out.println("           Fim das Ordens.            ");
        System.out.println("--------------------------------------");
        Menu_Voltar.voltar();
        Ferramentas.Delay(1500);


    }

    public static void alterarStatusOrdem(SERVICE_Servico serviceServico , MODEL_Tecnico tecnico){

        Ferramentas.limpaTerminal();


    }

    public static void alterarStatusDisponibilidade(SERVICE_Tecnico serviceTecnico ,MODEL_Tecnico tecnico){

        Ferramentas.limpaTerminal();
    }
}
