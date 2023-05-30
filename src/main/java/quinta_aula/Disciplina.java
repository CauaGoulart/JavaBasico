package quinta_aula;

public class Disciplina {
	private String nome;
	private int cargaHoraria;
	private Professor professorLeciona;

	public Disciplina(String nome, int cargaHoraria, Professor professorLeciona) {
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.professorLeciona = professorLeciona;
	}

	public String getNome() {
		return nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public Professor getProfessorLeciona() {
		return professorLeciona;
	}
}