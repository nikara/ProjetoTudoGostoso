package TudoGostoso.model;

import java.util.ArrayList;


public class Categoria  {

    private int idCategoria;
    private String categoria;
    private Boolean status;

    private static ArrayList<Categoria> categorias = new ArrayList<>();
    private static int contador = 1;

    public Categoria(){};

    
    public Categoria( String Categoria,Boolean Status){
        this.idCategoria = contador++;
        this.categoria = Categoria;
        this.status = Status;

        categorias.add(this);
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

    public static void setCategorias (ArrayList<Categoria> novasCategorias){
        categorias = novasCategorias;
    }

    public static ArrayList<Categoria> getCategorias(){
        return categorias;
    }



    @Override
    public String toString(){
        return "Categoria { id = '"+ idCategoria +"', Categoria = " + categoria + ", Status= " + status + " }";
    }
}




