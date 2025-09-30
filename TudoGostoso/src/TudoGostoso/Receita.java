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
    

    public Receita(int IdReceita, String titulo, String descricao, String imagem){
        this.IdReceita = IdReceita;
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagem = imagem;
        this.custos = new ArrayList<>();
        this.categorias = new ArrayList<>();
        this.preparos = new ArrayList<>();
        this.utensilios = new ArrayList<>();
    }

    public void adicionarCusto(Custo custo) {
        this.custos.add(custo);
    }

    public void adicionarCategoria(Categoria categoria){
        this.categorias.add(categoria);
    }

    public void adicionarPreparos(Preparo preparo){
        this.preparos.add(preparo);
    }

    public void adicionarUtensilios(Utensilio utensilio){
        this.utensilios.add(utensilio);
    }


    @Override
    public String toString(){
        return "Receita { Id = "+IdReceita+", Titulo = "+titulo+", Descricão = "+descricao+", Imagem = "+imagem+", Custo = "+custos+", Categoria = "+categorias+", Preparo = "+preparos+", Utensilio = "+utensilios+"}";
    }

}
