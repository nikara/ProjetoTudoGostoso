package TudoGostoso.API;

import TudoGostoso.model.Preparo;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class PreparoController implements HttpHandler {
    private static ArrayList<Preparo> preparos = new ArrayList<>();
    private static int contador = 1;

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
            exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=UTF-8");
            exchange.sendResponseHeaders(405, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }
    }

    private void handleGet(HttpExchange exchange) throws IOException {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < preparos.size(); i++) {
            Preparo p = preparos.get(i);
            json.append(String.format(
                "{\"id\": \"%s\", \"modoPreparo\": \"%s\", \"urlVideo\": \"%s\", \"tempoDePreparo\": \"%s\"}",
                p.getIdPreparo(), p.getModoPreparo(), p.getUrlVideo(), p.getTempoDePreparo()
            ));
            if (i < preparos.size() - 1) json.append(",");
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
        // Exemplo de entrada:
        // {"modoPreparo":"Misture bem", "urlVideo":"http://youtube.com/abc", "tempoDePreparo":"30min"}
        String modoPreparo = body.replaceAll(".*\"modoPreparo\"\\s*:\\s*\"([^\"]+)\".*", "$1");
        String urlVideo = body.replaceAll(".*\"urlVideo\"\\s*:\\s*\"([^\"]+)\".*", "$1");
        String tempoDePreparo = body.replaceAll(".*\"tempoDePreparo\"\\s*:\\s*\"([^\"]+)\".*", "$1");

        Preparo novo = new Preparo(contador++, modoPreparo, urlVideo, tempoDePreparo);
        preparos.add(novo);

        String response = "{\"message\": \"Preparo adicionado com sucesso\"}";
        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(201, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
}