package gerenciador;

import java.util.Scanner;

public interface Gerenciador {
    void cadastrar(Scanner sc);
    void visualizar(Scanner sc);
    void alterar(Scanner sc);
    void excluir(Scanner sc);
}
