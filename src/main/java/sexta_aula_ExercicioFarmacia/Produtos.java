package sexta_aula_ExercicioFarmacia;

import lombok.Getter;

@Getter
public class Produtos {
	protected String nome;
	protected int estoque;
	protected double valor;

	public Produtos(String nome, int estoque, double valor) {
		this.nome = nome;
		this.estoque = estoque;
		this.valor = valor;

	}

	public String getNome() {
		return nome;
	}

	public int getEstoque() {
		return estoque;
	}

	public double getValor() {
		return valor;
	}

	public boolean podeVender(double saldoDevedor) {
		return estoque > 0;
	}

	public void setEstoque(int valor) {
		this.estoque = valor;
	}
}
