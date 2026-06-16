import entidades.empregados.professor.Materia;
import gerenciador.GerenciadorAluno;
import gerenciador.GerenciadorFuncionario;
import gerenciador.GerenciadorProfessor;
import menu.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Materia> materias = new ArrayList<>(Arrays.asList(
                new Materia("Matematica", 60.0, 1),
                new Materia("Português", 54.6, 2),
                new Materia("Historia", 50.0, 3),
                new Materia("Fisica", 56.5, 4),
                new Materia("Geografia", 48.9, 5)
        ));

        GerenciadorAluno gerenciadorAluno = new GerenciadorAluno();
        GerenciadorFuncionario gerenciadorFuncionario = new GerenciadorFuncionario();
        GerenciadorProfessor gerenciadorProfessor = new GerenciadorProfessor(materias);

        Menu menu = new Menu(gerenciadorAluno, gerenciadorFuncionario, gerenciadorProfessor, sc);

        menu.iniciar();
    }
}
