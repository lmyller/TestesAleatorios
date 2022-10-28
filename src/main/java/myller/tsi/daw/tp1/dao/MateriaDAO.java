package myller.tsi.daw.tp1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import myller.tsi.daw.tp1.jdbc.ConnectionFactory;
import myller.tsi.daw.tp1.modelo.Disciplina;
import myller.tsi.daw.tp1.modelo.Materia;

public class MateriaDAO {
	private Connection connection;
	
	public MateriaDAO() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adiciona(Materia materia) {
		String sql = "insert into materia (nome, serie, iddisciplina) values (?, ?, ?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, materia.getNomeMateria());
			stmt.setInt(2, materia.getSerie());
			
			if(materia.getDisciplina() != null)
				stmt.setLong(3, materia.getDisciplina().getIdDisciplina());
			else
				stmt.setNull(3, Types.INTEGER);
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void altera(Materia materia) {
		String sql = "update materia set nome=?, serie=?, iddisciplina=? where idmateria=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, materia.getNomeMateria());
			stmt.setInt(2, materia.getSerie());
			stmt.setLong(3, materia.getIdMateria());
			
			if(materia.getDisciplina() != null)
				stmt.setLong(4, materia.getDisciplina().getIdDisciplina());
			else
				stmt.setNull(4, Types.INTEGER);
			
			stmt.setLong(5, materia.getIdMateria());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	private Materia rsToMateria(ResultSet rs) throws SQLException {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		Materia materia = new Materia();
		
		materia.setIdMateria(rs.getLong("idmateria"));
		materia.setNomeMateria(rs.getString("nome"));
		materia.setSerie(rs.getInt("serie"));
		
		Disciplina disciplina = new Disciplina();
		disciplina.setIdDisciplina(rs.getLong("iddisciplina"));
		materia.setDisciplina(disciplinaDAO.recuperaDisciplina(disciplina));
		
		return materia;
	}
	
	public Materia recuperaMateria(Materia m) {
		String sql = "select * from materia where idmateria=?";
		Materia materia = null;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setLong(1, m.getIdMateria());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				materia = rsToMateria(rs);
			}
		} catch (SQLException e) {}	

		return materia;
	}
	
	public void remove(Materia materia) {
		String sql = "delete from materia where idmateria=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setLong(1, materia.getIdMateria());
			stmt.execute();
		} catch (SQLException e) {}		
	}
	
	public List<Materia> listaMaterias(){
		List<Materia> materias = new ArrayList<>();
		String sql = "select * from materia ORDER BY idmateria ASC";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				materias.add(rsToMateria(rs));
			}
		} catch (SQLException e) {}	
		
		return materias;
	}
}
