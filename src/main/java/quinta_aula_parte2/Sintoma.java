package quinta_aula_parte2;

public enum Sintoma {
    DOR_DE_CABECA("Dor de cabeça"),
    DENGUE("Dengue"),
    PROBLEMAS_INTESTINO("Problemas de intestino");

    private String descricao;

    private Sintoma(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
