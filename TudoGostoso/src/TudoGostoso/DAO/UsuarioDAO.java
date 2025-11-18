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
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO usuario (nome,email,dataNascimento,cep,genero,senha,salt,inscrito,uuid) VALUES (?,?,?,?,?,?,?,?,?);");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getdataNascimento());
            stmt.setInt(4, usuario.getCep());
            stmt.setString(5, usuario.getGenero());
            stmt.setString(6, usuario.getSenha());
            stmt.setString(7, usuario.getSalt());
            stmt.setString(8, usuario.getInscrito());
            stmt.setString(9, usuario.getUuid());

            int verifica = stmt.executeUpdate();
            if (verifica == 0) {
                throw new Exception("Nenhum usuário inserido.");
            }

            stmt.close();
            DAO.closeConnection();
        } catch (SQLException e) {
            throw new Exception("Erro ao inserir usuário: " + e.getMessage(), e);
        }
    }

    public void deletarUsuario(Usuario usuario) throws Exception {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM usuario WHERE idUsuario = ?;");
            stmt.setInt(1, usuario.getIdUsuario());

            int verifica = stmt.executeUpdate();
            if (verifica == 0) {
                throw new Exception("Nenhum usuário deletado.");
            }

            stmt.close();
            DAO.closeConnection();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar usuário: " + e.getMessage(), e);
        }
    }

    public void atualizarUsuario(Usuario usuario) throws Exception {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE usuario SET nome=?, email=?, dataNascimento=?, cep=?, genero=?, senha=?, salt=?, inscrito=?, uuid=? WHERE idUsuario=?;");
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
                throw new Exception("Nenhum usuário atualizado.");
            }

            stmt.close();
            DAO.closeConnection();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar usuário: " + e.getMessage(), e);
        }
    }

    public Usuario buscarPorId(int idUsuario) throws Exception {
        Connection connection = DAO.createConnection();
        Usuario usuario = null;

        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM usuario WHERE idUsuario = ?;");
            stmt.setInt(1, idUsuario);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setCep(rs.getInt("cep"));
                usuario.setGenero(rs.getString("genero"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setSalt(rs.getString("salt"));
                usuario.setInscrito(rs.getString("inscrito"));
                usuario.setUuid(rs.getString("uuid"));
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            throw new Exception("Erro ao buscar usuário: " + e.getMessage(), e);

        } finally {
            DAO.closeConnection(); // agora fecha SEMPRE
        }

        return usuario;
    }

    public List<Usuario> listarTodos() throws Exception {
        Connection connection = DAO.createConnection();
        try {
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
                usuario.setSalt(rs.getString("salt"));
                usuario.setInscrito(rs.getString("inscrito"));
                usuario.setUuid(rs.getString("uuid"));
                lista.add(usuario);
            }
            rs.close();
            DAO.closeConnection();
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro ao listar usuários: " + e.getMessage(), e);
        }
    }

}