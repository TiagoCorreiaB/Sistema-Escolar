package gerenciador;

import entidades.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorAluno implements Gerenciador {
    private List<Aluno> alunos = new ArrayList<>();

    @Override
    public void cadastrar(Scanner sc) {
        System.out.print ("Digite o nome do aluno: ");
        String nome = sc.nextLine();

        System.out.print ("Digite a idade do aluno: ");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.print ("Digite o CPF do aluno: ");
        String cpf = sc.nextLine();

        System.out.print ("Digite o email do aluno: ");
        String email = sc.nextLine();

        System.out.print ("Digite a primeira nota: ");
        Double nota1 = sc.nextDouble();

        System.out.print ("Digite a segunda nota: ");
        Double nota2 = sc.nextDouble();

        System.out.print ("Digite a terceira nota: ");
        Double nota3 = sc.nextDouble();
        sc.nextLine();

        alunos.add(new Aluno (nome, idade, cpf, email, nota1, nota2, nota3));
    }

    @Override
    public void visualizar(Scanner sc) {
        if (alunos.isEmpty()){
            System.out.println("Nenhum aluno cadastrado");
            return;
        }

        int escolha;

        System.out.println("---------------------------------------------------");
        System.out.println("| Digite 1 para visualizar todos os alunos        |");
        System.out.println("| Digite 2 para visualizar um aluno em específico |");
        System.out.print("---------------------------------------------------");
        escolha = sc.nextInt();

        while (escolha > 2 || escolha < 1){
            System.out.print("Digite 1 ou 2 apenas: ");
            escolha = sc.nextInt();
        }

        sc.nextLine();
        System.out.println();

        if (escolha == 1){
            for(Aluno aluno : alunos){
                System.out.println(aluno);
                System.out.println("--------------------------------");
            }
        }
        else {
            System.out.print("Digite o CPF do aluno que deseja visualizar: ");
            String cpf = sc.nextLine();

            for(Aluno aluno : alunos){
                if(aluno.getCpf().equals(cpf)){
                    System.out.println("\n"+aluno);
                    return;
                }
            }

            System.out.println("Aluno não encontrado com o CPF informado.");
        }
    }

    @Override
    public void alterar(Scanner sc) {
        if (alunos.isEmpty()){
            System.out.println("Nenhum aluno cadastrado");
            return;
        }

        System.out.print("Digite o CPF do aluno que deseja alterar: ");
        String cpf = sc.nextLine();

        for(Aluno aluno : alunos){
            if(aluno.getCpf().equals(cpf)){
                int escolha;

                do {
                    System.out.println(" ---------------------------- ");
                    System.out.println("| ESCOLHA O QUE ALTERAR      |");
                    System.out.println(" ---------------------------- ");
                    System.out.println("| 1 - Nome                   |");
                    System.out.println("| 2 - Idade                  |");
                    System.out.println("| 3 - Email                  |");
                    System.out.println("| 4 - Nota 1                 |");
                    System.out.println("| 5 - Nota 2                 |");
                    System.out.println("| 6 - Nota 3                 |");
                    System.out.println(" ---------------------------- ");
                    System.out.println("| 7 - Sair                   |");
                    System.out.println(" ---------------------------- ");
                    System.out.print("Escolha: ");

                    escolha = sc.nextInt();
                    sc.nextLine();

                    while (escolha > 7 || escolha < 1){
                        System.out.print("Digite de 1 a 7 apenas: ");
                        escolha = sc.nextInt();
                        sc.nextLine();
                    }

                    switch(escolha){
                        case 1:
                            System.out.print("Digite o novo nome: ");
                            aluno.setNome(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Digite a nova idade: ");
                            aluno.setIdade(sc.nextInt());
                            sc.nextLine();
                            break;
                        case 3:
                            System.out.print("Digite o novo email: ");
                            aluno.setEmail(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Digite a nova nota 1: ");
                            aluno.setNota1(sc.nextDouble());
                            sc.nextLine();
                            break;
                        case 5:
                            System.out.print("Digite a nova nota 2: ");
                            aluno.setNota2(sc.nextDouble());
                            sc.nextLine();
                            break;
                        case 6:
                            System.out.print("Digite a nova nota 3: ");
                            aluno.setNota3(sc.nextDouble());
                            sc.nextLine();
                            break;
                        case 7:
                            System.out.println("Saindo do modo de edição...");
                            break;
                    }
                } while(escolha != 7);

                return;
            }
        }

        System.out.println("Aluno não encontrado");
    }

    @Override
    public void excluir(Scanner sc) {
        if (alunos.isEmpty()){
            System.out.println("Nenhum aluno cadastrado");
            return;
        }

        System.out.print("Digite o CPF do aluno que deseja excluir: ");
        String cpf = sc.nextLine();

        for(int i = 0; i < alunos.size(); i++){
            if(alunos.get(i).getCpf().equals(cpf)){
                alunos.remove(i);
                System.out.println("Aluno removido");
                return;
            }
        }

        System.out.println("Aluno não encontrado");
    }
}
