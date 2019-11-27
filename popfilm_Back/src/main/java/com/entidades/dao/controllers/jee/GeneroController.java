package com.entidades.dao.controllers.jee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entidades.dao.impl.jee.GeneroDaoImpl;
import com.entidades.dao.jee.GeneroDao;

import com.entidades.jee.Genero;

/**
 * Servlet implementation class GeneroController
 */
@WebServlet("/GeneroController")
public class GeneroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	
	GeneroDao generoDao = new GeneroDaoImpl();

    /**
     * Default constructor. 
     */
    public GeneroController() {
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listaGenero(request, response);
				break;
				
			case "EDIT":
				getSingleGenero(request, response);
				break;
				
			case "DELETE":
				deleteGenero(request, response);
				break;
				
			default:
				listaGenero(request, response);
				break;
				
		}
	}

	private void deleteGenero(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id_genero");
	
		if(generoDao.delete(Long.parseLong(id))) {
			request.setAttribute("NOTIFICATION", "Género eliminado!");
		}
		
		listaGenero(request, response);
	}

	private void getSingleGenero(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id_genero");
		
		Genero genero = generoDao.findById(Long.parseLong(id));
		
		request.setAttribute("genero", genero);
		
		dispatcher = request.getRequestDispatcher("/views/genero-form.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listaGenero(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Genero> lista = generoDao.findAll();
		
		request.setAttribute("lista", lista);
		
		dispatcher = request.getRequestDispatcher("/views/genero-list.jsp");
		
		dispatcher.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id_genero");		
		Genero genero = new Genero();
		
		genero.setNombre(request.getParameter("nombre"));
		genero.setDescripcion(request.getParameter("descripcion"));
		


		
		if(id.isEmpty() || id == null) {
			
			if(generoDao.save(genero)) {
				request.setAttribute("NOTIFICATION", "Género guardado!");
			}
		
		}else {
			
			genero.setId(Long.parseLong(id));
			if(generoDao.update(genero)) {
				request.setAttribute("NOTIFICATION", "Género actualizado!");
			}
			
		}
		
		listaGenero(request, response);
	}


}
