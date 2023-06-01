package ExemploPolimorfismo;

import lombok.Getter;

@Getter
public class Poligono extends Forma{
	private int lados;

	public Poligono(String nome, int lados) {
		super(nome);
		this.lados = lados;
	}
	
	public String desenhar() {
		return super.desenhar() + " e tenho " + getLados() + " lados";
	}

}
