package myller.tsi.daw.tp1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import myller.tsi.daw.tp1.jdbc.ConnectionFactory;
import myller.tsi.daw.tp1.modelo.Materia;
import myller.tsi.daw.tp1.modelo.Teste;
import myller.tsi.daw.tp1.modelo.Usuario;

public class TesteDAO {
	private Connection connection;
	
	public TesteDAO() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adiciona(Teste teste) {
		String sql = "insert into teste "
				+ "(qtdequestoes, numeroacerto, resposta, datateste, idusuario, idmateria) "
				+ "values (?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, teste.getQtdeQuestoes());
			stmt.setInt(2, teste.getNumeroAcerto());
			stmt.setString(3, teste.getResposta());
			
			if(teste.getDataTeste() != null) {
				Date data = new Date(teste.getDataTeste().getTimeInMillis());
				stmt.setDate(4, data);
			}
			else 
				stmt.setDate(4, null);
			
			if(teste.getUsuario() != null)
				stmt.setLong(5, teste.getUsuario().getIdUsuario());
			else
				stmt.setNull(5, Types.INTEGER);
			
			if(teste.getMateria() != null)
				stmt.setLong(6, teste.getMateria().getIdMateria());
			else
				stmt.setNull(6, Types.INTEGER);
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void altera(Teste teste) {
		String sql = "update teste set "
				+ "qtdequestoes=?, numeroacerto=?, resposta=?, datateste=?, idusuario, idmateria "
				+ "where idteste=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, teste.getQtdeQuestoes());
			stmt.setInt(2, teste.getNumeroAcerto());
			stmt.setString(3, teste.getResposta());
			
			if(teste.getDataTeste() != null) {
				Date data = new Date(teste.getDataTeste().getTimeInMillis());
				stmt.setDate(4, data);
			}
			else 
				stmt.setDate(4, null);
			
			if(teste.getUsuario() != null)
				stmt.setLong(5, teste.getUsuario().getIdUsuario());
			else
				stmt.setNull(5, Types.INTEGER);
			
			if(teste.getMateria() != null)
				stmt.setLong(6, teste.getMateria().getIdMateria());
			else
				stmt.setNull(6, Types.INTEGER);
			
			stmt.setLong(7, teste.getIdTeste());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	private Teste rsToTeste(ResultSet rs) throws SQLException {
		Teste teste = new Teste();
		MateriaDAO materiaDAO = new MateriaDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		teste.setIdTeste(rs.getLong("idteste"));
		teste.setQtdeQuestoes(rs.getInt("qtdequestoes"));
		teste.setNumeroAcerto(rs.getInt("numeroacerto"));
		teste.setResposta(rs.getString("resposta"));
		
		try {
			Calendar dataTeste = Calendar.getInstance();
			dataTeste.setTime(rs.getDate("datateste"));
			teste.setDataTeste(dataTeste);
		} catch (NullPointerException e) {}
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(rs.getLong("idusuario"));
		teste.setUsuario(usuarioDAO.recuperaUsuario(usuario));
		
		Materia materia = new Materia();
		materia.setIdMateria(rs.getLong("idmateria"));
		teste.setMateria(materiaDAO.recuperaMateria(materia));
		
		return teste;
	}
	
	public Teste recuperaEmprestimo(Teste t) {
		String sql = "select * from teste where idteste=?";
		Teste teste = null;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setLong(1, t.getIdTeste());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				teste = rsToTeste(rs);
			}
		} catch (SQLException e) {}	

		return teste;
	}
	
	public void remove(Teste teste) {
		String sql = "delete from teste where idteste=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setLong(1, teste.getIdTeste());
			stmt.execute();
		} catch (SQLException e) {}		
	}
	
	public List<Teste> listaTestes(){
		List<Teste> testes = new ArrayList<>();
		String sql = "select * from teste ORDER BY idteste DESC";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				testes.add(rsToTeste(rs));
			}
		} catch (SQLException e) {}	
		
		return testes;
	}
}