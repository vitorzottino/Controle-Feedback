package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionPool;
import model.User;

public class UserDAO {

	private Connection conexao;

	public UserDAO() throws SQLException {

		this.conexao = ConnectionPool.conectar();
	}

	public void insert(User user) throws SQLException {
		String sql = "INSERT INTO tb_usuarios_fb (nome, senha, admin) VALUES (?, ?, ?)";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, user.getNome());
		ps.setString(2, user.getSenha());
		ps.setString(3, user.getAdmin());
		ps.execute();
		ps.close();

	}

	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM tb_usuarios_fb WHERE id_user = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		ps.close();

	}

	public List<User> selectAll() {
		List<User> usuarios = new ArrayList<User>();
		String sql = "select * from tb_usuarios_fb order by id_user";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User usuario = new User();
				usuario.setId(rs.getInt("id_user"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setAdmin(rs.getString("admin"));
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

}
