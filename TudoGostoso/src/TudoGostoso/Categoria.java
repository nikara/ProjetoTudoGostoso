package TudoGostoso;

public class Categoria {
//#region Atributos
    private int idCategoria;
    private String categoria;
    private Boolean status;
//#endregion

//#region Construtor
    public Categoria(int idCategoria, String Categoria,Boolean Status){
        this.idCategoria = idCategoria;
        this.categoria = Categoria;
        this.status = Status;
    }
//#endregion

//#region Sets e Gets
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
//#endregion

//#region Sobrecarga
    @Override
    public String toString(){
        return "Categoria { id = '"+ idCategoria +"', Categoria = " + categoria + ", Status= " + status + " }";
    }

//#endregion
    
}
