package entidades.empregados;

public interface Pagavel {
    Double calcularSalarioBruto();
    Double adicionarImposto();
    Double calcularSalarioLiquido();
}