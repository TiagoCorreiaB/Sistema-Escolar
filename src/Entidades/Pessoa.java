package Entidades;

public abstract class Pessoa {
    //Atributos protegidos para que a classe e seus filhos possam ter esses mesmos atributos
    protected String nome;
    protected Integer idade;
    protected String cpf;
    protected String email;

    public Pessoa(String nome, Integer idade, String cpf, String email) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public Integer getIdade() {

        return idade;
    }

    public void setIdade(Integer idade) {

        this.idade = idade;
    }

    public String getCpf() {

        return cpf;
    }

    protected void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
