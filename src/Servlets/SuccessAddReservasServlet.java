package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.*;
import model.*;

public class SuccessAddReservasServlet extends GenericServlet {

	@Override
	public void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		Reserva reserva = new Reserva();
		Paquete paquete = new Paquete();
		List<Cliente> clientes = new ArrayList<Cliente>();
		Vuelo vuelo = new Vuelo();
		nReserva n = new nReserva();
		vuelo= (Vuelo)request.getAttribute("Vuelo");
		paquete = (Paquete)request.getAttribute("Paquete");
		clientes = (List<Cliente>)request.getAttribute("ListaClientes");
		
		reserva.setClientes(clientes);
		reserva.setVuelo(vuelo);
		reserva.setPaquete(paquete);
		reserva.setTotal(paquete.getPrecio() * clientes.size());
		
		if(n.ValidarDisponibilidad(reserva) >= clientes.size())
		{
			if(n.GrabarReserva(reserva))
			{
			}
		}	
		
		
	}

}
