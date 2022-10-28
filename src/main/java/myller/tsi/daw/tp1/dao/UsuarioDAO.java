package myller.tsi.daw.tp1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myller.tsi.daw.tp1.jdbc.ConnectionFactory;
import myller.tsi.daw.tp1.modelo.Usuario;

public class UsuarioDAO {

	private Connection connection;
	
	public UsuarioDAO() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adiciona(Usuario usuario) {
		String sql = "insert into usuario (nome, senha, perfil) values (?, ?, ?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getPerfil());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void altera(Usuario usuario) {
		String sql = "update usuario set nome=?, senha=?, perfil=? where idusuario=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getPerfil());
			stmt.setLong(4, usuario.getIdUsuario());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void remove(Usuario usuario) {
		String sql = "delete from usuario where idusuario=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setLong(1, usuario.getIdUsuario());
			stmt.execute();
		} catch (SQLException e) {}		
	}
	
	public Usuario rsToUsuario(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(rs.getLong("idusuario"));
		usuario.setNome(rs.getString("nome"));
		usuario.setSenha(rs.getString("senha"));
		usuario.setPerfil(rs.getString("perfil"));
		
		return usuario;
	}
	
	public Usuario recuperaUsuario(Usuario u) {
		String sql = "select * from usuario where idusuario=?";
		Usuario usuario = null;
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setLong(1, u.getIdUsuario());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				usuario = rsToUsuario(rs);
			}
		} catch (SQLException e) {}
		
		return usuario;
	}
	
	public Usuario validaCredencial(String usuario, String senha) {
		String sql = "select * from usuario where nome=? and senha=?";
		Usuario user = null;
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, usuario);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user = rsToUsuario(rs);
			}
		} catch (SQLException e) {}
		return user;
	}
	
	public List<Usuario> listaUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "select * from usuario ORDER BY idusuario ASC";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				usuarios.add(rsToUsuario(rs));
			}
		} catch (SQLException e) {}	
		
		return usuarios;
	}
}
