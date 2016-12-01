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

public class VentanaAlineacion extends JInternalFrame {
	VentanaAlineacion alineacion;
	JLabel lblAlineacion;
	JComboBox<String> Portero;
	JComboBox<String> LI;
	JComboBox<String> DFCI;
	JComboBox <String>DFCD;
	JComboBox <String>LD;
	JComboBox<String> MI;
	JComboBox <String>MCI;
	JComboBox <String>MCD;
	JComboBox <String>MD;
	JComboBox<String> DI;
	JComboBox<String> DCD;
	ImageIcon icono;
	ImageIcon fot; 
	JButton bañadir;
	JList <DefaultListModel>lista ;
	DefaultListModel modelo;
	private JButton btnGuardarAlineacion;
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
		

	
	
		
		
		Portero = new JComboBox<String>();
		Portero.setToolTipText("Portero");
		Portero.setBounds(171, 431, 101, 20);
		getContentPane().add(Portero);
		
		
		LI = new JComboBox<String>();
		LI.setToolTipText("LI");
		LI.setBounds(45, 332, 101, 20);
		getContentPane().add(LI);
		
		DFCI = new JComboBox<String>();
		DFCI.setToolTipText("DFCI");
		DFCI.setBounds(123, 363, 101, 20);
		getContentPane().add(DFCI);
		
		DFCD = new JComboBox<String>();
		DFCD.setToolTipText("DFCD");
		DFCD.setBounds(237, 363, 101, 20);
		getContentPane().add(DFCD);
		
		LD = new JComboBox<String>();
		LD.setToolTipText("LD");
		LD.setBounds(299, 332, 101, 20);
		getContentPane().add(LD);
		
		MI = new JComboBox<String>();
		MI.setToolTipText("MI");
		MI.setBounds(55, 264, 101, 20);
		getContentPane().add(MI);
		
		MCI = new JComboBox<String>();
		MCI.setToolTipText("MCI");
		MCI.setBounds(123, 295, 101, 20);
		getContentPane().add(MCI);
		
		MCD = new JComboBox<String>();
		MCD.setToolTipText("MCD");
		MCD.setBounds(237, 295, 101, 20);
		getContentPane().add(MCD);
		
		MD = new JComboBox<String>();
		MD.setToolTipText("MD");
		MD.setBounds(299, 264, 101, 20);
		getContentPane().add(MD);
		
		DI = new JComboBox<String>();
		DI.setToolTipText("DI");
		DI.setBounds(103, 170, 101, 20);
		getContentPane().add(DI);
		
		DCD = new JComboBox<String>();
		DCD.setToolTipText("DCD");
		DCD.setBounds(247, 170, 101, 20);
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
				Portero.setBounds(171, 431, 101, 20);
				LI.setBounds(45, 332, 101, 20);
				DFCI.setBounds(123, 363, 101, 20);
				DFCD.setBounds(237, 363, 101, 20);
				LD.setBounds(299, 332, 101, 20);
				MI.setBounds(55, 264, 101, 20);
				MCI.setBounds(123, 295, 101, 20);
				MCD.setBounds(237, 295, 101, 20);
				MD.setBounds(299, 264, 101, 20);
				DI.setBounds(103, 170, 101, 20);
				DCD.setBounds(247, 170, 101, 20);
				
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
		
		btnGuardarAlineacion = new JButton("GUARDAR ALINEACION");
		btnGuardarAlineacion.setBounds(433, 31, 147, 23);
		getContentPane().add(btnGuardarAlineacion);
		
		btnGuardarAlineacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(jugadoresrepetidosenalineacion()==true){
					JOptionPane.showMessageDialog(null, "Atención!! algunos jugadores estan repetidos");
			
				}
				else{
					
				}
				
				
			}
		});
		
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
		
	
		Usuario usuario=new Usuario();

for(int z=0;z<idusuario.size();z++){	
	if(idusuario.get(z).equals(idactual)){
		
			
//			for(int s=0;s<idJugador.size();s++){
		

		
				try {
					ResultSet	rs3 = st.executeQuery("select nombre from jugadores where id='"+idJugador.get(z)+"'");
					ResultSetMetaData rsmd3 = rs3.getMetaData();
					int columnCount3 = rsmd3.getColumnCount();
					
					
					
					
						jugadores3=rs3.getString(columnCount3);
						nombrejugadores.add(jugadores3);
						modelo.addElement(jugadores3);
						
//						modelo.addElement(nombre);
						
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
	
				}
			
				
				
				
			
//			}
		
	}
}
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
	
	}

