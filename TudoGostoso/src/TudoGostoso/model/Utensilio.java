package TudoGostoso.model;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Utensilio implements HttpHandler {
    // #region Atriburos
    private int idUtensilio;
    private String Utensilio;

    private static ArrayList<Utensilio> utensilios = new ArrayList<>();
    private static int contador = 1;
    // #endregion

    // #region Construtores

    public Utensilio() {
    };

    public Utensilio(int idUtensilio, String utensilio) {
        this.idUtensilio = contador++;
        this.idUtensilio = idUtensilio;
        this.Utensilio = utensilio;

        utensilios.add(this);
    }
    // #endregion

    // #region Sets e Gets
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
    // #endregion

    // #region Sobrecarga
    @Override
    public String toString() {
        return "Utensilio { id = " + idUtensilio + ", Utensilio = " + Utensilio + "}";
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        if (method.equalsIgnoreCase("GET")) {
            handleGet(exchange);
        } else if (method.equalsIgnoreCase("POST")) {
            handlePost(exchange);
        } else {
            String response = "Método não suportado";
            byte[] bytes = response.getBytes("UTF-8");
            exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=UTF-8");
            exchange.sendResponseHeaders(405, bytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }

    private void handleGet(HttpExchange exchange) throws IOException {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < utensilios.size(); i++) {
            Utensilio u = utensilios.get(i);
            json.append(String.format("{\"id\": \"%s\",\"Utensílio\": \"%s\"}",
                    u.getIdUtensilio(), u.getUtensilio()));
            if (i < utensilios.size() - 1)
                json.append(",");
        }
        json.append("]");

        byte[] bytes = json.toString().getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(200, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }

    private void handlePost(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();
        String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);

        // Parse simples (sem Gson)
        // Exemplo de entrada: {"nome":"Italiana", "ativo":"true"}
        
        String sUtensilio = body.replaceAll(".*\"Utensílio\"\\s*:\\s*\"([^\"]+)\".*", "$1");
        boolean ativo = sUtensilio.toLowerCase().equals("true");

        new Utensilio(idUtensilio, Utensilio);

        String response = "{\"message\": \"Categoria adicionada com sucesso\"}";
        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(201, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
    // #endregion

}
