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
	
	private JPasswordField contraseña;
	private JButton btnAcceder;
	private JButton btnCancelar;
	private JLabel lblLogInCon;
	private JLabel lblRegistrateYCrea;
	private JTextField nId;
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
		lContraseña.setBounds(10, 245, 167, 14);
		getContentPane().add(lContraseña);
		
		id = new JTextField();
		id.setBounds(187, 242, 86, 20);
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
		btnAcceder.setBounds(307, 264, 128, 23);
		getContentPane().add(btnAcceder);
		btnAcceder.addActionListener(this);
		btnAcceder.setActionCommand("acceder");
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(307, 200, 128, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("cancelar");
		
		lblLogInCon = new JLabel("LOG IN con tu cuenta");
		lblLogInCon.setForeground(Color.WHITE);
		lblLogInCon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogInCon.setBounds(35, 202, 238, 14);
		getContentPane().add(lblLogInCon);
		
		lblRegistrateYCrea = new JLabel("REGISTRATE y CREA UNA NUEVA CUENTA");
		lblRegistrateYCrea.setForeground(Color.WHITE);
		lblRegistrateYCrea.setBackground(Color.WHITE);
		lblRegistrateYCrea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRegistrateYCrea.setBounds(35, 32, 361, 14);
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
	
/**
 * al registrarnos,se nos asignarán 11 jugadores al azar. 4 defensas, 4 medios, 2 delanteros y 1 portero
 * @param ID: id del usuario que se ha registrado
 */
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
		
			
		
		
		
		
		
		
		
		/**
		 * este y los demas metodos siguientes nos servirán para para chequear que no haya jugadores repetidos
		 * @param jugador2: jugador a buscar para comprobar si es repetido
		 * @return true:cuando no este en la lista
		 */
	private boolean chequearDelantero(Jugador jugador2)
	{
		st=BasesDeDatos.getStatement();
		String sentencia="select * from delanterosSalidos";
		delanterosRepe.clear();
		
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
		defensasRepe.clear();
		
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
		mediosRepe.clear();
		
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
		porterosRepe.clear();
		
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
	/**
	 * este metodo sirve para generar un numero para identificar al usuario
	 * @return
	 */
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
/**
 * En el caso de que el usuario ya exista, no permite que se cree uno igual
 * @param st
 * @return 
 */
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

		return false;
	
}
	public String idusuario(){
		String a=id.getText();
		return a;
		
	}
	
	
}
