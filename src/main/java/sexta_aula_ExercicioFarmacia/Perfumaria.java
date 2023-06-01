package sexta_aula_ExercicioFarmacia;

public class Perfumaria extends Produtos {
    public Perfumaria(String nome, int estoque, double valor) {
        super(nome, estoque, valor);
    }
    
    @Override
    public boolean podeVender(double saldoDevedor) {
        return estoque > 0 && saldoDevedor < 300.0;
    }

	public void setEstoque(int valor) {
		this.estoque = valor;
		
	}
}