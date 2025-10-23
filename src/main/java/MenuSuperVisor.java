import java.util.InputMismatchException;

public class MenuSuperVisor {

    public static void Menu(){

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
                Default.Default();
            }

            switch (escolha) {
                case 1: {

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
                    Default.Default();
                }
            }
        }while (continuar);
        MenuInicial.Menu();
    }
}
