package model;

import java.io.Serializable;
import java.sql.Date;

public class Vuelo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int IdVuelo;
	protected Avion Avion;
	protected String Desde;
	protected String Hasta;
	protected Date Partida;
	protected Date Llegada;
	
	public String getDesde() {
		return Desde;
	}
	public void setDesde(String desde) {
		Desde = desde;
	}
	public String getHasta() {
		return Hasta;
	}
	public void setHasta(String hasta) {
		Hasta = hasta;
	}
	public int getIdVuelo() {
		return IdVuelo;
	}
	public void setIdVuelo(int idVuelo) {
		IdVuelo = idVuelo;
	}
	public Avion getAvion() {
		return Avion;
	}
	public void setAvion(Avion avion) {
		Avion = avion;
	}
	public Date getPartida() {
		return Partida;
	}
	public void setPartida(Date partida) {
		Partida = partida;
	}
	public Date getLlegada() {
		return Llegada;
	}
	public void setLlegada(Date llegada) {
		Llegada = llegada;
	}
	
}
