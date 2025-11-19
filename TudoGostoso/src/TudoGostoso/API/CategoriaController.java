package TudoGostoso.API;

import TudoGostoso.model.Categoria;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CategoriaController implements HttpHandler {
    private static ArrayList<Categoria> categorias = new ArrayList<>();
    private static int contator = 1;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        if (method.equalsIgnoreCase("GET")) {
            handleGet(exchange);
        } else if (method.equalsIgnoreCase("POST")) {
            handlePost(exchange);
        } else {
            String response = "Método não suportado";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "text/plain; charse=UTF-8");
            exchange.sendResponseHeaders(405, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }
    }

    private void handleGet(HttpExchange exchange) throws IOException{
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < categorias.size(); i++){
            Categoria c = categorias.get(i);
            json.append(String.format("{\"id\": \"%s\", \"nome\": \"%s\", \"email\": \"%s\", \"ativo\"; \"%s\"}", c.getCategoria()));
            if(i < categorias.size() - 1) json.append(",");
        }
        json.append("]");

        byte[] bytes = json.toString().getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(200, bytes.length);
        try (OutputStream os = exchange.getResponseBody()){
            os.write(bytes);
        }
    }

    private void handlePost(HttpExchange exchange) throws IOException{
        InputStream is = exchange.getRequestBody();
        String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        
    }



}
