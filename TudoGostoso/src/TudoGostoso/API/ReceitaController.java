package TudoGostoso.API;

import TudoGostoso.DAO.*;
import TudoGostoso.model.*;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class ReceitaController implements HttpHandler {
    private ReceitaDAO dao = new ReceitaDAO();
    private CustoDAO custoDAO = new CustoDAO();
    private CategoriaDAO categoriaDAO = new CategoriaDAO();
    private PreparoDAO preparoDAO = new PreparoDAO();
    private UtensilioDAO utensilioDAO = new UtensilioDAO();

    @Override
    public void handle(HttpExchange exchange) throws IOException{
        String method = exchange.getRequestMethod();
        if(method.equalsIgnoreCase("GET")){
            handleGet(exchange);
        }else if (method.equalsIgnoreCase("POST")){
            handlePost(exchange);
        }else if (method.equalsIgnoreCase("PUT")){
            handlePut(exchange);
        }else if (method.equalsIgnoreCase("DELETE")){
            handleDelete(exchange);
        }else{
            String response = "Método não suportado";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=UTF-8");
            exchange.sendResponseHeaders(405, bytes.length);
            try(OutputStream os = exchange.getResponseBody()){
                os.write(bytes);
            }
        }
    }

    private void handleGet(HttpExchange exchange) throws IOException{
        StringBuilder json = new StringBuilder("[");
        try{
            List<Receita> receitas = dao.listarTodas();
            for(int i = 0; i < receitas.size(); i++){
                Receita r = receitas.get(i);
                json.append(String.format("{\"id\": \"%s\", \"titulo\": \"%s\", \"descricao\": \"%s\", \"imagem\"; \"%s\"}",
                r.getIdReceita(),r.getTitulo(),r.getDescricao(),r.getImagem()));
                if (i < receitas.size() -1){
                    json.append(",");
                }
            } 
        }catch (Exception e){
            e.printStackTrace();
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

        String titulo =  body.replaceAll(".*\"nome\"\\s*:\\s*\"([^\"]+)\".*", "$1");
        String descricao = body.replaceAll(".*\"descricao\"\\s*:\\s*\"([^\"]+)\".*", "$1");
        String imagem = body.replaceAll(".*\"descricao\"\\s*:\\s*\"([^\"]+)\".*", "$1");

        int custoId = Integer.parseInt((body.replaceAll(".*\"custoId\"\\s*:\\s*(\\d+).*", "$1")));
        int categoriaId = Integer.parseInt((body.replaceAll(".*\"categoriaId\"\\s*:\\s*(\\d+).*", "$1")));
        int preparoId = Integer.parseInt((body.replaceAll(".*\"preparoId\"\\s*:\\s*(\\d+).*", "$1")));
        int utensilioId = Integer.parseInt((body.replaceAll(".*\"utensilioId\"\\s*:\\s*(\\d+).*", "$1")));
        
        try{
            Receita novo = new Receita(
                titulo, 
                descricao, 
                imagem, 
                custoDAO.buscarCustoPorId(custoId), 
                preparoDAO.buscarPreparoPorId(preparoId), 
                categoriaDAO.buscarCategoriaPorId(categoriaId),
                utensilioDAO.buscarUtensilioPorId(utensilioId)
            );


            dao.inserirReceita(novo);
            String response = "{\"status\":\"sucesso\",\"mensagem\":\"Receita inserida com sucesso\"}";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
            exchange.sendResponseHeaders(201, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }

        } catch (Exception e){
            e.printStackTrace();
            String response = "{\"status\":\"erro\",\"mensagem\":\"" + e.getMessage() + "\"}";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
            exchange.sendResponseHeaders(500, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }
    }

    private void handlePut(HttpExchange exchange) throws IOException{
        InputStream is = exchange.getRequestBody();
        String body = new String(is.readAllBytes(),StandardCharsets.UTF_8);

        String idStr = body.replaceAll(".*\"id\"\\s*:\\s*(\\d+).*", "$1");
        String titulo =  body.replaceAll(".*\"nome\"\\s*:\\s*\"([^\"]+)\".*", "$1");
        String descricao = body.replaceAll(".*\"descricao\"\\s*:\\s*\"([^\"]+)\".*", "$1");
        String imagem = body.replaceAll(".*\"descricao\"\\s*:\\s*\"([^\"]+)\".*", "$1");

        int custoId = Integer.parseInt((body.replaceAll(".*\"custoId\"\\s*:\\s*(\\d+).*", "$1")));
        int categoriaId = Integer.parseInt((body.replaceAll(".*\"categoriaId\"\\s*:\\s*(\\d+).*", "$1")));
        int preparoId = Integer.parseInt((body.replaceAll(".*\"preparoId\"\\s*:\\s*(\\d+).*", "$1")));
        int utensilioId = Integer.parseInt((body.replaceAll(".*\"utensilioId\"\\s*:\\s*(\\d+).*", "$1")));

        try{
            int id = Integer.parseInt(idStr);
            Receita atualizada = new Receita(
                titulo, 
                descricao, 
                imagem, 
                custoDAO.buscarCustoPorId(custoId), 
                preparoDAO.buscarPreparoPorId(preparoId), 
                categoriaDAO.buscarCategoriaPorId(categoriaId), 
                utensilioDAO.buscarUtensilioPorId(utensilioId));
                atualizada.setIdReceita(id);

                dao.atualizarReceita(atualizada);

                String response = "{\"message\": \"Receita atualizado com sucesso\"}";
                byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
                exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
                exchange.sendResponseHeaders(200, bytes.length);
                try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }catch (Exception e){
            e.printStackTrace();
            String response = "{\"error\": \"Falha ao atualizar Receita\"}";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(400, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }

    }

    private void handleDelete(HttpExchange exchange) throws IOException{
        InputStream is = exchange.getRequestBody();
        String body = new String(is.readAllBytes(),StandardCharsets.UTF_8);

        String idStr = body.replaceAll(".*\"id\"\\s*:\\s*\"?(\\d+)\"?.*", "$1");

        try{
            int id = Integer.parseInt(idStr);
            dao.deletarReceita(id);

            String response = "{\"message\": \"Receita deletado com sucesso\"}";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }catch(Exception e){
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
