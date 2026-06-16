import entidades.Aluno;
import entidades.empregados.Status;
import entidades.empregados.funcionario.Funcionario;
import entidades.empregados.professor.Materia;
import entidades.empregados.professor.Professor;
import gerenciador.GerenciadorAluno;
import gerenciador.GerenciadorFuncionario;
import gerenciador.GerenciadorProfessor;
import menu.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Programa {
    // Ponto de entrada do sistema
    // Inicializa objetos base e inicia o menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Materia m1 = new Materia("Matematica", 60.0, 1);
        Materia m2 = new Materia("Português", 54.6, 2);
        Materia m3 = new Materia("Historia", 50.0, 3);
        Materia m4 = new Materia("Fisica", 56.5, 4);
        Materia m5 = new Materia("Geografia", 48.9, 5);
        List<Materia> materias = new ArrayList<>(Arrays.asList(m1, m2, m3, m4, m5));

        List<Aluno> alunosIniciais = new ArrayList<>(Arrays.asList(
                new Aluno("Ana Silva", 15, "111.111.111-11", "ana@gmail.com", 8.5, 9.0, 7.5),
                new Aluno("Carlos Souza", 16, "222.222.222-22", "carlos@gmail.com", 6.0, 7.5, 8.0),
                new Aluno("Beatriz Lima", 14, "333.333.333-33", "bia@gmail.com", 9.5, 10.0, 9.0),
                new Aluno("Daniel Costa", 17, "444.444.444-44", "daniel@gmail.com", 5.5, 6.0, 7.0),
                new Aluno("Eduarda Alves", 15, "555.555.555-55", "eduarda@gmail.com", 7.0, 7.5, 8.5),
                new Aluno("Felipe Rocha", 16, "666.666.666-66", "felipe@gmail.com", 10.0, 9.5, 8.5),
                new Aluno("Gabriela Mendes", 14, "777.777.777-77", "gabi@gmail.com", 8.0, 8.5, 9.0)
        ));

        List<Funcionario> funcionariosIniciais = new ArrayList<>(Arrays.asList(
                new Funcionario("João Pedro", 30, "888.888.888-88", "joao@escola.com", 40.0, 35.0, Status.ATIVO),
                new Funcionario("Maria Clara", 45, "999.999.999-99", "maria@escola.com", 40.0, 40.0, Status.ATIVO),
                new Funcionario("José Santos", 50, "101.010.101-10", "jose@escola.com", 40.0, 30.0, Status.FERIAS),
                new Funcionario("Lucia Ferreira", 38, "202.020.202-20", "lucia@escola.com", 30.0, 25.0, Status.ATIVO),
                new Funcionario("Paulo Gomes", 42, "303.030.303-30", "paulo@escola.com", 40.0, 50.0, Status.AFASTADO),
                new Funcionario("Fernanda Lima", 28, "404.040.404-40", "fernanda@escola.com", 20.0, 20.0, Status.ATIVO),
                new Funcionario("Ricardo Nunes", 35, "505.050.505-50", "ricardo@escola.com", 40.0, 45.0, Status.ATIVO)
        ));

        Professor p1 = new Professor("Roberto Silva", 40, "606.060.606-60", "roberto@escola.com", 40.0, Status.ATIVO, m1);
        Professor p2 = new Professor("Sonia Alves", 35, "707.070.707-70", "sonia@escola.com", 30.0, Status.ATIVO, m2);
        Professor p3 = new Professor("Tiago Moura", 48, "808.080.808-80", "tiago@escola.com", 40.0, Status.FERIAS, m3);
        Professor p4 = new Professor("Vanessa Dias", 32, "909.090.909-90", "vanessa@escola.com", 20.0, Status.ATIVO, m4);
        Professor p5 = new Professor("Wellington Paz", 55, "112.233.445-56", "wellington@escola.com", 40.0, Status.ATIVO, m5);
        Professor p6 = new Professor("Ximena Cruz", 29, "998.877.665-54", "ximena@escola.com", 30.0, Status.ATIVO, m1);
        Professor p7 = new Professor("Yuri Castro", 41, "554.433.221-10", "yuri@escola.com", 40.0, Status.AFASTADO, m2);

        m1.adicionarProfessor(p1);
        m2.adicionarProfessor(p2);
        m3.adicionarProfessor(p3);
        m4.adicionarProfessor(p4);
        m5.adicionarProfessor(p5);
        m1.adicionarProfessor(p6);
        m2.adicionarProfessor(p7);

        List<Professor> professoresIniciais = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));

        GerenciadorAluno gerenciadorAluno = new GerenciadorAluno(alunosIniciais);
        GerenciadorFuncionario gerenciadorFuncionario = new GerenciadorFuncionario(funcionariosIniciais);
        GerenciadorProfessor gerenciadorProfessor = new GerenciadorProfessor(materias, professoresIniciais);

        Menu menu = new Menu(gerenciadorAluno, gerenciadorFuncionario, gerenciadorProfessor, sc);

        menu.iniciar();
    }
}
