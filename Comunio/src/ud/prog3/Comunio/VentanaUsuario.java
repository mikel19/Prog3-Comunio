package ud.prog3.Comunio;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;










import java.awt.Font;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Toolkit;

public class VentanaUsuario extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField id;
	//private JTextField contraseña;
	private JPasswordField contraseña;
	private JButton btnAcceder;
	private JButton btnCancelar;
	private JLabel lblLogInCon;
	private JLabel lblRegistrateYCrea;
	private JTextField nId;
	//private JTextField nContraseña;
	private JPasswordField nContraseña;
	private JLabel lblqueIdQuieres;
	private JLabel lblyQueContrasea;
	private JButton btnRegistrar;
	static Statement st=null;
	ArrayList Usuarios;
	 ArrayList <Jugador>defensas;
	 ArrayList <Jugador>medios;
	 ArrayList <Jugador>delanteros;
	 ArrayList <Jugador>porteros;
	 ArrayList<Jugador>todosJugadores;
	 ArrayList <Jugador>defensasRepe;
	 ArrayList <Jugador>mediosRepe;
	 ArrayList <Jugador>delanterosRepe;
	 ArrayList <Jugador>porterosRepe;
	 Jugador jugador;
	 Random  random;
	
	
	public VentanaUsuario()
	{
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaUsuario.class.getResource("/ud/prog3/Comunio/img/comunioIcono.jpg")));
		setResizable(false);
		getContentPane().setBackground(new Color(0, 128, 0));
		setBounds(400,300,500,400);
		setTitle("Sign Up - Comunio");
		getContentPane().setLayout(null);
		
		defensas=new ArrayList<Jugador>();
		medios=new ArrayList<Jugador>();
		delanteros=new ArrayList<Jugador>();
		porteros=new ArrayList<Jugador>();
		defensasRepe=new ArrayList<Jugador>();
		mediosRepe=new ArrayList<Jugador>();
		delanterosRepe=new ArrayList<Jugador>();
		porterosRepe=new ArrayList<Jugador>();
		
		todosJugadores=new ArrayList<Jugador>();
		jugador=new Jugador();
		
		
		JLabel lContraseña = new JLabel("inserte el id del usuario");
		lContraseña.setForeground(Color.WHITE);
		lContraseña.setBounds(10, 245, 128, 14);
		getContentPane().add(lContraseña);
		
		id = new JTextField();
		id.setBounds(169, 242, 86, 20);
		getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblInserteLaContrasea = new JLabel("inserte la contrase\u00F1a");
		lblInserteLaContrasea.setForeground(Color.WHITE);
		lblInserteLaContrasea.setBounds(10, 298, 128, 14);
		getContentPane().add(lblInserteLaContrasea);
		
		contraseña = new JPasswordField();
		contraseña.setBounds(169, 295, 86, 20);
		getContentPane().add(contraseña);
		contraseña.setColumns(10);
		
		btnAcceder = new JButton("ACCEDER");
		btnAcceder.setBounds(307, 264, 115, 23);
		getContentPane().add(btnAcceder);
		btnAcceder.addActionListener(this);
		btnAcceder.setActionCommand("acceder");
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(307, 200, 104, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("cancelar");
		
		lblLogInCon = new JLabel("LOG IN con tu cuenta");
		lblLogInCon.setForeground(Color.WHITE);
		lblLogInCon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogInCon.setBounds(35, 202, 204, 14);
		getContentPane().add(lblLogInCon);
		
		lblRegistrateYCrea = new JLabel("REGISTRATE y CREA UNA NUEVA CUENTA");
		lblRegistrateYCrea.setForeground(Color.WHITE);
		lblRegistrateYCrea.setBackground(Color.WHITE);
		lblRegistrateYCrea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRegistrateYCrea.setBounds(35, 32, 328, 14);
		getContentPane().add(lblRegistrateYCrea);
		
		nId = new JTextField();
		nId.setBounds(169, 68, 86, 20);
		getContentPane().add(nId);
		nId.setColumns(10);
		
		nContraseña = new JPasswordField();
		nContraseña.setBounds(169, 113, 86, 20);
		getContentPane().add(nContraseña);
		nContraseña.setColumns(10);
		
		lblqueIdQuieres = new JLabel("\u00BFQue id quieres tener?");
		lblqueIdQuieres.setForeground(Color.WHITE);
		lblqueIdQuieres.setBounds(10, 71, 149, 14);
		getContentPane().add(lblqueIdQuieres);
		
		lblyQueContrasea = new JLabel("\u00BFY que contrase\u00F1a?");
		lblyQueContrasea.setForeground(Color.WHITE);
		lblyQueContrasea.setBounds(10, 116, 140, 14);
		getContentPane().add(lblyQueContrasea);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(307, 83, 110, 23);
		getContentPane().add(btnRegistrar);
		btnRegistrar.addActionListener(this);
		btnRegistrar.setActionCommand("registrar");
		
		//BasesDeDatos.initBD("UsuariosBD");
		BasesDeDatos.crearTablaUsuarios();
		BasesDeDatos.crearTablaPorterosSalidos();
		BasesDeDatos.crearTablaMediosSalidos();
		BasesDeDatos.crearTablaDefensasSalidos();
		BasesDeDatos.crearTablaDelanterosSalidos();
	
		cargarJugadoresPosicion();
		
	}
	

	public void asignarjugadores(String ID) {
		Statement st=null;
		BasesDeDatos.crearTablaUsuarioJugadores();
		st=BasesDeDatos.getStatement();
		
		int posPortero;
		int posDefensa;
		int posMedio;
		int posDelantero;
		
		Random rnd=new Random();
		posPortero=rnd.nextInt(porteros.size()-1);
		
		do
		{
			posPortero=rnd.nextInt(porteros.size()-1);
		}while(chequearPortero(porteros.get(posPortero))==false);
		
		
		if(chequearPortero(porteros.get(posPortero))==true)
			{
				System.out.println("portero: "+porteros.get(posPortero).getNombre());
				
				String sentencia2="insert into usuarioJugadores values ('"+ID+"', '"+porteros.get(posPortero).getId()+"')";
				
				String sentencia="insert into porterosSalidos values"
						+ "('"+porteros.get(posPortero).getId()
						+"', '"+porteros.get(posPortero).getNombre()
						+"', '"+porteros.get(posPortero).getEquipo()
						+"', '"+porteros.get(posPortero).getPosicion()
						+"', '"+porteros.get(posPortero).getEdad()
						+"', '"+porteros.get(posPortero).getPuntosJornada()
						+"', '"+porteros.get(posPortero).getPuntosTotales()
						+"')";	
				System.out.println(sentencia);
				System.out.println(sentencia2);
				
				try {
					st.executeUpdate(sentencia);
					st.executeUpdate(sentencia2);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			
		
			
		
		
		for(int i=0;i<4;i++)
		{
			posMedio=rnd.nextInt(medios.size()-1);
			posDefensa=rnd.nextInt(defensas.size()-1);
			
			System.out.println("medios: "+medios.get(posMedio).getNombre());
			
			
			do{
				
				posMedio=rnd.nextInt(medios.size()-1);
				
			}while(chequearMedios(medios.get(posMedio))==false);
			
			if(chequearMedios(medios.get(posMedio))==true)
			{
				String sentencia="insert into mediosSalidos values"
						+ "('"+medios.get(posMedio).getId()
						+"', '"+medios.get(posMedio).getNombre()
						+"', '"+medios.get(posMedio).getEquipo()
						+"', '"+medios.get(posMedio).getPosicion()
						+"', '"+medios.get(posMedio).getEdad()
						+"', '"+medios.get(posMedio).getPuntosJornada()
						+"', '"+medios.get(posMedio).getPuntosTotales()
						+"')";	
				String sentencia2="insert into usuarioJugadores values ('"+ID+"', '"+medios.get(posMedio).getId()+"')";
				System.out.println(sentencia);
				System.out.println(sentencia2);
				
				try {
					st.executeUpdate(sentencia);
					st.executeUpdate(sentencia2);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
				
			
			
			
			System.out.println("defensas: "+defensas.get(posDefensa).getNombre());
			
			
			do{
			
				posDefensa=rnd.nextInt(defensas.size()-1);
			
			}while(chequearDefensas(defensas.get(posDefensa))==false);
			
			if(chequearDefensas(defensas.get(posDefensa))==true)
			{

				String sentencia="insert into defensasSalidos values"
						+ "('"+defensas.get(posDefensa).getId()
						+"', '"+defensas.get(posDefensa).getNombre()
						+"', '"+defensas.get(posDefensa).getEquipo()
						+"', '"+defensas.get(posDefensa).getPosicion()
						+"', '"+defensas.get(posDefensa).getEdad()
						+"', '"+defensas.get(posDefensa).getPuntosJornada()
						+"', '"+defensas.get(posDefensa).getPuntosTotales()
						+"')";	
				System.out.println(sentencia);
				String sentencia3="insert into usuarioJugadores values ('"+ID+"', '"+defensas.get(posDefensa).getId()+"')";
				System.out.println(sentencia3);
				
				try {
					st.executeUpdate(sentencia);
					st.executeUpdate(sentencia3);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		for(int i=0;i<2;i++)
		{
			posDelantero=rnd.nextInt(delanteros.size()-1);
			System.out.println("delanteros: "+delanteros.get(posDelantero).getNombre());
			
			do
			{
				posDelantero=rnd.nextInt(delanteros.size()-1);
			}while(chequearDelantero(delanteros.get(posDelantero))==false);
			
		
			
			if(chequearDelantero(delanteros.get(posDelantero))==true)
			{

				String sentencia="insert into delanterosSalidos values"
						+ "('"+delanteros.get(posDelantero).getId()
						+"', '"+delanteros.get(posDelantero).getNombre()
						+"', '"+delanteros.get(posDelantero).getEquipo()
						+"', '"+delanteros.get(posDelantero).getPosicion()
						+"', '"+delanteros.get(posDelantero).getEdad()
						+"', '"+delanteros.get(posDelantero).getPuntosJornada()
						+"', '"+delanteros.get(posDelantero).getPuntosTotales()
						+"')";	
				System.out.println(sentencia);
				String sentencia2="insert into usuarioJugadores values ('"+ID+"', '"+delanteros.get(posDelantero).getId()+"')";
				try {
					st.executeUpdate(sentencia);
					st.executeUpdate(sentencia2);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			}
					
		}
		
			
		
		
		
		
		
		
		
		
	private boolean chequearDelantero(Jugador jugador2)
	{
		st=BasesDeDatos.getStatement();
		String sentencia="select * from delanterosSalidos";
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			if(rs.first()==false)
			{
				return true;
			}
			else
			{
				while(rs.next())
					{
				jugador=new Jugador();
				
				jugador.setId(rs.getString("id"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setEquipo(rs.getString("equipo"));
				jugador.setPosicion(rs.getString("posicion"));
				jugador.setEdad(rs.getInt("edad"));
				jugador.setPuntosJornada(rs.getInt("puntosJornada"));
				jugador.setPuntosTotales(rs.getInt("puntosTotales"));
				
				delanterosRepe.add(jugador);
					
			} 
			}
		}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				for(int i=0;i<delanterosRepe.size();i++)
				{
					if(jugador2.getId().equalsIgnoreCase(delanterosRepe.get(i).getId()))
					{
				
						return false;
						
					}
				}
				
				
			
			
			return true;
		
		




	}


	private boolean chequearDefensas(Jugador jugador2)
	{
		
		st=BasesDeDatos.getStatement();
		String sentencia="select * from defensasSalidos";
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			if(rs.isFirst()==false)
			{
				return true;
			}
			else
			{
				while(rs.next())
					{
				jugador=new Jugador();
				
				jugador.setId(rs.getString("id"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setEquipo(rs.getString("equipo"));
				jugador.setPosicion(rs.getString("posicion"));
				jugador.setEdad(rs.getInt("edad"));
				jugador.setPuntosJornada(rs.getInt("puntosJornada"));
				jugador.setPuntosTotales(rs.getInt("puntosTotales"));
				
				defensasRepe.add(jugador);
					
			} 
			}
		}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				for(int i=0;i<defensasRepe.size();i++)
				{
					if(jugador2.getId().equalsIgnoreCase(defensasRepe.get(i).getId()))
					{
				
						return false;
						
					}
				}
				
				
			
			
			return true;
		
		




	}


	private boolean chequearMedios(Jugador jugador2)
	{

		st=BasesDeDatos.getStatement();
		String sentencia="select * from mediosSalidos";
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			if(rs.isFirst()==false)
			{
				return true;
			}
			else
			{
				while(rs.next())
					{
				jugador=new Jugador();
				
				jugador.setId(rs.getString("id"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setEquipo(rs.getString("equipo"));
				jugador.setPosicion(rs.getString("posicion"));
				jugador.setEdad(rs.getInt("edad"));
				jugador.setPuntosJornada(rs.getInt("puntosJornada"));
				jugador.setPuntosTotales(rs.getInt("puntosTotales"));
				
				mediosRepe.add(jugador);
					
			} 
			}
		}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				for(int i=0;i<mediosRepe.size();i++)
				{
					if(jugador2.getId().equalsIgnoreCase(mediosRepe.get(i).getId()))
					{
				
						return false;
						
					}
				}
				
				
			
			
			return true;
		
		






	}

	private boolean chequearPortero(Jugador jugador2) {
		
		
		st=BasesDeDatos.getStatement();
		String sentencia="select * from porterosSalidos";
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			if(rs.isFirst()==false)
			{
				return true;
			}
			else
			{
				while(rs.next())
					{
				jugador=new Jugador();
				
				jugador.setId(rs.getString("id"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setEquipo(rs.getString("equipo"));
				jugador.setPosicion(rs.getString("posicion"));
				jugador.setEdad(rs.getInt("edad"));
				jugador.setPuntosJornada(rs.getInt("puntosJornada"));
				jugador.setPuntosTotales(rs.getInt("puntosTotales"));
				
				porterosRepe.add(jugador);
					
			} 
			}
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				for(int i=0;i<porterosRepe.size();i++)
				{
					if(jugador2.getId().equalsIgnoreCase(porterosRepe.get(i).getId()))
					{
				
						return false;
						
					}
				}
				
				
			
			
			return true;
		
		
	}
	


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
		st=BasesDeDatos.getStatement();
		switch(e.getActionCommand())
		{
		case "acceder":
			
			
			
			if((chequearEnTabla(st))==true)
			{
				JOptionPane.showMessageDialog(null, "el usuario que ha introducido es correcto");
				
				VentanaJuegoUsuario VJU=new VentanaJuegoUsuario(id.getText());
				VJU.setVisible(true);
				dispose();
				break;
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "el usuario que ha introducido no es correcto");
				break;
			}
			
			
		case "cancelar":
			
			id.setText("");
			contraseña.setText("");
			nId.setText("");
			nContraseña.setText("");
			
			
			break;
			
		case "registrar":
			
			if(insertarNumIdentificador()==6)
			{
				JOptionPane.showMessageDialog(null, "Cantidad de usuarios de la comunidad alcanzada. El Máximo son 5 usuarios por liga");
				break;
			}
			if(nId.getText().isEmpty()==true&&nContraseña.getText().isEmpty()==true)
			{
				JOptionPane.showMessageDialog(this, "Por favor, introduzca valores para poder registrarte");
				break;
			}
			
			
			
			if (chequearYaEnTabla(st)) {  // Si está ya en la tabla
				JOptionPane.showMessageDialog(null, "Ya existe ese usuario en la base de datos");
				break;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
				
			
			try {
				String sentSQL = "insert into usuarios values(" +
						"'" + insertarNumIdentificador() + "', " +
						"'" + nId.getText() + "', " +
						"'" + nContraseña.getText() + "', "+ 
						"'" + 20000000 +"')";
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				int val = st.executeUpdate( sentSQL );
				
				asignarjugadores(nId.getText());
				System.out.println("perfectamente guardado");
//				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
//				return true;
			} catch (SQLException e1) {
				e1.printStackTrace();
//				return false;
			}
			
			}
			
			
			break;
		
		}
		
		
	}
	
	private int insertarNumIdentificador() 
	{
		Usuarios=new ArrayList();
		
		st=BasesDeDatos.getStatement();
		
		String sentencia="select * from usuarios";
		
		ResultSet rs;
		try {
			rs = st.executeQuery(sentencia);
			
			while(rs.next())
			{
				Usuarios.add(rs.getString("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return Usuarios.size()+1;
	}

	public boolean chequearYaEnTabla( Statement st ) {
		try {
			String sentSQL = "select * from usuarios " +
					"where (id = '" + nId.getText() + "' and contraseña = '"+nContraseña.getText()+"')";
			System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
			ResultSet rs = st.executeQuery( sentSQL );//resultado para la gestion de las bases de datos
			if (rs.next()) {  // Normalmente se recorre con un while, pero aquí solo hay que ver si ya existe
				rs.close();
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
		
//		ArrayList<Integer> taken=new ArrayList<Integer>();
//		ResultSet nombre=st.executeQuery("select idJugador from UsuarioJugadores");
//		ResultSetMetaData rsmd = nombre.getMetaData();
//		int columnCount = rsmd.getColumnCount();
//		while(nombre.next())
//		{
//			nombre1=nombre.getInt(columnCount);
//			taken.add(nombre1);
//		}
//	
//		System.out.println(taken);
		
//		int i=0;
//		Random random=new Random();
//		int a = (int)Math.random()*74;
//		int a=1+random.nextInt(73);
//		for(;i<taken.size();i++){
//			if(a==taken.get(i)){
//				
//				a=(int)Math.random()*74;
//				i=0;
//				
//			}
//			
//		}
//		taken.add(a);
//		ResultSet id=st.executeQuery("select idJugador from usuariojugadores" +" where (id='"+a+"and posicion=Portero')" );
//		ResultSetMetaData rsmd2 = id.getMetaData();
//		int columnCount2 = rsmd2.getColumnCount();
//		while(nombre.next())
//		{
//			id1=id.getInt(columnCount2);
//		}

		
		public  void cargarJugadoresPosicion() 
		{
		st=BasesDeDatos.getStatement();
		String sentencia="select * from jugadores";
		todosJugadores=new ArrayList<Jugador>();
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			
			while(rs.next())
			{
				jugador=new Jugador();
				
				jugador.setId(rs.getString("id"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setEquipo(rs.getString("equipo"));
				jugador.setPosicion(rs.getString("posicion"));
				jugador.setEdad(rs.getInt("edad"));
				jugador.setPuntosJornada(rs.getInt("puntosJornada"));
				jugador.setPuntosTotales(rs.getInt("puntosTotales"));
				
				todosJugadores.add(jugador);
				
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i=0;i<todosJugadores.size();i++)
		{
			if(todosJugadores.get(i).getPosicion().equalsIgnoreCase("Defensa"))
			{
				defensas.add(todosJugadores.get(i));
			}
			else
			{
				if(todosJugadores.get(i).getPosicion().equalsIgnoreCase("Delantero"))
				{
					delanteros.add(todosJugadores.get(i));
				}
				else
				{
					if(todosJugadores.get(i).getPosicion().equalsIgnoreCase("Centrocampista"))
					{
						medios.add(todosJugadores.get(i));
					}
					else
					{
						porteros.add(todosJugadores.get(i));
					}
				}
				System.out.println(todosJugadores.get(i).getPosicion());
			}
		}
		
		
	}

		/**

	for(int u=0;u<2;u++){
		String sentSQL="insert into usuariojugadores values(" +"'"+ID+"', '"+verificarrandomportero()+"')";
		 try {
			 
			 
			st.executeUpdate( sentSQL );
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 System.out.println(sentSQL);
	}
	
	for(int e=0;e<4;e++){
		
		String sentSQL="insert into usuariojugadores values(" +"'"+ID+"', '"+verificarrandomdefensa()+"')";
		 try {
			 
			 
			st.executeUpdate( sentSQL );
			 
		} catch (SQLException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}
		
		 System.out.println(sentSQL);
	}
	for(int v=0;v<4;v++){
		String sentSQL="insert into usuariojugadores values(" +"'"+ID+"', '"+verificarrandommedio()+"')";
		 try {
			 
			 
			st.executeUpdate( sentSQL );
			 
		} catch (SQLException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}
		
		 System.out.println(sentSQL);
	}
	for(int j=0;j<2;j++){
		String sentSQL="insert into usuariojugadores values(" +"'"+ID+"', '"+verificarrandomataque()+"')";
		 try {
			 
			 
			st.executeUpdate( sentSQL );
			 
		} catch (SQLException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}
		
		 System.out.println(sentSQL);
		
	}
	}
	
	
//	
//	ResultSet nombre=st.executeQuery("select nombre from jugadores" +" where (id='"+a+"')" );
//	ResultSetMetaData rsmd = nombre.getMetaData();
//	int columnCount = rsmd.getColumnCount();
//	while(nombre.next())
//	{
//		nombre1=nombre.getString(columnCount);
//	}
//	ResultSet equipo=st.executeQuery("select equipo from jugadores" +" where (id='"+a+"')" );
//	ResultSetMetaData rsmd1 = equipo.getMetaData();
//	int columnCount1 = rsmd1.getColumnCount();
//	while(equipo.next())
//	{
//		equipo1=equipo.getString(columnCount1);
//	}
	public static int verificarrandomportero() throws SQLException{
		Statement st=null;
		st=BasesDeDatos.getStatement();
		int nombre1=0;
		String nombre2="";
		
		
		ArrayList<Integer> taken=new ArrayList<Integer>();//contiene id de los jugadores que ya estan asignados
		ResultSet nombre=st.executeQuery("select idJugador from UsuarioJugadores");
		ResultSetMetaData rsmd = nombre.getMetaData();
		int columnCount = rsmd.getColumnCount();
		while(nombre.next())
		{
			nombre1=nombre.getInt(columnCount);
			taken.add(nombre1);
		}
		System.out.println("taken:"+taken);
		ArrayList<String> taken2=new ArrayList<String>();
		ArrayList<Integer>taken3=new ArrayList<Integer>();//contiene id de jugdaroes cuya posicion sea portero
		ResultSet nomb=st.executeQuery("select id from jugadores where posicion='Portero'");
		ResultSetMetaData rsmd2 = nombre.getMetaData();
		int columnCount2 = rsmd2.getColumnCount();
		while(nombre.next())
		{
			nombre2=nomb.getString(columnCount2);
			taken2.add(nombre2);
		}
		System.out.println("taken2:"+taken2);
		System.out.println("taken:"+taken);
		for(int o=0;o<taken2.size();o++){
			int y=Integer.parseInt(taken2.get(o));
//			int y=Integer.valueOf(s)
			taken3.add(y);
		}
		System.out.println("taken3:"+taken3);
		 Random random=new Random();
	
		int a = 0;
		int c=0;
		int s=0;
		
		
		for (;s<taken.size();s++){
//			
			a=taken3.get(c);
			
				 if(taken.get(s)==a){
					 c++;
					 s=0;
					 
				 }
//			 } 
		}
		
		
		
//		 taken2.get(a);
//		for(;i<taken.size();i++){
//			if(taken3.get(a)==taken.get(i)){
//				ResultSet nombre=st.executeQuery("select idJugador from Jugadores where posicion=portero ");
//				a=1+random.nextInt(73);
//				i=0;
				
//			}
			
//		}
		taken.add(a);
		
		
		
		return a;
		
		
		
	}
	public static int verificarrandomdefensa() throws SQLException{
		Statement st=null;
		st=BasesDeDatos.getStatement();
		int nombre1=0;
		String nombre2="";
		
		
		ArrayList<Integer> taken=new ArrayList<Integer>();//contiene id de los jugadores que ya estan asignados
		ResultSet nombre=st.executeQuery("select idJugador from UsuarioJugadores");
		ResultSetMetaData rsmd = nombre.getMetaData();
		int columnCount = rsmd.getColumnCount();
		while(nombre.next())
		{
			nombre1=nombre.getInt(columnCount);
			taken.add(nombre1);
		}
		System.out.println("taken:"+taken);
		ArrayList<String> taken2=new ArrayList<String>();
		ArrayList<Integer>taken3=new ArrayList<Integer>();//contiene id de jugdaroes cuya posicion sea portero
		ResultSet nomb=st.executeQuery("select id from jugadores where posicion='Defensa'");
		ResultSetMetaData rsmd2 = nombre.getMetaData();
		int columnCount2 = rsmd2.getColumnCount();
		while(nombre.next())
		{
			nombre2=nomb.getString(columnCount2);
			taken2.add(nombre2);
		}
		System.out.println("taken2:"+taken2);
		System.out.println("taken:"+taken);
		for(int o=0;o<taken2.size();o++){
			int y=Integer.parseInt(taken2.get(o));
//			int y=Integer.valueOf(s)
			taken3.add(y);
		}
		System.out.println("taken3:"+taken3);
		Random random=new Random();
	
		int a = 0;
		int c=0;
		int s=0;
		
		
		for (;s<taken.size();s++){
//			
			a=taken3.get(c);
			
				 if(taken.get(s)==a){
					 c++;
					 s=0;
					 
				 }
//			 } 
		}
		
		
		
//		 taken2.get(a);
//		for(;i<taken.size();i++){
//			if(taken3.get(a)==taken.get(i)){
//				ResultSet nombre=st.executeQuery("select idJugador from Jugadores where posicion=portero ");
//				a=1+random.nextInt(73);
//				i=0;
				
//			}
			
//		}
		taken.add(a);
		
		
		
		return a;
		
		
		
		
		
	}
	public static int verificarrandommedio() throws SQLException{
		Statement st=null;
		st=BasesDeDatos.getStatement();
		int nombre1=0;
		String nombre2="";
		
		
		ArrayList<Integer> taken=new ArrayList<Integer>();//contiene id de los jugadores que ya estan asignados
		ResultSet nombre=st.executeQuery("select idJugador from UsuarioJugadores");
		ResultSetMetaData rsmd = nombre.getMetaData();
		int columnCount = rsmd.getColumnCount();
		while(nombre.next())
		{
			nombre1=nombre.getInt(columnCount);
			taken.add(nombre1);
		}
		System.out.println("taken:"+taken);
		ArrayList<String> taken2=new ArrayList<String>();
		ArrayList<Integer>taken3=new ArrayList<Integer>();//contiene id de jugdaroes cuya posicion sea portero
		ResultSet nomb=st.executeQuery("select id from jugadores where posicion='Centrocampista'");
		ResultSetMetaData rsmd2 = nombre.getMetaData();
		int columnCount2 = rsmd2.getColumnCount();
		while(nombre.next())
		{
			nombre2=nomb.getString(columnCount2);
			taken2.add(nombre2);
		}
		System.out.println("taken2:"+taken2);
		System.out.println("taken:"+taken);
		for(int o=0;o<taken2.size();o++){
			int y=Integer.parseInt(taken2.get(o));
//			int y=Integer.valueOf(s)
			taken3.add(y);
		}
		System.out.println("taken3:"+taken3);
		Random random=new Random();
	
		int a = 0;
		int c=0;
		int s=0;
		
		
		for (;s<taken.size();s++){
//			
			a=taken3.get(c);
			
				 if(taken.get(s)==a){
					 c++;
					 s=0;
					 
				 }
//			 } 
		}
		
		
		
//		 taken2.get(a);
//		for(;i<taken.size();i++){
//			if(taken3.get(a)==taken.get(i)){
//				ResultSet nombre=st.executeQuery("select idJugador from Jugadores where posicion=portero ");
//				a=1+random.nextInt(73);
//				i=0;
				
//			}
			
//		}
		taken.add(a);
		
		
		
		return a;
	}
	public static int verificarrandomataque() throws SQLException{
		Statement st=null;
		st=BasesDeDatos.getStatement();
		int nombre1=0;
		String nombre2="";
		
		
		ArrayList<Integer> taken=new ArrayList<Integer>();//contiene id de los jugadores que ya estan asignados
		ResultSet nombre=st.executeQuery("select idJugador from UsuarioJugadores");
		ResultSetMetaData rsmd = nombre.getMetaData();
		int columnCount = rsmd.getColumnCount();
		while(nombre.next())
		{
			nombre1=nombre.getInt(columnCount);
			taken.add(nombre1);
		}
		System.out.println("taken:"+taken);
		ArrayList<String> taken2=new ArrayList<String>();
		ArrayList<Integer>taken3=new ArrayList<Integer>();//contiene id de jugdaroes cuya posicion sea portero
		ResultSet nomb=st.executeQuery("select id from jugadores where posicion='Delantero'");
		ResultSetMetaData rsmd2 = nombre.getMetaData();
		int columnCount2 = rsmd2.getColumnCount();
		while(nombre.next())
		{
			nombre2=nomb.getString(columnCount2);
			taken2.add(nombre2);
		}
		System.out.println("taken2:"+taken2);
		System.out.println("taken:"+taken);
		for(int o=0;o<taken2.size();o++){
			int y=Integer.parseInt(taken2.get(o));
//			int y=Integer.valueOf(s)
			taken3.add(y);
		}
		System.out.println("taken3:"+taken3);
		Random random=new Random();
	
		int a = 0;
		int c=0;
		int s=0;
		
		
		for (;s<taken.size();s++){
//			
			a=taken3.get(c);
			
				 if(taken.get(s)==a){
					 c++;
					 s=0;
					 
				 }
//			 } 
		}
		
		
		
//		 taken2.get(a);
//		for(;i<taken.size();i++){
//			if(taken3.get(a)==taken.get(i)){
//				ResultSet nombre=st.executeQuery("select idJugador from Jugadores where posicion=portero ");
//				a=1+random.nextInt(73);
//				i=0;
				
//			}
			
//		}
		taken.add(a);
		
		
		
		return a;
	}
	**/
	public static void asignarportero(){
		
		
		
	}
	
	public boolean chequearEnTabla( Statement st ) {
		try {
			String sentSQL = "select * from usuarios " +
					"where (id = '" + id.getText() + "'and contraseña = '"+contraseña.getText()+"')";
			System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
			ResultSet rs = st.executeQuery( sentSQL );//resultado para la gestion de las bases de datos
			if (rs.next()) {  // Normalmente se recorre con un while, pero aquí solo hay que ver si ya existe
				rs.close();
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean modificarFilaEnTabla( Statement st ) {
//		try {
//			String sentSQL = "update usuarios set " +
//					"error = '" + erroneo + "', " +
//					"titulo = '" + titulo + "', " +
//					"cantante = '" + cantante + "', " +
//					"comentarios = '" + comentarios + "' " +
//					"where (fichero = '" + file.getAbsolutePath() + "')";
//			System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
//			int val = st.executeUpdate( sentSQL );
//			if (val!=1) return false;  // Se tiene que modificar 1, error si no
//			return true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
		return false;
	
}
	public String idusuario(){
		String a=id.getText();
		return a;
		
	}
	
	
}
