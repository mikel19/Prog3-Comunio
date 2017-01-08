package ud.prog3.Comunio;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RepartoDinero extends JFrame implements ActionListener, ListSelectionListener
{
	JLabel lblReparteElCapital;
	JScrollPane scrollPane;
	JList list;
	DefaultListModel modelo;
	JLabel lblDineroActualDe;
	JLabel lblcuantoDineroLe;
	JButton btnGuardar;
	Statement st=null;
	JTextField textField;
	JTextField textField_1;
	ArrayList usuarios;
	
	public RepartoDinero() {
		setBounds(300,300,600,400);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RepartoDinero.class.getResource("/ud/prog3/Comunio/img/comunioIcono.jpg")));
		getContentPane().setLayout(null);
		
		lblReparteElCapital = new JLabel("REPARTE EL CAPITAL ");
		lblReparteElCapital.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 18));
		lblReparteElCapital.setBounds(23, 22, 240, 14);
		getContentPane().add(lblReparteElCapital);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 55, 135, 306);
		getContentPane().add(scrollPane);
		
		list = new JList();
		modelo=new DefaultListModel();
		list.setModel(modelo);
		list.addListSelectionListener(this);
		scrollPane.setViewportView(list);
		
		lblDineroActualDe = new JLabel("DINERO ACTUAL DE ESTE USUARIO");
		lblDineroActualDe.setBounds(217, 69, 202, 14);
		getContentPane().add(lblDineroActualDe);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(227, 98, 142, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblcuantoDineroLe = new JLabel("\u00BFCUANTO DINERO LE DAMOS?");
		lblcuantoDineroLe.setBounds(217, 162, 175, 14);
		getContentPane().add(lblcuantoDineroLe);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(227, 201, 142, 29);
		getContentPane().add(textField_1);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(241, 296, 105, 23);
		getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("guardar");
		
		usuarios=new ArrayList();
		añadirUsuariosALista();
		
		
	}

	

	private void añadirUsuariosALista() 
	{
		st=BasesDeDatos.getStatement();
		modelo.clear();
		usuarios.clear();
		
		String sentencia="select * from usuarios";
		
		ResultSet rs;
		try {
			rs = st.executeQuery(sentencia);
			while(rs.next())
			{
				modelo.addElement(rs.getString("id"));
				usuarios.add(rs.getInt("dinero"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		repaint();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
		case "guardar":
			
			
			try {
				st=BasesDeDatos.getStatement();
				int index=list.getSelectedIndex()+1;
				int dineroTotal=Integer.parseInt(textField_1.getText())+Integer.parseInt(textField.getText());
				String sentencia="update usuarios set dinero = '"+dineroTotal+"' where numIdentificador = '"+index+"'";
				System.out.println(sentencia);
				st.executeUpdate(sentencia);
				JOptionPane.showMessageDialog(null, "El usuario ahora tiene "+textField_1.getText()+" euros");
				
				dispose();
			
			}
			catch(NumberFormatException n)
			{
				JOptionPane.showMessageDialog(null, "introduce numeros de verdad, por favor");
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		repaint();
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) 
	{
		
		if(arg0.getValueIsAdjusting()==false)
		{
			textField.setText(buscarDineroUsuario(list.getSelectedIndex())+"");
			repaint();
		}
		
		
	}

	private int buscarDineroUsuario(int index) 
	{
		
		int dinero=0;
		
		
	
	
		dinero=(int)usuarios.get(index);
		
	
		return dinero;
		
	}
}
