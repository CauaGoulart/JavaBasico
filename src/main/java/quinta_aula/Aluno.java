package quinta_aula;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aluno {
	private String nome;
	private List<Disciplina> disciplinas;
	private Map<Disciplina, List<Double>> notas;

	public Aluno(String nome) {
		this.nome = nome;
		this.disciplinas = new ArrayList<>();
		this.notas = new HashMap<>();
	}

	public String getNome() {
		return nome;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public Map<Disciplina, List<Double>> getNotas() {
		return notas;
	}

	public void matricularDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
		notas.put(disciplina, new ArrayList<>());
	}

	public void cadastrarNota(Disciplina disciplina, double nota) {
		List<Double> notasDisciplina = notas.get(disciplina);
		notasDisciplina.add(nota);
	}
}
