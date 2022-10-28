package myller.tsi.daw.tp1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myller.tsi.daw.tp1.jdbc.ConnectionFactory;
import myller.tsi.daw.tp1.modelo.Disciplina;

public class DisciplinaDAO {
	private Connection connection;
	
	public DisciplinaDAO() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adiciona(Disciplina disciplina) {
		String sql = "insert into disciplina "
				+ "(nome) "
				+ "values (?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, disciplina.getNomeDisciplina());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void altera(Disciplina disciplina) {
		String sql = "update disciplina set "
				+ "nome=? "
				+ "where iddisciplina=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, disciplina.getNomeDisciplina());
			stmt.setLong(2, disciplina.getIdDisciplina());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	private Disciplina rsToDisciplina(ResultSet rs) throws SQLException {
		Disciplina disciplina = new Disciplina();
		disciplina.setIdDisciplina(rs.getLong("iddisciplina"));
		disciplina.setNomeDisciplina(rs.getString("nome"));
		
		return disciplina;
	}
	
	public Disciplina recuperaDisciplina(Disciplina r) {
		String sql = "select * from disciplina where iddisciplina=?";
		Disciplina disciplina = null;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setLong(1, r.getIdDisciplina());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				disciplina = rsToDisciplina(rs);
			}
		} catch (SQLException e) {}	

		return disciplina;
	}
	
	public void remove(Disciplina disciplina) {
		String sql = "delete from disciplina where iddisciplina=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setLong(1, disciplina.getIdDisciplina());
			stmt.execute();
		} catch (SQLException e) {}		
	}
	
	public List<Disciplina> listaDisciplinas(){
		List<Disciplina> disciplinas = new ArrayList<>();
		String sql = "select * from disciplina ORDER BY iddisciplina ASC";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				disciplinas.add(rsToDisciplina(rs));
			}
		} catch (SQLException e) {}	
		
		return disciplinas;
	}
}
