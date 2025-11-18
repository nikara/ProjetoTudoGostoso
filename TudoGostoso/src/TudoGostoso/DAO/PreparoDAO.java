package TudoGostoso.DAO;

import TudoGostoso.model.Categoria;
import TudoGostoso.model.Preparo;

import java.beans.PropertyDescriptor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import java.sql.SQLException;

public class PreparoDAO {
    
    public void inserirPreparo(Preparo preparo) throws Exception{
        Connection connection = DAO.createConnection();

        try{
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO preparo (modoPreparo,urlVideo,tempoDePreparo) VALUE (?,?,?);");
            stmt.setString(1,preparo.getModoPreparo());
            stmt.setString(2, preparo.getUrlVideo());
            stmt.setString(3, preparo.getTempoDePreparo());

            int verifica = stmt.executeUpdate();
            if(verifica == 0){
                throw new Exception("Nenhum Produto inserido");
            }
            stmt.close();
            DAO.closeConnection(); 

        }catch(SQLException e){
            throw new Exception("Erro ao inserir Preparo " + e.getMessage(), e);
        }
    }

    public void deletarProduto(Preparo preparo) throws Exception{
        Connection connection = DAO.createConnection();

        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM preparo WHERE idPreparo = ?");
            stmt.setInt(1, preparo.getIdPreparo());
            int verifica = stmt.executeUpdate();
            if (verifica == 0) {
                throw new Exception("Nenhum preparo deletada");
            }

            stmt.close();
            DAO.closeConnection();
            
        }catch(SQLException e){
            throw new Exception("Erro ao deletar preparo"+ e.getMessage(), e);
        }
    }
    
    public void atualizarPreparo(Preparo preparo) throws Exception{
        Connection connection = DAO.createConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement("UPDATE preparo SET modoPreparo = ?, urlVideo = ?, tempoDePreparo = ? HWERE idPreparo = ?; ");
            stmt.setString(1, preparo.getModoPreparo());
            stmt.setString(2, preparo.getUrlVideo());   
            stmt.setString(3, preparo.getUrlVideo());
            stmt.setInt(4, preparo.getIdPreparo());

            int verifica = stmt.executeUpdate();
            if (verifica == 0) {
                throw new Exception("Nenhum preparo atualizada");
            }

            stmt.close();
            DAO.closeConnection();

        }catch(Exception e){
            throw new Exception("Erro ao atualizar preparo" + e.getMessage(), e);
        }
    }
        public Preparo buscarPorId(int idPreparo)throws Exception{
        Connection connection = DAO.createConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM preparo WHERE idPreparo = ?");
            stmt.setInt(1, idPreparo);
            ResultSet rs = stmt.executeQuery();
            Preparo preparo = null;
            if(rs.next()){
                preparo = new Preparo(rs.getInt("idPreparo"),rs.getString("modoPreparo"),rs.getString("urlVideo"),rs.getString("tempoDePreparo"));
                
            }
            rs.close();
            stmt.close();
            DAO.closeConnection();
            return preparo;
        }catch(SQLException e){
            throw new Exception("Erro ao buscar id "+e.getMessage(), e);
        }
        
    }

    public List<Preparo> listarPreparo() throws Exception{
        Connection connection = DAO.createConnection();

        try{
        ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM preparo;");
        List<Preparo> lista = new ArrayList<>();

        while (rs.next()) {
            Preparo preparo = new Preparo(
                rs.getInt("idPreparo"),
                rs.getString("modoPreparo"),
                rs.getString("urlVideo"),
                rs.getString("tempoDePreparo")
            ); 
            lista.add(preparo);
        }
        rs.close();
        DAO.closeConnection();
        return lista;
        
        }catch(SQLException e){
            throw new Exception("Erro ao listar tabela "+e.getMessage(),e);
        }
    }



}
