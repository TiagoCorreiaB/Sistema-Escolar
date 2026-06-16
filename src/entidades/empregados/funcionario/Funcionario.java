package entidades.empregados.funcionario;

import entidades.empregados.Pagavel;
import entidades.Pessoa;
import entidades.empregados.Status;

public class Funcionario extends Pessoa implements Pagavel {
    protected Double horasTrabalhadas;
    private Double valorHora;
    protected Status status;

    public Funcionario(String nome, Integer idade, String cpf, String email, Double horasTrabalhadas, Double valorHora, Status status) {
        super(nome, idade, cpf, email);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
        this.status = status;
    }

    public Funcionario(String nome, Integer idade, String cpf, String email, Double horasTrabalhadas, Status status) {
        super(nome, idade, cpf, email);
        this.horasTrabalhadas = horasTrabalhadas;
        this.status = status;
    }

    @Override
    public Double calcularSalarioBruto(){
        return this.horasTrabalhadas * this.valorHora; //Horas * valor que a materia paga
    }

    @Override
    public Double adicionarImposto(){
        return calcularSalarioBruto() * 0.075; //7,5% de imposto
    }

    @Override
    public Double calcularSalarioLiquido(){
        return  calcularSalarioBruto() - adicionarImposto(); // Salario inicial menos o imposto sob ele
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return "======= FUNCIONÁRIO =======" +
                "\nNome: " + nome +
                "\nIdade: " + idade +
                "\nCPF: " + cpf +
                "\nEmail: " + email +
                "\n--------------------------" +
                "\nStatus: " + status +
                "\nHoras Trabalhadas: " + horasTrabalhadas +
                "\nValor/Hora: " + valorHora +
                "\n===========================";
    }
}
