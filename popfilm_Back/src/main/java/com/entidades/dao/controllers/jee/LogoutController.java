package com.entidades.dao.controllers.jee;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entidades.dao.impl.jee.UsuarioDaoImpl;
import com.entidades.dao.jee.UsuarioDao;



/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null; 
	
	UsuarioDao usuarioDao = new UsuarioDaoImpl();  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

	    session.invalidate(); // invalidamos sesion.
	        
		request.setAttribute("NOTIFICATION", "Sesión cerrada");
		dispatcher = request.getRequestDispatcher("/views/login.jsp");

		dispatcher.forward(request, response);

	}
	
}
