package TudoGostoso;



public class Receita {
    int IdReceita;
    String titulo;
    String descricao;
    String imagem;


    Custo custo;
    Categoria categoria;
    Preparo preparo;
    Utensilio utensilio;

    public Receita(int IdReceita, String titulo, String descricao, String imagem,Custo custo, Categoria categoria, Preparo preparo, Utensilio utensilio){
        this.IdReceita = IdReceita;
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagem = imagem;
        this.custo = custo;
        this.categoria = categoria;
        this.preparo = preparo;
        this.utensilio = utensilio;
    }

}
