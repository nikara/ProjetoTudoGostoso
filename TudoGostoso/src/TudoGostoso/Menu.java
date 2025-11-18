package TudoGostoso;


import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import TudoGostoso.DAO.DAO;
import TudoGostoso.model.*;


public class Menu { 
    public static void main(String[] args) throws IOException{
        
        //Criando o servidor HTTP
        HttpServer server = HttpServer.create(new InetSocketAddress(8089),0);

        //Definindo as rotas

        //Iniciando o servidor
        server.setExecutor(null);
        server.start();
        System.out.println("Servidor rodando em http://localhost:8089/");
        
        try{
            Connection conexao = DAO.createConnection();

            Custo custo = new Custo();
            custo.setCusto("custo");

            PreparedStatement stmt = conexao.prepareStatement(
                "INSERT INTO custo (custo) VALUES (?);"
            );

            stmt.setString(1, custo.getCusto());
            stmt.execute();


        }catch(Exception e){
            System.out.println(e);
        }


    }
    
}
