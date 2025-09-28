package TudoGostoso;

public class Preparo {

    int idPreparo;
    String modoPreparo;
    String urlVideo;
    int tempoDePreparo;

     public Preparo(int idPreparo, String modoPreparo,String urlVideo, int tempoDePreparo){
        this.idPreparo = idPreparo;
        this.modoPreparo = modoPreparo;
        this.urlVideo = urlVideo;
        this.tempoDePreparo = tempoDePreparo;
    }

    @Override
    public String toString(){
        return "Preparo{ id = "+idPreparo+", Modo de Preparo = "+modoPreparo+", Url do video = "+urlVideo+", Tempo de Preparo = "+tempoDePreparo+"}";
    }

    
}
