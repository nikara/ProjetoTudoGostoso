package TudoGostoso.API;

import TudoGostoso.model.Usuario;
import TudoGostoso.model.Administrador;
import TudoGostoso.model.Consumidor;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class UsuarioController implements HttpHandler {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
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
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            String tipo = (u instanceof Administrador) ? "Administrador" : "Consumidor";
            json.append(String.format(
                "{\"id\": \"%s\", \"nome\": \"%s\", \"email\": \"%s\", \"tipo\": \"%s\"}",
                u.getIdUsuario(), u.getNome(), u.getEmail(), tipo
            ));
            if (i < usuarios.size() - 1) json.append(",");
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
        // {"nome":"Nickolas","email":"nick@example.com","tipo":"administrador"}
        String nome = body.replaceAll(".*\"nome\"\\s*:\\s*\"([^\"]+)\".*", "$1");
        String email = body.replaceAll(".*\"email\"\\s*:\\s*\"([^\"]+)\".*", "$1");
        String tipo = body.replaceAll(".*\"tipo\"\\s*:\\s*\"([^\"]+)\".*", "$1");

        Usuario novo;
        if (tipo.equalsIgnoreCase("administrador")) {
            novo = new Administrador(contador++, nome, email, "", 0, "", "", "", "", "");
        } else {
            novo = new Consumidor(contador++, nome, email, "", 0, "", "", "", "", "");
        }

        usuarios.add(novo);

        String response = "{\"message\": \"Usuário adicionado com sucesso\"}";
        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(201, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
}