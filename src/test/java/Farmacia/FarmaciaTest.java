package Farmacia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sexta_aula_ExercicioFarmacia.Cliente;
import sexta_aula_ExercicioFarmacia.EquipamentoMedico;
import sexta_aula_ExercicioFarmacia.Farmacia;
import sexta_aula_ExercicioFarmacia.Medicamento;
import sexta_aula_ExercicioFarmacia.Perfumaria;
import sexta_aula_ExercicioFarmacia.Produtos;

public class FarmaciaTest {
	private Farmacia farmacia;
	private Cliente cliente;
	private Produtos medicamento;
	private Produtos perfumaria;
	private Produtos equipamento;

	@BeforeEach
	public void setup() {
		farmacia = new Farmacia();
		cliente = new Cliente("João");
		medicamento = new Medicamento("Paracetamol", 10, 5.0, false);
		perfumaria = new Perfumaria("Perfume", 20, 100.0);
		equipamento = new EquipamentoMedico("Termômetro", 5, 50.0);

		farmacia.cadastrarProduto(medicamento);
		farmacia.cadastrarProduto(perfumaria);
		farmacia.cadastrarProduto(equipamento);
		farmacia.cadastrarCliente(cliente);
	}

	@Test
	@DisplayName("Teste para cadastrar produto")
	public void testCadastrarProduto() {
		Produtos novoProduto = new Medicamento("Ibuprofeno", 20, 8.0, true);
		farmacia.cadastrarProduto(novoProduto);
		assertEquals(4, farmacia.produtos.size());
		assertEquals(novoProduto, farmacia.produtos.get(3));

	}

	@Test
	@DisplayName("Teste para cadastrar cliente")
	public void testCadastrarCliente() {
		Cliente novoCliente = new Cliente("Maria");
		farmacia.cadastrarCliente(novoCliente);
		assertEquals(2, farmacia.clientes.size());
		assertEquals(novoCliente, farmacia.clientes.get(1));
	}

	@Test
	@DisplayName("Teste para realizar venda de medicamento")
	public void testRealizarVendaMedicamento() {
		Medicamento medicamento = new Medicamento("Paracetamol", 10, 5.0, false);
		Cliente cliente = new Cliente("João");

		farmacia.cadastrarProduto(medicamento);
		farmacia.cadastrarCliente(cliente);

		farmacia.realizarVenda(cliente, medicamento, 2, "Dr. Carlos");

		assertEquals(10 - 2, medicamento.getEstoque());
		assertEquals(10.0, cliente.getSaldoDevedor());
	}

	@Test
	@DisplayName("Teste para realizar pagamento")
	public void testRealizarPagamento() {
		double valorPagamento = 50.0;
		farmacia.realizarPagamento(cliente, valorPagamento);
		assertEquals(0.0, cliente.getSaldoDevedor());
	}

	@Test
	@DisplayName("Teste para consultar produtos por valor")
	public void testConsultarProdutosPorValor() {
		double valorMinimo = 0.0;
		double valorMaximo = 10.0;
		List<Produtos> produtosEsperados = new ArrayList<>();
		produtosEsperados.add(medicamento);

		List<Produtos> produtosValidos = farmacia.consultarProdutosPorValor(valorMinimo, valorMaximo);

		assertEquals(produtosEsperados, produtosValidos);
	}

	@Test
	@DisplayName("Teste para consultar clientes por nome")
	public void testConsultarClientesPorNome() {
		String nomeCliente = "João";
		List<Cliente> clientesEsperados = new ArrayList<>();
		clientesEsperados.add(cliente);

		List<Cliente> clientesValidos = farmacia.consultarClientesPorNome(nomeCliente);

		assertEquals(clientesEsperados, clientesValidos);
	}

	@Test
	@DisplayName("Teste para verificar se o medicamento retém receita")
	public void testIsReterReceita() {
		Medicamento medicamento = new Medicamento("Paracetamol", 10, 5.0, true);

		boolean isReterReceita = medicamento.isReterReceita();

		assertTrue(isReterReceita);
	}

	@Test
	@DisplayName("Teste para realizar pagamento do cliente")
	public void testRealizarPagamentoCliente() {
		Cliente cliente = new Cliente("João");
		cliente.adicionarDebito(100.0);

		double valorPagamento = 50.0;
		cliente.realizarPagamento(valorPagamento);

		double saldoDevedorAtual = cliente.getSaldoDevedor();

		assertEquals(50.0, saldoDevedorAtual);
	}

	@Test
	@DisplayName("Teste para verificar se pode vender medicamento")
	public void testPodeVenderMedicamento() {
		Medicamento medicamento = new Medicamento("Paracetamol", 10, 5.0, false);
		Cliente cliente = new Cliente("João");

		assertTrue(medicamento.podeVender(cliente.getSaldoDevedor()));

		medicamento.setEstoque(0);

		assertFalse(medicamento.podeVender(cliente.getSaldoDevedor()));
	}

	@Test
	@DisplayName("Teste para verificar o nome do produto")
	public void testGetNomeProduto() {
		Produtos produto = new Medicamento("Paracetamol", 10, 5.0, false);

		assertEquals("Paracetamol", produto.getNome());
	}

