package quinta_aula_parte2;

import java.util.List;
import lombok.Getter;
@Getter

public class Prescricao {
    private Pessoa pessoa;
    private List<Medicamento> medicamentosPrescritos;

    public Prescricao(Pessoa pessoa, List<Medicamento> medicamentosPrescritos) {
        this.pessoa = pessoa;
        this.medicamentosPrescritos = medicamentosPrescritos;
    }

    public List<Medicamento> getMedicamentosPrescritos() {
		return medicamentosPrescritos;
	}
    
    public Pessoa getPessoa() {
		return pessoa;
	}
}
