package TudoGostoso;

public class Categoria {

    int idCategoria;
    String Categoria;
    Boolean Status;

    public Categoria(int idCategoria, String Categoria,Boolean Status){
        this.idCategoria = idCategoria;
        this.Categoria = Categoria;
        this.Status = Status;
    }

    public int getId(){
        return idCategoria;
    }

    @Override
    public String toString(){
        return "Categoria { id = '"+ idCategoria +"', Categoria = " + Categoria + ", Status= " + Status + " }";
    }
    
}
