package View;
import Model.MODEL_Supervisor;
import Model.MODEL_Tecnico;
import Model.SERVICE_Tecnico;
import Util.Ferramentas;
import Util.Validator_Geral;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Menu_SuperVisor {

    static SERVICE_Tecnico serviceTecnico = new SERVICE_Tecnico();

    public static void Menu(MODEL_Supervisor supervisor){

        boolean continuar = true;

        do{
            Ferramentas.limpaTerminal();
            System.out.println("      =====================");
            System.out.println("      == Menu SuperVisor ==");
            System.out.println("      =====================");

            System.out.println("1 - Ver todos os técnicos ");
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
                case 2:{
                    break;
                }
                case 3:{

                    break;
                }
                case 4:{

                    break;
                }
                case 5:{
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

    public static void verTecnicos(MODEL_Supervisor supervisor){

        ArrayList<MODEL_Tecnico> tecnicos = serviceTecnico.All_Tecnicos();

        Ferramentas.limpaTerminal();

        System.out.println("      ------------");
        System.out.println("      - Tecnicos -");
        System.out.println("      ------------");

        Ferramentas.Delay(1500);

        if (tecnicos == null || tecnicos.isEmpty()){
            System.err.println("Não há nenhum técnico para ser listado!");
        }else{
            System.out.println("--- Lista de técnicos ---");
            for(MODEL_Tecnico tecnico : tecnicos){
                System.out.println("");
                System.out.println("ID: " + tecnico.getId());
                System.out.println("Nome: " + tecnico.getNome());
                System.out.println("Especialidade: " + tecnico.getEspecialidade_tecnico());
                System.out.println("Status: " + (tecnico.isStatus_disponibilidade_tecnico() ? "Disponível" : "Em Atendimento"));
                System.out.println("-------------------------");
            }
        }
    }

}
