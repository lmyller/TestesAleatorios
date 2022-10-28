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
import myller.tsi.daw.tp1.modelo.Questao;

public class QuestaoDAO {
	private Connection connection;
	
	public QuestaoDAO() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adiciona(Questao questao) {
		String sql = "insert into questao (tituloquestao, resposta, iddisciplina, idmateria) "
				+ 	 "values (?, ?, ?, ?, ?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, questao.getTituloQuestao());
			stmt.setString(2, questao.getResposta());
			
			if(questao.getDisciplina() != null)
				stmt.setLong(3, questao.getDisciplina().getIdDisciplina());
			else
				stmt.setNull(3, Types.INTEGER);
			
			if(questao.getMateria() != null)
				stmt.setLong(4, questao.getMateria().getIdMateria());
			else
				stmt.setNull(4, Types.INTEGER);
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void altera(Questao questao) {
		String sql = "update questao set tituloquestao=?, resposta=?, iddisciplina=?, idmateria=? "
				+ 	 "where idquestao=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, questao.getTituloQuestao());
			stmt.setString(2, questao.getResposta());
			
			if(questao.getDisciplina() != null)
				stmt.setLong(3, questao.getDisciplina().getIdDisciplina());
			else
				stmt.setNull(3, Types.INTEGER);
			
			if(questao.getMateria() != null)
				stmt.setLong(4, questao.getMateria().getIdMateria());
			else
				stmt.setNull(4, Types.INTEGER);
			
			stmt.setLong(5, questao.getIdQuestao());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	private Questao rsToQuestao(ResultSet rs) throws SQLException {
		Questao questao = new Questao();
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		MateriaDAO materiaDAO = new MateriaDAO();
		
		questao.setIdQuestao(rs.getLong("idquestao"));
		questao.setTituloQuestao(rs.getString("tituloquestao"));
		questao.setResposta(rs.getString("resposta"));
		
		Disciplina disciplina = new Disciplina();
		disciplina.setIdDisciplina(rs.getLong("iddisciplina"));
		questao.setDisciplina(disciplinaDAO.recuperaDisciplina(disciplina));
		
		Materia materia = new Materia();
		materia.setIdMateria(rs.getLong("idmateria"));
		questao.setMateria(materiaDAO.recuperaMateria(materia));
		
		return questao;
	}
	
	public Questao recuperaQuestao(Questao q) {
		String sql = "select * from questao where idquestao=?";
		Questao questao = null;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setLong(1, q.getIdQuestao());
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				questao = rsToQuestao(rs);
			}
		} catch (SQLException e) {}	

		return questao;
	}
	
	public void remove(Questao questao) {
		String sql = "delete from questao where idquestao=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setLong(1, questao.getIdQuestao());
			stmt.execute();
		} catch (SQLException e) {}		
	}
	
	public List<Questao> listaQuestoes(){
		List<Questao> questoes = new ArrayList<>();
		String sql = "select * from questao ORDER BY idquestao ASC";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				questoes.add(rsToQuestao(rs));
			}
		} catch (SQLException e) {}	
		
		return questoes;
	}
}
