package quarta_aula;

public class Autor {
	private String nome;
	private String sobrenome;
	private int idade;
	private String sexo;

	public void cadastro() {
		boolean nomeSobrenomeValido = false;
		while (!nomeSobrenomeValido) {
			String nomeCompleto = Util.solicitarString("Digite o nome completo do autor:");
			String[] partesNome = nomeCompleto.split(" ");
			if (partesNome.length >= 2) {
				setNome(partesNome[0]);
				setSobrenome(partesNome[1]);
				nomeSobrenomeValido = true;
			} else {
				System.out.println("Nome e sobrenome inválidos. Por favor, digite o nome completo do autor.");
			}
		}

		boolean idadeValida = false;
		while (!idadeValida) {
			int idade = Util.solicitarInteiro("Digite a idade do autor:");
			if (idade > 0) {
				setIdade(idade);
				idadeValida = true;
			} else {
				System.out.println("Idade inválida. A idade do autor não pode ser negativa.");
			}
		}

		boolean sexoValido = false;
		while (!sexoValido) {
			String sexo = Util.solicitarString("Digite o sexo do autor (M/F):");
			if (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("F")) {
				setSexo(sexo);
				sexoValido = true;
			} else {
				System.out.println("Sexo inválido. O sexo deve ser Masculino (M) ou Feminino (F).");
			}
		}
	}

	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public int getIdade() {
		return idade;
	}

	public String getSexo() {
		return sexo;
	}
}
