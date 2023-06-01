package sexta_aula_ExercicioConta;

import java.util.ArrayList;
import java.util.List;

public class Caixa {

	public List<Conta> contas = new ArrayList<Conta>();

	public void addConta(Conta c) {
		contas.add(c);
	}

	public static void deposito(Conta conta, double valor) {
		conta.deposito(valor);
	}

	public static void saque(Conta conta, double valor) {
		conta.saque(valor);
	}

	public static void transferencia(Conta contaOrigem, Conta contaDestino, double valor) {
		contaOrigem.transferencia(valor, contaDestino);
	}
}
