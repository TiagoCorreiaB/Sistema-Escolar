package entidades.empregados.professor;

import entidades.empregados.funcionario.Funcionario;
import entidades.empregados.Status;

public class Professor extends Funcionario {
    private Materia materia;

    public Professor(String nome, Integer idade, String cpf, String email, Double horasTrabalhadas, Status status, Materia materia) {
        super(nome, idade, cpf, email, horasTrabalhadas, status);
        this.materia = materia;
    }

    @Override
    public Double calcularSalarioBruto(){
        return this.horasTrabalhadas * this.materia.getValorHora(); //Horas * valor que a materia paga
    }

    public Materia getMateria() {
        return materia;
    }

    private void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public Double getValorHora() {
        return materia.getValorHora();
    }

    @Override
    public String toString() {
        return "======== PROFESSOR ========" +
                "\nNome: " + nome +
                "\nIdade: " + idade +
                "\nCPF: " + cpf +
                "\nEmail: " + email +
                "\n--------------------------" +
                "\nMatéria: " + materia +
                "\nStatus: " + status +
                "\nHoras Trabalhadas: " + horasTrabalhadas +
                "\n===========================";
    }
}
