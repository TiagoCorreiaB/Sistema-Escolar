package entidades.empregados.professor;

import java.util.ArrayList;

public class Materia {

    private String nome;
    private Double valorHora; //Cada materia tem seu proprio valor que pode ser pago a hora
    private Integer idMateria;
    private final ArrayList<Professor> professores = new ArrayList<>();

    // Construtor principal da Materia
    // Inicializa o nome, valor por hora e ID único
    public Materia(String nome, Double valorHora, Integer idMateria) {
        this.nome = nome;
        this.valorHora = valorHora;
        this.idMateria = idMateria;
    }

    // Vincula um professor a esta matéria
    public void adicionarProfessor(Professor professor){

        professores.add(professor);
    }

    // Retorna a lista de professores que ensinam a matéria
    public ArrayList<Professor> getProfessores(){

        return professores;
    }

    // Retorna o nome da matéria
    public String getNome() {
        return nome;
    }

    // Define um novo nome para a matéria
    public void setNome(String nome) {

        this.nome = nome;
    }

    // Retorna o valor ganho por hora nesta matéria
    public Double getValorHora() {

        return valorHora;
    }

    // Define um novo valor de hora para a matéria
    public void setValorHora(Double valorHora) {

        this.valorHora = valorHora;
    }

    // Retorna o ID identificador da matéria
    public Integer getIdMateria() {

        return idMateria;
    }

    // Define um novo ID para a matéria
    public void setIdMateria(Integer idMateria) {

        this.idMateria = idMateria;
    }

    @Override
    // Retorna uma representação simples da matéria em texto
    public String toString() {
        return nome + "(R$" + valorHora + "/hora)";
    }
}
