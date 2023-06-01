package sexta_aula_ExercicioFarmacia;

public class Medicamento extends Produtos {
    private boolean reterReceita;

    public Medicamento(String nome, int estoque, double valor, boolean reterReceita) {
        super(nome, estoque, valor);
        this.reterReceita = reterReceita;
    }

    public boolean isReterReceita() {
        return reterReceita;
    }
    
    


}