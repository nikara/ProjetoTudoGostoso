package TudoGostoso.DAO;

import TudoGostoso.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import java.sql.SQLException;



public class CategoriaDAO {
    
    public void inserirCategoria(Categoria categoria)throws Exception{
        Connection connection = DAO.createConnection();

        try{
        PreparedStatement stmt = connection.prepareStatement("INSERT into categoria (categoria,status) VALUE (?,?);");
        stmt.setString(1, categoria.getCategoria());
        stmt.setBoolean(2, categoria.getStatus());

        int verifica = stmt.executeUpdate();
        
        if( verifica == 0 ){
            throw new Exception("Nenhuma categoria inserida");
        }

        
        stmt.close();
        DAO.closeConnection();

        }catch(SQLException e){
            throw new Exception ("Erro ao inserir categoria " + e.getMessage(), e);
        }

    }

    public void deletarCategoria(Categoria categoria)throws Exception{
        Connection connection = DAO.createConnection();

        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM categoria WHERE idCategoria = ?;");
            stmt.setInt(1, categoria.getIdCategoria());

            int verifica = stmt.executeUpdate();
            if( verifica == 0){
                throw new  Exception( "Nenhuma categoria deletada");
            }

            stmt.close();
            DAO.closeConnection();

        } catch (SQLException e) {
            throw new Exception ("Erro ao deletar Categoria " + e.getMessage(), e);
        }
    }

    public void AtualizarCategoria(Categoria categoria)throws Exception{
        Connection connection = DAO.createConnection();

        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE categoria SET categoria = ?, status = ? WHERE idCategoria=?");
            stmt.setString(1, categoria.getCategoria());
            stmt.setBoolean(2, categoria.getStatus());
            stmt.setInt(3, categoria.getIdCategoria());

            int verifica = stmt.executeUpdate();
            if( verifica == 0){
                throw new  Exception( "Nenhuma categoria atualizada");
            }

            stmt.close();
            DAO.closeConnection();

        }catch (SQLException e) {
            throw  new Exception("Erro ao atualizar Categoria "+ e.getMessage(), e);
        }
    }

    public void buscarPorId(int idCategoria)throws Ex




}
