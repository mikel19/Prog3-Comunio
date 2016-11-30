package ud.prog3.Comunio;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class AccesoAdministrador extends JFrame implements ActionListener
{
	private JTextField textFieldId;
	private JPasswordField passwordField;
	JLabel lblIntroduceElId;
	JLabel lblContrasea;
	JProgressBar progressBar;
	JButton btnAcceder;
	JButton btnCancelar;
	Runnable r;
	
	
	
	
	public AccesoAdministrador() {
		
		
		setBounds(400,400,600,300);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AccesoAdministrador.class.getResource("/ud/prog3/Comunio/img/comunioIcono.jpg")));
		setTitle("LOG IN Administrador");
		getContentPane().setLayout(null);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(190, 60, 86, 20);
		getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 137, 86, 20);
		getContentPane().add(passwordField);
		
		lblIntroduceElId = new JLabel("Introduce el ID administrador");
		lblIntroduceElId.setBounds(22, 63, 158, 14);
		getContentPane().add(lblIntroduceElId);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(59, 140, 91, 14);
		getContentPane().add(lblContrasea);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(59, 221, 146, 14);
		getContentPane().add(progressBar);
		
		btnAcceder = new JButton("ACCEDER");
		btnAcceder.setBounds(323, 89, 101, 23);
		getContentPane().add(btnAcceder);
		btnAcceder.addActionListener(this);
		btnAcceder.setActionCommand("acceder");
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(323, 175, 101, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("Cancelar");
	}





	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		switch(arg0.getActionCommand())
		{
		
		case "acceder":
			
			if(textFieldId.getText().equals("admin")&& passwordField.getText().equals("admin"))
			{
				JOptionPane.showMessageDialog(this, "Bienvenido Administrador");
				dispose();
				
				Administrador admin=new Administrador();
				admin.setVisible(true);
				break;
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, "El id o contraseña introducidos son incorrectos");
				break;
			}
			
			
		case "Cancelar":
			
			
			
			textFieldId.setText("");
			 passwordField.setText("");
			 break;
			
		
		}
		
		
	}
}
