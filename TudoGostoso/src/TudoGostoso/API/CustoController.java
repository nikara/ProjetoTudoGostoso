package TudoGostoso.API;

import TudoGostoso.DAO.CustoDAO;
import TudoGostoso.model.Custo;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CustoController implements HttpHandler {
    private CustoDAO dao = new CustoDAO();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        if (method.equalsIgnoreCase("GET")) {
            handleGet(exchange);
        } else if (method.equalsIgnoreCase("POST")) {
            handlePost(exchange);
        } else if (method.equalsIgnoreCase("PUT")) {
            handlePut(exchange);
        } else if (method.equalsIgnoreCase("DELETE")) {
            handleDelete(exchange);
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
            List<Custo> custos = dao.listarTodos();
            for (int i = 0; i < custos.size(); i++) {
                Custo c = custos.get(i);
                json.append(String.format(
                        "{\"id\": \"%s\", \"custo\": \"%s\"}",
                        c.getId(), c.getCusto()));
                if (i < custos.size() - 1)
                    json.append(",");
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

        // Parse simples do JSON
        String custoValor = body.replaceAll(".*\"custo\"\\s*:\\s*\"([^\"]+)\".*", "$1");

        Custo novo = new Custo();
        novo.setCusto(custoValor);

        try {
            dao.inserirCusto(novo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String response = "{\"message\": \"Custo adicionado com sucesso\"}";
        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(201, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }

    private void handlePut(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();
        String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);

        String idStr = body.replaceAll(".*\"id\"\\s*:\\s*\"?(\\d+)\"?.*", "$1");
        String custoValor = body.replaceAll(".*\"custo\"\\s*:\\s*\"([^\"]+)\".*", "$1");

        try {
            int id = Integer.parseInt(idStr);
            Custo atualizado = new Custo();
            atualizado.setIdCusto(id);
            atualizado.setCusto(custoValor);

            dao.atualizarCusto(atualizado);

            String response = "{\"message\": \"Custo atualizado com sucesso\"}";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String response = "{\"error\": \"Falha ao atualizar custo\"}";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(400, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }

    }

    private void handleDelete(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();
        String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);

        String idStr = body.replaceAll(".*\"id\"\\s*:\\s*\"?(\\d+)\"?.*", "$1");

        try {
            int id = Integer.parseInt(idStr);
            dao.deletarCusto(id);

            String response = "{\"message\": \"Custo deletado com sucesso\"}";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String response = "{\"error\": \"Falha ao deletar custo\"}";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(400, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }

    }

}