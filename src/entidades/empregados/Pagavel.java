package entidades.empregados;

public interface Pagavel {
    // Calcula o valor total sem descontos
    Double calcularSalarioBruto();
    // Calcula o valor dos descontos a aplicar
    Double adicionarImposto();
    // Calcula o valor final com descontos
    Double calcularSalarioLiquido();
}