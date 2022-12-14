package es.dtsi.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import es.dtsi.web.logicanegocio.Calculadora;

/**
 * Servlet implementation class CalculadoraServlet
 */
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculadoraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Responsabilidad del controlador
		// Deserializar los parametros de entrada
		int valor1 = Integer.parseInt(request.getParameter("valor1"));
		int valor2 = Integer.parseInt(request.getParameter("valor2"));
		
		// Delego en la logica de negocio para calcular los resultados
		Calculadora calculadora = new Calculadora();
		int resultado = calculadora.suma(valor1, valor2); // Modelo
		String horaActual = LocalDateTime.now().toString();
		
		request.setAttribute("horaActual", horaActual);
		request.setAttribute("resultado", resultado);
		
		// Buscar una vista (JSP) que pueda renderizar los resultados
		request.getRequestDispatcher("vista.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
