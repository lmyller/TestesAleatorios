package myller.tsi.daw.tp1.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myller.tsi.daw.tp1.logica.Logica;

public class Controladora extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeClasse = "myller.tsi.daw.tp1.logica." + request.getParameter("logica");
		Class classe;
		String url = "";
		
		try {
			classe = Class.forName(nomeClasse);
			Logica logica = (Logica) classe.newInstance();
			url = logica.executa(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
