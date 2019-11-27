package com.entidades.dao.controllers.jee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.entidades.dao.impl.jee.UsuarioDaoImpl;
import com.entidades.dao.jee.UsuarioDao;
import com.entidades.jee.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	
	UsuarioDao usuarioDao = new UsuarioDaoImpl();

    /**
     * Default constructor. 
     */
    public UsuarioController() {
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listaUsuario(request, response);
				break;
				
			case "EDIT":
				getSingleUsuario(request, response);
				break;
				
			case "DELETE":
				deleteUsuario(request, response);
				break;
				
			default:
				listaUsuario(request, response);
				break;
				
		}
	}

	private void deleteUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id_usuario");
	
		if(usuarioDao.delete(Long.parseLong(id))) {
			request.setAttribute("NOTIFICATION", "Usuario eliminado!");
		}
		
		listaUsuario(request, response);
	}

	private void getSingleUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id_usuario");
		
		Usuario usuario = usuarioDao.findById(Long.parseLong(id));
		
		request.setAttribute("usuario", usuario);
		
		dispatcher = request.getRequestDispatcher("/views/usuario-form.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listaUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Usuario> lista = usuarioDao.findAll();
		
		request.setAttribute("lista", lista);
		
		dispatcher = request.getRequestDispatcher("/views/usuario-list.jsp");
		
		dispatcher.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id_usuario");		
		Usuario usuario = new Usuario();
		
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setApellido(request.getParameter("apellido"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setNickName(request.getParameter("nickName"));
		usuario.setPassword(request.getParameter("password"));
		


		
		if(id.isEmpty() || id == null) {
			
			if(usuarioDao.save(usuario)) {
				request.setAttribute("NOTIFICATION", "Usuario guardado!");
			}
		
		}else {
			
			usuario.setId(Long.parseLong(id));
			if(usuarioDao.update(usuario)) {
				request.setAttribute("NOTIFICATION", "Usuario actualizado!");
			}
			
		}
		
		listaUsuario(request, response);
	}

}
