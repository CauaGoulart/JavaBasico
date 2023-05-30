package quinta_aula_parte2;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class BaseDados {
	public static void cadastrarMedicamento(List<Medicamento> medicamentos, String nome,
			EnumAdministracao administracao, EnumSet<Sintoma> alergiasContraindicadas, EnumSet<Sintoma> indicacoes) {
		Medicamento medicamento = new Medicamento(nome, administracao, alergiasContraindicadas, indicacoes);
		medicamentos.add(medicamento);
	}

	public static void cadastrarPessoa(List<Pessoa> pessoas, String nome, Sintoma sintoma, List<String> alergias) {
		Pessoa pessoa = new Pessoa(nome, sintoma, alergias);
		pessoas.add(pessoa);
	}

	public static void prescreverMedicamentos(List<Prescricao> prescricoes, Pessoa pessoa,
			List<Medicamento> medicamentosPrescritos) {
		for (Medicamento medicamento : medicamentosPrescritos) {
			if (!medicamento.getIndicacoes().contains(pessoa.getSintoma())) {
				System.out.println("AVISO: O medicamento " + medicamento.getNome()
						+ " não é indicado para o sintoma apresentado por " + pessoa.getNome());
			} else if (medicamento.getAlergiasContraindicadas().contains(pessoa.getSintoma())) {
				System.out.println(
						"AVISO: " + pessoa.getNome() + " possui alergia ao medicamento " + medicamento.getNome());
			} else {
				Prescricao prescricao = new Prescricao(pessoa, Arrays.asList(medicamento));
				prescricoes.add(prescricao);
				System.out.println("Medicamento " + medicamento.getNome() + " prescrito para " + pessoa.getNome());
			}
		}
	}

	public static void listarPessoasEMedicamentos(List<Prescricao> prescricoes) {
		for (Prescricao prescricao : prescricoes) {
			Pessoa pessoa = prescricao.getPessoa();
			List<Medicamento> medicamentosPrescritos = prescricao.getMedicamentosPrescritos();

			System.out.println("Pessoa: " + pessoa.getNome());
			System.out.println("Sintoma: " + pessoa.getSintoma().getDescricao());
			System.out.println("Medicamentos Prescritos:");
			for (Medicamento medicamento : medicamentosPrescritos) {
				System.out.println("- " + medicamento.getNome());
			}
			System.out.println();
		}
	}
}
