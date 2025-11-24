package TudoGostoso.API;

import TudoGostoso.DAO.UsuarioDAO;
import TudoGostoso.model.Usuario;
import TudoGostoso.model.Administrador;
import TudoGostoso.model.Consumidor;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class UsuarioController implements HttpHandler {
    private UsuarioDAO dao = new UsuarioDAO();

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
            List<Usuario> usuarios = dao.listarTodos();
            for (int i = 0; i < usuarios.size(); i++) {
                Usuario u = usuarios.get(i);
                String tipo = (u instanceof Administrador) ? "Administrador" : "Consumidor";
                json.append(String.format(
                    "{\"id\": \"%s\", \"nome\": \"%s\", \"email\": \"%s\", \"tipo\": \"%s\"}",
                    u.getIdUsuario(), u.getNome(), u.getEmail(), tipo
                ));
                if (i < usuarios.size() - 1) json.append(",");
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

        
        String nome = body.replaceAll(".*\"nome\"\\s*:\\s*\"([^\"]+)\".*", "$1");
        String email = body.replaceAll(".*\"email\"\\s*:\\s*\"([^\"]+)\".*", "$1");
        String tipo = body.replaceAll(".*\"tipo\"\\s*:\\s*\"([^\"]+)\".*", "$1");

        Usuario novo;
        if (tipo.equalsIgnoreCase("administrador")) {
            novo = new Administrador(0, nome, email, "", 0, "", "", "", "", "");
        } else {
            novo = new Consumidor(0, nome, email, "", 0, "", "", "", "", "");
        }

        try {
            dao.inserirUsuario(novo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String response = "{\"message\": \"Usuário adicionado com sucesso\"}";
        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(201, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
}