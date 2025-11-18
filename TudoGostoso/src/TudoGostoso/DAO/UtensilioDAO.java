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
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO utensilio (utensilio) VALUES (?);");
            stmt.setString(1, utensilio.getUtensilio());

            int verifica = stmt.executeUpdate();
            if (verifica == 0) {
                throw new Exception("Nenhum utensílio inserido.");
            }

            stmt.close();
            DAO.closeConnection();
        } catch (SQLException e) {
            throw new Exception("Erro ao inserir utensílio: " + e.getMessage(), e);
        }
    }

    public void deletarUtensilio(Utensilio utensilio) throws Exception {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM utensilio WHERE idUtensilio = ?;");
            stmt.setInt(1, utensilio.getIdUtensilio());

            int verifica = stmt.executeUpdate();
            if (verifica == 0) {
                throw new Exception("Nenhum utensílio deletado.");
            }

            stmt.close();
            DAO.closeConnection();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar utensílio: " + e.getMessage(), e);
        }
    }

    public void atualizarUtensilio(Utensilio utensilio) throws Exception {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE utensilio SET utensilio = ? WHERE idUtensilio = ?;");
            stmt.setString(1, utensilio.getUtensilio());
            stmt.setInt(2, utensilio.getIdUtensilio());

            int verifica = stmt.executeUpdate();
            if (verifica == 0) {
                throw new Exception("Nenhum utensílio atualizado.");
            }

            stmt.close();
            DAO.closeConnection();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar utensílio: " + e.getMessage(), e);
        }
    }

    public Utensilio buscarPorId(int idUtensilio) throws Exception {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM utensilio WHERE idUtensilio = ?;");
            stmt.setInt(1, idUtensilio);
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
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar utensílio: " + e.getMessage(), e);
        }
    }

    public List<Utensilio> listarTodos() throws Exception {
        Connection connection = DAO.createConnection();
        try {
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
        } catch (SQLException e) {
            throw new Exception("Erro ao listar utensílios: " + e.getMessage(), e);
        }
    }
}
