package ud.prog3.Comunio;

public class UsuarioJugador implements Comparable<UsuarioJugador>
{
	
	private String idUsuario;
	private String idJugador;
	private int puntosTotales;
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(String idJugador) {
		this.idJugador = idJugador;
	}
	public int getPuntosTotales() {
		return puntosTotales;
	}
	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
	}
	
	
	
	
	@Override
	public int compareTo(UsuarioJugador o) {
		
		if(this.getPuntosTotales()>o.getPuntosTotales())
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	
	

}
