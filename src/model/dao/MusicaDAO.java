package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Musica;

public class MusicaDAO {
	public void create(Musica c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("INSERT INTO `musicas`(`musica_titulo`, `musica_cantores`, `musica_compositores`, `musica_letra`, `musica_duracao`, `musica_nacional`) VALUES (?,?,?,?,?,?)");
			stmt.setString(1,c.getMusica_titulo());
			stmt.setString(2,c.getMusica_cantores());
			stmt.setString(3,c.getMusica_compositores());
			stmt.setString(4,c.getMusica_letra());
			stmt.setFloat(5,c.getMusica_duracao());
			stmt.setBoolean(6,c.isMusica_nacional());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastro na tabela top");
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no salvar: " + e);
			
	}
	finally {
		ConnectionFactory.closeConnection(con, stmt);
	}
		
}

	public List<Musica> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		List<Musica> cs = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM musicas;");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Musica c = new Musica();
				c.setMusica_id(rs.getInt("musica_id"));
				c.setMusica_titulo(rs.getString("musica_titulo"));
				c.setMusica_cantores(rs.getString("musica_cantores"));
				c.setMusica_compositores(rs.getString("musica_compositores"));
				c.setMusica_letra(rs.getString("musica_letra"));
				c.setMusica_duracao(rs.getInt("musica_duracao"));
				c.setMusica_nacional(rs.getBoolean("musica_nacional"));
				cs.add(c);
			}
		}
		
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "nao achou infomation:" + e);
			e.printStackTrace();	
		}
		
		finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return cs;
	}
	
	
	public Musica read(int id){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Musica c = new Musica();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM musicas WHERE musica_id=? Limit 1");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {
				c.setMusica_id(rs.getInt("musica_id"));
				c.setMusica_titulo(rs.getString("musica_titulo"));
				c.setMusica_cantores(rs.getString("musica_cantores"));
				c.setMusica_compositores(rs.getString("musica_compositores"));
				c.setMusica_letra(rs.getString("musica_letra"));
				c.setMusica_duracao(rs.getInt("musica_duracao"));
				c.setMusica_nacional(rs.getBoolean("musica_nacional"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return c;
	}

	public void  update(Musica c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE `musicas` SET `musica_titulo`=?,`musica_cantores`=?,`musica_compositores`=?,`musica_letra`=?,`musica_duracao`=?,`musica_nacional`=? WHERE `musica_id`=? LIMIT 1");
			stmt.setString(1,c.getMusica_titulo());
			stmt.setString(2,c.getMusica_cantores());
			stmt.setString(3,c.getMusica_compositores());
			stmt.setString(4,c.getMusica_letra());
			stmt.setFloat(5,c.getMusica_duracao());
			stmt.setBoolean(6,c.isMusica_nacional());
			stmt.setInt(7,c.getMusica_id());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"atualizou");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"nao atualizou " + e);
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void delete(Musica c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM musicas WHERE musica_id =?");
			stmt.setInt(1, c.getMusica_id());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "musica excluida");
			
		} catch(SQLException e){
			JOptionPane.showMessageDialog(null, "nao deletou: " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);	
		}
	}
	
} 