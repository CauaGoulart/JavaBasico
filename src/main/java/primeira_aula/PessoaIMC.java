package primeira_aula;

import javax.swing.JOptionPane;

public class PessoaIMC {
	public static void main(String[] args) {
		String[] pessoas = new String[5];
		char[] sexos = new char[5];
		double[] pesos = new double[5];
		double[] alturas = new double[5];

		for (int i = 0; i < pessoas.length; i++) {
			String nomeDigitada = JOptionPane.showInputDialog("Digite seu nome.");
			String nome = nomeDigitada;
			pessoas[i] = nome;

			String sexoDigitado = JOptionPane.showInputDialog("Qual o seu genero?.");
			char sexo = sexoDigitado.charAt(0);
			sexos[i] = sexo;

			String pesoDigitado = JOptionPane.showInputDialog("Qual o seu peso?.");
			double peso = Double.parseDouble(pesoDigitado);
			pesos[i] = peso;

			String alturaDigitada = JOptionPane.showInputDialog("Qual a sua altura?.");
			double altura = Double.parseDouble(alturaDigitada);
			alturas[i] = altura;
			System.out.println(nome);
			double imc = calculoIMC(peso, altura);
			System.out.printf("O seu IMC é de:%.2f", imc);
			System.out.println("\n");
			indiceIMC(imc, sexo);
		}

	}

	public static double calculoIMC(double peso, double altura) {
		double resultdoIMC = peso / (altura * altura);

		return resultdoIMC;
	}

	public static void indiceIMC(double imc, char sexo) {
		if (sexo == 'm' || sexo == 'M') {
			if (imc < 20.7) {
				System.out.println("Abaixo do peso");

			}

			if (imc <= 26.4 && imc >= 20.7) {
				System.out.println("Peso ideal");

			}

			if (imc <= 27.8 && imc >= 26.5) {
				System.out.println("Pouco acima do peso");

			}

			if (imc <= 31.1 && imc >= 27.9) {
				System.out.println("Acima do peso");

			}

			if (imc >= 31.2) {
				System.out.println("Obesidade");

			}

		}

		if (sexo == 'f' || sexo == 'F') {
			if (imc > 19.1) {
				System.out.println("Abaixo do peso");

			}

			if (imc <= 25.8 && imc >= 19.1) {
				System.out.println("Peso ideal");

			}

			if (imc <= 27.3 && imc >= 25.9) {
				System.out.println("Pouco acima do peso");

			}

			if (imc <= 32.3 && imc >= 27.4) {
				System.out.println("Acima do peso");

			}

			if (imc >= 32.4) {
				System.out.println("Obesidade");

			}

			if (imc <= 26.4 && imc >= 20.7) {
				System.out.println("Peso ideal");

			}
		}

	}
}
