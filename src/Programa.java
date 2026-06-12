import Entidades.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Programa {

    //Menu que retorna a escolha do tipo de Categoria que a pessoa quer executar a operação
    public static int tipoEscolha(Scanner sc){
        int escolha;

        System.out.println(" ---------------------------- ");
        System.out.println("| ESCOLHA O TIPO DE OPERAÇÃO |");
        System.out.println(" ---------------------------- ");
        System.out.println("| 1 - Aluno                  |");
        System.out.println("| 2 - Professor              |");
        System.out.println("| 3 - Funcionario            |");
        System.out.println(" ---------------------------- ");
        System.out.print("Escolha: ");
        escolha = sc.nextInt();

        while (escolha > 3 || escolha < 1){
            System.out.print("Digite uma opção válida: ");
            escolha = sc.nextInt();
        }

        return escolha;
    }


    // ------ CADASTROS -------
    public static Professor cadastroProfessor(Scanner sc, ArrayList<Materia> materia) {
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

        Professor professor = null;
        for (Materia m : materia) {
            if (m.getIdMateria().equals(disciplina)) {
                professor = new Professor(nome, idade, cpf, email, horas, m);
                m.adicionarProfessor(professor);
            }
        }
        return professor;
    }

    //Função para cadastrar nova matéria que o professor pode ter
    public static ArrayList<Materia> cadastroMateria(){
        ArrayList<Materia> disciplinas = new ArrayList<>(); //Sempre da para adicionar uma nova materia caso precise

        Materia matematica = new Materia("Matematica", 60.0, 1);
        Materia portugues = new Materia("Português", 54.6, 2);
        Materia historia = new Materia("Historia", 50.0, 3);
        Materia fisica = new Materia("Fisica", 56.5, 4);
        Materia geografia = new Materia("Geografia", 48.9, 5);

        disciplinas.add(matematica);
        disciplinas.add(portugues);
        disciplinas.add(historia);
        disciplinas.add(fisica);
        disciplinas.add(geografia);

        return disciplinas;
    }

    //Função para cadastrar Aluno
    public static Aluno cadastroAluno(Scanner sc) {
            //Inserção das informações de aluno
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

            return new Aluno (nome, idade, cpf, email, nota1, nota2, nota3);
    }

    //Função para cadastrar Funcionario
    public static void cadastroFuncionario(){

    }


    // ------ VISUALIZADORES -------


    public static void visualizarProfessor(Scanner sc, ArrayList<Professor> professores){

        if (professores.isEmpty()){
            System.out.println("Nenhum professor cadastrado");
            return;
        }

        System.out.println();
        System.out.println("Digite 1 para visualizar todos os professores");
        System.out.println("Digite 2 para visualizar um professor em especifico");
        System.out.print("Escolha: ");
        int escolha = sc.nextInt();

        while (escolha > 2 || escolha < 1){
            System.out.print("Digite 1 ou 2 apenas: ");
            escolha = sc.nextInt();
        }

        sc.nextLine();

        System.out.println();
        if (escolha == 1){
            for(Professor p : professores){
                if (p != null) {
                    System.out.println(p.toString());
                    System.out.println("-------------------");
                }
            }

        }
        else{
            System.out.print("Digite o cpf do professor que deseja visualizar: ");
            String cpf = sc.nextLine();

            for(Professor p : professores){
                if(p != null && cpf.equals(p.getCpf())){
                    System.out.println(p.toString());
                }
            }

        }

    }

    public static void visualizarAluno(Scanner sc, ArrayList<Aluno> alunos){

            // Caso não haja nenhum objeto de aluno
            if (alunos.isEmpty()){
                System.out.println("Nenhum aluno cadastrado");
                return;
            }

            int escolha;

            //Escolha de tipo de vizualização de aluno
            System.out.println("Digite 1 para visualizar todos os alunos");
            System.out.print("Digite 2 para visualizar um aluno em específico");
            escolha = sc.nextInt();

            //Conduz o usuário a não digitar um numero diferente das alternativas
            while (escolha > 2 || escolha < 1){
                System.out.print("Digite 1 ou 2 apenas: ");
                escolha = sc.nextInt();
            }

            sc.nextLine();
            System.out.println();

            //Exibição de todos os alunos conforme a alternativa escolhida
            if (escolha == 1){
                for(Aluno a : alunos){
                    if (a != null) {
                        System.out.println(a.toString());
                        System.out.println("--------------------------------");
                    }
                }
            }
            //Exibição de um aluno específico através de busca por CPF conforme a alternativa escolhida
            else {
                System.out.print("Digite o cpf do aluno que deseja visualizar: ");
                String cpf = sc.nextLine();

                for(Aluno a : alunos){
                    if(a != null && a.getCpf().equals(cpf)){
                        System.out.println("\n" + a.toString());
                        return; // Encontrou o aluno, encerra o método
                    }
                }

                //Caso não haja um objeto de aluno cadastrado com o CPF inserido
                System.out.println("Aluno não encontrado com o CPF informado.");
            }
        }

    public static void visualizarFuncionario(){

    }

    // ------ ALTERADORES -------


    static void alterarProfessor(Scanner sc, ArrayList<Professor> professores){

        System.out.print("Digite o cpf do professor que deseja alterar: ");
        String cpf = sc.nextLine();

        for(Professor p : professores){
            if(p.getCpf().equals(cpf)){
                System.out.print("Digite o novo nome: ");
                p.setNome(sc.nextLine());

                System.out.print("Digite a nova idade: ");
                p.setIdade(sc.nextInt());
                sc.nextLine();

                System.out.print("Digite o novo email: ");
                p.setEmail(sc.nextLine());

                System.out.println("Digite a nova quantidade de horas trabalhadas: ");
                p.setHorasTrabalhadas(sc.nextDouble());

                System.out.println("Professor alterado");
                return;

                //Materia e cpf não devem ser alterados
                //Materia diferente implica em um novo contrato
                //CPF é geralmente validado por uma api antes da aprovação de sistemas
            }
        }

        System.out.println("Professor não encontrado");
    }

    public static void alterarAluno(Scanner sc, ArrayList<Aluno> alunos){

        //Busca o aluno o através do CPF para realizar alterações
        System.out.print("Digite o cpf do aluno que deseja alterar: ");
        String cpf = sc.nextLine();

        for(Aluno a : alunos){
            if(a.getCpf().equals(cpf)){
                int escolha;

                //Menu de escolha para qual informação deseja alterar
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
                    System.out.println("| 7 - Voltar                 |");
                    System.out.println(" ---------------------------- ");
                    System.out.print("Escolha: ");

                    escolha = sc.nextInt();
                    sc.nextLine();

                    //Conduz o usuário a não digitar um numero diferente das alternativas
                    while (escolha > 7 || escolha < 1){
                        System.out.print("Digite de 1 a 7 apenas: ");
                        escolha = sc.nextInt();
                        sc.nextLine();
                    }

                    //Inserção das novas informações com base na escolha selecionada no menu
                    switch(escolha){
                        case 1:
                            System.out.print("Digite o novo nome: ");
                            a.setNome(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Digite a nova idade: ");
                            a.setIdade(sc.nextInt());
                            sc.nextLine();
                            break;
                        case 3:
                            System.out.print("Digite o novo email: ");
                            a.setEmail(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Digite a nova nota 1: ");
                            a.setNota1(sc.nextDouble());
                            sc.nextLine();
                            break;
                        case 5:
                            System.out.print("Digite a nova nota 2: ");
                            a.setNota2(sc.nextDouble());
                            sc.nextLine();
                            break;
                        case 6:
                            System.out.print("Digite a nova nota 3: ");
                            a.setNota3(sc.nextDouble());
                            sc.nextLine();
                            break;
                        case 7:
                            break;
                    }
                } while(escolha != 7);

                return;
            }
        }

        //Caso não haja um objeto de aluno com o CPF inserido
        System.out.println("Aluno não encontrado");
    }

    public static void alterarFuncionario(){}


    public static void alterarFuncionario(){}


    // ------ EXCLUSÕES -------


    static void excluirProfessor(Scanner sc, ArrayList<Professor> professores){
        System.out.print("Digite o cpf do professor que deseja excluir: ");
        String cpf = sc.nextLine();

        for(int i = 0; i < professores.size(); i++){ //Com o for-each alterar a lista enquanto percorre pode dar erro
            if(professores.get(i).getCpf().equals(cpf)){
                professores.remove(i);
                System.out.println("Professor removido");
                return;
            }
        }

        System.out.println("Professor não encontrado");
    }

    static void excluirAluno(Scanner sc, ArrayList<Aluno> alunos) {
        // Caso não haja nenhum objeto de aluno
        if (alunos.isEmpty()){
            System.out.println("Nenhum aluno cadastrado");
            return;
        }

        //Busca o aluno o através do CPF para realizar a exclusão dele
        System.out.print("Digite o cpf do aluno que deseja excluir: ");
        String cpf = sc.nextLine();

        for(int i = 0; i < alunos.size(); i++){
            if(alunos.get(i).getCpf().equals(cpf)){
                alunos.remove(i);
                System.out.println("Aluno removido");
                return;
            }
        }

        //Caso não haja um objeto de aluno com o CPF inserido
        System.out.println("Aluno não encontrado");
    }

static void excluirFuncionario(){}


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        ArrayList<Materia> materia = cadastroMateria();

        ArrayList<Professor> listaProfessores = new ArrayList<>();

        ArrayList<Aluno> listaAlunos = new ArrayList<>();

        System.out.println("---- Bem vindo ao sistema de cadastro escolar ----");

        int escolha, tipo;

        //Menu com opções da ação do usuario
        do{
            System.out.println(" ---------------------------- ");
            System.out.println("|       MENU DE OPÇÕES       |");
            System.out.println(" ---------------------------- ");
            System.out.println("| 1 - Cadastrar              |");
            System.out.println("| 2 - Visualizar             |");
            System.out.println("| 3 - Alterar                |");
            System.out.println("| 4 - Excluir                |");
            System.out.println("| 5 - Sair                   |");
            System.out.println(" ---------------------------- ");

            System.out.print("Escolha: ");
            escolha = sc.nextInt();

            if (escolha == 5){
                System.out.println("Programa encerrado");
                break;
            }

            tipo = tipoEscolha(sc);
            sc.nextLine();

            //Switch aninhado
            switch (escolha){
                case 1:
                    switch (tipo){
                        case 1: Aluno novoAluno = cadastroAluno(sc);
                        listaAlunos.add (novoAluno);
                        break;

                        case 2:  Professor novoProfessor = cadastroProfessor(sc, materia);
                                listaProfessores.add(novoProfessor); //Sempre adicionado um novo professor a lista

                            break;

                        case 3: cadastroFuncionario();
                            break;
                    }
                    break;

                case 2:
                    switch (tipo){
                        case 1: visualizarAluno(sc, listaAlunos);
                            break;

                        case 2: visualizarProfessor(sc, listaProfessores);
                            break;

                        case 3: visualizarFuncionario();
                            break;
                    }
                    break;

                case 3:
                    switch (tipo){
                        case 1: alterarAluno(sc, listaAlunos);
                            break;

                        case 2: alterarProfessor(sc, listaProfessores);
                            break;

                        case 3: alterarFuncionario();
                            break;
                    }
                    break;

                case 4:
                    switch (tipo){
                        case 1: excluirAluno(sc, listaAlunos);
                            break;

                        case 2: excluirProfessor(sc, listaProfessores);
                            break;

                        case 3: excluirFuncionario();
                            break;
                    }
                    break;

                default:
                    System.out.println("Escolha invalida");
                    break;
            }
        } while (escolha != 5);

    }
}
