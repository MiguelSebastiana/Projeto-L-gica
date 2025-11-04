package View;
import Model.MODEL_Servico;
import Model.SERVICE_Servico;
import Util.Ferramentas;

import java.util.InputMismatchException;
import java.util.List;

public class Menu_Gerente {

    public static void Menu(){

        boolean continuar = false;

        do{
            Ferramentas.limpaTerminal();

            System.out.println("      ====================");
            System.out.println("      ==  Menu Gerente  ==");
            System.out.println("      ====================");

            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Visualizar relatórios gerais");
            System.out.println("3 - Criar ordens de serviço");
            System.out.println("4 - Sair");

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
                    Menu_Servicos.Criar();
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

        Menu_Inicial.Menu();
    }

    public static void Relatorios(){
        SERVICE_Servico servico = new SERVICE_Servico();

        List<MODEL_Servico>ordensServico = servico.All_Servicos();

        System.out.println("Relatório de ordens de serviço");
        Ferramentas.Delay(1500);

        if (ordensServico.isEmpty()) {
            System.out.println("Nenhuma Ordem de Serviço cadastrada.");
        }
        for (MODEL_Servico) {


    }
}
