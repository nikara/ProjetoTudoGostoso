package TudoGostoso.API;

import TudoGostoso.DAO.CategoriaDAO;
import TudoGostoso.model.Categoria;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CategoriaController implements HttpHandler {
    private CategoriaDAO dao = new CategoriaDAO();

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
        try {
            List<Categoria> categorias = dao.listarCategoria();
            for (int i = 0; i < categorias.size(); i++) {
                Categoria c = categorias.get(i);
                json.append(String.format(
                        "{\"id\": \"%s\", \"categoria\": \"%s\", \"status\": \"%s\"}",
                        c.getIdCategoria(), c.getCategoria(), c.getStatus()
                ));
                if (i < categorias.size() - 1) json.append(",");
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        String categoriaNome = body.replaceAll(".*\"categoria\"\\s*:\\s*\"([^\"]+)\".*", "$1");
        String sStatus = body.replaceAll(".*\"status\"\\s*:\\s*\"([^\"]+)\".*", "$1");
        boolean status = sStatus.equalsIgnoreCase("true");

        Categoria nova = new Categoria(categoriaNome, status);
        try {
            dao.inserirCategoria(nova);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String response = "{\"message\": \"Categoria adicionada com sucesso\"}";
        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(201, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
}