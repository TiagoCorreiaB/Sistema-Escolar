package gerenciador;

import entidades.empregados.Status;
import entidades.empregados.professor.Materia;
import entidades.empregados.professor.Professor;

import java.util.List;
import java.util.Scanner;

public class GerenciadorProfessor implements Gerenciador {
    private List<Professor> professores;
    private List<Materia> materias;

    // Construtor do Gerenciador de Professores
    // Recebe a lista de matérias para vínculo e a lista de professores inicial
    public GerenciadorProfessor(List<Materia> materias, List<Professor> professores) {
        this.materias = materias;
        this.professores = professores;
    }

    // Lê os dados do terminal e vincula o novo professor a uma matéria
    @Override
    public void cadastrar(Scanner sc) {
        System.out.print("Digite o nome do professor: ");
        String nome = sc.nextLine();

        System.out.print("Digite a idade do professor: ");
        int idade = sc.nextInt();

        sc.nextLine();

        System.out.print("Digite o CPF do professor: ");
        String cpf = sc.nextLine();

        System.out.print("Digite o email do professor: ");
        String email = sc.nextLine();

        System.out.print("Digite a carga horaria deste professor (em horas): ");
        double horas = sc.nextDouble();

        System.out.print("---- Selecione a materia que ele atua ----");

        System.out.println(" ---------------------------- ");
        System.out.println("|     ESCOLHA A DISCIPLINA    |");
        System.out.println(" ---------------------------- ");
        System.out.println("| 1 - Matematica             |");
        System.out.println("| 2 - Português              |");
        System.out.println("| 3 - Historia               |");
        System.out.println("| 4 - Fisica                 |");
        System.out.println("| 5 - Geografia              |");
        System.out.println(" ---------------------------- ");
        System.out.print("Escolha: ");
        int disciplina = sc.nextInt();

        while (disciplina > 5 || disciplina < 1){
            System.out.print("Digite uma opção válida: ");
            disciplina = sc.nextInt();
        }

        sc.nextLine();

        Materia materia = materias.get(--disciplina);
        Professor professor = new Professor(nome, idade, cpf, email, horas, Status.ATIVO, materia);
        professores.add(professor);
        materia.adicionarProfessor(professor);
    }

    // Exibe todos os professores formatados ou busca por um CPF específico
    @Override
    public void visualizar(Scanner sc) {
        if (professores.isEmpty()){
            System.out.println("Nenhum professor cadastrado");
            return;
        }

        System.out.println("--------------------------------------------------------");
        System.out.println("| Digite 1 para visualizar todos os professores        |");
        System.out.println("| Digite 2 para visualizar um professor em específico  |");
        System.out.println("| Digite 3 para visualizar em ordem alfabética         |");
        System.out.println("--------------------------------------------------------");
        System.out.print("Escolha: ");
        int escolha = sc.nextInt();

        while (escolha > 3 || escolha < 1){
            System.out.print("Digite 1, 2 ou 3 apenas: ");
            escolha = sc.nextInt();
        }

        sc.nextLine();
        System.out.println();
        if (escolha == 1 || escolha == 3){
            List<Professor> lista = new java.util.ArrayList<>(professores);
            if (escolha == 3) {
                java.util.Collections.sort(lista);
            }

            System.out.println("NOME  |  IDADE  |  CPF  |  EMAIL  |  DISCIPLINA  |  STATUS  |  HORAS  |  SALÁRIO LÍQ.");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
            for(Professor p : lista){
                System.out.println(p.toString());
            }
        }
        else {
            System.out.print("Digite o CPF do professor que deseja visualizar: ");
            String cpf = sc.nextLine();

            for(Professor professor : professores){
                if(cpf.equals(professor.getCpf())){
                    System.out.println(professor);
                    return;
                }
            }

            System.out.println("Professor não encontrado com o CPF informado.");
        }
    }

    // Busca o professor por CPF e exibe um sub-menu para editar seus atributos
    @Override
    public void alterar(Scanner sc) {
        if (professores.isEmpty()){
            System.out.println("Nenhum professor cadastrado");
            return;
        }

        System.out.print("Digite o CPF do professor que deseja alterar: ");
        String cpf = sc.nextLine();

        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                int escolha;

                do {
                    System.out.println(" -------------------------------- ");
                    System.out.println("| ESCOLHA O QUE ALTERAR          |");
                    System.out.println(" -------------------------------- ");
                    System.out.println("| 1 - Nome                       |");
                    System.out.println("| 2 - Idade                      |");
                    System.out.println("| 3 - Email                      |");
                    System.out.println("| 4 - Horas Trabalhadas          |");
                    System.out.println("| 5 - Status                     |");
                    System.out.println(" -------------------------------- ");
                    System.out.println("| 6 - Sair                       |");
                    System.out.println(" -------------------------------- ");
                    System.out.print("Escolha: ");

                    escolha = sc.nextInt();
                    sc.nextLine();

                    while (escolha > 6 || escolha < 1) {
                        System.out.print("Digite de 1 a 6 apenas: ");
                        escolha = sc.nextInt();
                        sc.nextLine();
                    }

                    switch (escolha) {
                        case 1:
                            System.out.print("Digite o novo nome: ");
                            professor.setNome(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Digite a nova idade: ");
                            professor.setIdade(sc.nextInt());
                            sc.nextLine();
                            break;
                        case 3:
                            System.out.print("Digite o novo email: ");
                            professor.setEmail(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Digite a nova quantidade de horas trabalhadas: ");
                            professor.setHorasTrabalhadas(sc.nextDouble());
                            sc.nextLine();
                            break;
                        case 5:
                            System.out.println(" ---------------------------- ");
                            System.out.println("| ESCOLHA O NOVO STATUS      |");
                            System.out.println(" ---------------------------- ");
                            System.out.println("| 1 - ATIVO                  |");
                            System.out.println("| 2 - FÉRIAS                 |");
                            System.out.println("| 3 - AFASTADO               |");
                            System.out.println(" ---------------------------- ");
                            System.out.print("Escolha o status: ");

                            int escolhaStatus = sc.nextInt();
                            sc.nextLine();

                            while (escolhaStatus > 3 || escolhaStatus < 1) {
                                System.out.print("Digite de 1 a 4 apenas: ");
                                escolhaStatus = sc.nextInt();
                                sc.nextLine();
                            }

                            switch(escolhaStatus) {
                                case 1:
                                    professor.setStatus(Status.ATIVO);
                                    break;
                                case 2:
                                    professor.setStatus(Status.FERIAS);
                                    break;
                                case 3:
                                    professor.setStatus(Status.AFASTADO);
                                    break;
                            }
                            break;
                        case 6:
                            System.out.println("Saindo do modo de edição...");
                            break;
                    }
                } while (escolha != 6);

                return;
            }
        }

        System.out.println("Professor não encontrado.");
    }

    // Busca o professor por CPF e o remove permanentemente da lista
    @Override
    public void excluir(Scanner sc) {
        if (professores.isEmpty()){
            System.out.println("Nenhum professor cadastrado");
            return;
        }

        System.out.print("Digite o CPF do professor que deseja excluir: ");
        String cpf = sc.nextLine();

        for(int i = 0; i < professores.size(); i++){
            if(professores.get(i).getCpf().equals(cpf)){
                professores.remove(i);
                System.out.println("Professor removido");
                return;
            }
        }

        System.out.println("Professor não encontrado");
    }
}
