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
import com.entidades.jee.Usuario;



/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null; 
	
	UsuarioDao usuarioDao = new UsuarioDaoImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// cogemos los par�metros email y password del formulario.
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Se comprueba que el usuario existe en la base de datos.
		if(usuarioDao.login(email,password)) {
			


			
			HttpSession	session = request.getSession(true);

			Usuario usuarioLog = usuarioDao.findByEmail(email);
			session.setAttribute("usuarioLog",usuarioLog);

			response.sendRedirect("UsuarioController?action=LIST");

			
		}else {
			request.setAttribute("NOTIFICATION", "El Usuario no existe en la base de datos");
			dispatcher = request.getRequestDispatcher("/views/login.jsp");
			dispatcher.forward(request, response);
			
		}
//		doGet(request, response);
	}

}
