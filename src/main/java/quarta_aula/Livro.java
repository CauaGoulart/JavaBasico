package quarta_aula;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private List<Autor> autoresLivro;
    private String titulo;
    private double valor;

    public Livro() {
        this.autoresLivro = new ArrayList<Autor>();
    }

    public void cadastrar(List<Autor> autores) {
        setTitulo(Util.solicitarString("Insira o título do livro:").toLowerCase());

        while (true) {
            double valor = Util.solicitarDouble("Insira o valor do livro:");
            if (valor > 0) {
                setValor(valor);
                break;
            } else {
                System.out.println("Valor inválido. O valor deve ser maior que zero.");
            }
        }

        Util.adicionarAutores(autores, this);
    }

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTitulo() {
		return titulo;
	}

	public double getValor() {
		return valor;
	}

	public List<Autor> getAutoresLivro() {
        return autoresLivro;
    }
}
