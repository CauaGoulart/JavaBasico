package terceira_aula;

import java.util.List;

import javax.swing.JOptionPane;

public class Util {
	public static int escolheOP() {
		String menu = "1 – Cadastrar times\n" + "2 – Listar todos jogadores de um time\n"
				+ "3 – Verificar artilheiro do campeonato\n" + "4 – Verificar qual time fez mais gols no campeonato\n"
				+ "5 – Sair\n";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

	public static int escolheTimeExistente() {
		String menu = "Escolha a ação para o time:\n" + "1 - Adicionar jogador a um time existente\n"
				+ "2 - Criar um novo time\n";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

	public static Time escolheTimes(List<Time> times) {
		String menu = "Escolha um time:\n";
		int i = 0;
		for (Time time : times) {
			menu += (i + 1) + "-"+ time.getNome() + "\n";
		}
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return times.get(escolha - 1);
	}

	public static Jogador buscarArtilheiro(List<Time> times) {
		Jogador artilheiro = null;

		for (Time time : times) {
			for (Jogador jogador : time.getTime()) {
				if (artilheiro == null || jogador.getQuantGolsCampeonato() > artilheiro.getQuantGolsCampeonato()) {
					artilheiro = jogador;
				}
			}
		}

		return artilheiro;
	}

	public static String solicitarString(String mensagem) {
		String input = JOptionPane.showInputDialog(mensagem);
		while (input.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, digite novamente.");
			input = JOptionPane.showInputDialog(mensagem);
		}
		return input;
	}

	public static int solicitarInteiro(String mensagem) {
		String input = JOptionPane.showInputDialog(mensagem);
		while (input.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, digite novamente.");
			input = JOptionPane.showInputDialog(mensagem);
		}
		return Integer.parseInt(input);
	}

	public static Time buscarTimeComMaisGols(List<Time> times) {
		Time timeComMaisGols = null;

		for (Time time : times) {
			int somaGols = time.getTotalGols();

			if (timeComMaisGols == null || somaGols > timeComMaisGols.getTotalGols()) {
				timeComMaisGols = time;
			}
		}

		return timeComMaisGols;
	}

}
