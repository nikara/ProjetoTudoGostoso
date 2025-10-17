package TudoGostoso.model;

public class Utensilio {
//#region Atriburos
    private int idUtensilio;
    private String utensilio;
//#endregion

//#region Construtores
    public Utensilio(int idUtensilio, String utensilio){
        this.idUtensilio = idUtensilio;
        this.utensilio = utensilio;
    }
//#endregion

//#region Sets e Gets
    public void setIdUtensilio(int idUtensilio){
        this.idUtensilio = idUtensilio;
    }
    public int getIdUtensilio(){
        return idUtensilio;
    }

    public void setUtensilio(String utensilio){
        this.utensilio = utensilio;
    }
    public String getUtensilio(){
        return utensilio;
    }
//#endregion

//#region Sobrecarga
    @Override
    public String toString(){
        return "Utensilio { id = "+ idUtensilio+", Utensilio = "+utensilio+"}";
    }
//#endregion

}
