package TudoGostoso.API;

import TudoGostoso.DAO.UtensilioDAO;
import TudoGostoso.model.Utensilio;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class UtensilioController implements HttpHandler {
    private UtensilioDAO dao = new UtensilioDAO();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        if (method.equalsIgnoreCase("GET")) {
            handleGet(exchange);
        } else if (method.equalsIgnoreCase("POST")) {
            handlePost(exchange);
        } else if (method.equalsIgnoreCase("PUT")) {
            handlePut(exchange);
        } else if (method.equalsIgnoreCase("DELETE")){
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
            List<Utensilio> utensilios = dao.listarTodos();
            for (int i = 0; i < utensilios.size(); i++) {
                Utensilio u = utensilios.get(i);
                json.append(String.format(
                    "{\"id\": \"%s\", \"utensilio\": \"%s\"}",
                    u.getIdUtensilio(), u.getUtensilio()
                ));
                if (i < utensilios.size() - 1) json.append(",");
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
        String utensilioNome = body.replaceAll(".*\"utensilio\"\\s*:\\s*\"([^\"]+)\".*", "$1");

        Utensilio novo = new Utensilio();
        novo.setUtensilio(utensilioNome);

        try {
            dao.inserirUtensilio(novo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String response = "{\"message\": \"Utensílio adicionado com sucesso\"}";
        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(201, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }

    private void handlePut(HttpExchange exchange) throws IOException{
        InputStream is = exchange.getRequestBody();
        String body = new String(is.readAllBytes(),StandardCharsets.UTF_8);

        String idStr = body.replace(".*\"id\"\\s*\"?(\\d+)\"?.*", "$1");
        String utensilio = body.replace(".*\"utensilio\"\\s*\"([^\"]+)\".*", "$1");

        try{
            int id = Integer.parseInt(idStr);
            Utensilio atualizado = new Utensilio();
            atualizado.setIdUtensilio(id);
            atualizado.setUtensilio(utensilio);

            dao.atualizarUtensilio(atualizado);

            String response = "{\"message\": \"Utensilio atualizado com sucesso\"}";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()){
                os.write(bytes);
            }
        }catch (Exception e ){
            e.printStackTrace();
            String response = "{\"error\": \"Falha ao atualizar utensilio\"}";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(400, bytes.length);
            try (OutputStream os = exchange.getResponseBody()){
                os.write(bytes);
            }

        }
    }

    private void handleDelete(HttpExchange exchange) throws IOException{
        InputStream is = exchange.getRequestBody();
        String body = new String(is.readAllBytes(),StandardCharsets.UTF_8);

        String idStr = body.replaceAll(".\"id\"\\s*:\\s*\"?(\\d+)\"?.*","$1");

        try{
            int id = Integer.parseInt(idStr);
            dao.deletarUtensilio(id);

            String response = "{\"message\": \"Utensilio deletado com sucesso\"}";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()){
                os.write(bytes);
            }
        }catch (Exception e){
            e.printStackTrace();
            String response = "{\"error\": \"Falha ao deletar Utensilio\"}";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(400, bytes.length);
            try(OutputStream os = exchange.getResponseBody()){
                os.write(bytes);
            }
        }
    }




}