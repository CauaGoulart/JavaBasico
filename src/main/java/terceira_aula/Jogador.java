package terceira_aula;

public class Jogador {
	private String nome;
	private int numeroCamisa;
	private int quantGolsCampeonato;

	public void cadastro() {
		setNome(Util.solicitarString("Insira o nome do jogador:"));
		setNumeroCamisa(Util.solicitarInteiro("Insira o número da camisa:"));
		setQuantGolsCampeonato(Util.solicitarInteiro("Insira a quantidade de gols que o jogador fez no campeonato:"));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroCamisa() {
		return numeroCamisa;
	}

	public void setNumeroCamisa(int numeroCamisa) {
		this.numeroCamisa = numeroCamisa;
	}

	public int getQuantGolsCampeonato() {
		return quantGolsCampeonato;
	}

	public void setQuantGolsCampeonato(int quantGolsCampeonato) {
		this.quantGolsCampeonato = quantGolsCampeonato;
	}

}
