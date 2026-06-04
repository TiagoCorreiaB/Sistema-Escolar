package Entidades;

public class Professor extends Pessoa implements Pagavel{

    private Double horasTrabalhadas;
    private Materia materia;

    public Professor(String nome, Integer idade, String cpf, String email, Double horasTrabalhadas, Materia materia) {
        super(nome, idade, cpf, email);
        this.horasTrabalhadas = horasTrabalhadas;
        this.materia = materia;
    }

    @Override
    public Double calcularSalarioBruto(){

        return this.horasTrabalhadas * this.materia.getValorHora(); //Horas * valor que a materia paga
    }

    @Override
    public Double adicionarImposto(){

        return calcularSalarioBruto() * 0.075; //7,5% de imposto
    }

    @Override
    public Double calcularSalarioLiquido(){

        return  calcularSalarioBruto() - adicionarImposto(); // Salario inicial menos o imposto sob ele
    }

    public Double getHorasTrabalhadas() {

        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Double horasTrabalhadas) {

        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Materia getMateria() {
        return materia;
    }

    private void setMateria(Materia materia) {

        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Professor: " + nome +
                "\nHorasTrabalhadas: " + horasTrabalhadas +
                "\nDiciplina: " + materia +
                "\nSalário liquido: R$" + calcularSalarioLiquido();
    }
}
