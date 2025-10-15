package TudoGostoso;

public class Preparo {

//#region Atributos
    private int idPreparo;
    private String modoPreparo;
    private String urlVideo;
    private String tempoDePreparo;
//#endregion

//#region Cosntrutores
     public Preparo(int idPreparo, String modoPreparo,String urlVideo, String tempoDePreparo){
        this.idPreparo = idPreparo;
        this.modoPreparo = modoPreparo;
        this.urlVideo = urlVideo;
        this.tempoDePreparo = tempoDePreparo;
    }
//#endregion

//#region Sets e Gets

    public void setIdPreparo(int idPreparo){
        this.idPreparo = idPreparo;
    }
    public int getIdPreparo(){
        return idPreparo;
    }

    public void setModoPreparo(String modoPreparo){
        this.modoPreparo = modoPreparo;
    }
    public String getModoPreparo(){
        return modoPreparo;
    }

    public void setUrlVideo(String urlVideo){
        this.urlVideo = urlVideo;
    }
    public String getUrlVideo(){
        return urlVideo;
    }

    public void setTempoDePreparo(String tempoDePreparo){
        this.tempoDePreparo = tempoDePreparo;
    }

    public String getTempoDePreparo(){
        return tempoDePreparo;
    }
//#endregion

//#region Sobrecargar

    @Override
    public String toString(){
        return "Preparo{ id = "+idPreparo+", Modo de Preparo = "+modoPreparo+", Url do video = "+urlVideo+", Tempo de Preparo = "+tempoDePreparo+"}";
    }

//#endregion

    
}
