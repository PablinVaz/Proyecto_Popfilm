package com.entidades.dao.controllers.jee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entidades.dao.impl.jee.ProductoraDaoImpl;
import com.entidades.dao.jee.ProductoraDao;
import com.entidades.jee.Productora;

/**
 * Servlet implementation class ProductoraController
 */
@WebServlet("/ProductoraController")
public class ProductoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	
	ProductoraDao productoraDao= new ProductoraDaoImpl();

    /**
     * Default constructor. 
     */
    public ProductoraController() {
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listaProductora(request, response);
				break;
				
			case "EDIT":
				getSingleProductora(request, response);
				break;
				
			case "DELETE":
				deleteProductora(request, response);
				break;
				
			default:
				listaProductora(request, response);
				break;
				
		}
	}

	private void deleteProductora(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id_productora");
	
		if(productoraDao.delete(Long.parseLong(id))) {
			request.setAttribute("NOTIFICATION", "Productora eliminada!");
		}
		
		listaProductora(request, response);
	}

	private void getSingleProductora(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id_productora");
		
		Productora productora = productoraDao.findById(Long.parseLong(id));
		
		request.setAttribute("productora", productora);
		
		dispatcher = request.getRequestDispatcher("/views/productora-form.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listaProductora(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Productora> lista = productoraDao.findAll();
		
		request.setAttribute("lista", lista);
		
		dispatcher = request.getRequestDispatcher("/views/productora-list.jsp");
		
		dispatcher.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id_productora");
		String inversionInicial = request.getParameter("inversion_inicial");
		String ganancias = request.getParameter("ganancias");
		String gananciasTotales = request.getParameter("ganancias_totales");
		Productora productora= new Productora();
		
		productora.setNombre(request.getParameter("nombre"));
		productora.setInversionInicial(Double.parseDouble(inversionInicial));
		productora.setGanancias(Double.parseDouble(ganancias));
		productora.setGananciasTotales(Double.parseDouble(gananciasTotales));
		
		


		
		if(id.isEmpty() || id == null) {
			
			if(productoraDao.save(productora)) {
				request.setAttribute("NOTIFICATION", "Productora guardada!");
			}
		
		}else {
			
			productora.setId(Long.parseLong(id));
			if(productoraDao.update(productora)) {
				request.setAttribute("NOTIFICATION", "Productora actualizada!");
			}
			
		}
		
		listaProductora(request, response);
	}

}
