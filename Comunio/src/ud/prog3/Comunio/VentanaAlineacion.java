package ud.prog3.Comunio;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
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

public class VentanaAlineacion extends JInternalFrame {
	VentanaAlineacion alineacion;
	JLabel lblAlineacion;
	JComboBox<Jugador> Portero;
	JComboBox<Jugador> LI;
	JComboBox<Jugador> DFCI;
	JComboBox <Jugador>DFCD;
	JComboBox <Jugador>LD;
	JComboBox<Jugador> MI;
	JComboBox <Jugador>MCI;
	JComboBox <Jugador>MCD;
	JComboBox <Jugador>MD;
	JComboBox<Jugador> DI;
	JComboBox<Jugador> DCD;
	ImageIcon icono;
	ImageIcon fot; 
	JButton bañadir;
	JList <DefaultListModel>lista ;
	DefaultListModel modelo;
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
	 * @throws SQLException 
	 */
	public VentanaAlineacion()  {
//		addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				icono = new ImageIcon( 
//						fot.getImage( ).getScaledInstance( 
//								lblAlineacion.getWidth(), lblAlineacion.getHeight(), Image.SCALE_DEFAULT ) ); 
//				lblAlineacion.setIcon(icono);
//			}
//		});

		setClosable(true);
		
		JLabel campo=new JLabel();
		
		setTitle("Alineaci\u00F3n");
		setBounds(100, 100, 623, 513);
		getContentPane().setLayout(null);
		
		
		JLabel lblSistemaDeJuego = new JLabel("Sistema de Juego");
		lblSistemaDeJuego.setBounds(10, 11, 115, 20);
		getContentPane().add(lblSistemaDeJuego);
		
		
		
		
		 fot = new ImageIcon(VentanaAlineacion.class.getResource("/ud/prog3/Comunio/img/Alineacion.jpeg"));
		this.repaint();
		

	
	
		
		
		Portero = new JComboBox<Jugador>();
		Portero.setToolTipText("Portero");
		Portero.setBounds(207, 429, 28, 20);
		getContentPane().add(Portero);
		
		
		LI = new JComboBox<Jugador>();
		LI.setToolTipText("LI");
		LI.setBounds(60, 352, 28, 20);
		getContentPane().add(LI);
		
		DFCI = new JComboBox<Jugador>();
		DFCI.setToolTipText("DFCI");
		DFCI.setBounds(150, 365, 28, 20);
		getContentPane().add(DFCI);
		
		DFCD = new JComboBox<Jugador>();
		DFCD.setToolTipText("DFCD");
		DFCD.setBounds(266, 365, 28, 20);
		getContentPane().add(DFCD);
		
		LD = new JComboBox<Jugador>();
		LD.setToolTipText("LD");
		LD.setBounds(339, 352, 28, 20);
		getContentPane().add(LD);
		
		MI = new JComboBox<Jugador>();
		MI.setToolTipText("MI");
		MI.setBounds(117, 276, 28, 20);
		getContentPane().add(MI);
		
		MCI = new JComboBox<Jugador>();
		MCI.setToolTipText("MCI");
		MCI.setBounds(165, 301, 28, 20);
		getContentPane().add(MCI);
		
		MCD = new JComboBox<Jugador>();
		MCD.setToolTipText("MCD");
		MCD.setBounds(237, 301, 28, 20);
		getContentPane().add(MCD);
		
		MD = new JComboBox<Jugador>();
		MD.setToolTipText("MD");
		MD.setBounds(299, 276, 28, 20);
		getContentPane().add(MD);
		
		DI = new JComboBox<Jugador>();
		DI.setToolTipText("DI");
		DI.setBounds(137, 181, 28, 20);
		getContentPane().add(DI);
		
		DCD = new JComboBox<Jugador>();
		DCD.setToolTipText("DCD");
		DCD.setBounds(266, 181, 28, 20);
		getContentPane().add(DCD);
		
		
		lblAlineacion = new JLabel("");
		lblAlineacion.setBackground(Color.WHITE);
		lblAlineacion.setBounds(35, 81, 373, 392);
		getContentPane().add(lblAlineacion);
		 icono = new ImageIcon(fot.getImage().getScaledInstance(lblAlineacion.getWidth(), lblAlineacion.getHeight(), Image.SCALE_DEFAULT));
		lblAlineacion.setIcon(icono);
		
		
		JButton button = new JButton("4-4-2");		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LI.setBounds(60, 352, 28, 20);
				DFCI.setBounds(150, 365, 28, 20);
				DFCD.setBounds(266, 365, 28, 20);
				LD.setBounds(339, 352, 28, 20);
				MI.setBounds(117, 276, 28, 20);
				MCI.setBounds(165, 301, 28, 20);
				MCD.setBounds(237, 301, 28, 20);
				MD.setBounds(299, 276, 28, 20);
				DI.setBounds(137, 181, 28, 20);
				DCD.setBounds(266, 181, 28, 20);
				
			}
		});
		button.setBounds(10, 31, 89, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("3-4-3");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LI.setBounds(128, 366, 28, 20);
			DFCI.setBounds(206, 366, 28, 20);
			DFCD.setBounds(279, 366, 28, 20);
			LD.setBounds(206, 167, 28, 20);
			MI.setBounds(103, 284, 28, 20);
			MCI.setBounds(160, 250, 28, 20);
			MCD.setBounds(241, 250, 28, 20);
			MD.setBounds(302, 284, 28, 20);
			DI.setBounds(128, 167, 28, 20);
			DCD.setBounds(289, 167, 28, 20);
				
			}
		});
		button_1.setBounds(103, 31, 89, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("4-3-3");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LI.setBounds(60, 352, 28, 20);
			DFCI.setBounds(150, 365, 28, 20);
			DFCD.setBounds(266, 365, 28, 20);
			LD.setBounds(339, 352, 28, 20);
			MI.setBounds(110, 260, 28, 20);
			MCI.setBounds(210, 260, 28, 20);
			MCD.setBounds(310, 260, 28, 20);
			MD.setBounds(110, 167, 28, 20);
			DI.setBounds(210, 167, 28, 20);
			DCD.setBounds(310, 167, 28, 20);
				
			}
		});
		button_2.setBounds(196, 31, 89, 23);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("5-4-1");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LI.setBounds(65, 366, 28, 20);
			DFCI.setBounds(135, 366, 28, 20);
			DFCD.setBounds(205, 366, 28, 20);
			LD.setBounds(345, 366, 28, 20);
			MI.setBounds(275, 366, 28, 20);
			MCI.setBounds(90, 250, 28, 20);
			MCD.setBounds(170, 250, 28, 20);
			MD.setBounds(250, 250, 28, 20);
			DI.setBounds(330, 250, 28, 20);
			DCD.setBounds(210, 167, 28, 20);
				
			}
		});
		button_3.setBounds(289, 31, 89, 23);
		getContentPane().add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(431, 74, 166, 431);
		getContentPane().add(scrollPane);
		
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
		
		ArrayList<String>idusuario=new ArrayList<String>();

		 
		try {
			ResultSet	rs4 = st.executeQuery("select idUsuario from usuariojugadores");
			ResultSetMetaData rsmd4 = rs4.getMetaData();
			int columnCount4 = rsmd4.getColumnCount();
			
			while(rs4.next()){
				
				
				jugadores4=rs4.getString(columnCount4);
				idusuario.add(jugadores4);
				
				
				
				
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<String>idJugador=new ArrayList<String>();

		 
		try {
			ResultSet	rs = st.executeQuery("select idJugador from usuariojugadores");
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			while(rs.next()){
				
				
				jugadores=rs.getString(columnCount);
				idJugador.add(jugadores);
				
				
				
				
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("idjugadores:"+idJugador);
		ArrayList<String>idtodojugadores=new ArrayList<String>();
		try {
			ResultSet	rs2 = st.executeQuery("select id from jugadores");
			ResultSetMetaData rsmd2 = rs2.getMetaData();
			int columnCount2 = rsmd2.getColumnCount();
			
			while(rs2.next()){
			
			
				jugadores2=rs2.getString(columnCount2);
				idtodojugadores.add(jugadores2);
				
				
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("idtodojugadores:"+idtodojugadores);
		
		


		ArrayList<String>nombre=new ArrayList<String>();
		
		ArrayList<String>nombrejugadores=new ArrayList<String>();

for(int z=0;z<idusuario.size();z++){		
		for(int a=0;a<idJugador.size();a++){
			for(int s=0;s<idtodojugadores.size();s++){
			if(idJugador.get(a).equals(idtodojugadores.get(s))){

		
				try {
					ResultSet	rs3 = st.executeQuery("select nombre from jugadores where id='"+idJugador.get(a)+"'");
					ResultSetMetaData rsmd3 = rs3.getMetaData();
					int columnCount3 = rsmd3.getColumnCount();
					
					
					
					
						jugadores3=rs3.getString(columnCount3);
						nombrejugadores.add(jugadores3);
						
						
//						modelo.addElement(nombre);
						
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
				
				
			}
			}
		}
}
		System.out.println("nombre jugadores:"+nombrejugadores);

	
	
	}
	
	}

