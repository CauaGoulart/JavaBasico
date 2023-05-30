package quinta_aula_parte2;

import java.util.EnumSet;
import lombok.Getter;

@Getter

public class Medicamento {
	private String nome;
	private EnumAdministracao administracao;
	private EnumSet<Sintoma> indicacoes;
	private EnumSet<Sintoma> alergiasContraindicadas;

	public Medicamento(String nome, EnumAdministracao administracao, EnumSet<Sintoma> alergiasContraindicadas,
			EnumSet<Sintoma> indicacoes) {
		if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio ou nulo.");
        }

		this.nome = nome;
		this.administracao = administracao;
		this.alergiasContraindicadas = alergiasContraindicadas;
		this.indicacoes = indicacoes;
	}

	public String getNome() {
		return nome;
	}

	public EnumAdministracao getAdministracao() {
		return administracao;
	}

	public EnumSet<Sintoma> getAlergiasContraindicadas() {
		return alergiasContraindicadas;
	}

	public EnumSet<Sintoma> getIndicacoes() {
		return indicacoes;
	}
}
