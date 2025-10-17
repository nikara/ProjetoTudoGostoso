package TudoGostoso.model;

public class Receita {
    // Variaveis primitivas
    int IdReceita;
    String titulo;
    String descricao;
    String imagem;

    // Objetos
    Custo custo;
    Categoria categoria;
    Preparo preparo;
    Utensilio utensilio;
    

    public Receita(int IdReceita, String titulo, String descricao, String imagem,Custo custo, Preparo preparo,Categoria categoria, Utensilio utensilio){
        this.IdReceita = IdReceita;
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagem = imagem;
        this.custo = custo;
        this.categoria = categoria;
        this.preparo = preparo;
        this.utensilio = utensilio;
    }

    @Override
    public String toString(){
        return "Receita { Id = "+IdReceita+", Titulo = "+titulo+", Descricão = "+descricao+", Imagem = "+imagem+", Custo = "+custo+", Categoria = "+categoria+", Preparo = "+preparo+", Utensilio = "+utensilio+"}";
    }

}
