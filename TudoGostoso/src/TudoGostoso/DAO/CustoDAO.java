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
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO custo (custo) VALUES (?);");
            stmt.setString(1, custo.getCusto());

            int verifica = stmt.executeUpdate();
            if (verifica == 0) {
                throw new Exception("Nenhum custo inserido.");
            }

            stmt.close();
            DAO.closeConnection();
        } catch (SQLException e) {
            throw new Exception("Erro ao inserir custo: " + e.getMessage(), e);
        }
    }

    public void deletarCusto(Custo custo) throws Exception {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM custo WHERE idCusto = ?;");
            stmt.setInt(1, custo.getId());

            int verifica = stmt.executeUpdate();
            if (verifica == 0) {
                throw new Exception("Nenhum custo deletado.");
            }

            stmt.close();
            DAO.closeConnection();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar custo: " + e.getMessage(), e);
        }
    }

    public void atualizarCusto(Custo custo) throws Exception {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE custo SET custo = ? WHERE idCusto = ?;");
            stmt.setString(1, custo.getCusto());
            stmt.setInt(2, custo.getId());

            int verifica = stmt.executeUpdate();
            if (verifica == 0) {
                throw new Exception("Nenhum custo atualizado.");
            }

            stmt.close();
            DAO.closeConnection();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar custo: " + e.getMessage(), e);
        }
    }

    public Custo buscarPorId(int idCusto) throws Exception {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM custo WHERE idCusto = ?;");
            stmt.setInt(1, idCusto);
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
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar custo: " + e.getMessage(), e);
        }
    }

    public List<Custo> listarTodos() throws Exception {
        Connection connection = DAO.createConnection();
        try {
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
        } catch (SQLException e) {
            throw new Exception("Erro ao listar custos: " + e.getMessage(), e);
        }
    }
}