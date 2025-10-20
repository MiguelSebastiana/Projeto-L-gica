import java.util.InputMismatchException;


public class MenuLogin {


    public static void Menu(){


        Ferramentas.limpaTerminal();

        System.out.println("      =================");
        System.out.println("      ===   Login   ===");
        System.out.println("      =================");


        System.out.println("\n\n\n------------------");
        System.out.print("-Digite o seu cpf: ");
        String cpf = Ferramentas.lString();

        System.out.print("\n\n-Digite a sua senha: ");
        String senha = Ferramentas.lString();
        System.out.println("------------------");



    }


}
