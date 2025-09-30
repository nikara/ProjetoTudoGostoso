package TudoGostoso;
import java.util.ArrayList;
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
    

    public Receita(int IdReceita, String titulo, String descricao, String imagem, List<Categoria> categoria, List<Preparo> preparos, List<Utensilio> utensilios){
        this.IdReceita = IdReceita;
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagem = imagem;
        this.custos = new ArrayList<>();
        this.categorias = categoria;
        this.preparos = preparos;
        this.utensilios = utensilios;
    }

    public void adicionarCusto(Custo custo) {
        this.custos.add(custo);
    }

    @Override
    public String toString(){
        return "Receita { Id = "+IdReceita+", Titulo = "+titulo+", Descricão = "+descricao+", Imagem = "+imagem+", Custo = "+custos+", Categoria = "+categorias+", Preparo = "+preparos+", Utensilio = "+utensilios+"}";
    }

}
