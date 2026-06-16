package menu;

import gerenciador.Gerenciador;

import java.util.Scanner;

public class Menu {
    private Gerenciador gerenciadorAluno;
    private Gerenciador gerenciadorFuncionario;
    private Gerenciador gerenciadorProfessor;
    private Scanner sc;

    public Menu(Gerenciador gerenciadorAluno, Gerenciador gerenciadorFuncionario, Gerenciador gerenciadorProfessor, Scanner sc) {
        this.gerenciadorAluno = gerenciadorAluno;
        this.gerenciadorFuncionario = gerenciadorFuncionario;
        this.gerenciadorProfessor = gerenciadorProfessor;
        this.sc = sc;
    }

    public void iniciar(){
        int tipo, opcao;

        while (true) {
            System.out.println("------------------------------");
            System.out.println("| ESCOLHA O TIPO DE OPERAÇÃO |");
            System.out.println("------------------------------");
            System.out.println("| 1 - Aluno                  |");
            System.out.println("| 2 - Professor              |");
            System.out.println("| 3 - Funcionário            |");
            System.out.println("| 4 - Encerrar               |");
            System.out.println("------------------------------");
            System.out.print("Escolha: ");
            tipo = sc.nextInt();

            while (tipo > 4 || tipo < 1) {
                System.out.print("Digite uma opção válida: ");
                tipo = sc.nextInt();
            }

            if (tipo == 4) {
                System.out.println("Encerrando o sistema...");
                return;
            }

            Gerenciador gerenciadorAtual;
            if (tipo == 1) {
                gerenciadorAtual = gerenciadorAluno;
            } else if (tipo == 2) {
                gerenciadorAtual = gerenciadorProfessor;
            } else {
                gerenciadorAtual = gerenciadorFuncionario;
            }

            System.out.println("------------------------------");
            System.out.println("| ESCOLHA O TIPO DE OPERAÇÃO |");
            System.out.println("------------------------------");
            System.out.println("| 1 - Cadastro               |");
            System.out.println("| 2 - Visualização           |");
            System.out.println("| 3 - Edição                 |");
            System.out.println("| 4 - Exclusão               |");
            System.out.println("| 5 - Voltar                 |");
            System.out.println("------------------------------");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            while (opcao > 5 || opcao < 1) {
                System.out.print("Digite uma opção válida: ");
                opcao = sc.nextInt();
            }
            sc.nextLine();

            if (opcao == 5) {
                continue;
            }

            switch (opcao) {
                case 1:
                    gerenciadorAtual.cadastrar(sc);
                    break;
                case 2:
                    gerenciadorAtual.visualizar(sc);
                    break;
                case 3:
                    gerenciadorAtual.alterar(sc);
                    break;
                case 4:
                    gerenciadorAtual.excluir(sc);
                    break;
            }
        }
    }
}
