package TudoGostoso.model;

public class Receita {
    // Variaveis primitivas
    private int IdReceita;
    private String titulo;
    private String descricao;
    private String imagem;

    // Objetos
    private Custo custo;
    private Categoria categoria;
    private Preparo preparo;
    private Utensilio utensilio;

    public Receita(String titulo, String descricao, String imagem, Custo custo, Preparo preparo, Categoria categoria,
            Utensilio utensilio) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagem = imagem;
        this.custo = custo;
        this.categoria = categoria;
        this.preparo = preparo;
        this.utensilio = utensilio;
    }

    // Gets e Sets
    
    public int getIdReceita() {
        return IdReceita;
    }

    public void setIdReceita(int IdReceita) {
        this.IdReceita = IdReceita;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Custo getCusto() {
        return custo;
    }

    public void setCusto(Custo custo) {
        this.custo = custo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Preparo getPreparo() {
        return preparo;
    }

    public void setPreparo(Preparo preparo) {
        this.preparo = preparo;
    }

    public Utensilio getUtensilio() {
        return utensilio;
    }

    public void setUtensilio(Utensilio utensilio) {
        this.utensilio = utensilio;
    }


    @Override
    public String toString() {
        return "Receita { Id = " + IdReceita + ", Titulo = " + titulo + ", Descricão = " + descricao + ", Imagem = "
                + imagem + ", Custo = " + custo + ", Categoria = " + categoria + ", Preparo = " + preparo
                + ", Utensilio = " + utensilio + "}";
    }

}
