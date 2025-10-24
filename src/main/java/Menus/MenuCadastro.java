package Menus;
import Projeto_Base.*;
import java.util.InputMismatchException;

public class MenuCadastro {

    public static void Menu() {

        int escolha = 0;
        boolean continuar = true;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("      ==================");
            System.out.println("      ==   Cadastro   ==");
            System.out.println("      ==================");
            System.out.println("\n\n\n");
            System.out.println("--- Adicione um novo funcinario ---");
            System.out.println("\n\n");
            System.out.println("1 - Técnico");
            System.out.println("2 - Super Visor");
            System.out.println("3 - Sair");


            try {
                escolha = Ferramentas.lInteiro();
            } catch (InputMismatchException e) {
                Ferramentas.limpaTerminal();
                System.err.println("VALOR DIGITADO  INVALIDO!");
                Ferramentas.Delay(1500);
            }

            switch (escolha) {
                case 1: {
                    adicionarTecnico();
                    break;
                }
                case 2: {
                    adicionarSuperVisor();
                    break;
                }
                case 3: {
                    continuar = false;
                    break;
                }
            }
        } while (!continuar);
        return;
    }

    public static void adicionarSuperVisor() {

        Ferramentas.limpaTerminal();
        int anosExperiencia = 0;
        int cargaHoraria = 0;
        double salario = 0;
        int nivelAcesso = 0;
        int dia = 0;
        int mes = 0;
        int ano = 0;
        String nome = null;
        String senha = null;
        boolean verifica = false;
        boolean status = false;
        String email = null;
        String formacao;
        String setor;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("-Digite o cpf: ");
            try {

                String cpf = Ferramentas.lString();
                Validator_Usuario.validarCpf(cpf);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("-Digite a sua senha: ");
            try {

                senha = Ferramentas.lString();
                Validator_Geral.ValidarString(senha);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite o nome: ");
            try {

                nome = Ferramentas.lString();
                Validator_Geral.ValidarString(nome);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;


        nivelAcesso = 2;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite o telefone: ");
            try {

                String telefone = Ferramentas.lString();
                Validator_Geral.ValidarString(telefone);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite o salário: ");
            try {

                salario = Ferramentas.lDouble();
                Validator_Usuario.validarSalario(salario);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            do {
                System.out.println("-------------------------------------------");
                System.out.println("--- Data de nascimento ---");

                System.out.println("\n\n");
                System.out.print("Digite o ano: ");
                try {
                    ano = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e) {
                    Ferramentas.limpaTerminal();
                    System.err.println("ERRO - VALOR DIGITADO INCORRETO!");
                    Ferramentas.Delay(1500);
                }
            } while (verifica);
            System.out.println("-------------------------------------------");

            verifica = false;

            do {
                System.out.println("-------------------------------------------");
                System.out.print("Digite o mês: ");
                try {
                    mes = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e) {
                    Ferramentas.limpaTerminal();
                    System.err.println("ERRO - VALOR DIGITADO INCORRETO!");
                    Ferramentas.Delay(1500);
                }
            } while (verifica);
            System.out.println("-------------------------------------------");

            verifica = false;

            do {
                System.out.println("-------------------------------------------");
                System.out.print("Digite o dia: ");
                try {
                    dia = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e) {
                    Ferramentas.limpaTerminal();
                    System.err.println("ERRO - VALOR DIGITADO INCORRETO!");
                    Ferramentas.Delay(1500);
                }
            } while (verifica);
            try {
                Validator_Usuario.validarData(dia, mes, ano);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }

        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite o email: ");
            try {

                email = Ferramentas.lString();
                Validator_Geral.ValidarString(email);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite a carga horario(Em minutos): ");
            try {

                cargaHoraria = Ferramentas.lInteiro();
                Validator_Usuario.validarCargaHoraria(cargaHoraria);
                verifica = true;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        int op = 0;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite a formação: ");
            try {
                formacao = Ferramentas.lString();
                Validator_Geral.ValidarString(formacao);
                verifica = true;
            } catch (IllegalArgumentException e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.println("\n\n             SETOR  ");
            System.out.println("1- Manutenção  2-Produção   3-TI         4-Fundição");
            System.out.println("5-Usinagem     6-Bobinagem  7-Montagem   8-Controle de Qualidade");
            System.out.println("Digite o setor: ");
            try {
                op = Ferramentas.lInteiro();

                switch (op) {
                    case 1 -> setor = "Manutenção";
                    case 2 -> formacao = "Produção";
                    case 3 -> formacao = "TI";
                    case 4 -> formacao = "Fundição";
                    case 5 -> formacao = "Usinagem";
                    case 6 -> formacao = "Bobinagem";
                    case 7 -> formacao = "Montagem";
                    case 8 -> formacao = "Controle de Qualidade";
                    default -> Default.Default();
                }
                verifica = true;
            } catch (IllegalArgumentException e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        do {
            System.out.println("-------------------------------------------");
            System.out.println("Digite a quantidade de anos de experiencia: ");
            try {
                anosExperiencia = Ferramentas.lInteiro();
                Validator_Supervisor.validarAnosExperiencia(anosExperiencia);
                verifica = true;
            } catch (InputMismatchException e) {
                Ferramentas.limpaTerminal();
                System.err.println("ERRO - VALOR DIGITADO INCORRETO!");
                Ferramentas.Delay(1500);
            }
        }while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;


        //criar
    }

    public static void adicionarTecnico() {

        String especialidade = null;
        Ferramentas.limpaTerminal();
        int anosExperiencia = 0;
        int cargaHoraria = 0;
        double salario = 0;
        int nivelAcesso = 0;
        int dia = 0;
        int mes = 0;
        int ano = 0;
        String nome = null;
        String senha = null;
        boolean verifica = false;
        boolean status = false;
        String email = null;
        String formacao;
        String setor;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("-Digite o cpf: ");
            try {

                String cpf = Ferramentas.lString();
                Validator_Usuario.validarCpf(cpf);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("-Digite a sua senha: ");
            try {

                senha = Ferramentas.lString();
                Validator_Geral.ValidarString(senha);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite o nome: ");
            try {

                nome = Ferramentas.lString();
                Validator_Geral.ValidarString(nome);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;


        nivelAcesso = 2;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite o telefone: ");
            try {

                String telefone = Ferramentas.lString();
                Validator_Geral.ValidarString(telefone);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite o salário: ");
            try {

                salario = Ferramentas.lDouble();
                Validator_Usuario.validarSalario(salario);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            do {
                System.out.println("-------------------------------------------");
                System.out.println("--- Data de nascimento ---");

                System.out.println("\n\n");
                System.out.print("Digite o ano: ");
                try {
                    ano = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e) {
                    Ferramentas.limpaTerminal();
                    System.err.println("ERRO - VALOR DIGITADO INCORRETO!");
                    Ferramentas.Delay(1500);
                }
            } while (verifica);
            System.out.println("-------------------------------------------");

            verifica = false;

            do {
                System.out.println("-------------------------------------------");
                System.out.print("Digite o mês: ");
                try {
                    mes = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e) {
                    Ferramentas.limpaTerminal();
                    System.err.println("ERRO - VALOR DIGITADO INCORRETO!");
                    Ferramentas.Delay(1500);
                }
            } while (verifica);
            System.out.println("-------------------------------------------");

            verifica = false;

            do {
                System.out.println("-------------------------------------------");
                System.out.print("Digite o dia: ");
                try {
                    dia = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e) {
                    Ferramentas.limpaTerminal();
                    System.err.println("ERRO - VALOR DIGITADO INCORRETO!");
                    Ferramentas.Delay(1500);
                }
            } while (verifica);
            try {
                Validator_Usuario.validarData(dia, mes, ano);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }

        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite o email: ");
            try {

                email = Ferramentas.lString();
                Validator_Geral.ValidarString(email);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite a carga horario(Em minutos): ");
            try {

                cargaHoraria = Ferramentas.lInteiro();
                Validator_Usuario.validarCargaHoraria(cargaHoraria);
                verifica = true;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        int op = 0;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite a formação: ");
            try {
                formacao = Ferramentas.lString();
                Validator_Geral.ValidarString(formacao);
                verifica = true;
            } catch (IllegalArgumentException e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.println("\n\n             SETOR  ");
            System.out.println("1- Manutenção  2-Produção   3-TI         4-Fundição");
            System.out.println("5-Usinagem     6-Bobinagem  7-Montagem   8-Controle de Qualidade");
            System.out.println("Digite o setor: ");
            try {
                op = Ferramentas.lInteiro();

                switch (op) {
                    case 1 -> setor = "Manutenção";
                    case 2 -> formacao = "Produção";
                    case 3 -> formacao = "TI";
                    case 4 -> formacao = "Fundição";
                    case 5 -> formacao = "Usinagem";
                    case 6 -> formacao = "Bobinagem";
                    case 7 -> formacao = "Montagem";
                    case 8 -> formacao = "Controle de Qualidade";
                    default -> Default.Default();
                }
                verifica = true;
            } catch (IllegalArgumentException e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            System.out.println("-------------------------------------------");
            System.out.println("Digite a especialidade: ");
            try {
                especialidade = Ferramentas.lString();
                Validator_Tecnico.validarEspecialidade(especialidade);
                verifica = true;
            } catch (InputMismatchException e) {
                System.err.println("ERRO - VALOR DIGITADO INCORRETO!");
            }
        }while (verifica);
        System.out.println("\n");
        System.out.println("-------------------------------------------");


        //Criar

    }

    public static void adicionarGerente() {


        boolean verifica = true;
        int anosFuncao = 0;
        String especialidade = null;
        Ferramentas.limpaTerminal();
        int anosExperiencia = 0;
        int cargaHoraria = 0;
        double salario = 0;
        int nivelAcesso = 0;
        int dia = 0;
        int mes = 0;
        int ano = 0;
        String nome = null;
        String senha = null;
        boolean status = false;
        String email = null;
        String formacao;
        String setor;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("-Digite o cpf: ");
            try {

                String cpf = Ferramentas.lString();
                Validator_Usuario.validarCpf(cpf);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("-Digite a sua senha: ");
            try {

                senha = Ferramentas.lString();
                Validator_Geral.ValidarString(senha);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite o nome: ");
            try {

                nome = Ferramentas.lString();
                Validator_Geral.ValidarString(nome);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;


        nivelAcesso = 2;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite o telefone: ");
            try {

                String telefone = Ferramentas.lString();
                Validator_Geral.ValidarString(telefone);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite o salário: ");
            try {

                salario = Ferramentas.lDouble();
                Validator_Usuario.validarSalario(salario);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            do {
                System.out.println("-------------------------------------------");
                System.out.println("--- Data de nascimento ---");

                System.out.println("\n\n");
                System.out.print("Digite o ano: ");
                try {
                    ano = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e) {
                    Ferramentas.limpaTerminal();
                    System.err.println("ERRO - VALOR DIGITADO INCORRETO!");
                    Ferramentas.Delay(1500);
                }
            } while (verifica);
            System.out.println("-------------------------------------------");

            verifica = false;

            do {
                System.out.println("-------------------------------------------");
                System.out.print("Digite o mês: ");
                try {
                    mes = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e) {
                    Ferramentas.limpaTerminal();
                    System.err.println("ERRO - VALOR DIGITADO INCORRETO!");
                    Ferramentas.Delay(1500);
                }
            } while (verifica);
            System.out.println("-------------------------------------------");

            verifica = false;

            do {
                System.out.println("-------------------------------------------");
                System.out.print("Digite o dia: ");
                try {
                    dia = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e) {
                    Ferramentas.limpaTerminal();
                    System.err.println("ERRO - VALOR DIGITADO INCORRETO!");
                    Ferramentas.Delay(1500);
                }
            } while (verifica);
            try {
                Validator_Usuario.validarData(dia, mes, ano);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }

        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite o email: ");
            try {

                email = Ferramentas.lString();
                Validator_Geral.ValidarString(email);
                verifica = true;
            } catch (Exception e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite a carga horario(Em minutos): ");
            try {

                cargaHoraria = Ferramentas.lInteiro();
                Validator_Usuario.validarCargaHoraria(cargaHoraria);
                verifica = true;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        int op = 0;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("Digite a formação: ");
            try {
                formacao = Ferramentas.lString();
                Validator_Geral.ValidarString(formacao);
                verifica = true;
            } catch (IllegalArgumentException e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.println("\n\n             SETOR  ");
            System.out.println("1- Manutenção  2-Produção   3-TI         4-Fundição");
            System.out.println("5-Usinagem     6-Bobinagem  7-Montagem   8-Controle de Qualidade");
            System.out.println("Digite o setor: ");
            try {
                op = Ferramentas.lInteiro();

                switch (op) {
                    case 1 -> setor = "Manutenção";
                    case 2 -> formacao = "Produção";
                    case 3 -> formacao = "TI";
                    case 4 -> formacao = "Fundição";
                    case 5 -> formacao = "Usinagem";
                    case 6 -> formacao = "Bobinagem";
                    case 7 -> formacao = "Montagem";
                    case 8 -> formacao = "Controle de Qualidade";
                    default -> Default.Default();
                }
                verifica = true;
            } catch (IllegalArgumentException e) {
                Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            System.out.println("-------------------------------------------");
            System.out.println("Digite os anos na função: ");
            try {
                anosFuncao = Ferramentas.lInteiro();
                Validator_Gerente.validarTempoFuncao(anosFuncao);
                verifica = true;
            } catch (InputMismatchException e) {
                Ferramentas.limpaTerminal();
                System.err.println("ERRO - VALOR DIGITADO INCORRETO!");
                Ferramentas.Delay(1500);
            }
        }while (verifica);
        System.out.println("-------------------------------------------");


        //Criar
    }
}

