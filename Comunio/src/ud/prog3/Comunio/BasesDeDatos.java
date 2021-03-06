package ud.prog3.Comunio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BasesDeDatos 
{

	private static Connection connection = null;
	private static Statement statement = null;
	

	/** Inicializa una BD SQLITE y devuelve una conexi�n con ella. Debe llamarse a este 
	 * m�todo antes que ning�n otro, y debe devolver no null para poder seguir trabajando con la BD.
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexi�n con la base de datos indicada. Si hay alg�n error, se devuelve null
	 */
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog( null, "Error de conexi�n!! No se ha podido conectar con " + nombreBD , "ERROR", JOptionPane.ERROR_MESSAGE );
			System.out.println( "Error de conexi�n!! No se ha podido conectar con " + nombreBD );
			return null;
		}
	}
	
	/** Devuelve la conexi�n si ha sido establecida previamente (#initBD()).
	 * @return	Conexi�n con la BD, null si no se ha establecido correctamente.
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexi�n si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}

	
	/** Crea una tabla de cat�logo multimedia en una base de datos, si no exist�a ya.
	 * Debe haberse inicializado la conexi�n correctamente.
	 */
	public static void crearTablaUsuarios() {
	if (statement==null) return;//para que alguien no nos llame antes de initBD
	try {
			statement.executeUpdate("create table usuarios " + "(numIdentificador int, id string, contrase�a string, dinero double" +")");
	} catch (SQLException e) {
		// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
		// e.printStackTrace();  
	}
	}
	public static void crearTablaUsuarioJugadores(){
		
		if(statement==null) return;
		try{
			
			statement.executeUpdate("create table UsuarioJugadores " + "(idUsuario string, idJugador string" +")");
		}catch(SQLException e){
			
		}
		
		
		
	}
	
public static void crearTablaPorterosSalidos(){
		
		if(statement==null) return;
		try{
			
			statement.executeUpdate("create table porterosSalidos " + "(id string, nombre string, equipo string, posicion string, edad int, puntosJornada int, puntosTotales int" +")");
		}catch(SQLException e){
			
		}
		
		
	}
public static void crearTablaDefensasSalidos(){
		
		if(statement==null) return;
		try{
			
			statement.executeUpdate("create table defensasSalidos " + "(id string, nombre string, equipo string, posicion string, edad int, puntosJornada int, puntosTotales int" +")");
		}catch(SQLException e){
			
		}
		
		
	}
public static void crearTablaMediosSalidos(){
	
	if(statement==null) return;
	try{
		
		statement.executeUpdate("create table mediosSalidos " + "(id string, nombre string, equipo string, posicion string, edad int, puntosJornada int, puntosTotales int" +")");
	}catch(SQLException e){
		
	}
	
	
}
public static void crearTablaDelanterosSalidos(){
	
	if(statement==null) return;
	try{
		
		statement.executeUpdate("create table delanterosSalidos " + "(id string, nombre string, equipo string, posicion string, edad int, puntosJornada int, puntosTotales int" +")");
	}catch(SQLException e){
		
	}
	
	
}
	
	
	
	/** Cierra la conexi�n con la Base de Datos
	 */
	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void crearTablaJugadores() 
	{
		if (statement==null) return;//para que alguien no nos llame antes de initBD
		try {
				statement.executeUpdate("create table jugadores " + "(id string, nombre string, equipo string, posicion string, edad int, puntosJornada int, puntosTotales int" +")");
		} catch (SQLException e) {
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			// e.printStackTrace();  
		}
		}
	
//	public static void crearTablaPuntosJornada(){
//		
//		if(statement==null) return;
//		try{
//			
//			statement.executeUpdate("create table puntosjornada " + "(idJugador string, numJornada int, PuntosJornada1 int" +")");
//		}catch(SQLException e){
//			
//		}
//		
//		
//	}
public static void crearTablaMercadoDeFichajes(){
		
		if(statement==null) return;
		try{
			
			statement.executeUpdate("create table mercadoDeFichajes " + "(idJugador string, nombre string, precio int, puntosTotales int" +")");
		}catch(SQLException e){
			
		}
		
		
	}
public static void crearTablaClasificacion(){
	if(statement==null) return;
	
	try{
		statement.executeUpdate("create table clasificacion"+ "(Posicion string,idJugador string, PuntosJornada string,  PuntosTotales string"+")");
	}catch(SQLException e){
		
		
		
	}
	
	
}
	
	
	
		
	}

