package View;

import Model.MODEL_Administrador;
import Model.MODEL_Gerente;
import Model.MODEL_Usuario;
import Model.SERVICE_Gerente;
import Repository.DAO_Gerente;
import Repository.DAO_Usuario;
import Util.Ferramentas;
import Util.Validator_Geral;
import Util.Validator_Gerente;
import java.util.InputMismatchException;

public class Menu_Atualizar {

    static SERVICE_Gerente serviceGerente = new SERVICE_Gerente();
    static DAO_Gerente daoGerente = new DAO_Gerente();
    static DAO_Usuario daoUsuario = new DAO_Usuario();

    public static void AtualizarGerente(MODEL_Administrador adm,int id){

        do {

            int escolha = 0;

            MODEL_Gerente gerente = serviceGerente.Find_By_Id(id);

            System.out.println("       +---------------+             ------------------------");
            System.out.println("       |    GERENTE    |             |Nome: " + gerente.getNome());
            System.out.println("       +---------------+             |CPF: " + gerente.getCpf());
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
                    System.out.println("Digite seu novo Email: ");

                    try {
                        String email = Ferramentas.lString();
                        Validator_Geral.ValidarEmail(email);
                        gerente.setEmail(email);
                        daoUsuario.update_Email(gerente,email);

                    }catch (IllegalArgumentException e)
                    {
                        Ferramentas.limpaTerminal();
                        System.err.print(e.getMessage());
                        Ferramentas.Delay(1500);
                    }
                    break;
                }
                case 2:{
                    System.out.println("Digite seu novo telefone: ");

                    try {
                        String telefone = Ferramentas.lString();
                        Validator_Geral.ValidarTelefone(telefone);
                        gerente.setTelefone(telefone);
                        daoUsuario.update_Telefone(gerente,telefone);

                    }catch (IllegalArgumentException e)
                    {
                        Ferramentas.limpaTerminal();
                        System.err.print(e.getMessage());
                        Ferramentas.Delay(1500);
                    }
                    break;
                }
                case 3:{
                    System.out.println("Digite sua nova senha: ");

                    try {
                        String senha = Ferramentas.lString();
                        Validator_Geral.validarString(senha);
                        gerente.setSenha(senha);
                        daoUsuario.update_Senha(gerente,senha);

                    }catch (IllegalArgumentException e)
                    {
                        Ferramentas.limpaTerminal();
                        System.err.print(e.getMessage());
                        Ferramentas.Delay(1500);
                    }
                    break;
                }
                case 4:{
                    System.out.println("Digite seu novo Anos de servico: ");

                    try {
                        int anos = Ferramentas.lInteiro();
                        Validator_Gerente.validarTempoFuncao(anos);
                        gerente.setTempo_na_funcao_anos_gerente(anos);
                        daoGerente.update_Tempo_Funcao(gerente,anos);

                    }catch (IllegalArgumentException e)
                    {
                        Ferramentas.limpaTerminal();
                        System.err.print(e.getMessage());
                        Ferramentas.Delay(1500);
                    }
                    break;
                }
                case 5:{
                    System.out.println("Digite sua nova formação: ");

                    try {
                        String formacao = Ferramentas.lString();
                        Validator_Geral.validarString(formacao);
                        gerente.setFormacao(formacao);
                        daoUsuario.update_Formacao(gerente,formacao);

                    }catch (IllegalArgumentException e)
                    {
                        Ferramentas.limpaTerminal();
                        System.err.print(e.getMessage());
                        Ferramentas.Delay(1500);
                    }
                    break;
                }
                case 6:{

                    return;
                }
                default:{

                    Menu_Default.Default();
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
