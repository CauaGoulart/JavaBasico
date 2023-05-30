package quinta_aula_parte2;

import java.util.List;
import lombok.Getter;

@Getter
public class Pessoa {
    private String nome;
    private Sintoma sintoma;
    private List<String> alergias;

    public Pessoa(String nome, Sintoma sintoma, List<String> alergias) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio ou nulo.");
        }

        if (sintoma == null) {
            throw new IllegalArgumentException("O sintoma não pode ser nulo.");
        }

        this.nome = nome;
        this.sintoma = sintoma;
        this.alergias = alergias;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public String getNome() {
        return nome;
    }

    public Sintoma getSintoma() {
        return sintoma;
    }
}
