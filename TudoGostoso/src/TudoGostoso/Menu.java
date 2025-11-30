package TudoGostoso;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;

import TudoGostoso.DAO.DAO;
import TudoGostoso.API.*;   
import TudoGostoso.model.*; 

public class Menu {
    public static void main(String[] args) throws IOException {

        // Criando o servidor HTTP
        HttpServer server = HttpServer.create(new InetSocketAddress(8089), 0);

        // Definindo as rotas
        server.createContext("/usuarios", new UsuarioController());
        server.createContext("/categorias", new CategoriaController());
        server.createContext("/custos", new CustoController());
        server.createContext("/preparos", new PreparoController());
        server.createContext("/utensilios", new UtensilioController());
        server.createContext("/receitas", new ReceitaController());

        // Iniciando o servidor
        server.setExecutor(null);
        server.start();
        System.out.println("Servidor rodando em http://localhost:8089/");
        System.out.println("Endpoints disponíveis:");
        System.out.println("GET/POST/PUT/DELETE -> /usuarios");
        System.out.println("GET/POST/PUT/DELETE -> /categorias");
        System.out.println("GET/POST/PUT/DELETE -> /custos");
        System.out.println("GET/POST/PUT/DELETE -> /preparos");
        System.out.println("GET/POST/PUT/DELETE -> /utensilios");
        System.out.println("GET/POST/PUT/DELETE -> /receitas");

        /*  Exemplo de integração com banco de dados
        try {
            Connection conexao = DAO.createConnection();

            Custo custo = new Custo();
            custo.setCusto("custo");

            PreparedStatement stmt = conexao.prepareStatement(
                "INSERT INTO custo (custo) VALUES (?);"
            );

            stmt.setString(1, custo.getCusto());
            stmt.execute();

            System.out.println("Custo inserido no banco com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir custo: " + e);
        }
        */

    }
}