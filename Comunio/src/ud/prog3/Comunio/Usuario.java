package ud.prog3.Comunio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Usuario
{
	private String numIdentificador;
	private String id;
	private String contraseña;
	private int dinero;
	public String getNumIdentificador() {
		return numIdentificador;
	}
	public void setNumIdentificador(String numIdentificador) {
		this.numIdentificador = numIdentificador;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public int getDinero() {
		return dinero;
	}
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	
	
	
	
	
	
}
