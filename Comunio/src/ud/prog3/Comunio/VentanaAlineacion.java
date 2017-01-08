package ud.prog3.Comunio;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import java.awt.Color;

import javax.swing.JTabbedPane;

import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Toolkit;

public class VentanaAlineacion extends JFrame {
	VentanaAlineacion alineacion;
	JLabel lblAlineacion;
	JComboBox<String> EI;
	ImageIcon icono;
	ImageIcon fot; 
	JButton bañadir;
	JList <DefaultListModel>lista ;
	DefaultListModel modelo;
	static String idjornada;
	static String puntosjornada2;
	Statement st=null;
	ArrayList<Jugador>listaJugadores;
	ArrayList<UsuarioJugador>listaUsuarios;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaAlineacion frame = new VentanaAlineacion();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param b 
	 * @throws SQLException 
	 */
	public VentanaAlineacion(String b)  {
		getContentPane().setBackground(new Color(0, 128, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAlineacion.class.getResource("/ud/prog3/Comunio/img/comunioIcono.jpg")));
		idjornada=b;
		final ArrayList<String>nombrejugadores=new ArrayList<String>();
		String idactual=b;
//		addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				icono = new ImageIcon( 
//						fot.getImage( ).getScaledInstance( 
//								lblAlineacion.getWidth(), lblAlineacion.getHeight(), Image.SCALE_DEFAULT ) ); 
//				lblAlineacion.setIcon(icono);
//			}
//		});

		listaJugadores=new ArrayList<Jugador>();
		listaUsuarios=new ArrayList<UsuarioJugador>();
		
		JLabel campo=new JLabel();
		
		setTitle("Alineaci\u00F3n");
		setBounds(100, 100, 623, 513);
		getContentPane().setLayout(null);
		
		
		JLabel lblSistemaDeJuego = new JLabel("ESTE ES TU EQUIPO ACTUAL");
		lblSistemaDeJuego.setForeground(new Color(255, 255, 255));
		lblSistemaDeJuego.setBounds(35, 36, 224, 20);
		getContentPane().add(lblSistemaDeJuego);
		
		
		
		
		 fot = new ImageIcon(VentanaAlineacion.class.getResource("/ud/prog3/Comunio/img/Alineacion.jpeg"));
		this.repaint();
		

		
		lblAlineacion = new JLabel("");
		
		lblAlineacion.setBackground(Color.WHITE);
		lblAlineacion.setBounds(35, 81, 373, 392);
		getContentPane().add(lblAlineacion);
		 icono = new ImageIcon(fot.getImage().getScaledInstance(lblAlineacion.getWidth(), lblAlineacion.getHeight(), Image.SCALE_DEFAULT));
		lblAlineacion.setIcon(icono);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(431, 74, 166, 431);
		getContentPane().add(scrollPane);
		
	
		lblAlineacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				int i=0;

				
				
//				if(LI.getSelectedItem()==nombrejugadores.get(2) || DFCD.getSelectedItem()==nombrejugadores.get(2) ||  LD.getSelectedItem()==nombrejugadores.get(2)){
//					DFCI.removeItem(nombrejugadores.get(2));
//					
//				}
//				else{
//					DFCI.addItem(nombrejugadores.get(2));
//				}
//				if(LI.getSelectedItem()==nombrejugadores.get(3) || DFCD.getSelectedItem()==nombrejugadores.get(3) ||  LD.getSelectedItem()==nombrejugadores.get(3)){
//					DFCI.removeItem(nombrejugadores.get(3));
//					
//				}
//				else{
//					DFCI.addItem(nombrejugadores.get(3));
//				}
//				if(LI.getSelectedItem()==nombrejugadores.get(4) || DFCD.getSelectedItem()==nombrejugadores.get(4) ||  LD.getSelectedItem()==nombrejugadores.get(4)){
//					DFCI.removeItem(nombrejugadores.get(4));
//					
//				}
//				else{
//					DFCI.addItem(nombrejugadores.get(4));
//				}
//				if(LI.getSelectedItem()==nombrejugadores.get(5) || DFCD.getSelectedItem()==nombrejugadores.get(5) ||  LD.getSelectedItem()==nombrejugadores.get(5)){
//					DFCI.removeItem(nombrejugadores.get(5));
//					
//				}
//				else{
//					
//					DFCI.addItem(nombrejugadores.get(5));
//			
//				}
			}
			
			
		});
		
		
