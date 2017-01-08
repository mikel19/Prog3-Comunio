package ud.prog3.Comunio;

import java.io.Serializable;

public class Noticia implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String noticia;

	public String getNoticia() {
		return noticia;
	}

	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}

	@Override
	public String toString() {
		return "Noticia de Administrador [" + noticia + "]"+"\n";
	}
	
}
