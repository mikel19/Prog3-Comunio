package ud.prog3.Comunio;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class VentanaPrincipal extends JFrame implements ActionListener, WindowListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public VentanaPrincipal()
	{
		 JLabel lIcono=new JLabel();
		 JLabel lCabecera=new JLabel();
		
		 
		 JPanel pBotonera;
		 ArrayList<JButton> botones;
		 String[] ficsBotones = new String[] { "Button Mercado", "Button Alineacion", "Button Maximize"}; 
//		"Button Mercado", "Button Alineacion", "Button Maximize" };
		 JPanel contentPane=new JPanel();
		 JButton bUsuario=new JButton();
		 JButton bAdministrador=new JButton();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 845, 520);
		// Creación de componentes/contenedores de swing
		
		
		
		
		pBotonera = new JPanel();
		
		try {
			lIcono.setIcon((new ImageIcon(VentanaPrincipal.class.getResource("/ud/prog3/Comunio/img/comunioIcono.jpg"))));
			
			//"comunioIcono.jpg" ).toURI().toURL() )
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: icono de comunio no encontrado" );
			e.printStackTrace();
		}
		
		try {
			lCabecera.setIcon((new ImageIcon(VentanaPrincipal.class.getResource("/ud/prog3/Comunio/img/cabeceraComunio.PNG"))));
			
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: icono de comunio no encontrado" );
			e.printStackTrace();
		}
		
		
	/**	 
		addWindowListener( new WindowAdapter()
        {
            public void windowResized(WindowEvent evt)
            {
                lCabecera.repaint();
                lIcono.repaint();
            }
        });
		
		**/
		
//		botones = new ArrayList<>();
//		for (String fic : ficsBotones) {
//			JButton boton = new JButton( new ImageIcon( VentanaPrincipal.class.getResource( "img/" + fic + ".png" )) );
//			botones.add( boton );
//			boton.setName(fic);  // Pone el nombre al botón del fichero (útil para testeo o depuración)
//		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		
		contentPane.setBackground(new Color(0,128,0));
//		lCabecera.setBounds(0, 0, 832, 98);
//		lIcono.setBounds(0, 150, 124, 124);
		
		bUsuario.setActionCommand("usuario");
		bUsuario.addActionListener(this);
		bAdministrador.setActionCommand("administrador");
		bAdministrador.addActionListener(this);
		bUsuario.setText("USUARIO");
//		bUsuario.setBounds(200, 300, 100, 20);
		bAdministrador.setText("ADMINISTRADOR");
//		bAdministrador.setBounds(350, 300, 150, 20);
		
		
		contentPane.add(lIcono,BorderLayout.NORTH);
//		lIcono.setBounds(0, 0, contentPane.getWidth(), contentPane.getHeight());
		contentPane.add(lCabecera,BorderLayout.AFTER_LAST_LINE);
//		lCabecera.setBounds(0, 0, contentPane.getWidth(), contentPane.getHeight());
		contentPane.add(bUsuario,BorderLayout.WEST);
		contentPane.add(bAdministrador,BorderLayout.EAST);
		
	
		
		lIcono.setVisible(true);
		lCabecera.setVisible(true);
		bUsuario.setVisible(true);
		bAdministrador.setVisible(true);
		
		setContentPane(contentPane);
		
		
       
	}
	public void actionPerformed(ActionEvent e) 
	{
		
		switch(e.getActionCommand())
		{
		case "usuario":
			Usuario vUsuario=new Usuario();
			vUsuario.setVisible(true);
			BasesDeDatos.close();
			break;
			
			
			
		case "administrador":
			JOptionPane.showMessageDialog(null, "Has accedido como administrador");
			System.out.println("hola soy");
			System.out.println("Ioritz Lopetegui iza 5");
			break;
		
		
		}
		
		
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}
	
	
	
	   
	
}
