package es.dtsi.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class SessionDeUsuario
 */
public class SessionDeUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDeUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesionDeUsuario = request.getSession(true);
		
		ServletContext contexto = request.getServletContext();
		
		Integer contadorGlobal = 1;
		if(contexto.getAttribute("contadorGlobal") != null) {
			contadorGlobal = ((Integer) contexto.getAttribute("contadorGlobal")) + 1;
		}
		contexto.setAttribute("contadorGlobal", contadorGlobal);
		
		Integer contador = 1; 
		
		if(sesionDeUsuario.getAttribute("contador") != null) {
			contador = ((Integer) sesionDeUsuario.getAttribute("contador")) + 1;
		} 
		sesionDeUsuario.setAttribute("contador", contador);
		
		response.getWriter().append("Visita de este usuarion es numero ").append(contador.toString());
		response.getWriter().append("Visitas desde que arrancamos el servidor ")
							.append(contadorGlobal.toString());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
