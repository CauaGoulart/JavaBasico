package quarta_aula;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Util {
	private List<Autor> autores = new ArrayList<Autor>();

	public static int escolheOpcao() {
		String menu = "1 – Cadastrar Autor\n" + "2 – Cadastrar Livro\n" + "3 – Listar todos os livros cadastrados\n"
				+ "4 – Pesquisar por autor\n" + "5 – Pesquisar por faixa de valor do livro \n"
				+ "6 - Listar livros cujos autores tenham crianças\n"
				+ "7 - Listar todos os livros que foram escritos apenas por mulheres ou por homens (O usuário informará o sexo)\n"
				+ "8 - Sair";

		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

	public void cadastrarAutor() {
		Autor a = new Autor();
		a.cadastro();
		autores.add(a);
	}

	public static void listarLivros(List<Livro> livros) {
		if (livros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado.");
			return;
		}

		System.out.println("Livros cadastrados:");
		for (Livro livro : livros) {
			System.out.println("Título: " + livro.getTitulo());
			System.out.println("Valor: R$" + String.format("%.2f", livro.getValor()));
			System.out.println("Autores:");

			List<Autor> autoresLivro = livro.getAutoresLivro();
			for (Autor autor : autoresLivro) {
				System.out.println("- " + autor.getNome() + " " + autor.getSobrenome() + " ,Idade: " + autor.getIdade()
						+ " ,Genero: " + autor.getSexo());
			}

			System.out.println("--------------------");
		}
	}

	public static void listarAutores(List<Autor> autores) {
		int i = 1;
		for (Autor autor : autores) {
			System.out.println(i + ". " + autor.getNome() + " " + autor.getSobrenome());
			i++;
		}
	}

	public static List<Livro> pesquisarLivrosPorAutor(List<Livro> livros, Autor autor) {
		List<Livro> livrosEncontrados = new ArrayList<Livro>();

		for (Livro livro : livros) {
			List<Autor> autoresLivro = livro.getAutoresLivro();
			if (autoresLivro.contains(autor)) {
				livrosEncontrados.add(livro);
			}
		}

		return livrosEncontrados;
	}

	public static Livro escolherLivro(List<Livro> livros) {
		if (livros.isEmpty()) {
			System.out.println("Não há livros disponíveis.");
			return null;
		}

		String menu = "Escolha um livro:\n";
		int i = 0;
		for (Livro livro : livros) {
			menu += (i + 1) + "- " + livro.getTitulo() + "\n";
			i++;
		}

		int escolha = solicitarInteiro(menu) - 1;
		if (escolha >= 0 && escolha < livros.size()) {
			return livros.get(escolha);
		} else {
			System.out.println("Livro inválido.");
			return null;
		}
	}

	public static List<Livro> pesquisarLivrosPorFaixaValor(List<Livro> livros, double valorInicial, double valorFinal) {
	    List<Livro> livrosEncontrados = new ArrayList<Livro>();

	    for (Livro livro : livros) {
	        double valorLivro = livro.getValor();
	        if (valorLivro >= valorInicial && valorLivro <= valorFinal) {
	            livrosEncontrados.add(livro);
	        }
	    }

	    return livrosEncontrados;
	}


	public static List<Livro> listarLivrosAutoresCrianca(List<Livro> livros, List<Autor> autores) {
	    List<Livro> livrosAutoresCrianca = new ArrayList<Livro>();

	    for (Livro livro : livros) {
	        List<Autor> autoresLivro = livro.getAutoresLivro();
	        boolean temAutorCrianca = false;

	        for (Autor autor : autoresLivro) {
	            if (autor.getIdade() <= 12) {
	                temAutorCrianca = true;
	                break;
	            }
	        }

	        if (temAutorCrianca) {
	            livrosAutoresCrianca.add(livro);
	        }
	    }

	    return livrosAutoresCrianca;
	}


	public static List<Livro> listarLivrosPorSexo(List<Livro> livros, List<Autor> autores, String sexo) {
	    List<Livro> livrosPorSexo = new ArrayList<Livro>();

	    for (Livro livro : livros) {
	    	List<Autor> autoresLivro = livro.getAutoresLivro();
			
	        
	        boolean temAutorOutroSexo = false;

	        for (Autor autor : autoresLivro) {
	            if (!autor.getSexo().equalsIgnoreCase(sexo)) {
	                temAutorOutroSexo = true;
	                break;
	            }
	        }

	        if (!temAutorOutroSexo) {
	            livrosPorSexo.add(livro);
	        }
	    }
	    
	    if (livrosPorSexo.isEmpty()) {
	        System.out.println("Não há livros escritos apenas por " + sexo + ".");
	    } else {
	        System.out.println("Livros escritos apenas por " + sexo + ":");
	        for (Livro livro : livrosPorSexo) {
	            System.out.println("Título: " + livro.getTitulo());
	            System.out.println("Valor: " + livro.getValor());
	            System.out.println("Autores:");
	            for (Autor autor : livro.getAutoresLivro()) {
	                System.out.println("- " + autor.toString());
	            }
	            System.out.println("--------------------");
	        }
	    }

	    return livrosPorSexo;
	}

	public static List<Autor> escolherAutores(List<Autor> autores) {
		List<Autor> autoresEscolhidos = new ArrayList<Autor>();

		System.out.println("Selecione os autores para o livro:");

		int maxAutores = 4;

		while (true) {
			System.out.println("Autores disponíveis:");
			listarAutores(autores);

			System.out.println("Selecione o número correspondente ao autor (0 para sair):");
			int opcao = solicitarInteiro("Opção: ");

			if (opcao == 0 || autoresEscolhidos.size() >= maxAutores) {
				if (autoresEscolhidos.size() == maxAutores) {
					System.out.println("Você já alcançou o número máximo de autores cadastrados.");
				}
				break;
			}

			if (opcao > 0 && opcao <= autores.size()) {
				Autor autor = autores.get(opcao - 1);
				if (!autoresEscolhidos.contains(autor)) {
					autoresEscolhidos.add(autor);
					System.out.println("Autor adicionado ao livro com sucesso.");
				} else {
					System.out.println("Autor já foi selecionado.");
				}
			} else {
				System.out.println("Opção inválida. Tente novamente.");
			}

		}

		if (autoresEscolhidos.isEmpty()) {
			System.out.println("É necessário selecionar pelo menos 1 autor para o livro.");
		}

		return autoresEscolhidos;
	}

	public static void adicionarAutores(List<Autor> autores, Livro livro) {
		boolean adicionandoAutores = true;
		while (adicionandoAutores) {
			List<Autor> autoresEscolhidos = escolherAutores(autores);
			if (!autoresEscolhidos.isEmpty()) {
				livro.getAutoresLivro().addAll(autoresEscolhidos);
				System.out.println("Autores adicionados ao livro com sucesso.");
			} else {
				System.out.println("Nenhum autor selecionado.");
			}

			String opcao = solicitarString("Deseja adicionar mais autores? (S/N)");
			if (opcao.equalsIgnoreCase("N")) {
				adicionandoAutores = false;
			}
		}
	}

	public static String solicitarString(String mensagem) {
		String input = JOptionPane.showInputDialog(mensagem);
		while (input.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, digite novamente.");
			input = JOptionPane.showInputDialog(mensagem);
		}
		return input;
	}

	public static int solicitarInteiro(String mensagem) {
		String input = JOptionPane.showInputDialog(mensagem);
		while (input.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, digite novamente.");
			input = JOptionPane.showInputDialog(mensagem);
		}
		return Integer.parseInt(input);
	}

	public static double solicitarDouble(String mensagem) {
		String input = JOptionPane.showInputDialog(mensagem);
		while (input.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, digite novamente.");
			input = JOptionPane.showInputDialog(mensagem);
		}
		return Double.parseDouble(input);
	}

	public List<Autor> getAutores() {
		return autores;
	}
}
