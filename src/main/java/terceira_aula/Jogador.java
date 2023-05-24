package terceira_aula;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

public class Jogador {
	private String nome;
	private int numeroCamisa;
	private int quantGolsCampeonato;

	void cadastro() {
		String nomeDigitado = JOptionPane.showInputDialog("Insira o nome do usuario.");
		int numeroCamisaDigitado = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da camisa."));
		int quantGolsCampeonatoDigitado = Integer
				.parseInt(JOptionPane.showInputDialog("Insira o nome de gols que o jogador fez."));

		setNome(nomeDigitado);
		setNumeroCamisa(numeroCamisaDigitado);
		setQuantGolsCampeonato(quantGolsCampeonatoDigitado);

	}

	public String getNome() {
		return nome;
	}

	public int getNumeroCamisa() {
		return numeroCamisa;
	}

	public int getQuantGolsCampeonato() {
		return quantGolsCampeonato;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumeroCamisa(int numeroCamisa) {
		this.numeroCamisa = numeroCamisa;
	}

	public void setQuantGolsCampeonato(int quantGolsCampeonato) {
		this.quantGolsCampeonato = quantGolsCampeonato;
	}

}
