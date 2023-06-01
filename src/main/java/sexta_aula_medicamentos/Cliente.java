package sexta_aula_medicamentos;

public class Cliente {
    private String nome;
    private double saldoDevedor;

    public Cliente(String nome) {
        this.nome = nome;
        this.saldoDevedor = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldoDevedor() {
        return saldoDevedor;
    }

    public void adicionarDebito(double valor) {
        saldoDevedor += valor;
    }

    public void realizarPagamento(double valor) {
        if (valor <= saldoDevedor) {
            saldoDevedor -= valor;
        }
    }
}
