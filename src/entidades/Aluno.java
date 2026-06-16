package entidades;

//Classe Aluno herda atributos e comportamentos da classe Pessoa via extends
public class Aluno extends Pessoa {
    //Atributos privados acessados apenas via getters e setters
    private Double nota1;
    private Double nota2;
    private Double nota3;
    private Double media;

    // Construtor principal da classe Aluno
    // Inicializa os atributos básicos e as três notas
    public Aluno (String nome, Integer idade, String cpf, String email, Double nota1, Double nota2, Double nota3) {
        super (nome, idade, cpf, email); // super() chama atributos da classe mãe (Pessoa)
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.media = calcularMedia();
    }

    //Setters recalculam a média ao alterar qualquer nota
    // Retorna a primeira nota do aluno
    public Double getNota1 () {
        return nota1;
    }

    // Define a primeira nota
    // e recalcula a média automaticamente
    public void setNota1 (Double nota1) {
        this.nota1 = nota1;
        this.media = calcularMedia();
    }

    // Retorna a segunda nota do aluno
    public Double getNota2 () {
        return nota2;
    }

    // Define a segunda nota
    // e recalcula a média automaticamente
    public void setNota2 (Double nota2) {
        this.nota2 = nota2;
        this.media = calcularMedia();
    }

    // Retorna a terceira nota do aluno
    public Double getNota3 () {
        return nota3;
    }

    // Define a terceira nota
    // e recalcula a média automaticamente
    public void setNota3 (Double nota3) {
        this.nota3 = nota3;
        this.media = calcularMedia();
    }

    //"media" não possui setter pois é calculada ao invés de ser inserida pelo usuário
    // Retorna a média atual do aluno
    public double getMedia () {
        return media;
    }

    // Calcula a média aritmética das três notas
    public Double calcularMedia () {
        return (nota1 + nota2 + nota3)/3.0;
    }

    //Sobrescreve o toString() da classe Object
    @Override
    // Retorna uma representação em texto dos dados do aluno
    public String toString () {
        return nome + "  |  " + idade + "  |  " + cpf + "  |  " + email + "  |  " + nota1 + "  |  " + nota2 + "  |  " + nota3 + "  |  " + media;
    }
}