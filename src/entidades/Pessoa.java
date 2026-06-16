package entidades;

public abstract class Pessoa {
    //Atributos protegidos para que a classe e seus filhos possam ter esses mesmos atributos
    protected String nome;
    protected Integer idade;
    protected String cpf;
    protected String email;

    // Construtor principal da classe Pessoa
    // Inicializa os atributos comuns a todos
    public Pessoa(String nome, Integer idade, String cpf, String email) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
    }

    // Retorna o nome da pessoa
    public String getNome() {

        return nome;
    }

    // Define um novo nome para a pessoa
    public void setNome(String nome) {

        this.nome = nome;
    }

    // Retorna a idade da pessoa
    public Integer getIdade() {

        return idade;
    }

    // Define uma nova idade
    public void setIdade(Integer idade) {

        this.idade = idade;
    }

    // Retorna o CPF da pessoa
    public String getCpf() {

        return cpf;
    }

    // Define um novo CPF (método protegido)
    protected void setCpf(String cpf) {

        this.cpf = cpf;
    }

    // Retorna o email da pessoa
    public String getEmail() {

        return email;
    }

    // Define um novo email
    public void setEmail(String email) {

        this.email = email;
    }

    @Override
    // Retorna os dados da pessoa como texto
    public String toString() {
        return nome + "  |  " + idade + "  |  " + cpf + "  |  " + email;
    }

}
