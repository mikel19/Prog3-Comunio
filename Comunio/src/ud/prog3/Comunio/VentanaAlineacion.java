package ud.prog3.Comunio;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

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
	JList list;
	JButton bañadir;
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
	 */
	public VentanaAlineacion() {
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
		
		list = new JList();
		list.setBounds(418, 81, 179, 372);
		getContentPane().add(list);
		

		

	
	}
}
