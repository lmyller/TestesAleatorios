package myller.tsi.daw.tp1.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myller.tsi.daw.tp1.dao.DisciplinaDAO;
import myller.tsi.daw.tp1.dao.MateriaDAO;
import myller.tsi.daw.tp1.dao.QuestaoDAO;
import myller.tsi.daw.tp1.modelo.Disciplina;
import myller.tsi.daw.tp1.modelo.Materia;
import myller.tsi.daw.tp1.modelo.Questao;

public class CadastrarQuestao implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Questao questao = new Questao();
		QuestaoDAO questaoDAO = new QuestaoDAO();
		
		questao.setTituloQuestao(request.getParameter("questao"));
		questao.setResposta(request.getParameter("resposta"));
		
		Materia materia = new Materia();
		materia.setIdMateria(Long.parseLong(request.getParameter("iddisciplina")));
		questao.setMateria(new MateriaDAO().recuperaMateria(materia));
		
		Disciplina disciplina = new Disciplina();
		disciplina.setIdDisciplina(Long.parseLong(request.getParameter("iddisciplina")));
		questao.setDisciplina(new DisciplinaDAO().recuperaDisciplina(disciplina));
				
		questaoDAO.adiciona(questao);
		
		return "menu-cadastro.jsp";
	}

	
	
}
