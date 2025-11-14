package TudoGostoso.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import TudoGostoso.model.Receita;


public class ReceitaDAO {
    
    public void inserir(Receita receita) throws Exception{
        Connection connection = DAO.createConnection();

        PreparedStatement stmt = connection.prepareStatement(
            "INSERTO into receitas (titulo,descricao,imagem) VALUES (?,?,?)"
            );
        stmt.setString(1, receita.getTitulo());
        stmt.setString(2, receita.getDescricao());
        stmt.setString(3, receita.getImagem());

        stmt.executeUpdate();
        stmt.close();
        DAO.closeConnection();
    }

    public Receita buscarPorId(int idReceita) throws Exception{
        Connection conexao = DAO.createConnection();

        PreparedStatement stmt = conexao.prepareStatement(
            "SELECT * from receita Where idReceita = ?"
        );
        stmt.setInt(1, idReceita);
        ResultSet rs = stmt.executeQuery();
        Receita receita = null;
        if(rs.next()){
            receita = new Receita(rs.getString("titulo"), rs.getString("descricao"),rs.getString("imagem"),null,null,null,null);
            receita.setIdReceita(rs.getInt("idReceita"));
        }
        rs.close();
        stmt.close();
        DAO.closeConnection();

        return receita;
    }

    public List<Receita> listarTodas() throws Exception{
        Connection connection = DAO.createConnection();

        ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM receitas;");
        List<Receita> lista = new ArrayList<>();

        while (rs.next()) {
            Receita receita = new Receita(
                rs.getString("titulo"),
                rs.getString("descriacao"),
                rs.getString("imagem"),
                null,null,null,null    
            );
            receita.setIdReceita(rs.getInt("idReceita"));
            lista.add(receita);
        }
        rs.close();
        DAO.closeConnection();

        return lista;
    }

}
