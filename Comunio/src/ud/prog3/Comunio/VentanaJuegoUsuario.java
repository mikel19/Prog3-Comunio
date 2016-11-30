package ud.prog3.Comunio;


import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JInternalFrame;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JDesktopPane;



public class VentanaJuegoUsuario extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tiempoUso;
	JMenuBar menuBar;
	JMenu mnNoticias;
	JMenuItem mntmLeerNoticias;
	JTextField noticia;
	ImageIcon icono;
	ImageIcon fot; 
	JLabel lblmanager;
	private JLabel lblNewLabel;
	JMenuItem mntmVerAlineacion;
	public VentanaJuegoUsuario(String string) {
		final String b=string;
		setResizable(false);
		fot = new ImageIcon(VentanaJuegoUsuario.class.getResource("/ud/prog3/Comunio/img/manager.jpg"));
		this.repaint();
		
		
//		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuario.class.getResource("/ud/prog3/Comunio/img/comunioIcono.jpg")));
		setTitle("OFICINA DEL ENTRENADOR - Gestiona tu equipo");
		setBounds(300, 20, 849, 711);
		getContentPane().setLayout(null);
		
		menuBar = new JMenuBar();
		
		menuBar.setBounds(0, 0, 484, 21);
		getContentPane().add(menuBar);
		
		mnNoticias = new JMenu("Noticias");
		mnNoticias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JInternalNoticias noti=new JInternalNoticias();
				if(noti.isClosed()==true){
					mntmLeerNoticias.setEnabled(true);
				}
				if(noti.isClosed()==false){
					mntmLeerNoticias.setEnabled(false);
					
				}
			}
		});
		menuBar.add(mnNoticias);
		
		mntmLeerNoticias = new JMenuItem("Escribir");
	
		
	
		mnNoticias.add(mntmLeerNoticias);
		
		JMenu mnClasificacin = new JMenu("Clasificaci\u00F3n");
		menuBar.add(mnClasificacin);
		
		JMenu mnAlineacin = new JMenu("Alineaci\u00F3n");
		menuBar.add(mnAlineacin);
		
		mntmVerAlineacion = new JMenuItem("Ver Alineacion");

		
		
		mnAlineacin.add(mntmVerAlineacion);
		
		lblmanager = new JLabel("");
		lblmanager.setBounds(0, 27, 833, 646);
		 getContentPane().add(lblmanager);
		 icono = new ImageIcon(fot.getImage().getScaledInstance(lblmanager.getWidth(), lblmanager.getHeight(), Image.SCALE_DEFAULT));
		 lblmanager.setIcon(icono);
	
		 
		
		
		
		
		
		
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			
				menuBar.setSize(getContentPane().getWidth(), 21);
				
			}
		});
		
	
		
		

		
	
		
		mntmVerAlineacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaAlineacion alineacion =new VentanaAlineacion(b);
			
					 

				
				
				getContentPane().add(alineacion);
				lblmanager.add(alineacion);
				
				
				alineacion.setVisible(true);
				
				
			}
		});
		
		mntmLeerNoticias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				
				JInternalNoticias noti=new JInternalNoticias();

				getContentPane().add(noti);
					noti.setVisible(true);
				
			
			
				
			}
		});
		
	
		
//		tiempoUso = new JTextField();
//		tiempoUso.setLocation(60, 24);
//		tiempoUso.setSize(93, 20);
//		getContentPane().add(tiempoUso);
//		tiempoUso.setColumns(10);
		
		
		
//		Runnable r=new Runnable()
//		{
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				for(int i=0;i<10;i++)
//				{
//				tiempoUso.setText("El tiempo uso: "+i);
//				if(i==9)
//				{
//					tiempoUso.setText("Tiempo de expiracion - La conexión va a finalizar");
//					try {
//						Thread.sleep(4000);
//						dispose();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				}
//			}
//			
//		};
//		Thread mihilo=new Thread(r);
//		mihilo.start();
		
	
	}

	
		
	

	public void actionPerformed(ActionEvent e) 
	{
		
		switch(e.getActionCommand())
		{
		case "Escribir":
		
			JInternalNoticias noti=new JInternalNoticias();
//			Escritorio.add(noti);
			noti.setVisible(true);
			break;
			
		case "Ver Alineacion":
			
			VentanaAlineacion alineacion = null;
//			alineacion = new VentanaAlineacion(b);
//			Escritorio.add(alineacion);
			alineacion.setVisible(true);
			break;
		
		
		}
		
		
	}
}
