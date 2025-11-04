package View;
import Model.MODEL_Servico;
import Model.MODEL_Tecnico;
import Model.SERVICE_Servico;
import Model.SERVICE_Tecnico;
import Util.Ferramentas;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class Menu_Tecnico {

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
                    verOrdensAtribuidas(serviceServico,tecnico.getId());
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

    public static void verOrdensAtribuidas(SERVICE_Servico servicoOrdem , int id_tecnico){

        Ferramentas.limpaTerminal();

        System.out.println("----| Minhas Ordens De Serviço |----\n");

        ArrayList<MODEL_Servico> minhasOrdens = servicoOrdem.All_Servicos();
    }

    public static void alterarStatusOrdem(SERVICE_Servico serviceServico , MODEL_Tecnico tecnico){

        Ferramentas.limpaTerminal();


    }

    public static void alterarStatusDisponibilidade(SERVICE_Tecnico serviceTecnico ,MODEL_Tecnico tecnico){

        Ferramentas.limpaTerminal();
    }
}
