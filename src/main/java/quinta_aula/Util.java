package quinta_aula;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Util {
	public static void cadastrarProfessor(List<Professor> professores, String nome, NivelGraduacao nivelGraduacao) {
	    if (nome != null && !nome.isEmpty()) {
	        Professor professor = new Professor(nome, nivelGraduacao);
	        professores.add(professor);
	    }
	}


	public static void cadastrarAluno(List<Aluno> alunos, String nome) {
		Aluno aluno = new Aluno(nome);
		alunos.add(aluno);
	}

	public static void cadastrarDisciplina(List<Disciplina> disciplinas, List<Professor> professores, String nome,
			int cargaHoraria, Professor professor) {
		Disciplina disciplina = new Disciplina(nome, cargaHoraria, professor);
		disciplinas.add(disciplina);
	}

	public static void escolherDisciplinas(List<Disciplina> disciplinas, Aluno aluno,
			List<Disciplina> disciplinasEscolhidas) {
		for (Disciplina disciplina : disciplinasEscolhidas) {
			if (disciplinas.contains(disciplina)) {
				aluno.getDisciplinas().add(disciplina);
			}
		}
	}

	public static void informarNotasAluno(Aluno aluno, Disciplina disciplina, List<Double> notas) {
		aluno.getNotas().put(disciplina, notas);
	}

	public static List<String> listarDisciplinasComMediaAluno(Aluno aluno) {
		List<String> disciplinasComMedia = new ArrayList<>();

		return disciplinasComMedia;
	}

	public static List<Disciplina> listarDisciplinasComPosGraduacao(List<Disciplina> disciplinas) {
	    List<Disciplina> disciplinasPosGraduacao = disciplinas.stream()
	            .filter(d -> d.getProfessorLeciona().getFormacao() == NivelGraduacao.POS_GRADUACAO)
	            .collect(Collectors.toList());

	    return disciplinasPosGraduacao;
	}
	public static List<String> listarDisciplinasComNotasAluno(Aluno aluno) {
		List<String> disciplinasComNotas = new ArrayList<>();

		for (Map.Entry<Disciplina, List<Double>> entry : aluno.getNotas().entrySet()) {
			Disciplina disciplina = entry.getKey();
			List<Double> notas = entry.getValue();

			StringBuilder disciplinaComNotas = new StringBuilder();
			disciplinaComNotas.append("Disciplina: ").append(disciplina.getNome()).append("\n");
			disciplinaComNotas.append("Notas: ").append(notas.toString()).append("\n");

			disciplinasComNotas.add(disciplinaComNotas.toString());
		}

		return disciplinasComNotas;
	}

}
