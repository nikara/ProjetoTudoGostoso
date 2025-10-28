package TudoGostoso.model;

import java.util.ArrayList;

import java.net.http.HttpResponse;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;


public class Custo implements HttpHandler {

//#region Atributos
    private int idCusto;
    private String custo;

    private static ArrayList<Custo> custos = new ArrayList<>();
    private static int contator = 1;
//#endregion

//#region Construtores

    public Custo(){

    };
    
    public Custo(int idCusto, String custo){
        this.idCusto = contator++;
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

    private static void setCustos (ArrayList<Custo> novosCustos){
        custos = novosCustos;
    }

    private static ArrayList<Custo> getCustos(){
        return custos;
    }


//#endregion

//#region Sobrecargas
    @Override
    public String toString(){
        return "Custo { id = "+ idCusto +", Custo "+ custo +" }";
    }

    @Override

    public void handle(HttpExchange exchange) throws IOException{
        
    }

    private void handlePost (HttpExchange exchange) throws IOException{
        InputStream is =  exchange.getRequestBody();
        String body = new String(is.readAllBytes(),StandardCharsets.UTF_8);

        // Exemplo de entrada: {"Custo":"12.22"}
        String custoString = body.replaceAll(".*\"categoria\"\\s*:\\s*\"([^\"]+)\".*","$1");

        new Custo();

        String response = "{\"message\":\"Categoria adicionada com sucesso\"}";
        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
    }



//#endregion


}
