package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.*;


public class UpdateReservaServlet extends GenericServlet {

	@Override
	public void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		nReserva nR = new nReserva();
		nCliente nC = new nCliente();
		nPaquete nP = new nPaquete();
		nVuelo nV = new nVuelo();
		
		
		request.setAttribute("clientes", nC.ListaBase());
		request.setAttribute("vuelos", nV.ListaVuelos());
		request.setAttribute("paquetes", nP.ListaBase());
		request.setAttribute("reserva", nR.GetReservabyID(Integer.parseInt(request.getParameter("id"))));
	
	}

}
