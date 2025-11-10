package View;
import Model.*;
import Util.Ferramentas;
import Util.Validator_Usuario;

import java.util.InputMismatchException;

public class Menu_Administrador {


    static SERVICE_Gerente gerente = new SERVICE_Gerente();


    public static void Menu(MODEL_Administrador adm) {


        while (true){

            Ferramentas.limpaTerminal();

            System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│                                  ███╗   ███╗███████╗███╗   ██╗ ██╗   ██╗    █████╗ ██████╗  ███╗ ███╗ ██╗███╗   ██╗                                  │");
            System.out.println("│                                  ████╗ ████║██╔════╝████╗  ██║ ██║   ██║   ██╔══██╗██╔══██╗████╗ ████║██║████╗  ██║                                  │");
            System.out.println("│                                  ██╔████╔██║█████╗  ██╔██╗ ██║ ██║   ██║   ███████║██║  ██║██╔████╔██║██║██╔██╗ ██║                                  │");
            System.out.println("│                                  ██║╚██╔╝██║██╔══╝  ██║╚██╗██║ ██║   ██║   ██╔══██║██║  ██║██║╚██╔╝██║██║██║╚██╗██║                                  │");
            System.out.println("│                                  ██║ ╚═╝ ██║███████╗██║ ╚████║ ╚██████╔╝   ██║  ██║██████╔╝██║ ╚═╝ ██║██║██║ ╚████║                                  │");
            System.out.println("│                                  ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝  ╚═════╝    ╚═╝  ╚═╝╚═════╝ ╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝                                  │");
            System.out.println("└──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
            Ferramentas.Delay(1500);

            Ferramentas.limpaTerminalOpcional(2);

            System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│ OPÇÕES                                                                                                                                              │");
            System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤");
            System.out.println("│ (1) ➔ Cadastrar Gerente                                                                                                                             │");
            System.out.println("│ (2) ➔ Atualizar Gerente                                                                                                                             │");
            System.out.println("│ (3) ➔ Excluir Gerente                                                                                                                               │");
            System.out.println("│ (4) ➔ Sair                                                                                                                                          │");
            System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
            System.out.print("│ ➤ Digite a opção desejada: ");

            int escolha = 0;

            try {
                escolha = Ferramentas.lInteiro();
                System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");

            } catch (InputMismatchException e) {
                System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
                System.err.println("VALOR DIGITADO  INVALIDO!");
            }


            switch (escolha) {

                case 1: {
                    CadastrarGerente(adm);
                    break;
                }

                case 2: {
                    AtualizarGerente(adm);
                    break;
                }
                case 3: {
                    ExcluirGerente(adm);
                    break;
                }
                case 4: {
                    return;
                }
                default: {
                    Menu_Default.Default();
                    break;
                }
            }

        }

    }

    public static void CadastrarGerente(MODEL_Administrador adm){

        Ferramentas.limpaTerminal();

        System.out.println("      +-------------------------------+");
        System.out.println("      |       Cadastrar Gerente       |");
        System.out.println("      +-------------------------------+");

        Ferramentas.Delay(1500);

        Menu_Cadastro.adicionarGerente();

    }

    public static void AtualizarGerente(MODEL_Administrador adm){

        Ferramentas.limpaTerminal();
        int id = 0;

        System.out.println("      +-------------------------------+");
        System.out.println("      |       Atualizar Gerente       |");
        System.out.println("      +-------------------------------+");

        Ferramentas.limpaTerminalOpcional(2);

        System.out.print("> Digite o ID do gerente que deseja atualizar: ");

        try {
            id = Ferramentas.lInteiro();
            Validator_Usuario.verificarID(id);
            gerente.Find_By_Id(id);
            Menu_Atualizar.AtualizarGerente(adm, id);
        }catch (Exception e){
            Ferramentas.limpaTerminal();
            System.err.println(e.getMessage());
            Ferramentas.Delay(1500);
        }
    }

    public static void ExcluirGerente(MODEL_Administrador adm){

        Ferramentas.limpaTerminal();
        int id = 0;

        System.out.println("      +---------------------------+");
        System.out.println("      |       Excluir gerente       |");
        System.out.println("      +---------------------------+");

        Ferramentas.limpaTerminalOpcional(2);

        System.out.print("> Digite o ID do gerente que deseja excluir: ");

        try {
            id = Ferramentas.lInteiro();
            gerente.Find_By_Id(id);
        }catch (Exception e){
            Ferramentas.limpaTerminal();
            System.err.println(e.getMessage());
            Ferramentas.Delay(1500);
        }

        MODEL_Gerente gerente1 = gerente.Find_By_Id(id);

        try {
            gerente.Delete_Gerente(gerente1);
        }catch (Exception e){
            Ferramentas.limpaTerminal();
            System.err.println(e.getMessage());
            Ferramentas.Delay(1500);
        }
    }
}
