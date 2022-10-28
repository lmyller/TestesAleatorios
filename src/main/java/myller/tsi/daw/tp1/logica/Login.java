package myller.tsi.daw.tp1.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import myller.tsi.daw.tp1.dao.UsuarioDAO;
import myller.tsi.daw.tp1.modelo.Usuario;

public class Login implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().validaCredencial(login, senha);
		
		if(usuario != null) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(2 * 60);
			session.setAttribute("status", true);
			session.setAttribute("login", login);
			session.setAttribute("perfil", usuario.getPerfil());
			
			return "menu-principal.jsp";
		}
		
		return "login.jsp";
	}
}
