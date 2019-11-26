package com.entidades.dao.controllers.jee;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entidades.dao.impl.jee.DirectorDaoImpl;
import com.entidades.dao.jee.DirectorDao;
import com.entidades.jee.Director;



/**
 * Servlet implementation class DirectorController
 */
@WebServlet("/DirectorController")
public class DirectorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	RequestDispatcher dispatcher = null;
	
	DirectorDao directorDao = new DirectorDaoImpl();
	
	
    public DirectorController() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listaDirector(request, response);
				break;
				
			case "EDIT":
				getSingleDirector(request, response);
				break;
				
			case "DELETE":
				deleteDirector(request, response);
				break;
				
			default:
				listaDirector(request, response);
				break;
				
		}
	}

	private void deleteDirector(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id_director");
	
		if(directorDao.delete(Long.parseLong(id))) {
			request.setAttribute("NOTIFICATION", "Director eliminado!");
		}
		
		listaDirector(request, response);
	}

	private void getSingleDirector(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id_director");
		
		Director director = directorDao.findById(Long.parseLong(id));
		
		request.setAttribute("director", director);
		
		dispatcher = request.getRequestDispatcher("/views/director-form.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listaDirector(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Director> lista = directorDao.findAll();
		
		request.setAttribute("lista", lista);
		
		dispatcher = request.getRequestDispatcher("/views/director-list.jsp");
		
		dispatcher.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id_director");
		String cadenaFecha = request.getParameter("fecha_de_nacimiento");
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		try {
			fecha = formatter.parse(cadenaFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String numPremios = request.getParameter("numPremios");
		Director director = new Director();
		
//		director.setPeliculas(request.getParameter("pelicula")); La lista de peliculas sera accesible desde la entidad pelicula
		director.setNombre(request.getParameter("nombre"));
		director.setNumPremios(Integer.parseInt(numPremios));
		director.setFechaDeNacimiento(fecha);


		
		if(id.isEmpty() || id == null) {
			
			if(directorDao.save(director)) {
				request.setAttribute("NOTIFICATION", "Director guardado!");
			}
		
		}else {
			
			director.setId(Long.parseLong(id));
			if(directorDao.update(director)) {
				request.setAttribute("NOTIFICATION", "Director actualizado!");
			}
			
		}
		
		listaDirector(request, response);
	}

}
