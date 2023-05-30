import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import quinta_aula.Aluno;
import quinta_aula.Disciplina;
import quinta_aula.NivelGraduacao;
import quinta_aula.Professor;
import quinta_aula.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilTest {

	@Test
	@DisplayName("Teste para Cadastrar professor")
	public void testCadastrarProfessor() {
		List<Professor> professores = new ArrayList<>();
		Util.cadastrarProfessor(professores, "João", NivelGraduacao.GRADUACAO);
		Assertions.assertEquals(1, professores.size());
		Assertions.assertEquals("João", professores.get(0).getNome());
	}

	@Test
	@DisplayName("Teste para Cadastrar o aluno")
	public void testCadastrarAluno() {
		List<Aluno> alunos = new ArrayList<>();
		Util.cadastrarAluno(alunos, "Maria");
		Assertions.assertEquals(1, alunos.size());
	}

	@Test
	@DisplayName("Teste para Cadastrar a disciplina")
	public void testCadastrarDisciplina() {
		List<Disciplina> disciplinas = new ArrayList<>();
		List<Professor> professores = new ArrayList<>();
		Professor professor = new Professor("João", NivelGraduacao.GRADUACAO);
		professores.add(professor);

		Util.cadastrarDisciplina(disciplinas, professores, "Matemática", 60, professor);
		Assertions.assertEquals(1, disciplinas.size());
	}

	@Test
	@DisplayName("Teste para escolher disciplina")
	public void testEscolherDisciplinas() {
		List<Disciplina> disciplinas = new ArrayList<>();
		Professor professor = new Professor("João", NivelGraduacao.GRADUACAO);
		Disciplina disciplina = new Disciplina("Matemática", 60, professor);
		disciplinas.add(disciplina);

		List<Disciplina> disciplinasEscolhidas = new ArrayList<>();
		disciplinasEscolhidas.add(disciplina);

		Aluno aluno = new Aluno("Maria");
		Util.escolherDisciplinas(disciplinas, aluno, disciplinasEscolhidas);
		Assertions.assertEquals(1, aluno.getDisciplinas().size());
	}

	@Test
	@DisplayName("Teste para informar a nota dos alunos")
	public void testInformarNotasAluno() {
		Aluno aluno = new Aluno("Maria");
		Disciplina disciplina = new Disciplina("Matemática", 60, new Professor("João", NivelGraduacao.GRADUACAO));
		List<Double> notas = Arrays.asList(7.5, 8.0, 6.5);

		Util.informarNotasAluno(aluno, disciplina, notas);
		Assertions.assertEquals(3, aluno.getNotas().get(disciplina).size());
	}

	@Test
	@DisplayName("Teste para listar as disciplinas de um aluno com a nota obtida por ele")
	public void testListarDisciplinasComNotasAluno() {
		Aluno aluno = new Aluno("Maria");
		Disciplina disciplina1 = new Disciplina("Matemática", 60, new Professor("João", NivelGraduacao.GRADUACAO));
		Disciplina disciplina2 = new Disciplina("Física", 60, new Professor("Carlos", NivelGraduacao.POS_GRADUACAO));

		List<Double> notas1 = Arrays.asList(7.5, 8.0, 6.5);
		List<Double> notas2 = Arrays.asList(6.0, 7.0, 7.5);

		aluno.getNotas().put(disciplina1, notas1);
		aluno.getNotas().put(disciplina2, notas2);

		List<String> disciplinasComNotas = Util.listarDisciplinasComNotasAluno(aluno);
		Assertions.assertEquals(2, disciplinasComNotas.size());
	}
	
	@Test
	@DisplayName("Teste para listar as disciplinas com professores que tenham pos graduação")

	public void testListarDisciplinasComPosGraduacao() {
		Professor professor1 = new Professor("João", NivelGraduacao.GRADUACAO);
		Professor professor2 = new Professor("Carlos", NivelGraduacao.ESPECIALIZACAO);
		Professor professor3 = new Professor("Ana", NivelGraduacao.POS_GRADUACAO);

		Disciplina disciplina1 = new Disciplina("Matemática", 60, professor1);
		Disciplina disciplina2 = new Disciplina("Física", 60, professor2);
		Disciplina disciplina3 = new Disciplina("Química", 60, professor3);

		List<Disciplina> disciplinas = Arrays.asList(disciplina1, disciplina2, disciplina3);

		List<Disciplina> disciplinasComPosGraduacao = Util.listarDisciplinasComPosGraduacao(disciplinas);

		Assertions.assertEquals(1, disciplinasComPosGraduacao.size());
		Assertions.assertTrue(disciplinasComPosGraduacao.contains(disciplina3));
	}

	@Test
	@DisplayName("Teste para Cadastrar professor inexistente")
	public void testCadastrarProfessorInesistente() {
		List<Professor> professores = new ArrayList<>();
		Util.cadastrarProfessor(professores, null, NivelGraduacao.GRADUACAO);
		Assertions.assertEquals(0, professores.size());
	}

	@Test
	@DisplayName("Teste para escolher disciplina inexistente")
	public void testEscolherDisciplinasInesistente() {
		List<Disciplina> disciplinas = new ArrayList<>();
		Professor professor = new Professor("João", NivelGraduacao.GRADUACAO);
		Disciplina disciplina = new Disciplina("Matemática", 60, professor);
		disciplinas.add(disciplina);

		List<Disciplina> disciplinasEscolhidas = new ArrayList<>();
		disciplinasEscolhidas.add(new Disciplina("Física", 60, professor));

		Aluno aluno = new Aluno("Maria");
		Util.escolherDisciplinas(disciplinas, aluno, disciplinasEscolhidas);
		Assertions.assertEquals(0, aluno.getDisciplinas().size());
	}

	@Test
	@DisplayName("Teste para informar se esta faltando nota")
	public void testInformarNotasAlunoInesistente() {
		Aluno aluno = new Aluno("Maria");
		Disciplina disciplina = new Disciplina("Matemática", 60, new Professor("João", NivelGraduacao.GRADUACAO));
		List<Double> notas = Arrays.asList(7.5, 8.0);

		Util.informarNotasAluno(aluno, disciplina, notas);
		Assertions.assertEquals(1, aluno.getNotas().size());
	}
	
	@Test
	@DisplayName("Teste reverso para listar as disciplinas de um aluno com a nota que não existe")
	public void testListarDisciplinasComNotasAlunoInesistente() {
	    Aluno aluno = new Aluno("Maria");

	    List<String> disciplinasComNotas = Util.listarDisciplinasComNotasAluno(aluno);
	    Assertions.assertTrue(disciplinasComNotas.isEmpty());
	}
}
