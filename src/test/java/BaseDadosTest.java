import quinta_aula_parte2.BaseDados;
import quinta_aula_parte2.EnumAdministracao;
import quinta_aula_parte2.Medicamento;
import quinta_aula_parte2.Pessoa;
import quinta_aula_parte2.Prescricao;
import quinta_aula_parte2.Sintoma;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class BaseDadosTest {
	private Pessoa p1;
	private Medicamento medicamento1;

	@BeforeEach
	public void setUp() {
		p1 = new Pessoa("João", Sintoma.DOR_DE_CABECA, new ArrayList<>());

		medicamento1 = new Medicamento("Medicamento 1", EnumAdministracao.ORAL, EnumSet.of(Sintoma.DENGUE),
				EnumSet.of(Sintoma.DOR_DE_CABECA));

	}

	@Test
	@DisplayName("Teste para Cadastrar pessoa")
	public void testCadastrarPessoa() {
		List<Pessoa> pessoas = new ArrayList<>();
		BaseDados.cadastrarPessoa(pessoas, "João", Sintoma.DOR_DE_CABECA, new ArrayList<>());

		assertEquals(1, pessoas.size());
		assertEquals("João", pessoas.get(0).getNome());
	}

	@Test
	@DisplayName("Teste para Cadastrar medicamento")
	public void testCadastrarMedicamentos() {
		List<Medicamento> medicamentos = new ArrayList<>();
		BaseDados.cadastrarMedicamento(medicamentos, "Medicamento 1", EnumAdministracao.ORAL,
				EnumSet.of(Sintoma.DENGUE), EnumSet.of(Sintoma.DOR_DE_CABECA));

		assertEquals(1, medicamentos.size());
	}

	@Test
	@DisplayName("Teste para prescrever medicamentos")
	public void testPrescreverMedicamentos() {
		List<Prescricao> prescricoes = new ArrayList<Prescricao>();
		List<Medicamento> medicamentosPrescritos = Arrays.asList(medicamento1);

		BaseDados.prescreverMedicamentos(prescricoes, p1, medicamentosPrescritos);

		assertEquals(1, prescricoes.size());

		Prescricao prescricao = prescricoes.get(0);
		assertEquals(p1, prescricao.getPessoa());
		assertEquals(medicamentosPrescritos, prescricao.getMedicamentosPrescritos());
	}

	@Test
	@DisplayName("Teste para listar pessoas e medicamentos")

	public void testListarPessoasEMedicamentos() {
		List<Prescricao> prescricoes = new ArrayList<>();

		Pessoa pessoa1 = new Pessoa("João", Sintoma.DOR_DE_CABECA, new ArrayList<>());
		Medicamento medicamento1 = new Medicamento("Medicamento 1", EnumAdministracao.ORAL, EnumSet.of(Sintoma.DENGUE),
				EnumSet.of(Sintoma.DOR_DE_CABECA));
		Prescricao prescricao1 = new Prescricao(pessoa1, Arrays.asList(medicamento1));
		prescricoes.add(prescricao1);

		Pessoa pessoa2 = new Pessoa("Maria", Sintoma.PROBLEMAS_INTESTINO, new ArrayList<>());
		Medicamento medicamento2 = new Medicamento("Medicamento 2", EnumAdministracao.ORAL, EnumSet.of(Sintoma.DENGUE),
				EnumSet.of(Sintoma.PROBLEMAS_INTESTINO));
		Prescricao prescricao2 = new Prescricao(pessoa2, Arrays.asList(medicamento2));
		prescricoes.add(prescricao2);

		BaseDados.listarPessoasEMedicamentos(prescricoes);
		assertEquals(2, prescricoes.size());
	}

	@Test
	@DisplayName("Teste para listar pessoas e medicamentos estando vazio")
	public void testListarPessoasEMedicamentosVazio() {
		List<Prescricao> prescricoes = new ArrayList<Prescricao>();

		BaseDados.listarPessoasEMedicamentos(prescricoes);

		assertEquals(0, prescricoes.size());
	}

	@Test
	@DisplayName("Teste para prescrever sem medicamentos")
	public void testPrescreverSemMedicamentos() {
		List<Prescricao> prescricoes = new ArrayList<>();
		Pessoa pessoa1 = new Pessoa("João", Sintoma.DOR_DE_CABECA, new ArrayList<>());
		List<Medicamento> medicamentosPrescritos = new ArrayList<>();

		BaseDados.prescreverMedicamentos(prescricoes, pessoa1, medicamentosPrescritos);
		assertEquals(0, prescricoes.size());
	}

	@Test
	@DisplayName("Teste para cadastrar pessoa inválida")
	public void testCadastrarPessoaInvalida() {
		List<Pessoa> pessoas = new ArrayList<>();

		assertThrows(IllegalArgumentException.class, () -> {
			BaseDados.cadastrarPessoa(pessoas, "", Sintoma.DOR_DE_CABECA, new ArrayList<>());
		});

		assertThrows(IllegalArgumentException.class, () -> {
			BaseDados.cadastrarPessoa(pessoas, null, Sintoma.DOR_DE_CABECA, new ArrayList<>());
		});

		assertThrows(IllegalArgumentException.class, () -> {
			BaseDados.cadastrarPessoa(pessoas, "João", null, new ArrayList<>());
		});

		assertEquals(0, pessoas.size());
	}

	@Test
	@DisplayName("Teste para Cadastrar medicamento inválido")
	public void testCadastrarMedicamentoInvalidoNomeVazio() {
	    List<Medicamento> medicamentos = new ArrayList<>();

	    assertThrows(IllegalArgumentException.class, () -> {
	        BaseDados.cadastrarMedicamento(medicamentos, "", EnumAdministracao.ORAL, EnumSet.of(Sintoma.DENGUE),
	                EnumSet.of(Sintoma.DOR_DE_CABECA));
	    });

	    assertEquals(0, medicamentos.size());
	}


}