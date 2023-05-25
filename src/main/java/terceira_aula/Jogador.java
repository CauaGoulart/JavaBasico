package terceira_aula;

import javax.swing.JOptionPane;

public class Jogador {
	private String nome;
	private int numeroCamisa;
	private int quantGolsCampeonato;

	public void cadastro() {
		setNome(solicitarString("Insira o nome do jogador:"));
		setNumeroCamisa(solicitarInteiro("Insira o número da camisa:"));
		setQuantGolsCampeonato(solicitarInteiro("Insira a quantidade de gols que o jogador fez no campeonato:"));
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

	private String solicitarString(String mensagem) {
		String input = JOptionPane.showInputDialog(mensagem);
		while (input.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, digite novamente.");
			input = JOptionPane.showInputDialog(mensagem);
		}
		return input;
	}

	private int solicitarInteiro(String mensagem) {
		String input = JOptionPane.showInputDialog(mensagem);
		while (input.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, digite novamente.");
			input = JOptionPane.showInputDialog(mensagem);
		}
		return Integer.parseInt(input);
	}
}
