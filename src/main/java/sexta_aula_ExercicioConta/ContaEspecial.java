package sexta_aula_ExercicioConta;

public class ContaEspecial extends Conta {
	protected double limite;

	public ContaEspecial(int numero, int agencia, String nomeDoCorrentista, double limite) {
		super(numero, agencia, nomeDoCorrentista);
		this.limite = limite;
	}

	@Override
	public void saque(double valor) {
		if (saldo >= valor || saldo + limite >= valor) {
			saldo -= valor;
		}
	}

}
