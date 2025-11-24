package TudoGostoso.model;




public class Categoria  {

    private int idCategoria;
    private String categoria;
    private Boolean status;

    public Categoria(){};

    
    public Categoria(int idCategoria ,String Categoria,Boolean Status){
        this.idCategoria = idCategoria;
        this.categoria = Categoria;
        this.status = Status;  
    }
    public Categoria(String Categoria,Boolean Status){
        this.categoria = Categoria;
        this.status = Status;  
    }


    public void setIdCategoria(int idCategoria){
        this.idCategoria = idCategoria;
    }

    public int getIdCategoria(){
        return idCategoria;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }

    public boolean getStatus(){
        return status;
    }

    
    @Override
    public String toString(){
        return "Categoria { id = '"+ idCategoria +"', Categoria = " + categoria + ", Status= " + status + " }";
    }
}




