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


import com.entidades.dao.impl.jee.PeliculaDaoImpl;
import com.entidades.dao.jee.PeliculaDao;
import com.entidades.jee.Pelicula;

/**
 * Servlet implementation class PeliculaController
 */
@WebServlet("/PeliculaController")
public class PeliculaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	
	PeliculaDao peliculaDao = new PeliculaDaoImpl();

    /**
     * Default constructor. 
     */
    public PeliculaController() {
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listaPelicula(request, response);
				break;
				
			case "EDIT":
				getSinglePelicula(request, response);
				break;
				
			case "DELETE":
				deletePelicula(request, response);
				break;
				
			default:
				listaPelicula(request, response);
				break;
				
		}
	}

	private void deletePelicula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id_pelicula");
	
		if(peliculaDao.delete(Long.parseLong(id))) {
			request.setAttribute("NOTIFICATION", "Película eliminada!");
		}
		
		listaPelicula(request, response);
	}

	private void getSinglePelicula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id_pelicula");
		
//		Pelicula peliculaFilter = new Pelicula(); //esta viene de un filtro 
//		List<Pelicula> peliculasFiltradas = peliculaDao.findByCriteria(peliculaFilter);
		
		Pelicula pelicula = peliculaDao.findById(Long.parseLong(id));
		
		request.setAttribute("pelicula", pelicula);
		
		dispatcher = request.getRequestDispatcher("/views/pelicula-form.jsp");
		
		dispatcher.forward(request, response);
		
		
	}

	

	private void listaPelicula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Pelicula> lista = peliculaDao.findAll();
		
		request.setAttribute("lista", lista);
		
		dispatcher = request.getRequestDispatcher("/views/pelicula-list.jsp");
		
		dispatcher.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id_genero");		
		String cadenaFecha = request.getParameter("fecha_de_estreno");
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		try {
			fecha = formatter.parse(cadenaFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Pelicula pelicula = new Pelicula();
		
		pelicula.setTitulo(request.getParameter("titulo"));
		pelicula.setReparto(request.getParameter("reparto"));
		pelicula.setEdadRecomendada(request.getParameter("edad_recomendada"));
		pelicula.setSinopsis(request.getParameter("sinopsis"));
		pelicula.setFechaEstreno(fecha);
		
		
		


		
		if(id.isEmpty() || id == null) {
			
			if(peliculaDao.save(pelicula)) {
				request.setAttribute("NOTIFICATION", "Película guardada!");
			}
		
		}else {
			
			pelicula.setId(Long.parseLong(id));
			if(peliculaDao.update(pelicula)) {
				request.setAttribute("NOTIFICATION", "Género actualizado!");
			}
			
		}
		
		listaPelicula(request, response);
	}



}
