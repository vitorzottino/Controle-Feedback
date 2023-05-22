package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionFactory;
import lists.ListFb;
import model.Feedback;


public class FeedbackDAO {

    private Connection conexao;

    public FeedbackDAO() {
        this.conexao = new ConnectionFactory().conectar();
    }

    public void insert(Feedback fb) throws SQLException {
        String sql = "INSERT INTO tb_feedback (dt_registro, dt_saida, assunto_fb, mensagem_fb, status_fb, motivo_fb) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setDate(1, fb.getDataEntrada());
        stmt.setDate(2, fb.getDataSaida());
        stmt.setString(3, fb.getAssunto());
        stmt.setString(4, fb.getConteudo());
        stmt.setString(5, fb.getStatus());
        stmt.setString(6, fb.getMotivo());
        stmt.execute();
        stmt.close();

    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM tb_feedback WHERE id_fb = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();

    }

    public ListFb selectAll() throws SQLException {

        ListFb fbList = new ListFb();
        String sql = "SELECT * FROM tb_feedback";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Feedback fb = new Feedback();
            fb.setId(rs.getInt("id_fb"));
            fb.setDataEntrada(rs.getDate("dt_registro"));
            fb.setDataSaida(rs.getDate("dt_saida"));
            fb.setAssunto(rs.getString("assunto_fb"));
            fb.setConteudo(rs.getString("mensagem_fb"));
            fb.setStatus(rs.getString("status_fb"));
            fb.setMotivo(rs.getString("motivo_fb"));
            fbList.add(fb);
        }
        rs.close();
        ps.close();
        return fbList;

    }

}
