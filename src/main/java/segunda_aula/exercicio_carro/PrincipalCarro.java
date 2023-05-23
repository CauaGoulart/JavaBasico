package segunda_aula.exercicio_carro;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PrincipalCarro {
	static List<Carro> carros = new ArrayList<Carro>();

	public static void main(String[] args) {
	

		int opcao = 0;
		do {
			String menu = "1 - Cadastrar Carro.\n" + "2 - Listar os carros por periodo de fabricação.\n"
					+ "3 - Listar carros por marca.\n" + "4 - Listar carros por cor.\n\n" + "5 - Sair";
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

			switch (opcao) {

			case 1:
				Carro c = new Carro();
				c.cadastra();
				carros.add(c);
				break;

			case 2:
				String periodoInicial = JOptionPane.showInputDialog("Digite o ano de início.");
				int comeco = Integer.parseInt(periodoInicial);
				String periodoFinal = JOptionPane.showInputDialog("Digite o ano final");
				int fim = Integer.parseInt(periodoFinal);
				String fabricacao = "";

				int totalCarros = carros.size();
				int totalCarrosFabricacao = 0;

				for (Carro carro : carros) {
					if (carro.getAno() >= comeco && carro.getAno() <= fim) {
						fabricacao += carro.getMarca() + ": " + carro.getAno() + "\n";
						totalCarrosFabricacao++;
					}
				}

				JOptionPane.showMessageDialog(null, fabricacao);

				double percentualCarrosFabricacao = (double) totalCarrosFabricacao / totalCarros * 100;
				String mensagemPercentual = String.format("Percentual de carros no período de fabricação: %.2f%%",
						percentualCarrosFabricacao);
				JOptionPane.showMessageDialog(null, mensagemPercentual);
				break;

			case 3:
				String marca = "";
				int totalMarca = carros.size();
				int contadorMarca = 0;
				String pesquisa = JOptionPane.showInputDialog("Digite a marca que deseja procurar.").toUpperCase();
				for (Carro carro : carros) {
					if(pesquisa.equals(carro.getMarca())){
					marca += carro.getMarca() + "\n";
					contadorMarca++;
					}
				}

				JOptionPane.showMessageDialog(null, marca);
				
				double percentualCarrosMarca = (double) contadorMarca / totalMarca * 100;
				String percentualMarca = String.format("Percentual de carros no período de fabricação: %.2f%%",
						percentualCarrosMarca);
				JOptionPane.showMessageDialog(null, percentualMarca);
				break;

			case 4:
				String cor = "";

				for (Carro carro : carros) {
					cor += carro.getMarca() + ":" + carro.getCor() + "\n";
				}

				JOptionPane.showMessageDialog(null, cor);
				break;
			default:
				if (opcao > 5) {
					JOptionPane.showMessageDialog(null, "Opção Invalida");
				}
			}
		} while (opcao != 5);

	}

}
