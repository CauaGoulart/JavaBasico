package quarta_aula;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static void main(String[] args) {
		int op = 0;
		List<Livro> livros = new ArrayList<Livro>();
		List<Autor> autores = new ArrayList<Autor>();

		do {
			op = Util.escolheOpcao();

			switch (op) {
			case 1:
				Autor novoAutor = new Autor();
				novoAutor.cadastro();
				autores.add(novoAutor);
				break;
			case 2:
			    Livro novoLivro = new Livro();
			    novoLivro.cadastrar(autores);;
			    livros.add(novoLivro);
			    System.out.println("Livro cadastrado com sucesso.");
			    break;


			case 3:
				Util.listarLivros(livros);
				break;

			case 4:
				if (autores.isEmpty()) {
				    System.out.println("Não há autores cadastrados.");
				} else {
				    System.out.println("Autores disponíveis:");
				    
				    for (Autor autor : autores) {
				    	System.out.println("- " + autor.toString());
				       
				    }

				    List<Autor> autoresEscolhidos = Util.escolherAutores(autores);
				    if (!autoresEscolhidos.isEmpty()) {
				        List<Livro> livrosEncontrados = Util.pesquisarLivrosPorAutor(livros, autoresEscolhidos.get(0));
				        if (livrosEncontrados.isEmpty()) {
				            System.out.println("Não há livros cadastrados para esse autor.");
				        } else {
				            System.out.println("Livros encontrados para o autor " + autoresEscolhidos.get(0).getNome() + ":");
				            for (Livro livro : livrosEncontrados) {
				                System.out.println("Título: " + livro.getTitulo());
				                System.out.println("Valor: " + livro.getValor());
				                System.out.println("Autores:");
				                for (Autor autor : livro.getAutoresLivro()) {
				                	System.out.println("- " + autor.toString());
				                }
				                System.out.println("--------------------");
				            }
				        }
				    } else {
				        System.out.println("Nenhum autor selecionado.");
				    }
				}
				break;

			case 5:
				double valorInicial = Util.solicitarDouble("Digite o valor inicial:");
				double valorFinal = Util.solicitarDouble("Digite o valor final:");

				List<Livro> livrosEncontrados = Util.pesquisarLivrosPorFaixaValor(livros, valorInicial, valorFinal);
				if (livrosEncontrados.isEmpty()) {
					System.out.println("Não há livros cadastrados dentro da faixa de valor especificada.");
				} else {
					System.out.println(
							"Livros encontrados na faixa de valor entre " + valorInicial + " e " + valorFinal + ":");
					for (Livro livro : livrosEncontrados) {
						System.out.println("Título: " + livro.getTitulo());
						System.out.println("Valor: " + livro.getValor());
						System.out.println("Autores:");
						for (Autor autor : livro.getAutoresLivro()) {
							System.out.println("- " + autor.toString());
						}
						System.out.println("--------------------");
					}
				}
				break;

			case 6:
				List<Livro> livrosAutoresCrianca = Util.listarLivrosAutoresCrianca(livros, autores);
				if (livrosAutoresCrianca.isEmpty()) {
					System.out.println("Não há livros cujos autores sejam crianças.");
				} else {
					System.out.println("Livros cujos autores são crianças:");
					for (Livro livro : livrosAutoresCrianca) {
						System.out.println("Título: " + livro.getTitulo());
						System.out.println("Valor: " + livro.getValor());
						System.out.println("Autores:");
						for (Autor autor : livro.getAutoresLivro()) {
							System.out.println("- " + autor.toString());
						}
						System.out.println("--------------------");
					}
				}
				break;

			case 7:
				String sexoConsulta = Util.solicitarString("Informe o sexo (M/F) para a consulta:");
				List<Livro> livrosPorSexo = Util.listarLivrosPorSexo(livros, autores, sexoConsulta);
				if (livrosPorSexo.isEmpty()) {
					System.out.println("Não há livros escritos apenas por "
							+ (sexoConsulta.equalsIgnoreCase("F") ? "mulheres." : "homens."));
				} else {
					System.out.println("Livros escritos apenas por "
							+ (sexoConsulta.equalsIgnoreCase("F") ? "mulheres:" : "homens:"));
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
				break;

			}
		} while (op != 8);
	}

}