	@Test
	@DisplayName("Teste para verificar se pode vender produto")
	public void testPodeVenderProduto() {
		Produtos produto = new Medicamento("Paracetamol", 10, 5.0, false);
		Cliente cliente = new Cliente("João");

		assertTrue(produto.podeVender(cliente.getSaldoDevedor()));

		produto.setEstoque(0);

		assertFalse(produto.podeVender(cliente.getSaldoDevedor()));
	}

	@Test
	@DisplayName("Teste para verificar o estoque do produto")
	public void testSetEstoqueProduto() {
		Produtos produto = new Medicamento("Paracetamol", 10, 5.0, false);

		assertEquals(10, produto.getEstoque());

		produto.setEstoque(5);

		assertEquals(5, produto.getEstoque());
	}

	@Test
	@DisplayName("Teste para verificar se é possível vender perfumaria")
	public void testPodeVenderPerfumaria() {
		Produtos perfumaria = new Perfumaria("Perfume", 10, 100.0);

		assertTrue(perfumaria.podeVender(200.0));

		perfumaria.setEstoque(0);
		assertFalse(perfumaria.podeVender(200.0));

		perfumaria.setEstoque(10);
		assertFalse(perfumaria.podeVender(400.0));
	}

	@Test
	@DisplayName("Teste para verificar a alteração do estoque de perfumaria")
	public void testSetEstoquePerfumaria() {
		Produtos perfumaria = new Perfumaria("Perfume", 10, 100.0);

		assertEquals(10, perfumaria.getEstoque());

		perfumaria.setEstoque(5);

		assertEquals(5, perfumaria.getEstoque());
	}

	@Test
	@DisplayName("Teste para realizar venda de medicamento com saldo devedor suficiente e estoque disponível")
	public void testRealizarVendaMedicamentoSaldoEstoqueSuficiente() {
		Medicamento medicamento = new Medicamento("Paracetamol", 10, 5.0, false);
		Cliente cliente = new Cliente("João");
		Farmacia farmacia = new Farmacia();

		farmacia.cadastrarProduto(medicamento);
		farmacia.cadastrarCliente(cliente);

		farmacia.realizarVenda(cliente, medicamento, 2, "Dr. Carlos");

		assertEquals(10 - 2, medicamento.getEstoque());
		assertEquals(10.0, cliente.getSaldoDevedor());
	}

	@Test
	@DisplayName("Teste para realizar venda de perfumaria com saldo devedor suficiente e estoque disponível")
	public void testRealizarVendaPerfumariaSaldoEstoqueSuficiente() {
		Perfumaria perfumaria = new Perfumaria("Perfume", 20, 100.0);
		Cliente cliente = new Cliente("João");
		Farmacia farmacia = new Farmacia();

		farmacia.cadastrarProduto(perfumaria);
		farmacia.cadastrarCliente(cliente);

		farmacia.realizarVenda(cliente, perfumaria, 5, "Dr. Carlos");

		assertEquals(20 - 5, perfumaria.getEstoque());
		assertEquals(500.0, cliente.getSaldoDevedor());
	}

	@Test
	@DisplayName("Teste para realizar venda de equipamento com saldo devedor suficiente")
	public void testRealizarVendaEquipamentoSaldoSuficiente() {
		EquipamentoMedico equipamento = new EquipamentoMedico("Termômetro", 5, 50.0);
		Cliente cliente = new Cliente("João");
		Farmacia farmacia = new Farmacia();

		farmacia.cadastrarProduto(equipamento);
		farmacia.cadastrarCliente(cliente);

		farmacia.realizarVenda(cliente, equipamento, 1, "Dr. Carlos");

		assertEquals(50.0, cliente.getSaldoDevedor());
	}

	@Test
	@DisplayName("Teste para realizar venda de medicamento com saldo devedor insuficiente")
	public void testRealizarVendaMedicamentoSaldoInsuficiente() {
		Medicamento medicamento = new Medicamento("Paracetamol", 10, 5.0, false);
		Cliente cliente = new Cliente("João");
		Farmacia farmacia = new Farmacia();

		farmacia.cadastrarProduto(medicamento);
		farmacia.cadastrarCliente(cliente);

		cliente.realizarPagamento(500.0);
		farmacia.realizarVenda(cliente, medicamento, 3, "Dr. Carlos");

		assertEquals(10 - 3, medicamento.getEstoque());
		assertEquals(15.0, cliente.getSaldoDevedor());
	}

	@Test
	@DisplayName("Teste para realizar venda de medicamento com estoque insuficiente")
	public void testRealizarVendaMedicamentoEstoqueInsuficiente() {
		Medicamento medicamento = new Medicamento("Paracetamol", 10, 5.0, false);
		Cliente cliente = new Cliente("João");
		Farmacia farmacia = new Farmacia();

		farmacia.cadastrarProduto(medicamento);
		farmacia.cadastrarCliente(cliente);

		farmacia.realizarVenda(cliente, medicamento, 20, "Dr. Carlos");

		assertEquals(10, medicamento.getEstoque());
		assertEquals(0.0, cliente.getSaldoDevedor());
	}

}

