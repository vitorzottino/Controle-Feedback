package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.User;

public class UserDAO {

    private Connection conexao;

    public UserDAO() {
        
        this.conexao = new ConnectionFactory().conectar();
    }

    public void insert(User user) throws SQLException{
        String sql = "INSERT INTO tb_usuarios_fb (id_user, nome, email, senha, estado, idade, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(2, user.getNome());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getSenha());
        ps.setString(5, user.getEndereco());
        ps.setInt(6, user.getIdade());
        ps.setBoolean(7, user.getAdmin());
        ps.execute();
        ps.close();

    }

    public void delete (int id) throws SQLException{
        String sql = "DELETE FROM tb_usuario_fb WHERE id_user = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }  

  
}
