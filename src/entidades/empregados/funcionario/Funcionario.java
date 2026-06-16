package entidades.empregados.funcionario;

import entidades.empregados.Pagavel;
import entidades.Pessoa;
import entidades.empregados.Status;

public class Funcionario extends Pessoa implements Pagavel {
    protected Double horasTrabalhadas;
    private Double valorHora;
    protected Status status;

    // Construtor completo do Funcionario
    // Inicializa todos os atributos, incluindo valorHora
    public Funcionario(String nome, Integer idade, String cpf, String email, Double horasTrabalhadas, Double valorHora, Status status) {
        super(nome, idade, cpf, email);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
        this.status = status;
    }

    // Construtor sem valorHora (utilizado por subclasses como Professor)
    public Funcionario(String nome, Integer idade, String cpf, String email, Double horasTrabalhadas, Status status) {
        super(nome, idade, cpf, email);
        this.horasTrabalhadas = horasTrabalhadas;
        this.status = status;
    }

    @Override
    // Calcula o salário bruto do funcionário
    public Double calcularSalarioBruto(){
        return this.horasTrabalhadas * this.valorHora; //Horas * valor que a materia paga
    }

    @Override
    // Calcula o desconto de imposto sobre o salário bruto
    public Double adicionarImposto(){
        return calcularSalarioBruto() * 0.075; //7,5% de imposto
    }

    @Override
    // Calcula o salário líquido deduzindo os impostos
    public Double calcularSalarioLiquido(){
        return  calcularSalarioBruto() - adicionarImposto(); // Salario inicial menos o imposto sob ele
    }

    // Retorna o status atual do funcionário
    public Status getStatus() {
        return status;
    }

    // Define um novo status
    public void setStatus(Status status) {
        this.status = status;
    }

    // Retorna as horas trabalhadas
    public Double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    // Define as horas trabalhadas
    public void setHorasTrabalhadas(Double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    // Retorna o valor ganho por hora
    public Double getValorHora() {
        return valorHora;
    }

    // Define o valor ganho por hora
    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    // Retorna os dados do funcionário formatados em texto
    public String toString() {
        return nome + "  |  " + idade + "  |  " + cpf + "  |  " + email + "  |  " + status + "  |  " + horasTrabalhadas + "h  |  R$ " + valorHora + "  |  R$ " + calcularSalarioLiquido();
    }
}
