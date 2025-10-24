import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Validator_Geral
{
    // ---- VALIDA SE A STRING É VAZIA ----//
    public static String  ValidarString(String texto) {
        if (texto == null || texto.trim().isEmpty()){
            throw new IllegalArgumentException("ERRO - O TEXTO NÃO PODE SER VAZIO!");
        }else{
            return texto;
        }
    }

    // ---- VALIDA SE O NÚMERO É NEGATIVO (int)----//
    public static int ValidarNumeroNegativoInt(int numero){
        if (numero < 0){
            throw new IllegalArgumentException("ERRO - NÃO SÃO ACEITOS NÚMEROS NEGATIVOS");
        }else{
            return numero;
        }
    }

    // ---- VALIDA SE O NÚMERO É NEGATIVO (double) ----//
    public static double ValidarNumeroNegativoDouble(double numero){
        if (numero <= 0){
            throw new IllegalArgumentException("ERRO - NÃO SÃO ACEITOS NÚMEROS NEGATIVOS");
        }else{
            return numero;
        }
    }

    // ---- VALIDA SE O TELEFONE É DO TAMANHO CORRETO OU VAZIO ----//
    public static String ValidarTelefone(String telefone){

        String telefoneNumerico = telefone.replaceAll("[^0-9]", "");

        if (telefoneNumerico.length() != 11){
            throw new IllegalArgumentException("ERRO - TAMANHO DE TELEFONE INCORRETO!");
        }else{
            return telefoneNumerico;
        }
    }

    public static String ValidarEmail(String email){
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

    // Lista de setores válidos
    private static final List<String> setoresValidos = Arrays.asList(
            "Manutenção", "Produção", "Qualidade", "Logística", "Financeiro"
    );

    // ---- METODO DE VALIDAÇÃO DE SETOR ---- //
    public static MODEL_Setor ValidarSetor(MODEL_Setor setor) {
        // Verifica se o nome do setor está na lista de setores válidos
        if (setor == null || !setoresValidos.contains(setor.getNomeSetor())) {
            throw new IllegalArgumentException("ERRO - Setor inválido!");
        }
        return setor;
    }

    // Dentro da classe ValidacoesGerais
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
        if (idade < 16) {
            throw new IllegalArgumentException("ERRO - O USUÁRIO DEVE TER PELO MENOS 16 ANOS!");
        }

        return dataNascimento; // retorna a data válida
    }



}
