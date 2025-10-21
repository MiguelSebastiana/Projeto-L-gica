public class MenuCadastro
{
    public static void Menu(){

        Ferramentas.limpaTerminal();

        System.out.println("      ==================");
        System.out.println("      ==   Cadastro   ==");
        System.out.println("      ==================");

        System.out.println("\n\n\n\n------------------");
        System.out.print("-Digite o seu cpf: ");
        String cpf = Ferramentas.lString();
        System.out.println("------------------");

        System.out.println("\n\n------------------");
        System.out.print("-Digite a sua senha: ");
        String senha = Ferramentas.lString();
        System.out.println("------------------");

    }

}

