package ud.prog3.Comunio;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
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
	private JDesktopPane Escritorio;
	public VentanaJuegoUsuario() {
	
		
		
	
		
		setBounds(400,300,500,400);
		getContentPane().setLayout(null);
		
		menuBar = new JMenuBar();
		
		menuBar.setBounds(0, 0, 484, 21);
		getContentPane().add(menuBar);
		
		mnNoticias = new JMenu("Noticias");
		menuBar.add(mnNoticias);
		
		mntmLeerNoticias = new JMenuItem("Escribir");
		
	
		mnNoticias.add(mntmLeerNoticias);
		
		JMenu mnClasificacin = new JMenu("Clasificaci\u00F3n");
		menuBar.add(mnClasificacin);
		
		JMenu mnAlineacin = new JMenu("Alineaci\u00F3n");
		menuBar.add(mnAlineacin);
		
		JMenuItem mntmVerAlineacin = new JMenuItem("Ver Alineacion");
		
		
		mnAlineacin.add(mntmVerAlineacin);
		
		Escritorio = new JDesktopPane();
		Escritorio.setBounds(0, 23, 484, 339);
		getContentPane().add(Escritorio);
		
		
		
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				menuBar.setSize(getContentPane().getWidth(), 21);
			}
		});
		
	
		
		

		
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Escritorio.setSize(getContentPane().getWidth(), getContentPane().getHeight());
				
			}
		});
		
		mntmVerAlineacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAlineacion alineacion=new VentanaAlineacion();
				Escritorio.add(alineacion);
				alineacion.setVisible(true);
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
			Escritorio.add(noti);
			noti.setVisible(true);
			break;
			
		case "Ver Alineacion":
			
			VentanaAlineacion alineacion=new VentanaAlineacion();
			Escritorio.add(alineacion);
			alineacion.setVisible(true);
			break;
		
		
		}
		
		
	}
}
