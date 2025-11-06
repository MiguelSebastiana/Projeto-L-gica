package View;
import Model.MODEL_Servico;
import Model.MODEL_Supervisor;
import Model.MODEL_Usuario;
import Model.SERVICE_Servico;
import Util.Ferramentas;
import Util.Validator_Geral;
import Util.Validator_Usuario;

import java.util.InputMismatchException;
public class Menu_Servicos {

    static SERVICE_Servico servico = new SERVICE_Servico();

    public static void Criar(MODEL_Supervisor supervisor) {

        boolean continuar = true;
        int escolha = 0;

        do {
            Ferramentas.limpaTerminal();

            System.out.println("      +----------------------+");
            System.out.println("      |       Máquinas       |");
            System.out.println("      +----------------------+");

            Ferramentas.limpaTerminalOpcional(2);

            System.out.println("--- Opções ---");

            System.out.println("\n");
            System.out.println("1 - Criar Ordem de serviço");
            System.out.println("2 - Sair");
            System.out.println("\n ----------------------------------");
            System.out.print("> Digite a opção desejada: ");

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

    public static void Adicionar(MODEL_Supervisor supervisor) {

        Ferramentas.limpaTerminalOpcional(5);
        int idTecnico = 0;
        String descricao = "";
        boolean feito = false;
        int idMaquina = 0;
        double preco = 0;
        String status = "Em andamento";

        System.out.println("      +----------------------------------+");
        System.out.println("      |       Criando novo serviço       |");
        System.out.println("      +----------------------------------+");


        do {
            System.out.print("> Digite a descrição da ordem de serviço: ");
            try {
                descricao = Ferramentas.lString();
                Validator_Geral.validarString(descricao);
                feito = true;
            } catch (RuntimeException e) {
                Ferramentas.limpaTerminal();
                System.err.println(e.getMessage());
                Ferramentas.Delay(1500);
            }
        }while (feito) ;

        feito = false;

        do {
            System.out.print("> Digite o valor da ordem de serviço: ");
            try {
                preco = Ferramentas.lDouble();
                Validator_Geral.ValidarNumeroNegativoDouble(preco);
                feito = true;
            } catch (RuntimeException e) {
                Ferramentas.limpaTerminal();
                System.err.println(e.getMessage());
                Ferramentas.Delay(1500);
            }
        }while (feito) ;

        feito = false;

        do{
            System.out.print("> Digite o ID do técnico responsável: ");
            try {
                idTecnico = Ferramentas.lInteiro();
                Validator_Usuario.verificarID(idTecnico);
                feito = true;
            } catch (InputMismatchException e) {
                Ferramentas.limpaTerminal();
                System.err.println(e.getMessage());
                Ferramentas.Delay(1500);
            }
        }while (feito);

        feito = false;

        do {
            System.out.print("> Digite o ID da máquina associada: ");
            try {
                idMaquina = Ferramentas.lInteiro();
                Validator_Usuario.verificarID(idMaquina);
                feito = true;
            } catch (InputMismatchException e) {
                Ferramentas.limpaTerminal();
                System.err.println(e.getMessage());
                Ferramentas.Delay(1500);
            }
        } while (feito);

        Ferramentas.limpaTerminalOpcional(3);
        System.out.println("Ordem de Serviço criada com sucesso!");
        Ferramentas.Delay(1500);

        MODEL_Servico servico1 = new MODEL_Servico(status,descricao,idTecnico,idMaquina,preco);

        servico.Insert_Servico(servico1);


    }
}
