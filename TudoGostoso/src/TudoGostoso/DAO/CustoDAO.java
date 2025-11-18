package TudoGostoso.DAO;

import TudoGostoso.model.Custo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustoDAO {

    public void inserirCusto(Custo custo) throws Exception {
        Connection connection = DAO.createConnection();

        PreparedStatement stmt = connection.prepareStatement(
                "INSERT into custo (custo) VALUES (?);");
        stmt.setString(1, custo.getCusto());

        stmt.executeUpdate();
        stmt.close();
        DAO.closeConnection();
    }

    public void deletarCusto(Custo custo) throws Exception {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "DELETE FROM custo WHERE idCusto = ?; ");
            stmt.setInt(1, custo.getId());

            int verifica = stmt.executeUpdate();
            if (verifica == 0) {
                throw new Exception("Nenhum custo encontrado com o ID informado.");
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar custo: " + e.getMessage(), e);
        }
    }

    public void atualizarCusto(Custo custo) throws Exception {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE custo SET custo = ? WHERE idCusto = ?; ");

            stmt.setString(1, custo.getCusto());
            stmt.setInt(2, custo.getId());

            int verifica = stmt.executeUpdate();

            if (verifica == 0) {
                throw new Exception("Nenhum custo encontrado para atualizar.");
            }

        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar custo: " + e.getMessage(), e);
        }
    }

    public Custo buscarPorId(int id) throws Exception {
        Connection conexao = DAO.createConnection();

        PreparedStatement stmt = conexao.prepareStatement(
                "SELECT * from custo Where idCusto = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Custo custo = null;
        if (rs.next()) {

            custo = new Custo();
            custo.setIdCusto(rs.getInt("idCusto"));
            custo.setCusto(rs.getString("custo"));

        }
        rs.close();
        stmt.close();
        DAO.closeConnection();

        return custo;
    }

    public List<Custo> listarTodas() throws Exception {
        Connection connection = DAO.createConnection();

        ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM custo;");
        List<Custo> lista = new ArrayList<>();

        while (rs.next()) {

            Custo custo = new Custo();
            custo.setIdCusto(rs.getInt("idCusto"));
            custo.setCusto(rs.getString("custo"));
            lista.add(custo);
        }
        rs.close();
        DAO.closeConnection();

        return lista;
    }

}
