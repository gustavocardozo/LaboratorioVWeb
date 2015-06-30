package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.*;
import model.*;


public class SuccessUpdateReservaServlet extends GenericServlet {

	@Override
	public void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		Reserva r = (Reserva)request.getAttribute("reserva");
		nReserva n = new nReserva();
		
		
		if(n.ActualizarReserva(r))
		{
			boolean $var = true;
		}
			
		
		
		
		
		
		
		
		
		
	}

}
