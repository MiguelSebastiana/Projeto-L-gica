import java.util.ArrayList;
import java.util.Arrays;

public class Validator_Setor {

    // ---- LISTA DE SETORES DISPONÍVEIS POR STRING ----
    public static final ArrayList<String> setoresValidos = new ArrayList<>(Arrays.asList(
            "Manutenção",
            "Produção",
            "TI",
            "Fundição",
            "Usinagem",
            "Bobinagem",
            "Montagem",
            "Controle de Qualidade"
    ));

    // ---- VALIDAÇÃO DO SETOR ----
    public static String validarSetor(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("ERRO - NOME DE SETOR NÃO PODE SER VAZIO!");
        }

        String setor = nome.trim();

        if (!setoresValidos.contains(setor)) {
            throw new IllegalArgumentException("ERRO - SETOR INVÁLIDO!");
        }

        return setor;
    }
}
