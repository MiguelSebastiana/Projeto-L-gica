package View;
import Model.MODEL_Usuario;
import Util.Ferramentas;
import Util.Validator_Usuario;
import Model.SERVICE_Usuario;

public class Menu_Login {

    static SERVICE_Usuario serviceUsuario;

    public MODEL_Usuario Menu() {

        boolean continuar = true;
        String cpf = null;
        String senha = null;

        Ferramentas.limpaTerminal();

        System.out.println("      =================");
        System.out.println("      ===   Login   ===");
        System.out.println("      =================");


        System.out.println("\n\n\n------------------");
        System.out.print("-Digite o seu cpf: ");

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

        System.out.println("\n\n");
        System.out.println("------------------");
        System.out.print("-Digite a sua senha: ");
        senha = Ferramentas.lString();
        System.out.println("------------------");

        Ferramentas.Delay(500);

        return serviceUsuario.Verificar_Login(cpf,senha);


    }
}
