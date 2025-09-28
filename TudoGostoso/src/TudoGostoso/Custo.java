package TudoGostoso;

public class Custo {
    int idCusto;
    String custo;

    public Custo(int idCusto, String custo){
        this.idCusto = idCusto;
        this.custo = custo;
    }

    @Override
    public String toString(){
        return "Custo { id = "+ idCusto +", Custo "+ custo +" }";
    }


}
