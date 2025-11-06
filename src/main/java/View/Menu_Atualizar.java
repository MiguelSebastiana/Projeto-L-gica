package View;

import Model.MODEL_Administrador;
import Model.MODEL_Gerente;
import Model.MODEL_Usuario;
import Model.SERVICE_Gerente;
import Repository.DAO_Usuario;
import Util.Ferramentas;
import Util.Validator_Usuario;

import java.util.ArrayList;
import java.util.InputMismatchException;

import static View.Menu_Administrador.gerente;

public class Menu_Atualizar {

    static SERVICE_Gerente serviceGerente = new SERVICE_Gerente();

    public static void AtualizarGerente(MODEL_Administrador adm,int id){

        do {

            int escolha = 0;

            MODEL_Gerente gerente = serviceGerente.Find_By_Id(id);

            System.out.println("       -----------------             ------------------------");
            System.out.println("       |    GERENTE    |             |Nome: " + gerente.getNome());
            System.out.println("       -----------------             |CPF: " + gerente.getCpf());
            System.out.println("                                     |EMAIL: " + gerente.getEmail());
            System.out.println("Digite para alterar:                 |Telefone: " + gerente.getTelefone());
            System.out.println("1-Email                              |Anos de servico: " + gerente.getTempo_na_funcao_anos_gerente());
            System.out.println("2-Telefone                           |Senha: " + gerente.getSenha());
            System.out.println("3-Senha                              |Formação: " + gerente.getFormacao());
            System.out.println("4-Anos de serviço                    ------------------------");
            System.out.println("5-Formação                  ");
            System.out.println("6-Sair                               ");

            try {
                escolha = Ferramentas.lInteiro();
            }catch (InputMismatchException e){
                Menu_Default.Default();
            }

            switch (escolha){

                case 1:{

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

                    break;
                }
                case 6:{

                    break;
                }
                default:{

                    break;
                }

            }

        }while (true);
    }

    public static void AtualizarTecnico(){

    }

    public static void AtulizarTecnico(){

    }

}
