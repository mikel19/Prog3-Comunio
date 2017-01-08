package ud.prog3.Comunio;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import javax.swing.ImageIcon;

public class MercadoFichajes extends JFrame  implements ListSelectionListener,ActionListener, Serializable
{

	JButton btnNewButton;
	JScrollPane scrollPane;
	JList list;
	JLabel lblUsuario;
	JLabel label;
	JLabel lblPrecioJugador;
	JLabel lblRealizarOferta;
	JTextField textField;
	JTextField textField_1;
	DefaultListModel modelo;
	Statement st=null;
	ArrayList precios;
	ArrayList<Usuario> dineroUsuarios;
	Usuario usuario;
	int i=0;
	ArrayList mercadoId;
	private JLabel label_1;
	/**
	 * Create the frame.
	 * @param b 
	 */
	public MercadoFichajes(String b) {
		getContentPane().setBackground(new Color(0, 128, 0));
		getContentPane().setForeground(new Color(0, 100, 0));
		setTitle("MERCADO DE FICHAJES");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MercadoFichajes.class.getResource("/ud/prog3/Comunio/img/comunioIcono.jpg")));
		setBounds(300, 300, 550, 400);
		getContentPane().setLayout(null);
		precios=new ArrayList();
		mercadoId=new ArrayList();
		dineroUsuarios=new ArrayList();
		
		btnNewButton = new JButton("Pujar");
		btnNewButton.setBounds(233, 231, 89, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("pujar");
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 34, 162, 317);
		getContentPane().add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		modelo=new DefaultListModel();
		list.setModel(modelo);
		list.addListSelectionListener(this);
		
		
		lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setBounds(362, 11, 69, 14);
		getContentPane().add(lblUsuario);
		
		label = new JLabel(b);
		label.setBounds(430, 11, 94, 14);
		getContentPane().add(label);
		
		lblPrecioJugador = new JLabel("Precio Jugador");
		lblPrecioJugador.setBounds(233, 66, 94, 14);
		getContentPane().add(lblPrecioJugador);
		
		lblRealizarOferta = new JLabel("Realizar Oferta");
		lblRealizarOferta.setBounds(233, 145, 107, 14);
		getContentPane().add(lblRealizarOferta);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(233, 94, 117, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 170, 107, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MercadoFichajes.class.getResource("/ud/prog3/Comunio/img/iconoMercado2.png")));
		label_1.setBounds(417, 68, 46, 46);
		getContentPane().add(label_1);

			cargarMercadoDeFichajes();
			
			
			

	}

/**
 * metodo para cargar el dinero que dispone el usuario que ha accedido
 * @param idUsuario
 * @return dinero: cantidad de dinero que dispone este usuario
 */
	private int cargarDineroUsuario(String idUsuario)
	{
		String sentencia="select * from usuarios";
		
		int dinero=0;
		st=BasesDeDatos.getStatement();
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			
			while(rs.next())
			{
				usuario=new Usuario();
				
				usuario.setId(rs.getString("id"));
				usuario.setDinero(rs.getInt("dinero"));
				
				dineroUsuarios.add(usuario);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<dineroUsuarios.size();i++)
		{
			
			if(idUsuario.equalsIgnoreCase(dineroUsuarios.get(i).getId()))
			{
				dinero=dineroUsuarios.get(i).getDinero();
			}
		}
		return dinero;
		
		
		
		
	}


	private void cargarMercadoDeFichajes() 
	{
		st=BasesDeDatos.getStatement();
		modelo.clear();
		precios.clear();
		mercadoId.clear();
		
		String sentencia="select * from mercadodefichajes";
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			
			while(rs.next())
			{
				modelo.addElement(rs.getString("nombre"));
				precios.add(rs.getInt("precio"));
				mercadoId.add(rs.getString("idJugador"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
		
	}


	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		
		if(arg0.getValueIsAdjusting()==false)
		{
			
			
			int index=list.getSelectedIndex();
			
			textField.setText(precios.get(index)+"");
		
			repaint();
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
		case "pujar":
			
			try
			{
			int p1=Integer.parseInt(textField.getText());
			int p2=Integer.parseInt(textField_1.getText());
			
			if(p2<cargarDineroUsuario((String)label.getText()))
			{
				
			
			
			if(p1>p2)
			{
				JOptionPane.showMessageDialog(null, "El jugador NO ha aceptado la oferta, es demasiado baja");
			}
			if(p1<=p2)
			{
				JOptionPane.showMessageDialog(null, "el usuario "+label.getText()+" ha fichado a "+modelo.getElementAt(list.getSelectedIndex()));
			
			st=BasesDeDatos.getStatement();
			
			String sentencia="insert into usuariojugadores values('"+label.getText()+"', '"+mercadoId.get(list.getSelectedIndex())+"')";
			String sentencia2="delete from mercadodefichajes where idJugador = '"+mercadoId.get(list.getSelectedIndex())+"'";
			
			int dinero=cargarDineroUsuario((String)label.getText());
			int dinero2=dinero-p2;
			
			String sentencia3="update usuarios set dinero ='"+dinero2+"' where id ='"+label.getText()+"'";
			

			
				st.executeUpdate(sentencia);
				st.executeUpdate(sentencia2);
				st.executeUpdate(sentencia3);
				dispose();
				
			}
			}
			
			else
			{
				JOptionPane.showMessageDialog(null,"el usuario no tiene tanto dinero para fichar");
				
			}
			}
				
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(NumberFormatException n)
			{
				JOptionPane.showMessageDialog(null, "inserta numeros lógicos por favor, puede que haya introducido una cantidad muy elevada, o puede que haya introducido texto,en vez de cifras");
			}
			
			}
			
			
		
		}
		
	}


	


