package entidades.empregados.professor;

import entidades.empregados.funcionario.Funcionario;
import entidades.empregados.Status;

public class Professor extends Funcionario {
    private Materia materia;

    // Construtor principal do Professor
    // Inicializa os atributos da Pessoa/Funcionario e a matéria vinculada
    public Professor(String nome, Integer idade, String cpf, String email, Double horasTrabalhadas, Status status, Materia materia) {
        super(nome, idade, cpf, email, horasTrabalhadas, status);
        this.materia = materia;
    }

    @Override
    // Calcula o salário base do professor
    // Baseado nas horas trabalhadas e valor da matéria
    public Double calcularSalarioBruto(){
        return this.horasTrabalhadas * this.materia.getValorHora(); //Horas * valor que a materia paga
    }

    // Retorna a matéria ensinada pelo professor
    public Materia getMateria() {
        return materia;
    }

    // Define a matéria (método privado)
    private void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    // Retorna o valor da hora associado à matéria
    public Double getValorHora() {
        return materia.getValorHora();
    }

    @Override
    // Retorna os dados formatados do professor em texto
    public String toString() {
        return nome + "  |  " + idade + "  |  " + cpf + "  |  " + email + "  |  " + materia.getNome() + "  |  " + status + "  |  " + horasTrabalhadas + "h  |  R$ " + calcularSalarioLiquido();
    }
}
