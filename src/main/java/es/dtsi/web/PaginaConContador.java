package es.dtsi.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PaginaConContador
 */
public class PaginaConContador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginaConContador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// trato de leer si he recibido una cookie de nombre "contador"
		// si la he recibido, inicializo mi contador con el valor 
		// que ya estaba en la cookie + 1
		// en caso contrario inicializo el contador a 1
		
		Integer contador = 1;
		
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if(cookie.getName().equals("contador")) {
				contador = Integer.parseInt(cookie.getValue()) + 1;
			}
			
		}
		
		response.getWriter().append("Visita ").append(contador.toString());
		// voy a establecer la cookie en la respuesta
		// con el nuevo valor
		response.addCookie(new Cookie("contador", contador.toString()));
	}


}
