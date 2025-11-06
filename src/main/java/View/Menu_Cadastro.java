package View;
import Model.*;
import Util.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Locale;

public class Menu_Cadastro {

    static SERVICE_Gerente serviceGerente;
    static SERVICE_Tecnico serviceTecnico;
    static SERVICE_Supervisor serviceSupervisor;

    public static void Menu() {

        int escolha = 0;
        boolean continuar = true;

        do {
            Ferramentas.limpaTerminal();

            System.out.println("      +---------------------------+");
            System.out.println("      |       Menu Cadastro       |");
            System.out.println("      +---------------------------+");

            Ferramentas.limpaTerminalOpcional(3);

            System.out.println("--- Opções ---");
            System.out.println("1 - Técnico");
            System.out.println("2 - Super Visor");
            System.out.println("3 - Sair");
            System.out.println("\n ----------------------------------");
            System.out.print("> Digite a opção desejada: ");


            try
            {
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
    }

    public static void adicionarSuperVisor() {

        String nome;

        MODEL_Supervisor supervisor = (MODEL_Supervisor) coletarInformacoes(1);

        int experiencia = 0;
        boolean verifica = false;

        do {
            System.out.println("-------------------------------------------");
            System.out.print("> Digite os anos de experiência do supervisor: ");
            try {
                experiencia = Ferramentas.lInteiro();
                Validator_Supervisor.validarAnosExperiencia(experiencia);
                supervisor.setExperiencia_anos_supervisor(experiencia);
                verifica = true;

            } catch (IllegalArgumentException iae) {
                Ferramentas.limpaTerminal();
                System.err.println(iae.getMessage());
                Ferramentas.Delay(1500);
            }

        }while (verifica);
        System.out.println("-------------------------------------------");

        serviceSupervisor.Insert_Supervisor(supervisor);
        //criar
    }

    public static void adicionarTecnico() {

        String nome;

        MODEL_Tecnico tecnico = (MODEL_Tecnico) coletarInformacoes(2);

        String especialidade = null;
        boolean verifica = false;

        do {
            System.out.println("-------------------------------------------");
            System.out.print("> Digite a especialidade do técnico: ");
            try {
                especialidade = Ferramentas.lString();
                Validator_Tecnico.validarEspecialidade(especialidade);
                tecnico.setEspecialidade_tecnico(especialidade);
                verifica = true;

            } catch (IllegalArgumentException iae) {
                Ferramentas.limpaTerminal();
                System.err.println(iae.getMessage());
                Ferramentas.Delay(1500);
            }

        }while (verifica);
        System.out.println("-------------------------------------------");


        serviceTecnico.Inserir_Tecnico(tecnico);
        //Criar

    }

    public static void adicionarGerente()
    {

        String nome;

        MODEL_Gerente gerente = (MODEL_Gerente) coletarInformacoes(3);

        int anosFuncao = 0;
        boolean verifica = false;

        do {
            System.out.println("-------------------------------------------");
            System.out.print("> Digite os anos na função: ");
            try {
                anosFuncao = Ferramentas.lInteiro();
                Validator_Gerente.validarTempoFuncao(anosFuncao);
                gerente.setTempo_na_funcao_anos_gerente(anosFuncao);
                verifica = true;

            } catch (InputMismatchException e) {
                Ferramentas.limpaTerminal();
                System.err.println("ERRO - VALOR DIGITADO INCORRETO!");
                Ferramentas.Delay(1500);
            }

        }while (verifica);
        System.out.println("-------------------------------------------");

        serviceGerente.Inserir_Gerente(gerente);
    }


    public static MODEL_Usuario coletarInformacoes(int nivelAcesso) {
        Ferramentas.limpaTerminal();


        String nome = null;
        String cpf = null;
        String telefone = null;
        double salario = 0;
        int dia = 0;
        int mes = 0;
        int ano = 0;
        String email = null;
        int cargaHoraria = 0;
        String formacao = null;
        int setor = 0;
        String senha = null;
        LocalDate dataNascimento = null;
        boolean verifica = false;



        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("> Digite o cpf: ");
            try {

                cpf = Ferramentas.lString();
                Validator_Usuario.validarCpf(cpf);
                verifica = true;

            } catch (Exception e) {
                Menu_Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("> Digite o email: ");
            try {

                email = Ferramentas.lString();
                Validator_Geral.ValidarEmail(email);
                verifica = true;
            } catch (Exception e) {
                Menu_Default.Default();
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
                Validator_Usuario.senha(senha);
                verifica = true;
            } catch (Exception e) {
                Menu_Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("> Digite o nome: ");
            try {

                nome = Ferramentas.lString();
                Validator_Geral.validarString(nome);
                verifica = true;
            } catch (Exception e) {
                Menu_Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;


        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("> Digite o telefone: ");
            try {

                telefone = Ferramentas.lString();
                Validator_Geral.validarString(telefone);
                verifica = true;
            } catch (Exception e) {
                Menu_Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("> Digite o salário: ");
            try {

                salario = Ferramentas.lDouble();
                Validator_Usuario.validarSalario(salario);
                verifica = true;
            } catch (Exception e) {
                Menu_Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            do {
                System.out.println("-------------------------------------------");

                System.out.println("      +----------------------------+");
                System.out.println("      |       Data Nascimento      |");
                System.out.println("      +----------------------------+");

                System.out.println("\n\n");
                System.out.print("> Digite o ano: ");
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
                System.out.print("> Digite o mês: ");
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
                System.out.print("> Digite o dia: ");
                try {
                    dia = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e) {
                    Ferramentas.limpaTerminal();
                    System.err.println("ERRO - VALOR DIGITADO INCORRETO!");
                    Ferramentas.Delay(1500);
                }
            }
            while (verifica);
            try {
                Validator_Usuario.validarData(dia, mes, ano);
                verifica = true;
                dataNascimento = LocalDate.of(ano,mes,dia);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }

        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;


        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.print("> Digite a carga horario(Em minutos): ");
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
            System.out.print("> Digite a formação: ");
            try {
                formacao = Ferramentas.lString();
                Validator_Geral.validarString(formacao);
                verifica = true;
            } catch (IllegalArgumentException e) {
                Menu_Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        verifica = false;

        do {
            Ferramentas.limpaTerminal();
            System.out.println("-------------------------------------------");
            System.out.println("\n\n             SETOR  ");
            System.out.println("1- P&D(Pesquisa e desenvolvimento)  2-Motores Elétricos   3-Tintas e vernizes   4-Geração solar");
            System.out.println("5-Automação Industrial  6-Qualidade  7-Fundição   8-Manutenção 9-Administração");
            System.out.print("> Digite o setor: ");
            try {
                 setor = Ferramentas.lInteiro();
                verifica = true;
            } catch (IllegalArgumentException e) {
                Menu_Default.Default();
            }
        } while (verifica);
        System.out.println("-------------------------------------------");

        //Criar

        if (nivelAcesso == 1)
        {
            MODEL_Tecnico tecnico = new MODEL_Tecnico(nome,cpf, senha, nivelAcesso, telefone, salario, dataNascimento, email, cargaHoraria, formacao, setor,null, true   );
        }
        else if (nivelAcesso == 2)
        {
            MODEL_Supervisor supervisor = new MODEL_Supervisor(nome,cpf,senha,nivelAcesso,telefone,salario,dataNascimento,email,cargaHoraria,formacao,setor,0);
        }
        else if (nivelAcesso == 3)
        {
            MODEL_Gerente gerente = new MODEL_Gerente(nome,cpf,senha,nivelAcesso,telefone,salario,dataNascimento,email,cargaHoraria,formacao,setor,0);
        }

        return null;
    }
}

