package terceira_aula;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		int op = 0;
		List<Time> times = new ArrayList<Time>();

		do {
			op = Util.escolheOP();

			switch (op) {
			case 1:
				int acaoTime = Util.escolheTimeExistente();

				switch (acaoTime) {
				case 1:
					Time timeExistente = Util.escolheTimes(times);
					if (timeExistente != null) {
						timeExistente.cadastrarJogador();
					} else {
						Time novoTime = new Time();
						novoTime.cadastrarTime();
						novoTime.cadastrarJogador();
						times.add(novoTime);
					}
					break;
				case 2:
					Time novoTime = new Time();
					novoTime.cadastrarTime();
					novoTime.cadastrarJogador();
					times.add(novoTime);
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
				break;
			case 2:
				if (times.isEmpty()) {
					System.out.println("Nenhum time cadastrado.");
				} else {
					Time timeEscolhido = Util.escolheTimes(times);
					Util.listarJogadores(timeEscolhido);
				}
				break;
			case 3:
				if (times.isEmpty()) {
					System.out.println("Nenhum time cadastrado.");
				} else {
					Jogador artilheiro = Util.buscarArtilheiro(times);
					if (artilheiro != null) {
						System.out.println("Artilheiro do campeonato:");
						System.out.println("Nome: " + artilheiro.getNome());
						System.out.println("Número da camisa: " + artilheiro.getNumeroCamisa());
						System.out.println("Quantidade de gols no campeonato: " + artilheiro.getQuantGolsCampeonato());
					} else {
						System.out.println("Nenhum jogador cadastrado.");
					}
				}
				break;
			case 4:
				if (times.isEmpty()) {
					System.out.println("Nenhum time cadastrado.");
				} else {
					Time timeComMaisGols = Util.buscarTimeComMaisGols(times);
					if (timeComMaisGols != null) {
						System.out.println("Time com mais gols: Time " + (times.indexOf(timeComMaisGols) + 1));
					} else {
						System.out.println("Não foi possível determinar o time com mais gols.");
					}
				}
				break;
			default:
				if (op > 5) {
					JOptionPane.showMessageDialog(null, "Opção Invalida");
				}
				break;
			}
		} while (op != 5);
	}
}
