package myller.tsi.daw.tp1.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myller.tsi.daw.tp1.dao.DisciplinaDAO;
import myller.tsi.daw.tp1.dao.MateriaDAO;
import myller.tsi.daw.tp1.modelo.Disciplina;
import myller.tsi.daw.tp1.modelo.Materia;

public class CadastrarMateria implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Materia materia = new Materia();
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		Disciplina disciplina = new Disciplina();
		
		materia.setNomeMateria(request.getParameter("nome"));
		materia.setSerie(Integer.parseInt(request.getParameter("serie")));
		
		disciplina.setIdDisciplina(Long.parseLong(request.getParameter("iddisciplina")));
		disciplina = disciplinaDAO.recuperaDisciplina(disciplina);

		materia.setDisciplina(disciplina);
		
		MateriaDAO dao = new MateriaDAO();
		
		dao.adiciona(materia);
		
		return "menu-principal.jsp";
	}
}
