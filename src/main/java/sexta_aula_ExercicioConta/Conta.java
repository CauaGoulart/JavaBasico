package sexta_aula_ExercicioConta;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Conta {
	private int numero;
	private int agencia;
	private String nomeDoCorrentista;
	protected double saldo;

	public Conta(int numero, int agencia, String nomeDoCorrentista) {
		this.numero = numero;
		this.agencia = agencia;
		this.nomeDoCorrentista = nomeDoCorrentista;
		this.saldo = 0;
	}

	public void deposito(double valor) {
		saldo = getSaldo() + valor;
	}

	public void saque(double valor) {
		if (getSaldo() >= valor) {
			saldo -= valor;
		}
	}

	public void transferencia(double valor, Conta contaDestino) {
		if (saldo >= valor) {
			saldo -= valor;
			contaDestino.deposito(valor);
		} else {
			deposito(valor);
		}
	}

	public double getSaldo() {
		return saldo;
	}

	public String getNome() {
		return nomeDoCorrentista;
	}

}
