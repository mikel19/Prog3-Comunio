package ud.prog3.Comunio;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import java.sql.SQLException;
import java.sql.Statement;

public class Usuario extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JTextField contraseña;
	private JButton btnAcceder;
	private JButton btnCancelar;
	private JLabel lblLogInCon;
	private JLabel lblRegistrateYCrea;
	private JTextField nId;
	private JTextField nContraseña;
	private JLabel lblqueIdQuieres;
	private JLabel lblyQueContrasea;
	private JButton btnRegistrar;
	
	public Usuario()
	{
		getContentPane().setBackground(new Color(0, 128, 0));
		setBounds(400,300,500,400);
		setTitle("Sign Up - Comunio");
		getContentPane().setLayout(null);
		
		JLabel lContraseña = new JLabel("inserte el id del usuario");
		lContraseña.setForeground(Color.WHITE);
		lContraseña.setBounds(94, 248, 128, 14);
		getContentPane().add(lContraseña);
		
		id = new JTextField();
		id.setBounds(112, 285, 86, 20);
		getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblInserteLaContrasea = new JLabel("inserte la contrase\u00F1a");
		lblInserteLaContrasea.setForeground(Color.WHITE);
		lblInserteLaContrasea.setBounds(94, 316, 128, 14);
		getContentPane().add(lblInserteLaContrasea);
		
		contraseña = new JTextField();
		contraseña.setBounds(112, 341, 86, 20);
		getContentPane().add(contraseña);
		contraseña.setColumns(10);
		
		btnAcceder = new JButton("ACCEDER");
		btnAcceder.setBounds(307, 312, 115, 23);
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
		
		nContraseña = new JTextField();
		nContraseña.setBounds(169, 113, 86, 20);
		getContentPane().add(nContraseña);
		nContraseña.setColumns(10);
		
		lblqueIdQuieres = new JLabel("\u00BFQue id quieres tener?");
		lblqueIdQuieres.setForeground(Color.WHITE);
		lblqueIdQuieres.setBounds(35, 71, 124, 14);
		getContentPane().add(lblqueIdQuieres);
		
		lblyQueContrasea = new JLabel("\u00BFY que contrase\u00F1a?");
		lblyQueContrasea.setForeground(Color.WHITE);
		lblyQueContrasea.setBounds(35, 116, 115, 14);
		getContentPane().add(lblyQueContrasea);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(307, 83, 110, 23);
		getContentPane().add(btnRegistrar);
		btnRegistrar.addActionListener(this);
		btnRegistrar.setActionCommand("registrar");
		
		setResizable(false);
		
		BasesDeDatos.initBD("UsuariosBD");
		BasesDeDatos.crearTablaBD();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Statement st=null;
		st=BasesDeDatos.getStatement();
		switch(e.getActionCommand())
		{
		case "acceder":
			
			
			
			if((chequearEnTabla(st))==true)
			{
				JOptionPane.showMessageDialog(null, "el usuario que ha introducido es correcto");
				
				VentanaJuegoUsuario VJU=new VentanaJuegoUsuario();
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
			
			
			break;
			
		case "registrar":
			
			if(nId.getText().isEmpty()==true&&nContraseña.getText().isEmpty()==true)
			{
				JOptionPane.showMessageDialog(this, "Por favor, introduzca valores para poder registrarte");
				break;
			}
			
			
			
			if (chequearYaEnTabla(st)) {  // Si está ya en la tabla
				JOptionPane.showMessageDialog(null, "Ya existe ese usuario en la base de datos");
				break;
			}
			
			try {
				String sentSQL = "insert into usuarios values(" +
						"'" + nId.getText() + "', " +
						"'" + nContraseña.getText() +  "')";
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				int val = st.executeUpdate( sentSQL );
//				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
//				return true;
			} catch (SQLException e1) {
				e1.printStackTrace();
//				return false;
			}
			
			
			break;
		
		}
		
		
	}
	
	public boolean chequearYaEnTabla( Statement st ) {
		try {
			String sentSQL = "select * from usuarios " +
					"where (id = '" + nId.getText() + "')";
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
	public boolean chequearEnTabla( Statement st ) {
		try {
			String sentSQL = "select * from usuarios " +
					"where (id = '" + id.getText() + "')";
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
	
	
}
