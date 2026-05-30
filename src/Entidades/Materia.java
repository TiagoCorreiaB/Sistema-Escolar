package Entidades;

import java.util.ArrayList;

public class Materia {

    private String nome;
    private Double valorHora; //Cada materia tem seu proprio valor que pode ser pago a hora
    private Integer idMateria;
    private final ArrayList<Professor> professores = new ArrayList<>();

    public Materia(String nome, Double valorHora, Integer idMateria) {
        this.nome = nome;
        this.valorHora = valorHora;
        this.idMateria = idMateria;

    }

    //Uma materia pode ter mais de 1 professor (eles são colocados no arrayList)
    public void adicionarProfessor(Professor professor){

        professores.add(professor);
    }

    public ArrayList<Professor> getProfessores(){

        return professores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public Double getValorHora() {

        return valorHora;
    }

    public void setValorHora(Double valorHora) {

        this.valorHora = valorHora;
    }

    public Integer getIdMateria() {

        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {

        this.idMateria = idMateria;
    }

    @Override
    public String toString() {
        return  nome + '\'' +
                ", valorHora=" + valorHora;
    }
}
