package terceira_aula;

import java.util.ArrayList;
import java.util.List;

public class Time {
	List<Jogador> time = new ArrayList<Jogador>(); 
	
	 public void cadastrarJogador() {
	        Jogador jogador = new Jogador();
	        jogador.cadastro();
	        time.add(jogador);
	    }

}
