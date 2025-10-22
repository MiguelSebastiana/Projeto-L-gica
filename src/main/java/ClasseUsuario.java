import java.util.Date;

public class ClasseUsuario {

    // Atributos
    private int id;
    private String nome;
    private String cpf;
    private int nivelacesso;
    private String telefone;
    private double salario;
    private Date datanasci;
    private String email;
    private int cargahoraria;
    private String formacao;
    private ClasseSetor setor;

    // Construtor
    public ClasseUsuario(int id, String nome, String cpf, int nivelacesso, String telefone, double salario,
                         Date datanasci, String email, int cargahoraria, String formacao, ClasseSetor setor) {
        this.id = id;

        // ---- VALIDAÇÃO DE NOME ---- //
        this.nome = ValidacoesGerais.ValidarString(nome);

        // ---- VALIDAÇÃO DE CPF ---- //
        // Remover qualquer formatação antes de validar
        String cpfNumerico = cpf.replaceAll("[^0-9]", "");

       // ---- VALIDAÇÃO ---- //
        ValidacaoCPF.validar(cpfNumerico);
        this.cpf = cpfNumerico;


        // ---- VALIDAÇÃO DE NÚMERO ----//
        this.nivelacesso = ValidacoesGerais.ValidarNumeroNegativoInt(nivelacesso);

        // ---- VALIDAÇÃO DE TELEFONE ----//
        this.telefone = ValidacoesGerais.ValidarTelefone(telefone);

        // ---- VALIDAÇÃO DE SALARIO ----//
        this.salario = ValidacoesGerais.ValidarNumeroNegativoDouble(salario);

        // ---- VALIDAÇÃO DE DATA DE NASCIMENTO ---- //
        this.datanasci = ValidacoesGerais.validarDataNascimento(datanasci);
        this.datanasci = datanasci;

        // --- VALIDAÇÃO DE EMAIL ----//
        this.email = ValidacoesGerais.ValidarEmail(email);

        // ---- VALIDAÇÃO DE CARGA HORARIA --- //
        this.cargahoraria = ValidacoesGerais.ValidarNumeroNegativoInt(cargahoraria);

        // ---- VALIDAÇÃO DE FORMAÇÃO ---- //
        this.formacao = ValidacoesGerais.ValidarString(formacao);

        // ---- VALIDAÇÃO DE SETOR ---- //
        this.setor = setor;
    }



    // Getter e Setters //
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getNivelacesso() {
        return nivelacesso;
    }

    public void setNivelacesso(int nivelacesso) {
        this.nivelacesso = nivelacesso;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getDatanasci() {
        return datanasci;
    }

    public void setDatanasci(Date datanasci) {
        this.datanasci = datanasci;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public ClasseSetor getSetor() {
        return setor;
    }

    public void setSetor(ClasseSetor setor) {
        this.setor = setor;
    }
}
