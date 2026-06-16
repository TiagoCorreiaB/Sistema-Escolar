package gerenciador;

import java.util.Scanner;

public interface Gerenciador {
    // Cadastra um novo registro
    void cadastrar(Scanner sc);
    // Exibe todos os registros ou busca por CPF
    void visualizar(Scanner sc);
    // Altera os dados de um registro existente pelo CPF
    void alterar(Scanner sc);
    // Remove um registro da lista pelo CPF
    void excluir(Scanner sc);
}
