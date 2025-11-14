package TudoGostoso;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import TudoGostoso.DAO.DAO;
import TudoGostoso.model.*;


public class Menu { 
    public static void main(String[] args){
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
