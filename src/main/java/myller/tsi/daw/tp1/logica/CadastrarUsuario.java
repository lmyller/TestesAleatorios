package myller.tsi.daw.tp1.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myller.tsi.daw.tp1.dao.UsuarioDAO;
import myller.tsi.daw.tp1.modelo.Usuario;

public class CadastrarUsuario implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = new Usuario();
		
		usuario.setNome(request.getParameter("nome"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setPerfil(request.getParameter("perfil"));
		
		UsuarioDAO dao = new UsuarioDAO();
		
		dao.adiciona(usuario);
		
		return "menu-cadastro.jsp";
	}
}
