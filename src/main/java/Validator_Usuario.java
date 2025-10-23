import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;
import java.util.IllegalFormatCodePointException;

public class Validator_Usuario {

    // ---- VALIDAÇÃO DE CPF ---- //

    // Metodo para validar cpf
    public static String validarCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("ERRO - CPF NÃO PODE SER VAZIO!");
        }

        // Remover qualquer formatação do CPF (caso tenha sido passado com pontos ou traços)
        String cpfNumerico = cpf.replaceAll("[^0-9]", "");

        // Verificar se tem exatamente 11 dígitos
        if (cpfNumerico.length() != 11 || cpfNumerico.matches("(\\d)\\1{10}")) {
            throw new IllegalArgumentException("ERRO - CPF DE TAMANHO INVÁLIDO OU SEQUÊNCIA DE DÍGITOS IGUAIS!");
        }

        // Calcular os dois dígitos verificadores
        int d1 = calcularDigito(cpfNumerico.substring(0, 9), 10);
        int d2 = calcularDigito(cpfNumerico.substring(0, 9) + d1, 11);

        // Verificar se os dígitos verificadores são iguais aos fornecidos
        if (cpfNumerico.charAt(9) != (d1 + '0') || cpfNumerico.charAt(10) != (d2 + '0')) {
            throw new IllegalArgumentException("ERRO - CPF INVÁLIDO (DÍGITOS VERIFICADORES INCORRETOS)!");
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
            throw new IllegalArgumentException("ERRO - TAMANHO DE TELEFONE INCORRETO!");
        } else {
            return telefoneNumerico;
        }
    }


    // ---- VALIDAÇÃO DE DATAS ---- //
    public static Date validarDataNascimento(Date dataNascimento) {
        if (dataNascimento == null) {
            throw new IllegalArgumentException("ERRO - A DATA DE NASCIMENTO NÃO PODE SER NULA!");
        }

        LocalDate dataLocal = dataNascimento.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate hoje = LocalDate.now();

        if (dataLocal.isAfter(hoje)) {
            throw new IllegalArgumentException("ERRO - A DATA DE NASCIMENTO NÃO PODE SER NO FUTURO!");
        }

        int idade = java.time.Period.between(dataLocal, hoje).getYears();
        if (idade < 18) {
            throw new IllegalArgumentException("ERRO - O USUÁRIO DEVE TER PELO MENOS 18 ANOS!");
        }

        return dataNascimento; // retorna a data válida
    }

    // Valida a data informada (ano, mês, dia)
    public static LocalDate validarData(int dia, int mes, int ano) {
        if (ano < 1900 || ano > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("ERRO - ANO INVÁLIDO! O ANO DEVE ESTAR ENTRE 1900 E O ANO ATUAL.");
        }

        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("ERRO - MÊS INVÁLIDO! O MÊS DEVE ESTAR ENTRE 1 E 12.");
        }

        YearMonth anoMes = YearMonth.of(ano, mes);
        int diasNoMes = anoMes.lengthOfMonth();

        if (dia < 1 || dia > diasNoMes) {
            throw new IllegalArgumentException("ERRO - DIA INVÁLIDO! O DIA DEVE ESTAR ENTRE 1 E " + diasNoMes + " PARA O MÊS " + mes + ".");
        }

        return LocalDate.of(ano, mes, dia);
    }



    public static String ValidarEmail(String email) {
        // Verifica se o e-mail não é nulo e se contém exatamente um "@" e um "."
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("ERRO - EMAIL INCORRETO!");
        }

        // Verifica se o "@" vem antes de algum "."
        int atIndex = email.indexOf("@");
        int dotIndex = email.indexOf(".", atIndex);

        if (atIndex == -1 || dotIndex == -1 || dotIndex < atIndex) {
            throw new IllegalArgumentException("ERRO - EMAIL INCORRETO!");
        }

        // Verifica se há espaços
        if (email.contains(" ")) {
            throw new IllegalArgumentException("ERRO - EMAIL NÃO PODE CONTER ESPAÇOS!");
        }

        return email;
    }

    // ---- VALIDACÃO DE SALÁRIO ---- //
    public static double validarSalario(double salario) {
        if (salario < 1518) {
            throw new IllegalArgumentException("ERRO - SALÁRIO NÃO PODE SER INFERIOR A R$1518,00!");
        }

        return salario;
    }


    // ---- VALIDAÇÃO DE NÍVEL DE ACESSO ---- //
    public static int validarNivelAcesso(int nivel){
        if(nivel == 1 || nivel == 2 || nivel == 3){
            return nivel;
        }
        throw new IllegalArgumentException("ERRO - NIVEL NÃO PODE SER DIFERENTE DE 1 , 2 , 3");
    }


    // ---- VALIDAÇÃO DE CARGA HORÁRIA MÍNIMA ---- //
    public static int validarCargaHoraria(int cargaHoraria){
        int cargaHorariaMinimaMinutos = 13200;
        if (cargaHoraria < cargaHorariaMinimaMinutos){
            throw new IllegalArgumentException("ERRO - CARGA HORÁRIA MÍNIMA NÃO ATINGIDA!");
        }

        return cargaHoraria;
    }


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
}
