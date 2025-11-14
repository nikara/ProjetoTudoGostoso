package TudoGostoso.model;

import java.util.ArrayList;

public class Utensilio  {
    
    private int idUtensilio;
    private String Utensilio;

    private static ArrayList<Utensilio> utensilios = new ArrayList<>();
    private static int contador = 1;
    
    public Utensilio() {
    };

    public Utensilio(int idUtensilio, String utensilio) {
        this.idUtensilio = contador++;
        this.idUtensilio = idUtensilio;
        this.Utensilio = utensilio;

        utensilios.add(this);
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
