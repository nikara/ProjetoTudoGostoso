package TudoGostoso.model;



public class Utensilio  {
    
    private int idUtensilio;
    private String Utensilio;
    
    public Utensilio() {
    };

    public Utensilio(int idUtensilio, String utensilio) {
        
        this.idUtensilio = idUtensilio;
        this.Utensilio = utensilio;

        
    }
    
    public void setIdUtensilio(int idUtensilio) {
        this.idUtensilio = idUtensilio;
    }

    public int getIdUtensilio() {
        return idUtensilio;
    }

    public void setUtensilio(String utensilio) {
        this.Utensilio = utensilio;
    }

    public String getUtensilio() {
        return Utensilio;
    }
    
    @Override
    public String toString() {
        return "Utensilio { id = " + idUtensilio + ", Utensilio = " + Utensilio + "}";
    }

}
