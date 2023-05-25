package terceira_aula;
import java.util.List;

import javax.swing.JOptionPane;

public class Util {
    public static int escolheOP() {
        String menu = "1 – Cadastrar times\n"
                + "2 – Listar todos jogadores de um time\n"
                + "3 – Verificar artilheiro do campeonato\n"
                + "4 – Verificar qual time fez mais gols no campeonato\n"
                + "5 – Sair\n";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    public static void listarJogadores(Time time) {
        System.out.println("Jogadores do time:" + time.getNome());

        for (Jogador jogador : time.getTime()) {
            System.out.println("Nome: " + jogador.getNome());
            System.out.println("Número da camisa: " + jogador.getNumeroCamisa());
            System.out.println("Quantidade de gols no campeonato: " + jogador.getQuantGolsCampeonato());
            System.out.println();
        }
    }

    public static int escolheTimeExistente() {
        String menu = "Escolha a ação para o time:\n"
                + "1 - Adicionar jogador a um time existente\n"
                + "2 - Criar um novo time\n";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    public static Time escolheTimes(List<Time> times) {
        String menu = "Escolha um time:\n";
        for (int i = 0; i < times.size(); i++) {
            menu += (i + 1) + " - Time " + (i + 1) + "\n";
        }
        int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
        return times.get(escolha - 1);
    }

    public static Jogador buscarArtilheiro(List<Time> times) {
        Jogador artilheiro = null;

        for (Time time : times) {
            for (Jogador jogador : time.getTime()) {
                if (artilheiro == null || jogador.getQuantGolsCampeonato() > artilheiro.getQuantGolsCampeonato()) {
                    artilheiro = jogador;
                }
            }
        }

        return artilheiro;
    }

    public static Time buscarTimeComMaisGols(List<Time> times) {
        return Time.buscarTimeComMaisGols(times);
    }
}
