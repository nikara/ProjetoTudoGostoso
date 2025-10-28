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

public class Categoria implements HttpHandler {
//#region Atributos
    private int idCategoria;
    private String categoria;
    private Boolean status;

    private static ArrayList<Categoria> categorias = new ArrayList<>();
    private static int contador = 1;

//#endregion

//#region Construtor
    public Categoria(){};

    
    public Categoria( String Categoria,Boolean Status){
        this.idCategoria = contador++;
        this.categoria = Categoria;
        this.status = Status;

        categorias.add(this);
    }
//#endregion

//#region Sets e Gets
    public void setIdCategoria(int idCategoria){
        this.idCategoria = idCategoria;
    }

    public int getIdCategoria(){
        return idCategoria;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }

    public boolean getStatus(){
        return status;
    }

    public static void setCategorias (ArrayList<Categoria> novasCategorias){
        categorias = novasCategorias;
    }

    public static ArrayList<Categoria> getCategorias(){
        return categorias;
    }

//#endregion

//#region Metodos



//#endregion

//#region Sobrecarga
    @Override
    public String toString(){
        return "Categoria { id = '"+ idCategoria +"', Categoria = " + categoria + ", Status= " + status + " }";
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException{
        String method = exchange.getRequestMethod();
        if(method.equalsIgnoreCase("GET")){
            handleGet(exchange);
        }else if( method.equalsIgnoreCase("POST")){
            handlePost(exchange);
        }else {
            String response = "Método não suportado";
            byte[] bytes = response.getBytes("UTF-8");
            exchange.getRequestHeaders().add("Content-Type", "text/plain; charset=UTF-8");
            exchange.sendResponseHeaders(405, bytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }


    private void handleGet(HttpExchange exchange) throws IOException{
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < categorias.size(); i++){
            Categoria c = categorias.get(i);
            json.append(String.format("{\"Id\": \"%d\",\"Categoria\": \"%s\",\"Status\": \"%s\"}",
            c.getIdCategoria(),c.getCategoria()));
            if(i < categorias.size() - 1) json.append(",");
        }
        json.append("]");

        byte[] bytes = json.toString().getBytes(StandardCharsets.UTF_8);
        exchange.getRequestHeaders().add("Content-Type", "aplication/json; charset = UTF-8");
        exchange.sendResponseHeaders(200, bytes.length);
        try(OutputStream os = exchange.getResponseBody()){
            os.write(bytes);
        }

    }

    private void handlePost (HttpExchange exchange) throws IOException{
        InputStream is = exchange.getRequestBody();
        String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);

       
        String categoria = body.replaceAll(".*\"categoria\"\\s*:\\s*\"([^\"]+)\".*", "$1");
        String status = body.replaceAll(".*\"status\"\\s*:\\s*\"([^\"]+)\".*", "$1");
        boolean ativo = status.toLowerCase().equals("true");


        new Categoria(categoria,ativo);

        String respose = "{\"message\":\"Categoria adicionada com sucesso\"}";
        byte[] bytes = respose.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().add("Content-Type","application/json; charset=UTF-8");
        exchange.sendResponseHeaders(201, bytes.length);
        try(OutputStream os = exchange.getResponseBody()){
            os.write(bytes);
        }



    }





//#endregion
    
}