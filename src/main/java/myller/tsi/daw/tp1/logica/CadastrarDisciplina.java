package myller.tsi.daw.tp1.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myller.tsi.daw.tp1.dao.DisciplinaDAO;
import myller.tsi.daw.tp1.modelo.Disciplina;

public class CadastrarDisciplina implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Disciplina disciplina = new Disciplina();
		
		disciplina.setNomeDisciplina(request.getParameter("nome"));
		
		DisciplinaDAO dao = new DisciplinaDAO();
		
		dao.adiciona(disciplina);
		
		return "menu-principal.jsp";
	}
}
