package View;

import Model.MODEL_Administrador;
import Util.Ferramentas;

import static View.Menu_Administrador.gerente;

public class Menu_Atualizar {

    public static void AtualizarGerente(MODEL_Administrador adm){

        Ferramentas.limpaTerminal();
        int id = 0;

        System.out.println("     ---------------------");
        System.out.println("     - ATUALIZAR GERENTE -");
        System.out.println("     ---------------------");

        System.out.println("\n\n");

        System.out.print("Digite o ID do gerente que deseja atualizar: ");

        try {
            id = Ferramentas.lInteiro();
            gerente.Find_By_Id(id);
        }catch (Exception e){
            Ferramentas.limpaTerminal();
            System.err.println(e.getMessage());
            Ferramentas.Delay(1500);
        }



    }


}
