package terceira_aula;

import java.util.ArrayList;
import java.util.List;

public class Time {
	public String nome;
	private List<Jogador> time = new ArrayList<Jogador>();
	private int totalGols;

	public void cadastrarJogador() {
		Jogador jogador = new Jogador();
		jogador.cadastro();
		time.add(jogador);
		totalGols += jogador.getQuantGolsCampeonato();
	}

	public void cadastrarTime() {
		setNome(Util.solicitarString("Insira o nome do Time:"));
	}

	public static void listarJogadores(Time time) {
		System.out.println("Jogadores do time:" + time.getNome());

		for (Jogador jogador : time.getTime()) {
			System.out.println("Nome: " + jogador.getNome());
			System.out.println("Número da camisa: " + jogador.getNumeroCamisa());
			System.out.println("Quantidade de gols no campeonato: " + jogador.getQuantGolsCampeonato());
			System.out.println();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Jogador> getTime() {
		return time;
	}

	public int getTotalGols() {
		return totalGols;
	}

	public void setTotalGols(int totalGols) {
		this.totalGols = totalGols;
	}

}
