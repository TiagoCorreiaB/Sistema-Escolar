package entidades;

//Classe Aluno herda atributos e comportamentos da classe Pessoa via extends
public class Aluno extends Pessoa {
    //Atributos privados acessados apenas via getters e setters
    private Double nota1;
    private Double nota2;
    private Double nota3;
    private Double media;

    public Aluno (String nome, Integer idade, String cpf, String email, Double nota1, Double nota2, Double nota3) {
        super (nome, idade, cpf, email); // super() chama atributos da classe mãe (Pessoa)
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.media = calcularMedia();
    }

    //Setters recalculam a média ao alterar qualquer nota
    public Double getNota1 () {
        return nota1;
    }
    public void setNota1 (Double nota1) {
        this.nota1 = nota1;
        this.media = calcularMedia();
    }

    public Double getNota2 () {
        return nota2;
    }
    public void setNota2 (Double nota2) {
        this.nota2 = nota2;
        this.media = calcularMedia();
    }

    public Double getNota3 () {
        return nota3;
    }
    public void setNota3 (Double nota3) {
        this.nota3 = nota3;
        this.media = calcularMedia();
    }

    //"media" não possui setter pois é calculada ao invés de ser inserida pelo usuário
    public double getMedia () {
        return media;
    }

    public Double calcularMedia () {
        return (nota1 + nota2 + nota3)/3.0;
    }

    //Sobrescreve o toString() da classe Object
    @Override
    public String toString () {
        return "========== ALUNO ==========" +
                "\nNome: " + nome +
                "\nIdade: " + idade +
                "\nCPF: " + cpf +
                "\nEmail: " + email +
                "\n--------------------------" +
                "\nNota 1: " + nota1 +
                "\nNota 2: " + nota2 +
                "\nNota 3: " + nota3 +
                "\nMédia: "+ media +
                "\n===========================";
    }
}