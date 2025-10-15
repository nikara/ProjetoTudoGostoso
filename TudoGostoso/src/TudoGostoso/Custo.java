package TudoGostoso;

public class Custo {

//#region Atributos
    private int idCusto;
    private String custo;
//#endregion

//#region Construtores
    public Custo(int idCusto, String custo){
        this.idCusto = idCusto;
        this.custo = custo;
    }
//#endregion

//#region Sets e Gets

    public void setIdCusto(int idCusto){
        this.idCusto = idCusto;
    }
    public int getId(){
        return idCusto;
    }

    public void setCusto(String custo){
        this.custo = custo;
    }

    public String getCusto(){
        return custo;
    }
//#endregion

//#region Sobrecargas
    @Override
    public String toString(){
        return "Custo { id = "+ idCusto +", Custo "+ custo +" }";
    }

//#endregion


}
