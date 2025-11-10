package View;
import Model.*;
import Util.Ferramentas;
import Util.Validator_Usuario;

public class Menu_Login {

    static SERVICE_Usuario serviceUsuario;

    public static void Menu() {

        boolean continuar = true;
        String cpf = null;
        String senha = null;

        Ferramentas.limpaTerminal();

        System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                                   ███╗   ███╗███████╗███╗   ██╗ ██╗   ██╗   ██╗      ██████╗  ██████╗  ██╗ ███╗   ██╗                                 │");
        System.out.println("│                                   ████╗ ████║██╔════╝████╗  ██║ ██║   ██║   ██║     ██╔═══██╗██╔════╝  ██║ ████╗  ██║                                 │");
        System.out.println("│                                   ██╔████╔██║█████╗  ██╔██╗ ██║ ██║   ██║   ██║     ██║   ██║██║  ███╗ ██║ ██╔██╗ ██║                                 │");
        System.out.println("│                                   ██║╚██╔╝██║██╔══╝  ██║╚██╗██║ ██║   ██║   ██║     ██║   ██║██║   ██║ ██║ ██║╚██╗██║                                 │");
        System.out.println("│                                   ██║ ╚═╝ ██║███████╗██║ ╚████║ ╚██████╔╝   ███████╗╚██████╔╝╚██████╔╝ ██║ ██║ ╚████║                                 │");
        System.out.println("│                                   ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝  ╚═════╝    ╚══════╝ ╚═════╝  ╚═════╝  ╚═╝ ╚═╝  ╚═══╝                                 │");
        System.out.println("└───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
        Ferramentas.limpaTerminalOpcional(2);
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.print("│ ➤ Digite o seu cpf: ");

        do {
            try {
                cpf = Ferramentas.lString();
                Validator_Usuario.validarCpf(cpf);
                continuar = false;
            }catch (Exception e){
                Ferramentas.limpaTerminal();
                System.err.println(e.getMessage());
                Ferramentas.Delay(1500);
            }
        }while (continuar);
        System.out.println("------------------");

        Ferramentas.limpaTerminalOpcional(1);
        System.out.println("------------------");
        System.out.print("> Digite a sua senha: ");
        senha = Ferramentas.lString();
        System.out.println("------------------");

        Ferramentas.Delay(500);

        MODEL_Usuario usuario = serviceUsuario.Verificar_Login(cpf, senha);

        if (serviceUsuario.verificarIdFuncao(usuario) == 1) {
            Menu_Tecnico.Menu((MODEL_Tecnico) usuario);
        } else if (serviceUsuario.verificarIdFuncao(usuario) == 2) {
            Menu_SuperVisor.Menu((MODEL_Supervisor) usuario);
        } else if (serviceUsuario.verificarIdFuncao(usuario) == 3) {
            Menu_Gerente.Menu((MODEL_Gerente) usuario);
        }
    }
}
