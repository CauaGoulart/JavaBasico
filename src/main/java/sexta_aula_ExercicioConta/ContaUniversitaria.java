package sexta_aula_ExercicioConta;

public class ContaUniversitaria extends Conta {
	public ContaUniversitaria(int numero, int agencia, String nomeDoCorrentista) {
		super(numero, agencia, nomeDoCorrentista);
	}

	public void deposito(double valor) {
		if (saldo + valor <= 2000) {
			saldo += valor;
		}
	}
}
