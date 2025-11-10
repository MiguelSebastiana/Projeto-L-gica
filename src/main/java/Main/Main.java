package Main;

import Model.MODEL_Administrador;
import View.Menu_Administrador;
import View.Menu_Inicial;

public class Main {
    public static void main(String[] args) {

        MODEL_Administrador adm = new MODEL_Administrador("2","2");

        Menu_Administrador.Menu(adm);

        Menu_Inicial.Menu();

    }
}