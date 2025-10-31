package Util;

import Exception.*;
import Model.MODEL_Setor;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

public class Validator_Usuario {

    // ---- VALIDAÇÃO DE CPF ---- //

    // Metodo para validar cpf
    public static String validarCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw CPFException.vazio();
        }

        // Remover qualquer formatação do CPF (caso tenha sido passado com pontos ou traços)
        String cpfNumerico = cpf.replaceAll("[^0-9]", "");

        // Verificar se tem exatamente 11 dígitos
        if (cpfNumerico.length() != 11 || cpfNumerico.matches("(\\d)\\1{10}")) {
            throw CPFException.tamanhoInvalido();
        }

        // Calcular os dois dígitos verificadores
        int d1 = calcularDigito(cpfNumerico.substring(0, 9), 10);
        int d2 = calcularDigito(cpfNumerico.substring(0, 9) + d1, 11);

        // Verificar se os dígitos verificadores são iguais aos fornecidos
        if (cpfNumerico.charAt(9) != (d1 + '0') || cpfNumerico.charAt(10) != (d2 + '0')) {
            throw CPFException.digitoInvalido();
        }

        return cpf.replaceAll("[^0-9]", "");
    }

    // Calcular os digitos
    private static int calcularDigito(String cpfBase, int peso) {
        int soma = 0;
        for (int i = 0; i < cpfBase.length(); i++) {
            soma += (cpfBase.charAt(i) - '0') * peso;
            peso--;
        }
        int digito = soma % 11;
        return digito < 2 ? 0 : 11 - digito;
    }



    // ---- VALIDA SE O TELEFONE É DO TAMANHO CORRETO OU VAZIO ---- //
    public static String ValidarTelefone(String telefone) {

        String telefoneNumerico = telefone.replaceAll("[^0-9]", "");

        if (telefoneNumerico.length() != 11) {
            throw new TELEFONEException();
        } else {
            return telefoneNumerico;
        }
    }



    // ---- VALIDAÇÃO DE DATAS ---- //
    public static Date validarDataNascimento(Date dataNascimento) {
        if (dataNascimento == null) {
            throw DATESException.vazio();
        }

        LocalDate dataLocal = dataNascimento.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate hoje = LocalDate.now();

        if (dataLocal.isAfter(hoje)) {
            throw DATESException.futuro();
        }

        int idade = java.time.Period.between(dataLocal, hoje).getYears();
        if (idade < 18) {
            throw DATESException.maiorIdade();
        }

        return dataNascimento; // retorna a data válida
    }

    // Valida a data informada (ano, mês, dia)
    public static LocalDate validarData(int dia, int mes, int ano) {
        if (ano < 1900 || ano > LocalDate.now().getYear()) {
            throw DATESException.anoInvalido();
        }

        if (mes < 1 || mes > 12) {
            throw DATESException.mesInvalido();
        }

        YearMonth anoMes = YearMonth.of(ano, mes);
        int diasNoMes = anoMes.lengthOfMonth();

        if (dia < 1 || dia > diasNoMes) {
            throw DATESException.diaInvalido();
        }

        return LocalDate.of(ano, mes, dia);
    }



    public static String ValidarEmail(String email) {
        // Verifica se o e-mail não é nulo e se contém exatamente um "@" e um "."
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw EMAILException.vazio();
        }

        // Verifica se o "@" vem antes de algum "."
        int atIndex = email.indexOf("@");
        int dotIndex = email.indexOf(".", atIndex);

        if (atIndex == -1 || dotIndex == -1 || dotIndex < atIndex) {
            throw EMAILException.caracteres();
        }

        // Verifica se há espaços
        if (email.contains(" ")) {
            throw EMAILException.espaco();
        }

        return email;
    }

    // ---- VALIDACÃO DE SALÁRIO ---- //
    public static double validarSalario(double salario) {
        if (salario < 1518) {
            throw SALARIOException.inferior();
        }

        return salario;
    }


    // ---- VALIDAÇÃO DE NÍVEL DE ACESSO ---- //
    public static int validarNivelAcesso(int nivel){
        if(nivel == 1 || nivel == 2 || nivel == 3){
            return nivel;
        }
        throw NIVELACESSOException.errado();
    }


    // ---- VALIDAÇÃO DE CARGA HORÁRIA MÍNIMA ---- //
    public static int validarCargaHoraria(int cargaHoraria){
        int cargaHorariaMinimaMinutos = 13200;
        if (cargaHoraria < cargaHorariaMinimaMinutos){
            throw CARGAHORARIAException.inferior();
        }

        return cargaHoraria;
    }


    // ---- NÃO TEM NECESSIDADE DE CLASSE DE EXCEÇÃO ! -- //
    // ---- VALIDAÇÃO DE SETOR ---- //
    public static MODEL_Setor validarSetor(MODEL_Setor setor){
        if (setor == null){
            throw new IllegalArgumentException("ERRO - SETOR NÃO PODE SER NULO!");
        }

        if (setor.getNomeSetor() == null || setor.getNomeSetor().trim().isEmpty()){
            throw new IllegalArgumentException("ERRO - NOME DO SETOR NÃO PODE SER VAZIO!");
        }

        return setor;
    }
    // ------------------------------------------------------------------------------------ //

    public static String senha(String senha){
        if (senha == null || senha.trim().isEmpty()){
            throw SENHA.vazia();
        }

        if (senha.length() < 5){
            throw SENHA.tamanho();
        }

        return senha;
    }
}
