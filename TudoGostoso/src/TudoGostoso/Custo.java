package TudoGostoso;

public class Custo {
    int idCusto;
    String custo;

    public Custo(int idCusto, String custo){
        this.idCusto = idCusto;
        this.custo = custo;
    }

    public int getId(){
        return idCusto;
    }

    @Override
    public String toString(){
        return "Custo { id = "+ idCusto +", Custo "+ custo +" }";
    }


}
