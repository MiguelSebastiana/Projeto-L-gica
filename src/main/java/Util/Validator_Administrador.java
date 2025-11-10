package Util;

public class Validator_Administrador {

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

    public static String validarSenha(String senha){
        if (senha == null || senha.trim().isEmpty()){
            throw new IllegalArgumentException("ERRO - SENHA NÃO PODE SER VAZIA!");
        }
        return senha;
    }
}
