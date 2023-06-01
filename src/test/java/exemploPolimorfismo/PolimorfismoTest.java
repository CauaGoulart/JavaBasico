package exemploPolimorfismo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ExemploPolimorfismo.Cilindro;
import ExemploPolimorfismo.Circulo;
import ExemploPolimorfismo.Forma;
import ExemploPolimorfismo.Quadrado;
import ExemploPolimorfismo.Triangulo;

public class PolimorfismoTest {
	
   List<Forma> formas = new ArrayList<Forma>();
   
   @BeforeEach
   public void init() {
	   formas.add(new Cilindro());
	   formas.add(new Circulo());
	   formas.add(new Quadrado());
	   formas.add(new Triangulo());


	   
   }
   
   @Test
   @DisplayName("Teste desenhar cilindro")
   public void desenharCilindro(){
	   String s = formas.get(0).desenhar();
	   assertEquals("Sou a forma Cilindro", s);
	   if(formas.get(0) instanceof Cilindro) {
		   Cilindro c = (Cilindro) new Cilindro();
		   assertEquals("Cilindro", c.getNome());
	   }
	  
   }
   
   @Test
   @DisplayName("Teste desenhar circulo")
   public void desenharCirculo() {
	   String s = formas.get(1).desenhar();
	   assertEquals("Sou um círculo e tenho meu próprio desenho", s);
   }
   
   @Test
   @DisplayName("Teste desenhar Quadrado")
   public void desenharQuadrado() {
	   String s = formas.get(2).desenhar();
	   assertEquals("Sou a forma Quadrado e tenho 4 lados", s);
   }
   
   @Test
   @DisplayName("Teste desenhar Triângulo")
   public void desenharTriangulo() {
	   String s = formas.get(3).desenhar();
	   assertEquals("Sou a forma Triângulo e tenho 3 lados", s);
   }
   
   @Test
   @DisplayName("Teste calcular área circulo")
   public void calcularAreaCirculo() {
	   String s = "";
	   if(formas.get(1) instanceof Circulo) {
		   Circulo c = (Circulo) formas.get(1);
		    s = c.calculaArea();
	   }
	   
	   assertEquals("Minha área pode ser calculada", s);
   }
}
