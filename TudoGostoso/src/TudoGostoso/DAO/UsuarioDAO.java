package TudoGostoso.DAO;

import TudoGostoso.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void inserirUsuario(Usuario usuario) throws Exception {
        Connection connection = DAO.createConnection();

        PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO usuario (nome, email, dataNascimento, cep, genero, senha, salt, inscrito, uuid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getdataNascimento()); // java.sql.Date
        stmt.setInt(4, usuario.getCep());
        stmt.setString(5, usuario.getGenero());
        stmt.setString(6, usuario.getSenha());
        stmt.setString(7, usuario.getSalt());
        stmt.setString(8, usuario.getInscrito());
        stmt.setString(9, usuario.getUuid());

        stmt.executeUpdate();
        stmt.close();
        DAO.closeConnection();
    }

    public void deletarUsuario(Usuario usuario) throws Exception {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "DELETE FROM usuario WHERE idUsuario = ?;");
            stmt.setInt(1, usuario.getIdUsuario());

            int verifica = stmt.executeUpdate();
            if (verifica == 0) {
                throw new Exception("Nenhum usuário encontrado com o ID informado.");
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar usuário: " + e.getMessage(), e);
        }
    }

    public void atualizarUsuario(Usuario usuario) throws Exception {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE usuario SET nome = ?, email = ?, dataNascimento = ?, cep = ?, genero = ?, senha = ?, salt = ?, inscrito = ?, uuid = ? WHERE idUsuario = ?;");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getdataNascimento());
            stmt.setInt(4, usuario.getCep());
            stmt.setString(5, usuario.getGenero());
            stmt.setString(6, usuario.getSenha());
            stmt.setString(7, usuario.getSalt());
            stmt.setString(8, usuario.getInscrito());
            stmt.setString(9, usuario.getUuid());
            stmt.setInt(10, usuario.getIdUsuario());

            int verifica = stmt.executeUpdate();
            if (verifica == 0) {
                throw new Exception("Nenhum usuário encontrado para atualizar.");
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar usuário: " + e.getMessage(), e);
        }
    }

    public Usuario buscarPorId(int id) throws Exception {
        Connection conexao = DAO.createConnection();

        PreparedStatement stmt = conexao.prepareStatement(
                "SELECT * FROM usuario WHERE idUsuario = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Usuario usuario = null;
        if (rs.next()) {
            usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setdataNascimento(rs.getString("dataNascimento"));
            usuario.setCep(rs.getInt("cep"));
            usuario.setGenero(rs.getString("genero"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setInscrito(rs.getString("inscrito")); // ✔ CORRIGIDO
            usuario.setUuid(rs.getString("uuid"));
        }
        rs.close();
        stmt.close();
        DAO.closeConnection();

        return usuario;
    }

    public List<Usuario> listarTodos() throws Exception {
        Connection connection = DAO.createConnection();

        ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM usuario;");
        List<Usuario> lista = new ArrayList<>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setdataNascimento(rs.getString("dataNascimento"));
            usuario.setCep(rs.getInt("cep"));
            usuario.setGenero(rs.getString("genero"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setInscrito(rs.getString("inscrito")); // ✔ CORRIGIDO
            usuario.setUuid(rs.getString("uuid"));
            lista.add(usuario);
        }
        rs.close();
        DAO.closeConnection();

        return lista;
    }

}