package service;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.*;

public class nReserva {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "";
	private String dbName = "grupo_6_db";
	public boolean GrabarReserva(Reserva r)
	{
		Connection conn =null;
		int id_reserva = obtenerID();
		String query = "INSERT INTO RESERVA(ID_RESERVA,ID_PAQUETE,ID_VUELO) "; 
		
		try
		{
			conn = (Connection) DriverManager.getConnection(host + dbName, user,pass );
			Statement st = (Statement) conn.createStatement();
			query = query+ "VALUES("+id_reserva+", "+r.getPaquete().getIdPaquete()+", "+r.getVuelo().getIdVuelo()+")";
			st.execute(query);
			
			for(Cliente c : r.getClientes())
			{
				query = "INSERT INTO RESERVA_CLIENTE(ID_RESERVA,ID_CLIENTE) VALUES("+id_reserva+","+c.getId()+")";
				st.execute(query);
			}
		}
		catch(Exception e)
		{
			return false;
			
		}
		finally
		{
			if(conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		return true;
		
	}
	
	
	public int obtenerID()
	{
		String query = "SELECT MAX(ID_RESERVA) ID FROM RESERVA"; 
		Connection conn = null;
		
		try
		{
			conn = (Connection) DriverManager.getConnection(host + dbName, user,pass );
			Statement st = (Statement) conn.createStatement();
			
			ResultSet rs = st.executeQuery(query);
		
			if(rs != null)
			{
				return rs.getInt("ID");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		return 1;
		
	}
	
	
	public boolean ActualizarReserva(Reserva r)
	{
		Connection conn =null;
		String query = "INSERT INTO RESERVA(ID_RESERVA,ID_PAQUETE,ID_VUELO) "; 
		
		try
		{
			conn = (Connection) DriverManager.getConnection(host + dbName, user,pass );
			Statement st = (Statement) conn.createStatement();
			st.execute("DELETE RESERVA WHERE ID_RESERVA = "+r.getIdReserva());
			st.execute("DELETE RESERVA_CLIENTE WHERE ID_RESERVA = "+r.getIdReserva());
			
			query = query+ "VALUES("+r.getIdReserva()+", "+r.getPaquete().getIdPaquete()+", "+r.getVuelo().getIdVuelo()+")";
			st.execute(query);
			
			for(Cliente c : r.getClientes())
			{
				query = "INSERT INTO RESERVA_CLIENTE(ID_RESERVA,ID_CLIENTE) VALUES("+c.getId()+")";
				st.execute(query);
			}
		}
		catch(Exception e)
		{
			return false;
			
		}
		finally
		{
			if(conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		return true;
		
	}
	
	public int ValidarDisponibilidad(Reserva r)
	{
		Connection conn =null;
		String query = "SELECT COUNT(R.ID_VUELO) - A.CANTIDAD AS 'CANTIDAD' FROM RESERVA AS R";
		query = "INNER JOIN VUELO AS V ON V.ID_VUELO = R.ID_VUELO";
		query = "INNER JOIN AVION AS A ON A.ID_AVION = V.ID_AVION";
		
		
		try
		{
			conn = (Connection) DriverManager.getConnection(host + dbName, user,pass );
			Statement st = (Statement) conn.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			if(rs!=null)
			{
				
				return rs.getInt("CANTIDAD");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally
		{
			if(conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		return 0;
	}
	
	
	public Reserva GetReservabyID(int id)
	{
		Connection conn =null;
		Reserva reserva = new Reserva();
		
		String query = "SELECT C.* FROM RESERVA_CLIENTE AS RC";
		query = "INNER JOIN CLIENTE AS C ON RC.ID_CLIENTE = C.ID_CLIENTE";
		query = "WHERE RC.ID_RESERVA = " + id;
		
		
		
		try{
			conn = (Connection) DriverManager.getConnection(host + dbName, user,pass );
			Statement st = (Statement) conn.createStatement();
			List<Cliente> clientes = new ArrayList<>();
			Cliente clie = new Cliente();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{
				clie.setId(rs.getInt("ID_CLIENTE"));
				clie.setDni(rs.getString("DNI"));
				clie.setNombre(rs.getString("APELLIDO")+", "+rs.getString("NOMBRE"));
				clie.setDireccion(rs.getString("DIRECCION"));
				clie.setEmail(rs.getString("EMAIL"));
				clie.setFechaNac(rs.getDate("FEC_NACIMIENTO"));
				clie.setTelefono(rs.getString("TELEFONO"));
				
				clientes.add(clie);
				
			}
			
			reserva.setClientes(clientes);
			
			rs.close();
			query = "SELECT P.*, V.* FROM RESERVA AS R";
			query="INNER JOIN VUELO AS V ON V.ID_VUELO = R.ID_VUELO";
			query = "INNER JOIN PAQUETE AS P ON P.ID_PAQUETE = R.ID_PAQUETE";
			query = "WHERE ID_RESERVA ="+id;
			
			rs=st.executeQuery(query);
			
			if(rs != null)
			{
				Vuelo v= new Vuelo();
				Avion a = new Avion();
				Paquete p = new Paquete();
				
				a.setId(rs.getInt("V.ID_AVION"));
				v.setAvion(a);
				v.setIdVuelo(rs.getInt("V.ID_VUELO"));
				v.setLlegada(rs.getDate("V.HORARIO_LLEGADA"));
				v.setPartida(rs.getDate("V.HORARIO_PARTIDA"));
				reserva.setVuelo(v);
				
				p.setIdPaquete(rs.getInt("P.ID_PAQUETE"));
				p.setNombre(rs.getString("P.NOMBRE"));
				p.setDestino(rs.getString("P.HACIA"));
				p.setOrigen(rs.getString("P.DESDE"));
				p.setPrecio(rs.getFloat("P.PRECIO"));
				reserva.setPaquete(p);
				
				reserva.setIdReserva(id);
				
				reserva.setTotal(reserva.getClientes().size() *reserva.getPaquete().getPrecio());		
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
			
		}
		return reserva;
	}
}
