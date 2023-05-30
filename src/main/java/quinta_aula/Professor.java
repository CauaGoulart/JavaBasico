package quinta_aula;

import java.util.ArrayList;
import java.util.List;

public class Professor {
	private String nome;
	private NivelGraduacao formacao;
	private List<Disciplina> disciplinasLecionadas;

	public Professor(String nome, NivelGraduacao formacao) {
		this.nome = nome;
		this.formacao = formacao;
		this.disciplinasLecionadas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public NivelGraduacao getFormacao() {
		return formacao;
	}

	public List<Disciplina> getDisciplinasLecionadas() {
		return disciplinasLecionadas;
	}

	public void cadastrarDisciplina(Disciplina disciplina) {
		disciplinasLecionadas.add(disciplina);
	}
	
	
}
