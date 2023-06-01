package Caixa;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sexta_aula_ExercicioConta.Caixa;
import sexta_aula_ExercicioConta.Conta;
import sexta_aula_ExercicioConta.ContaEspecial;
import sexta_aula_ExercicioConta.ContaUniversitaria;

public class CaixaTest {
	List<Conta> contas = new ArrayList<Conta>();

	@BeforeEach
	public void init() {
		contas.add(new Conta());
		contas.add(new ContaEspecial(2, 456, "Maria", 2000));
		contas.add(new ContaUniversitaria(3, 789, "Pedro"));

	}

	@Test
	@DisplayName("Teste para depositar")
	public void testDeposito() {
		Conta conta = new Conta();
		conta.deposito(10);

		Caixa.deposito(conta, 20);

		assertEquals(30, conta.getSaldo());
	}

	@Test
	@DisplayName("Teste para saque em ContaEspecial com saldo dentro do limite")
	public void testSaqueDentroDoLimite() {
		ContaEspecial conta = new ContaEspecial(2, 456, "Maria", 2000);
		conta.deposito(500);

		Caixa.deposito(conta, 500);

		assertEquals(1000, conta.getSaldo());
	}

	@Test
	@DisplayName("Teste para saque em ContaEspecial com saldo fora do limite")
	public void testSaqueForaDoLimite() {
		ContaEspecial conta = new ContaEspecial(2, 456, "Maria", 1000);
		conta.deposito(500);

		Caixa.saque(conta, 1700);

		assertEquals(500, conta.getSaldo());
	}

	@Test
	@DisplayName("Teste para saque em ContaUniversditaria com saldo dentro do limite")
	public void testSaqueUniversitarioDentroDoLimite() {
		ContaUniversitaria conta = new ContaUniversitaria(3, 789, "Pedro");
		conta.deposito(500);

		Caixa.deposito(conta, 500);

		assertEquals(1000, conta.getSaldo());
	}

	@Test
	@DisplayName("Teste para saque em ContaUniversditaria com saldo fora do limite")
	public void testSaqueUniversitarioForaDoLimite() {
		ContaUniversitaria conta = new ContaUniversitaria(3, 789, "Pedro");
		conta.deposito(500);

		Caixa.deposito(conta, 2100);

		assertEquals(500, conta.getSaldo());
	}

	@Test
	@DisplayName("Teste para o get da Conta")
	public void testGet() {
		Conta conta = new Conta(3, 789, "Pedro");
		conta.deposito(100);

		double saldo = conta.getSaldo();
		int numero = conta.getNumero();
		int agencia = conta.getAgencia();
		String nome = conta.getNome();

		assertEquals(100, saldo);
		assertEquals(3, numero);
		assertEquals(789, agencia);
		assertEquals("Pedro", nome);
	}

	@Test
	@DisplayName("Teste para saque")
	public void testSaque() {
		Conta conta = new Conta();
		conta.deposito(30);

		Caixa.saque(conta, 20);
		assertEquals(10, conta.getSaldo());

		Caixa.saque(conta, 15);
		assertEquals(10, conta.getSaldo());
	}

	@Test
	@DisplayName("Teste para transferencia")
	public void testTransferencia() {
		Conta conta1 = new Conta();
		Conta conta2 = new Conta();
		conta1.deposito(30);
		conta2.deposito(30);

		Caixa.transferencia(conta1, conta2, 20);
		assertEquals(10, conta1.getSaldo());
		assertEquals(50, conta2.getSaldo());

		Caixa.transferencia(conta1, conta2, 15);
		assertEquals(25, conta1.getSaldo());
		assertEquals(50, conta2.getSaldo());
	}

	@Test
	@DisplayName("Teste para ver se o get do Conta esta funcionando")
	public void testGetConta() {
		Conta conta = new Conta();
		conta.deposito(1500);

		assertEquals(1500, conta.getSaldo());
	}

	@Test
	@DisplayName("Teste para adicionar conta")
	public void testAddConta() {
		Caixa caixa = new Caixa();
		Conta conta = new Conta();

		caixa.addConta(conta);

		assertEquals(1, caixa.contas.size());
		assertTrue(caixa.contas.contains(conta));
	}

	@Test
	@DisplayName("Teste para checar operaçoes caixa")
	public void caixaOperacoes() {
		Conta conta1 = new Conta(1, 123, "João");
		ContaEspecial conta2 = new ContaEspecial(2, 456, "Maria", 2000);
		ContaUniversitaria conta3 = new ContaUniversitaria(3, 789, "Pedro");

		Caixa.deposito(conta1, 100);

		Caixa.deposito(conta2, 500);
		Caixa.saque(conta2, 300);

		Caixa.deposito(conta3, 500);
		Caixa.transferencia(conta1, conta3, 50);

		assertEquals(50, conta1.getSaldo());
		assertEquals(200, conta2.getSaldo());
		assertEquals(550, conta3.getSaldo());
	}

}
