package TudoGostoso;

public class Utensilio {
    
    int idUtensilio;
    String utensilio;

    public Utensilio(int idUtensilio, String utensilio){
        this.idUtensilio = idUtensilio;
        this.utensilio = utensilio;
    }

    public int getId(){
        return idUtensilio;
    }

    @Override
    public String toString(){
        return "Utensilio { id = "+ idUtensilio+", Utensilio = "+utensilio+"}";
    }
}
