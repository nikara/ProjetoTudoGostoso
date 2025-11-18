package TudoGostoso.DAO;

import TudoGostoso.model.Utensilio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtensilioDAO {

    public void inserirUtensilio(Utensilio utensilio) throws Exception {
        Connection connection = DAO.createConnection();

        PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO utensilio (utensilio) VALUES (?);");
        stmt.setString(1, utensilio.getUtensilio());

        stmt.executeUpdate();
        stmt.close();
        DAO.closeConnection();
    }

    public void deletarUtensilio(Utensilio utensilio) throws Exception {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "DELETE FROM utensilio WHERE idUtensilio = ?;");
            stmt.setInt(1, utensilio.getIdUtensilio());

            int verifica = stmt.executeUpdate();
            if (verifica == 0) {
                throw new Exception("Nenhum utensílio encontrado com o ID informado.");
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar utensílio: " + e.getMessage(), e);
        }
    }

    public void atualizarUtensilio(Utensilio utensilio) throws Exception {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE utensilio SET utensilio = ? WHERE idUtensilio = ?;");
            stmt.setString(1, utensilio.getUtensilio());
            stmt.setInt(2, utensilio.getIdUtensilio());

            int verifica = stmt.executeUpdate();
            if (verifica == 0) {
                throw new Exception("Nenhum utensílio encontrado para atualizar.");
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar utensílio: " + e.getMessage(), e);
        }
    }

    public Utensilio buscarPorId(int id) throws Exception {
        Connection conexao = DAO.createConnection();

        PreparedStatement stmt = conexao.prepareStatement(
                "SELECT * FROM utensilio WHERE idUtensilio = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Utensilio utensilio = null;
        if (rs.next()) {
            utensilio = new Utensilio();
            utensilio.setIdUtensilio(rs.getInt("idUtensilio"));
            utensilio.setUtensilio(rs.getString("utensilio"));
        }
        rs.close();
        stmt.close();
        DAO.closeConnection();

        return utensilio;
    }

    public List<Utensilio> listarTodos() throws Exception {
        Connection connection = DAO.createConnection();

        ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM utensilio;");
        List<Utensilio> lista = new ArrayList<>();

        while (rs.next()) {
            Utensilio utensilio = new Utensilio();
            utensilio.setIdUtensilio(rs.getInt("idUtensilio"));
            utensilio.setUtensilio(rs.getString("utensilio"));
            lista.add(utensilio);
        }
        rs.close();
        DAO.closeConnection();

        return lista;
    }
}
