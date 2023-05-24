package segunda_aula.exercicio_carro;

import javax.swing.JOptionPane;

enum cores {
	Azul, Verde, Laranja, Vermelho,
}

public class Carro {
	String marca;
	int ano;
	cores cor;

	void cadastra() {
		marca = JOptionPane.showInputDialog("Marca").toUpperCase();
		ano = Integer.parseInt(JOptionPane.showInputDialog("Ano"));
		int opcao = Integer
				.parseInt(JOptionPane.showInputDialog("Escolha uma cor.\n1-Azul\n2-Verde\n3-Laranja\n4-Vermelho"));

		switch (opcao) {
		case 1:
			cor = cores.Azul;
			break;
		case 2:
			cor = cores.Verde;
			break;
		case 3:
			cor = cores.Laranja;
			break;
		case 4:
			cor = cores.Vermelho;
			break;

		}

	}

	public String getMarca() {
		return marca;
	}

	public int getAno() {
		return ano;
	}

	public cores getCor() {
		return cor;
	}
}