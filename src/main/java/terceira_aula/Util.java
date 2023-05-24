package terceira_aula;

import javax.swing.JOptionPane;

public class Util {
	static int escolheOP() {
		String menu = "1 – Cadastrar times\n"
				+ "2 – Listar todos jogadores de um time\n"
				+ "3 – Verificar artilheiro do campeonato\n"
				+ "4 – Verificar qual time fez mais gols no campeonato\n"
				+ "5 – Sair\n";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
}
