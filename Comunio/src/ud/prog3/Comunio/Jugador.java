package ud.prog3.Comunio;

import java.sql.SQLException;
import java.sql.Statement;

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
	
	public static void inserccionJugadores()
	{
		Statement st=null;
		st=BasesDeDatos.getStatement();
//		try {
//			String sentSQL = "insert into jugadores values(" +
		try {
			st.executeUpdate("insert into jugadores values('Cristiano Ronaldo', 'Real Madrid C.F', 'Delantero', '32', '0', '0')");
			st.executeUpdate("insert into jugadores values('Keylor Navas', 'Real Madrid C.F', 'Portero', '31', '0', '0')");
			st.executeUpdate( "insert into jugadores values('Dani Carvajal', 'Real Madrid C.F', 'Defensa', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('Pepe', 'Real Madrid C.F', 'Defensa', '34', '0', '0')");
			st.executeUpdate("insert into jugadores values('Sergio Ramos', 'Real Madrid C.F', 'Defensa', '31', '0', '0')");
			st.executeUpdate("insert into jugadores values('Raphael Varane', 'Real Madrid C.F', 'Defensa', '23', '0', '0')");
			st.executeUpdate("insert into jugadores values('Nacho Fernandez', 'Real Madrid C.F', 'Defensa', '26', '0', '0')");
			st.executeUpdate("insert into jugadores values('Marcelo', 'Real Madrid C.F', 'Defensa', '28', '0', '0')");
			st.executeUpdate("insert into jugadores values('Fabio Coentrao', 'Real Madrid C.F', 'Defensa', '28', '0', '0')");
			st.executeUpdate("insert into jugadores values('Danilo', 'Real Madrid C.F', 'Defensa', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('Toni Kroos', 'Real Madrid C.F', 'Centrocampista', '26', '0', '0')");
			st.executeUpdate("insert into jugadores values('James Rodriguez', 'Real Madrid C.F', 'Centrocampista', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('Casemiro', 'Real Madrid C.F', 'Centrocampista', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('Mateo Kovacic', 'Real Madrid C.F', 'Centrocampista', '22', '0', '0')");
			st.executeUpdate("insert into jugadores values('Luca Modric', 'Real Madrid C.F', 'Centrocampista', '31', '0', '0')");
			st.executeUpdate("insert into jugadores values('Marco Asensio', 'Real Madrid C.F', 'Centrocampista', '20', '0', '0')");
			st.executeUpdate("insert into jugadores values('Isco', 'Real Madrid C.F', 'Centrocampista', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('Karim Benzema', 'Real Madrid C.F', 'Delantero', '29', '0', '0')");
			st.executeUpdate("insert into jugadores values('Gareth Bale', 'Real Madrid C.F', 'Delantero', '27', '0', '0')");
			st.executeUpdate("insert into jugadores values('Lucas Vazquez', 'Real Madrid C.F', 'Delantero', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('Mariano Diaz', 'Real Madrid C.F', 'Delantero', '23', '0', '0')");
			st.executeUpdate("insert into jugadores values('Alvaro Morata', 'Real Madrid C.F', 'Delantero', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('Gorka Iraizoz', 'Athletic Club', 'Portero', '35', '0', '0')");
			st.executeUpdate("insert into jugadores values('Iago Herrerin', 'Athletic Club', 'Portero', '28', '0', '0')");
			st.executeUpdate("insert into jugadores values('Kepa Arrizabalaga', 'Athletic Club', 'Portero', '21', '0', '0')");
			st.executeUpdate("insert into jugadores values('Eneko Boveda', 'Athletic Club', 'Defensa', '27', '0', '0')");
			st.executeUpdate("insert into jugadores values('Aymeric Laporte', 'Athletic Club', 'Defensa', '22', '0', '0')");
			st.executeUpdate("insert into jugadores values('Mikel San Jose', 'Athletic Club', 'Defensa', '27', '0', '0')");
			st.executeUpdate("insert into jugadores values('Xabier Etxeita', 'Athletic Club', 'Defensa', '28', '0', '0')");
			st.executeUpdate("insert into jugadores values('Mikel Balenciaga', 'Athletic Club', 'Defensa', '28', '0', '0')");
			st.executeUpdate("insert into jugadores values('Enric Saborit', 'Athletic Club', 'Defensa', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('Yeray Alvarez', 'Athletic Club', 'Defensa', '21', '0', '0')");
			st.executeUpdate("insert into jugadores values('Gorka Elustondo', 'Athletic Club', 'Centrocampista', '29', '0', '0')");
			st.executeUpdate("insert into jugadores values('Javier Eraso', 'Athletic Club', 'Centrocampista', '26', '0', '0')");
			st.executeUpdate("insert into jugadores values('Beñat Etxebarria', 'Athletic Club', 'Centrocampista', '29', '0', '0')");
			st.executeUpdate("insert into jugadores values('Ander Iturraspe', 'Athletic Club', 'Centrocampista', '27', '0', '0')");
			st.executeUpdate("insert into jugadores values('Mikel Vesga', 'Athletic Club', 'Centrocampista', '23', '0', '0')");
			st.executeUpdate("insert into jugadores values('Markel Susaeta', 'Athletic Club', 'Centrocampista', '28', '0', '0')");
			st.executeUpdate("insert into jugadores values('Iñigo Lekue', 'Athletic Club', 'Centrocampista', '23', '0', '0')");
			st.executeUpdate("insert into jugadores values('Mikel Rico', 'Athletic Club', 'Centrocampista', '31', '0', '0')");
			st.executeUpdate("insert into jugadores values('Oscar De Marcos', 'Athletic Club', 'Centrocampista', '27', '0', '0')");
			st.executeUpdate("insert into jugadores values('Raul Garcia', 'Athletic Club', 'Centrocampista', '30', '0', '0')");
			st.executeUpdate("insert into jugadores values('Iker Muniain', 'Athletic Club', 'Delantero', '23', '0', '0')");
			st.executeUpdate("insert into jugadores values('Iñaki Williams', 'Athletic Club', 'Delantero', '22', '0', '0')");
			st.executeUpdate("insert into jugadores values('Sabin Merino', 'Athletic Club', 'Delantero', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('Aritz Aduriz', 'Athletic Club', 'Delantero', '35', '0', '0')");
			st.executeUpdate( "insert into jugadores values('Bardaji', 'Real Sociedad S.A.D', 'Portero', '21', '0', '0')");
			st.executeUpdate("insert into jugadores values('Geronimo Rulli', 'Real Sociedad S.A.D', 'Portero', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('Toño', 'Real Sociedad S.A.D', 'Portero', '30', '0', '0')");
			st.executeUpdate("insert into jugadores values('Aritz Elustondo', 'Real Sociedad S.A.D', 'Defensa', '22', '0', '0')");
			st.executeUpdate("insert into jugadores values('Carlos Martinez', 'Real Sociedad S.A.D', 'Defensa', '30', '0', '0')");
			st.executeUpdate("insert into jugadores values('Hector', 'Real Sociedad S.A.D', 'Defensa', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('Iñigo Martinez', 'Real Sociedad S.A.D', 'Defensa', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('Joseba Zaldua', 'Real Sociedad S.A.D', 'Defensa', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('Mikel Gonzalez', 'Real Sociedad S.A.D', 'Defensa', '31', '0', '0')");
			st.executeUpdate("insert into jugadores values('Raul Navas', 'Real Sociedad S.A.D', 'Defensa', '28', '0', '0')");
			st.executeUpdate("insert into jugadores values('Yuri Berchiche', 'Real Sociedad S.A.D', 'Defensa', '26', '0', '0')");
			st.executeUpdate("insert into jugadores values('Markel Bergara', 'Real Sociedad S.A.D', 'Centrocampista', '30', '0', '0')");
			st.executeUpdate("insert into jugadores values('Sergio Canales', 'Real Sociedad S.A.D', 'Centrocampista', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('Mikel Gaztañaga', 'Real Sociedad S.A.D', 'Centrocampista', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('Esteban Granero', 'Real Sociedad S.A.D', 'Centrocampista', '29', '0', '0')");
			st.executeUpdate("insert into jugadores values('Asier Illarramendi', 'Real Sociedad S.A.D', 'Centrocampista', '26', '0', '0')");
			st.executeUpdate("insert into jugadores values('Kevin Rodrigues', 'Real Sociedad S.A.D', 'Centrocampista', '22', '0', '0')");
			st.executeUpdate("insert into jugadores values('Ruben Pardo', 'Real Sociedad S.A.D', 'Centrocampista', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('Xabi Prieto', 'Real Sociedad S.A.D', 'Centrocampista', '33', '0', '0')");
			st.executeUpdate("insert into jugadores values('David Zurutuza', 'Real Sociedad S.A.D', 'Centrocampista', '30', '0', '0')");
			st.executeUpdate("insert into jugadores values('Imanol Agirretxe', 'Real Sociedad S.A.D', 'Delantero', '29', '0', '0')");
			st.executeUpdate("insert into jugadores values('David Concha', 'Real Sociedad S.A.D', 'Delantero', '20', '0', '0')");
			st.executeUpdate("insert into jugadores values('Jon Bautista', 'Real Sociedad S.A.D', 'Delantero', '21', '0', '0')");
			st.executeUpdate("insert into jugadores values('Juanmi', 'Real Sociedad S.A.D', 'Delantero', '23', '0', '0')");
			st.executeUpdate("insert into jugadores values('Mikel Oyarzabal', 'Real Sociedad S.A.D', 'Delantero', '19', '0', '0')");
			st.executeUpdate("insert into jugadores values('Carlos Vela', 'Real Sociedad S.A.D', 'Delantero', '27', '0', '0')");
			st.executeUpdate("insert into jugadores values('William Jose', 'Real Sociedad S.A.D', 'Delantero', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('Zubeldia', 'Real Sociedad S.A.D', 'Delantero', '19', '0', '0')");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

					//;
			//System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
			//int val = st.executeUpdate( sentSQL );
//			if (val!=1) return false;  // Se tiene que añadir 1 - error si no
//			return true;
	//	} catch (SQLException e1) {
		//	e1.printStackTrace();
//			return false;
	//	}
		
		
//		String sentSQL="drop table jugadores";
//		try {
//			st.executeUpdate(sentSQL);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	//}
		
	
	
	}
}


