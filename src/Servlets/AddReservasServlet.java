package Servlets;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import service.*;

public class AddReservasServlet extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		nCliente nC = new nCliente();
		nPaquete nP = new nPaquete();
		nVuelo nV = new nVuelo();
		
		
		for(Cliente clie : nC.ListaBase())
		{
			System.out.println(clie.getId());
			
		}
		
		request.setAttribute("clientes", nC.ListaBase());
		request.setAttribute("vuelos", nV.ListaVuelos());
		request.setAttribute("paquetes", nP.ListaBase());
		request.setAttribute("string", "Hola, soy un ejemplo");
	
		request.getRequestDispatcher("/AgregarReserva.jsp").forward(request, response);
		
	}

}
