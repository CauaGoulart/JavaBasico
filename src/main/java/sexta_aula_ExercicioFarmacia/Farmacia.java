package sexta_aula_ExercicioFarmacia;

import java.util.ArrayList;
import java.util.List;

public class Farmacia {
	public List<Produtos> produtos = new ArrayList<>();
	public List<Cliente> clientes = new ArrayList<>();

	public void cadastrarProduto(Produtos produto) {
		produtos.add(produto);
	}

	public void cadastrarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public void realizarVenda(Cliente cliente, Produtos produto, int quantidade, String nomeMedico) {
		if (produto instanceof Medicamento) {
			Medicamento medicamento = (Medicamento) produto;
			if (medicamento.podeVender(cliente.getSaldoDevedor()) && medicamento.getEstoque() >= quantidade) {
				double valorTotal = produto.getValor() * quantidade;
				cliente.adicionarDebito(valorTotal);
				medicamento.setEstoque(medicamento.getEstoque() - quantidade);
			}
		} else if (produto instanceof Perfumaria) {
			Perfumaria perfumaria = (Perfumaria) produto;
			if (perfumaria.podeVender(cliente.getSaldoDevedor()) && perfumaria.getEstoque() >= quantidade) {
				double valorTotal = produto.getValor() * quantidade;
				cliente.adicionarDebito(valorTotal);
				perfumaria.setEstoque(perfumaria.getEstoque() - quantidade);
			}
		} else if (produto instanceof EquipamentoMedico) {
			double valorTotal = produto.getValor() * quantidade;
			cliente.adicionarDebito(valorTotal);
		}
	}

	public void realizarPagamento(Cliente cliente, double valor) {
		cliente.realizarPagamento(valor);
	}

	public List<Produtos> consultarProdutosPorValor(double valorMinimo, double valorMaximo) {
		List<Produtos> produtosPorValor = new ArrayList<>();
		for (Produtos produto : produtos) {
			if (produto.getValor() >= valorMinimo && produto.getValor() <= valorMaximo) {
				produtosPorValor.add(produto);
			}
		}
		return produtosPorValor;
	}

	public List<Cliente> consultarClientesPorNome(String nomeCliente) {
		List<Cliente> clientesPorNome = new ArrayList<>();
		for (Cliente cliente : clientes) {
			if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
				clientesPorNome.add(cliente);
			}
		}
		return clientesPorNome;
	}
	
	
}
