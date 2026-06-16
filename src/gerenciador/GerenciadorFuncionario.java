package gerenciador;

import entidades.empregados.funcionario.Funcionario;
import entidades.empregados.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorFuncionario implements Gerenciador {
    private List<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public void cadastrar(Scanner sc) {
        System.out.print("Digite o nome do funcionário: ");
        String nome = sc.nextLine();

        System.out.print("Digite a idade do funcionário: ");
        int idade = sc.nextInt();

        sc.nextLine();

        System.out.print("Digite o CPF do funcionário: ");
        String cpf = sc.nextLine();

        System.out.print("Digite o email do funcionário: ");
        String email = sc.nextLine();

        System.out.print("Digite a carga horaria deste funcionário (em horas): ");
        double horas = sc.nextDouble();

        System.out.print("Digite o valor-hora deste funcionário (em reais): ");
        double valor = sc.nextDouble();

        funcionarios.add(new Funcionario(nome, idade, cpf, email, horas, valor, Status.ATIVO));
    }

    @Override
    public void visualizar(Scanner sc) {
        if (funcionarios.isEmpty()){
            System.out.println("Nenhum funcionário cadastrado");
            return;
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("| Digite 1 para visualizar todos os funcionários        |");
        System.out.println("| Digite 2 para visualizar um funcionário em específico |");
        System.out.println("---------------------------------------------------------");
        System.out.print("Escolha: ");
        int escolha = sc.nextInt();

        while (escolha > 2 || escolha < 1){
            System.out.print("Digite 1 ou 2 apenas: ");
            escolha = sc.nextInt();
        }

        sc.nextLine();

        System.out.println();
        if (escolha == 1){
            for(Funcionario funcionario : funcionarios){
                System.out.println(funcionario);
                System.out.println("-------------------");
            }

        }
        else{
            System.out.print("Digite o CPF do funcionário que deseja visualizar: ");
            String cpf = sc.nextLine();

            for(Funcionario funcionario : funcionarios){
                if(cpf.equals(funcionario.getCpf())){
                    System.out.println(funcionario);
                    return;
                }
            }

            System.out.println("Funcionário não encontrado com o CPF informado.");
        }
    }

    @Override
    public void alterar(Scanner sc) {
        if (funcionarios.isEmpty()){
            System.out.println("Nenhum funcionário cadastrado");
            return;
        }

        System.out.print("Digite o CPF do funcionário que deseja alterar: ");
        String cpf = sc.nextLine();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                int escolha;

                do {
                    System.out.println(" ---------------------------- ");
                    System.out.println("| ESCOLHA O QUE ALTERAR      |");
                    System.out.println(" ---------------------------- ");
                    System.out.println("| 1 - Nome                   |");
                    System.out.println("| 2 - Idade                  |");
                    System.out.println("| 3 - Email                  |");
                    System.out.println("| 4 - Horas Trabalhadas      |");
                    System.out.println("| 5 - Valor Hora             |");
                    System.out.println("| 6 - Status                 |");
                    System.out.println(" ---------------------------- ");
                    System.out.println("| 7 - Sair                   |");
                    System.out.println(" ---------------------------- ");
                    System.out.print("Escolha: ");

                    escolha = sc.nextInt();
                    sc.nextLine();

                    while (escolha > 7 || escolha < 1) {
                        System.out.print("Digite de 1 a 7 apenas: ");
                        escolha = sc.nextInt();
                        sc.nextLine();
                    }

                    switch (escolha) {
                        case 1:
                            System.out.print("Digite o novo nome: ");
                            funcionario.setNome(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Digite a nova idade: ");
                            funcionario.setIdade(sc.nextInt());
                            sc.nextLine();
                            break;
                        case 3:
                            System.out.print("Digite o novo email: ");
                            funcionario.setEmail(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Digite a nova quantidade de horas trabalhadas: ");
                            funcionario.setHorasTrabalhadas(sc.nextDouble());
                            sc.nextLine();
                            break;
                        case 5:
                            System.out.print("Digite o novo valor-hora do funcionário: ");
                            funcionario.setValorHora(sc.nextDouble());
                            sc.nextLine();
                            break;
                        case 6:
                            System.out.println(" ---------------------------- ");
                            System.out.println("| ESCOLHA O NOVO STATUS      |");
                            System.out.println(" ---------------------------- ");
                            System.out.println("| 1 - ATIVO                  |");
                            System.out.println("| 2 - FÉRIAS                 |");
                            System.out.println("| 3 - AFASTADO               |");
                            System.out.println("| 4 - DESLIGADO              |");
                            System.out.println(" ---------------------------- ");
                            System.out.print("Escolha o status: ");

                            int escolhaStatus = sc.nextInt();
                            sc.nextLine();

                            while (escolhaStatus > 4 || escolhaStatus < 1) {
                                System.out.print("Digite de 1 a 4 apenas: ");
                                escolhaStatus = sc.nextInt();
                                sc.nextLine();
                            }

                            switch(escolhaStatus) {
                                case 1:
                                    funcionario.setStatus(Status.ATIVO);
                                    break;
                                case 2:
                                    funcionario.setStatus(Status.FERIAS);
                                    break;
                                case 3:
                                    funcionario.setStatus(Status.AFASTADO);
                                    break;
                                case 4:
                                    funcionario.setStatus(Status.DESLIGADO);
                                    break;
                            }
                            break;
                        case 7:
                            System.out.println("Saindo do modo de edição...");
                            break;
                    }
                } while (escolha != 7);
                return;
            }
        }

        System.out.println("Funcionário não encontrado.");
    }

    @Override
    public void excluir(Scanner sc) {
        if (funcionarios.isEmpty()){
            System.out.println("Nenhum funcionário cadastrado");
            return;
        }

        System.out.print("Digite o CPF do funcionário que deseja excluir: ");
        String cpf = sc.nextLine();

        for(int i = 0; i < funcionarios.size(); i++){
            if(funcionarios.get(i).getCpf().equals(cpf)){
                funcionarios.remove(i);
                System.out.println("Funcionário removido");
                return;
            }
        }

        System.out.println("Funcionário não encontrado");
    }
}
