import java.util.InputMismatchException;

public class MenuGerente {

    public static void Menu(){

        boolean continuar = true;

        do{
            System.out.println("      ====================");
            System.out.println("      ==  Menu Gerente  ==");
            System.out.println("      ====================");

            System.out.println("1 - Cadastrar usuário");
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
                }

                case 4:{
                    MenuInicial.Menu();
                }
            }

        }while (!continuar);


    }




}
