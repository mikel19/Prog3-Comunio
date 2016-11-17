package ud.prog3.Comunio;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JInternalNoticias extends JInternalFrame {
	private JTextField nombre;
	private JTextField noticia;
	JLabel lblNombreDeUsuario;
	JLabel lblNoticia;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JInternalNoticias frame = new JInternalNoticias();
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
	public JInternalNoticias() {
		setClosable(true);
		getContentPane().setBackground(Color.WHITE);
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 515, 395);
		getContentPane().setLayout(null);
		
		 lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setBounds(29, 31, 116, 26);
		getContentPane().add(lblNombreDeUsuario);
		
		nombre = new JTextField();
		nombre.setBounds(29, 68, 200, 26);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		lblNoticia = new JLabel("Noticia");
		lblNoticia.setBounds(29, 125, 46, 14);
		getContentPane().add(lblNoticia);
		
		noticia = new JTextField();
		noticia.setBounds(29, 145, 374, 93);
		getContentPane().add(noticia);
		noticia.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(108, 294, 121, 26);
		getContentPane().add(btnEnviar);
		
		JButton btnCancelar = new JButton("Cancelar");
	
		btnCancelar.setBounds(289, 296, 121, 24);
		getContentPane().add(btnCancelar);
		
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nombre.setText("");
				noticia.setText("");
				
			}
		});

	}
}
