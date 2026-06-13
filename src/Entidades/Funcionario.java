package Entidades;

public class Funcionario extends Pessoa implements Pagavel {
    protected Double horasTrabalhadas;
    private Double valorHora;
    protected StatusFuncionario status;

    public Funcionario(String nome, Integer idade, String cpf, String email, Double horasTrabalhadas, Double valorHora, StatusFuncionario status) {
        super(nome, idade, cpf, email);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
        this.status = status;
    }

    public Funcionario(String nome, Integer idade, String cpf, String email, Double horasTrabalhadas, StatusFuncionario status) {
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

    public StatusFuncionario getStatus() {
        return status;
    }

    public void setStatus(StatusFuncionario status) {
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
        return "Funcionario{" +
                "status=" + status +
                ", horasTrabalhadas=" + horasTrabalhadas +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
