package terceira_aula;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


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
		setNome(solicitarString("Insira o nome do Time:"));
	}
	
	private String solicitarString(String mensagem) {
		String input = JOptionPane.showInputDialog(mensagem);
		while (input.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, digite novamente.");
			input = JOptionPane.showInputDialog(mensagem);
		}
		return input;
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

   