//		DFCI.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				if(LI.getSelectedItem()==nombrejugadores.get(2) || DFCD.getSelectedItem()==nombrejugadores.get(2) ||  LD.getSelectedItem()==nombrejugadores.get(2)){
//					DFCI.removeItem(nombrejugadores.get(2));
//					
//				}
//				else{
//					if(DFCI.getSelectedItem()==nombrejugadores.get(2)){
//						
//					}else{
//					
//					DFCI.addItem(nombrejugadores.get(2));
//					}
//				}
//			}
//		});
		
		lista = new JList<DefaultListModel>();
		
		modelo=new DefaultListModel();
		lista.setModel(modelo);
		
		scrollPane.setViewportView(lista);
		
	
		
		Statement st=null;
		st=BasesDeDatos.getStatement();
		String jugadores="";
		String jugadores2="";
		String jugadores3="";
		String jugadores4="";
		
		cargarJugadoresEnLista(b);
		
//		ArrayList<String>idusuario=new ArrayList<String>();
//
//		 
//		try {
//			ResultSet	rs4 = st.executeQuery("select idUsuario from usuariojugadores");
//			ResultSetMetaData rsmd4 = rs4.getMetaData();
//			int columnCount4 = rsmd4.getColumnCount();
//			
//			while(rs4.next()){
//				
//				
//				jugadores4=rs4.getString(columnCount4);
//				idusuario.add(jugadores4);
//				
//				
//				
//				
//			}
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		ArrayList<String>idJugador=new ArrayList<String>();
//
//		 
//		try {
//			ResultSet	rs = st.executeQuery("select idJugador from usuariojugadores");
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int columnCount = rsmd.getColumnCount();
//			
//			while(rs.next()){
//				
//				
//				jugadores=rs.getString(columnCount);
//				idJugador.add(jugadores);
//				
//				
//				
//				
//			}
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println("idjugadores:"+idJugador);
//		ArrayList<String>idtodojugadores=new ArrayList<String>();
//		try {
//			ResultSet	rs2 = st.executeQuery("select id from jugadores");
//			ResultSetMetaData rsmd2 = rs2.getMetaData();
//			int columnCount2 = rsmd2.getColumnCount();
//			
//			while(rs2.next()){
//			
//			
//				jugadores2=rs2.getString(columnCount2);
//				idtodojugadores.add(jugadores2);
//				
//				
//				
//			}
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println("idtodojugadores:"+idtodojugadores);
//		
//		
//
//
//		ArrayList<String>nombre=new ArrayList<String>();
//		
//	
//		VentanaUsuario usuario=new VentanaUsuario();
//
//for(int z=0;z<idusuario.size();z++){	
//	if(idusuario.get(z).equals(idactual)){
//		
//			
////			for(int s=0;s<idJugador.size();s++){
//		
//
//		
//				try {
//					ResultSet	rs3 = st.executeQuery("select nombre from jugadores where id='"+idJugador.get(z)+"'");
//					ResultSetMetaData rsmd3 = rs3.getMetaData();
//					int columnCount3 = rsmd3.getColumnCount();
//					
//					
//					
//					
//						jugadores3=rs3.getString(columnCount3);
//						nombrejugadores.add(jugadores3);
//						modelo.addElement(jugadores3);
//						
////						modelo.addElement(nombre);
//						
//					
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//	
//				}
//			
//				
//				
//				
//			
////			}
//		
//	}
//	
//}
//final ArrayList <Integer>id=new ArrayList<Integer>();
//for(int z=0;z<idusuario.size();z++){	
//	int jugadores5=0;
//	if(idusuario.get(z).equals(idactual)){
//		
//			
////			for(int s=0;s<idJugador.size();s++){
//		
//
//		
//				try {
//					ResultSet	rs3 = st.executeQuery("select id from jugadores where id='"+idJugador.get(z)+"'");
//					ResultSetMetaData rsmd3 = rs3.getMetaData();
//					int columnCount3 = rsmd3.getColumnCount();
//					
//					
//					
//					
//						jugadores5=rs3.getInt(columnCount3);
//						id.add(jugadores5);
//						
////						modelo.addElement(nombre);
//						
//					
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//	
//				}
//			
//				
//				
//				
//			
////			}
//		
//	}
//	
//}
		/**
	
	btnGuardarAlineacion.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			if(jugadoresrepetidosenalineacion()==true){
				JOptionPane.showMessageDialog(null, "Atención!! algunos jugadores estan repetidos");
		
			}
			else{
				
			}
			
			
		}
		
		@Override
		
		public void mouseClicked(MouseEvent arg0) {
			int puntos=0;
			int resultado=0;
			int puntosjornada = 0;
			Statement st=null;
			st=BasesDeDatos.getStatement();
			try {
				for(int i=0;i<id.size();i++){
				ResultSet	rs4 = st.executeQuery("select PuntosJornada1 from puntosJornada where idJugador='"+id.get(i)+"'");
				ResultSetMetaData rsmd4 = rs4.getMetaData();
				int columnCount4 = rsmd4.getColumnCount();
				
				while(rs4.next()){
					
					
					puntos=rs4.getInt(columnCount4);
					System.out.println("puntos:"+ puntos);
					
					puntosjornada=puntosjornada+puntos;
					
					
					
					
					
				}
				}
				System.out.println("puntos jornada:"+puntosjornada);
				puntosjornada2=String.valueOf(puntosjornada);
			
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
	});

		
//		System.out.println("nombre jugadores:"+nombrejugadores);
//for(int a=0;a<nombrejugadores.size();a++){
//	modelo.addElement(nombrejugadores);
//}

	
	Portero.addItem(nombrejugadores.get(0));
	Portero.addItem(nombrejugadores.get(1));
	
	LI.addItem(nombrejugadores.get(2));
	LI.addItem(nombrejugadores.get(3));
	LI.addItem(nombrejugadores.get(4));
	LI.addItem(nombrejugadores.get(5));
	
	DFCI.addItem(nombrejugadores.get(5));
	DFCI.addItem(nombrejugadores.get(4));
	DFCI.addItem(nombrejugadores.get(2));
	DFCI.addItem(nombrejugadores.get(2));
	
	DFCD.addItem(nombrejugadores.get(3));
	DFCD.addItem(nombrejugadores.get(2));
	DFCD.addItem(nombrejugadores.get(4));
	DFCD.addItem(nombrejugadores.get(5));
	
	LD.addItem(nombrejugadores.get(4));
	LD.addItem(nombrejugadores.get(3));
	LD.addItem(nombrejugadores.get(2));
	LD.addItem(nombrejugadores.get(5));
	
	MI.addItem(nombrejugadores.get(6));
	MI.addItem(nombrejugadores.get(7));
	MI.addItem(nombrejugadores.get(8));
	MI.addItem(nombrejugadores.get(9));
	
	MCI.addItem(nombrejugadores.get(7));
	MCI.addItem(nombrejugadores.get(6));
	MCI.addItem(nombrejugadores.get(8));
	MCI.addItem(nombrejugadores.get(9));
	
	MCD.addItem(nombrejugadores.get(8));
	MCD.addItem(nombrejugadores.get(7));
	MCD.addItem(nombrejugadores.get(6));
	MCD.addItem(nombrejugadores.get(9));
	
	MD.addItem(nombrejugadores.get(9));
	MD.addItem(nombrejugadores.get(7));
	MD.addItem(nombrejugadores.get(8));
	MD.addItem(nombrejugadores.get(6));
	
	DI.addItem(nombrejugadores.get(10));
	DCD.addItem(nombrejugadores.get(11));
	
	


	}
	
	public boolean jugadoresrepetidosenalineacion(){
		boolean repetido=false;
		if(LI.getSelectedItem()==DFCI.getSelectedItem() || LI.getSelectedItem()==DFCD.getSelectedItem() || LI.getSelectedItem()==LD.getSelectedItem()){
		
			repetido=true;
		}
		if(DFCI.getSelectedItem()==LI.getSelectedItem() || DFCI.getSelectedItem()==DFCD.getSelectedItem() ||DFCI.getSelectedItem()==LD.getSelectedItem()){
			repetido=true;
		}
		if(DFCD.getSelectedItem()==LI.getSelectedItem() ||DFCD.getSelectedItem()==DFCI.getSelectedItem()||DFCD.getSelectedItem()==LD.getSelectedItem()){
			repetido=true;
		}
		if(LD.getSelectedItem()==LI.getSelectedItem() ||LD.getSelectedItem()==DFCI.getSelectedItem()||LD.getSelectedItem()==DFCD.getSelectedItem()){
			repetido=true;
		}
		
		
		if(MI.getSelectedItem()==MD.getSelectedItem() ||MD.getSelectedItem()==MCI.getSelectedItem()||MD.getSelectedItem()==MCD.getSelectedItem()){
			repetido=true;
		}
		if(MD.getSelectedItem()==MI.getSelectedItem() ||MD.getSelectedItem()==MCI.getSelectedItem()||MD.getSelectedItem()==MCD.getSelectedItem()){
			repetido=true;
		}
		if(MCI.getSelectedItem()==MD.getSelectedItem() ||MCI.getSelectedItem()==MCD.getSelectedItem()||MCI.getSelectedItem()==MI.getSelectedItem()){
			repetido=true;
		}
		if(MCD.getSelectedItem()==MI.getSelectedItem() ||MCD.getSelectedItem()==MCI.getSelectedItem()||MCD.getSelectedItem()==MD.getSelectedItem()){
			repetido=true;
		}
	
		
		if(DI.getSelectedItem()==DCD.getSelectedItem()){
			repetido=true;
		}
		if(DCD.getSelectedItem()==DI.getSelectedItem()){
			repetido=true;
		}
		
		
		
		return repetido;
		
		
		}
	public static String valor1(){
		return idjornada;
	}
	public static String valor2(){
		return puntosjornada2;
	}
	**/
	}
	private String buscarDelantero() {
		String nombre="";
		for(int i=0;i<listaUsuarios.size();i++)
		{
			for(int e=0;e<listaJugadores.size();e++)
			{
				if(listaUsuarios.get(i).getIdJugador().equalsIgnoreCase(listaJugadores.get(e).getId())&&listaJugadores.get(e).getPosicion().equalsIgnoreCase("Delantero"))
				{
					nombre=listaJugadores.get(e).getNombre();
					break;
				}
			}
		}
		
		return nombre;
	}
	private void cargarJugadoresEnLista(String b) 
	{
	Jugador jugador;
	UsuarioJugador usujug;
		st=BasesDeDatos.getStatement();
		String sentencia="select * from usuariojugadores";
		
		String sentencia2="select * from jugadores";
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			while(rs.next())
			{
				usujug=new UsuarioJugador();
				usujug.setIdUsuario(rs.getString("idUsuario"));
				usujug.setIdJugador(rs.getString("idJugador"));
				
				listaUsuarios.add(usujug);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ResultSet rs2=st.executeQuery(sentencia2);
			while(rs2.next())
			{
				jugador=new Jugador();
				jugador.setId(rs2.getString("id"));
				jugador.setNombre(rs2.getString("nombre"));
				
				listaJugadores.add(jugador);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i=0;i<listaUsuarios.size();i++)
		{
			if(b.equalsIgnoreCase(listaUsuarios.get(i).getIdUsuario()))
					{

					String nombre=chequearNombreJugador(listaUsuarios.get(i).getIdJugador());
						modelo.addElement(nombre);
				
					}
		}
		
		
	}
	private String chequearNombreJugador(String idJugador) 
	{
		String nombre="";
		for(int i=0;i<listaJugadores.size();i++)
		{
			if(idJugador.equalsIgnoreCase(listaJugadores.get(i).getId()))
			{
				nombre=listaJugadores.get(i).getNombre();
				break;
			}
		}
		return nombre;
	}
	}

