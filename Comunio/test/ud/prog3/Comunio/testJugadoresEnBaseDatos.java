package ud.prog3.Comunio;

import static org.junit.Assert.*;

import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class testJugadoresEnBaseDatos 
{
	private ArrayList<Jugador> listaJugadores;
	Statement st;
	Jugador j;
	int num;
	
	@Before
	public void setUp() throws Exception
	{
		listaJugadores=new ArrayList<Jugador>();
		st=null;
		j=new Jugador();
		
		num=j.testJugadoresEnBaseDatos(listaJugadores, st);
	
	}
	
	@After
	public void tearDown() {
		listaJugadores.clear();
	}

	/**
	 * En este test, se comprueba que realmente estan todos los jugadores bien metidos en la base de datos
	 */
	@Test
	public void test() 
	{
		
		assertEquals(num, 74);
		
	}

}
