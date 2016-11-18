package ud.prog3.Comunio;

import java.sql.SQLException;
import java.sql.Statement;

public class Jugador 
{
	private String nombre;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

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
			st.executeUpdate("insert into jugadores values('1', 'Cristiano Ronaldo', 'Real Madrid C.F', 'Delantero', '32', '0', '0')");
			st.executeUpdate("insert into jugadores values('2', 'Keylor Navas', 'Real Madrid C.F', 'Portero', '31', '0', '0')");
			st.executeUpdate("insert into jugadores values('3', 'Dani Carvajal', 'Real Madrid C.F', 'Defensa', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('4', 'Pepe', 'Real Madrid C.F', 'Defensa', '34', '0', '0')");
			st.executeUpdate("insert into jugadores values('5', 'Sergio Ramos', 'Real Madrid C.F', 'Defensa', '31', '0', '0')");
			st.executeUpdate("insert into jugadores values('6', 'Raphael Varane', 'Real Madrid C.F', 'Defensa', '23', '0', '0')");
			st.executeUpdate("insert into jugadores values('7', 'Nacho Fernandez', 'Real Madrid C.F', 'Defensa', '26', '0', '0')");
			st.executeUpdate("insert into jugadores values('8', 'Marcelo', 'Real Madrid C.F', 'Defensa', '28', '0', '0')");
			st.executeUpdate("insert into jugadores values('9', 'Fabio Coentrao', 'Real Madrid C.F', 'Defensa', '28', '0', '0')");
			st.executeUpdate("insert into jugadores values('10', 'Danilo', 'Real Madrid C.F', 'Defensa', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('11', 'Toni Kroos', 'Real Madrid C.F', 'Centrocampista', '26', '0', '0')");
			st.executeUpdate("insert into jugadores values('12', 'James Rodriguez', 'Real Madrid C.F', 'Centrocampista', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('13', 'Casemiro', 'Real Madrid C.F', 'Centrocampista', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('14', 'Mateo Kovacic', 'Real Madrid C.F', 'Centrocampista', '22', '0', '0')");
			st.executeUpdate("insert into jugadores values('15', 'Luca Modric', 'Real Madrid C.F', 'Centrocampista', '31', '0', '0')");
			st.executeUpdate("insert into jugadores values('16', 'Marco Asensio', 'Real Madrid C.F', 'Centrocampista', '20', '0', '0')");
			st.executeUpdate("insert into jugadores values('17', 'Isco', 'Real Madrid C.F', 'Centrocampista', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('18', 'Karim Benzema', 'Real Madrid C.F', 'Delantero', '29', '0', '0')");
			st.executeUpdate("insert into jugadores values('19', 'Gareth Bale', 'Real Madrid C.F', 'Delantero', '27', '0', '0')");
			st.executeUpdate("insert into jugadores values('20', 'Lucas Vazquez', 'Real Madrid C.F', 'Delantero', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('21', 'Mariano Diaz', 'Real Madrid C.F', 'Delantero', '23', '0', '0')");
			st.executeUpdate("insert into jugadores values('22', 'Alvaro Morata', 'Real Madrid C.F', 'Delantero', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('23', 'Gorka Iraizoz', 'Athletic Club', 'Portero', '35', '0', '0')");
			st.executeUpdate("insert into jugadores values('24', 'Iago Herrerin', 'Athletic Club', 'Portero', '28', '0', '0')");
			st.executeUpdate("insert into jugadores values('25', 'Kepa Arrizabalaga', 'Athletic Club', 'Portero', '21', '0', '0')");
			st.executeUpdate("insert into jugadores values('26', 'Eneko Boveda', 'Athletic Club', 'Defensa', '27', '0', '0')");
			st.executeUpdate("insert into jugadores values('27', 'Aymeric Laporte', 'Athletic Club', 'Defensa', '22', '0', '0')");
			st.executeUpdate("insert into jugadores values('28', 'Mikel San Jose', 'Athletic Club', 'Defensa', '27', '0', '0')");
			st.executeUpdate("insert into jugadores values('29', 'Xabier Etxeita', 'Athletic Club', 'Defensa', '28', '0', '0')");
			st.executeUpdate("insert into jugadores values('30', 'Mikel Balenciaga', 'Athletic Club', 'Defensa', '28', '0', '0')");
			st.executeUpdate("insert into jugadores values('31', 'Enric Saborit', 'Athletic Club', 'Defensa', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('32', 'Yeray Alvarez', 'Athletic Club', 'Defensa', '21', '0', '0')");
			st.executeUpdate("insert into jugadores values('33', 'Gorka Elustondo', 'Athletic Club', 'Centrocampista', '29', '0', '0')");
			st.executeUpdate("insert into jugadores values('34', 'Javier Eraso', 'Athletic Club', 'Centrocampista', '26', '0', '0')");
			st.executeUpdate("insert into jugadores values('35', 'Beñat Etxebarria', 'Athletic Club', 'Centrocampista', '29', '0', '0')");
			st.executeUpdate("insert into jugadores values('36', 'Ander Iturraspe', 'Athletic Club', 'Centrocampista', '27', '0', '0')");
			st.executeUpdate("insert into jugadores values('37', 'Mikel Vesga', 'Athletic Club', 'Centrocampista', '23', '0', '0')");
			st.executeUpdate("insert into jugadores values('38', 'Markel Susaeta', 'Athletic Club', 'Centrocampista', '28', '0', '0')");
			st.executeUpdate("insert into jugadores values('39', 'Iñigo Lekue', 'Athletic Club', 'Centrocampista', '23', '0', '0')");
			st.executeUpdate("insert into jugadores values('40', 'Mikel Rico', 'Athletic Club', 'Centrocampista', '31', '0', '0')");
			st.executeUpdate("insert into jugadores values('41', 'Oscar De Marcos', 'Athletic Club', 'Centrocampista', '27', '0', '0')");
			st.executeUpdate("insert into jugadores values('42', 'Raul Garcia', 'Athletic Club', 'Centrocampista', '30', '0', '0')");
			st.executeUpdate("insert into jugadores values('43', 'Iker Muniain', 'Athletic Club', 'Delantero', '23', '0', '0')");
			st.executeUpdate("insert into jugadores values('44', 'Iñaki Williams', 'Athletic Club', 'Delantero', '22', '0', '0')");
			st.executeUpdate("insert into jugadores values('45', 'Sabin Merino', 'Athletic Club', 'Delantero', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('46', 'Aritz Aduriz', 'Athletic Club', 'Delantero', '35', '0', '0')");
			st.executeUpdate("insert into jugadores values('47', 'Bardaji', 'Real Sociedad S.A.D', 'Portero', '21', '0', '0')");
			st.executeUpdate("insert into jugadores values('48', 'Geronimo Rulli', 'Real Sociedad S.A.D', 'Portero', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('49', 'Toño', 'Real Sociedad S.A.D', 'Portero', '30', '0', '0')");
			st.executeUpdate("insert into jugadores values('50', 'Aritz Elustondo', 'Real Sociedad S.A.D', 'Defensa', '22', '0', '0')");
			st.executeUpdate("insert into jugadores values('51', 'Carlos Martinez', 'Real Sociedad S.A.D', 'Defensa', '30', '0', '0')");
			st.executeUpdate("insert into jugadores values('52', 'Hector', 'Real Sociedad S.A.D', 'Defensa', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('53', 'Iñigo Martinez', 'Real Sociedad S.A.D', 'Defensa', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('54', 'Joseba Zaldua', 'Real Sociedad S.A.D', 'Defensa', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('55', 'Mikel Gonzalez', 'Real Sociedad S.A.D', 'Defensa', '31', '0', '0')");
			st.executeUpdate("insert into jugadores values('56', 'Raul Navas', 'Real Sociedad S.A.D', 'Defensa', '28', '0', '0')");
			st.executeUpdate("insert into jugadores values('57', 'Yuri Berchiche', 'Real Sociedad S.A.D', 'Defensa', '26', '0', '0')");
			st.executeUpdate("insert into jugadores values('58', 'Markel Bergara', 'Real Sociedad S.A.D', 'Centrocampista', '30', '0', '0')");
			st.executeUpdate("insert into jugadores values('59', 'Sergio Canales', 'Real Sociedad S.A.D', 'Centrocampista', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('60', 'Mikel Gaztañaga', 'Real Sociedad S.A.D', 'Centrocampista', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('61', 'Esteban Granero', 'Real Sociedad S.A.D', 'Centrocampista', '29', '0', '0')");
			st.executeUpdate("insert into jugadores values('62', 'Asier Illarramendi', 'Real Sociedad S.A.D', 'Centrocampista', '26', '0', '0')");
			st.executeUpdate("insert into jugadores values('63', 'Kevin Rodrigues', 'Real Sociedad S.A.D', 'Centrocampista', '22', '0', '0')");
			st.executeUpdate("insert into jugadores values('64', 'Ruben Pardo', 'Real Sociedad S.A.D', 'Centrocampista', '24', '0', '0')");
			st.executeUpdate("insert into jugadores values('65', 'Xabi Prieto', 'Real Sociedad S.A.D', 'Centrocampista', '33', '0', '0')");
			st.executeUpdate("insert into jugadores values('66', 'David Zurutuza', 'Real Sociedad S.A.D', 'Centrocampista', '30', '0', '0')");
			st.executeUpdate("insert into jugadores values('67', 'Imanol Agirretxe', 'Real Sociedad S.A.D', 'Delantero', '29', '0', '0')");
			st.executeUpdate("insert into jugadores values('68', 'David Concha', 'Real Sociedad S.A.D', 'Delantero', '20', '0', '0')");
			st.executeUpdate("insert into jugadores values('69', 'Jon Bautista', 'Real Sociedad S.A.D', 'Delantero', '21', '0', '0')");
			st.executeUpdate("insert into jugadores values('70', 'Juanmi', 'Real Sociedad S.A.D', 'Delantero', '23', '0', '0')");
			st.executeUpdate("insert into jugadores values('71', 'Mikel Oyarzabal', 'Real Sociedad S.A.D', 'Delantero', '19', '0', '0')");
			st.executeUpdate("insert into jugadores values('72', 'Carlos Vela', 'Real Sociedad S.A.D', 'Delantero', '27', '0', '0')");
			st.executeUpdate("insert into jugadores values('73', 'William Jose', 'Real Sociedad S.A.D', 'Delantero', '25', '0', '0')");
			st.executeUpdate("insert into jugadores values('74', 'Zubeldia', 'Real Sociedad S.A.D', 'Delantero', '19', '0', '0')");
			
			
			
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
		
		
		String sentSQL="drop table jugadores";
		try {
			st.executeUpdate(sentSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	//}
		
	
	
	}
}


