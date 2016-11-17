package ud.prog3.Comunio;

public class Jugador 
{
	private String nombre;
	private String equipo;
	private int edad;
	private int puntosJornada;
	private int puntosTotales;
	private String posicion;
	
	public Jugador()
	{
		nombre="";
		equipo="";
		edad=0;
		puntosJornada=0;
		puntosTotales=0;
		posicion="";
		
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getPuntosJornada() {
		return puntosJornada;
	}
	public void setPuntosJornada(int puntosJornada) {
		this.puntosJornada = puntosJornada;
	}
	public int getPuntosTotales() {
		return puntosTotales;
	}
	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
	}
	
	
	
	

}
