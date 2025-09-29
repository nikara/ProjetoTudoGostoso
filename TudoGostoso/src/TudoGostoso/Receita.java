package TudoGostoso;
import java.util.List;



public class Receita {
    // Variaveis primitivas
    int IdReceita;
    String titulo;
    String descricao;
    String imagem;

    // Objetos
    List<Custo> custos;
    List<Categoria> categorias;
    List<Preparo> preparos;
    List<Utensilio> utensilios;
    

    public Receita(int IdReceita, String titulo, String descricao, String imagem, List<Custo> custo, List<Categoria> categoria, List<Preparo> preparos, List<Utensilio> utensilios){
        this.IdReceita = IdReceita;
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagem = imagem;
        this.custos = custo;
        this.categorias = categoria;
        this.preparos = preparos;
        this.utensilios = utensilios;
    }

    @Override
    public String toString(){
        return "Receita { Id = "+IdReceita+", Titulo = "+titulo+", Descricão = "+descricao+", Imagem = "+imagem+", Custo = "+custos+", Categoria = "+categorias+", Preparo = "+preparos+", Utensilio = "+utensilios+"}";
    }

}
