package ud.prog3.Comunio;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.FlowLayout;

import javax.swing.JTextPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Rectangle;

public class Administrador extends JFrame
{
	public Administrador() {
		setBounds(new Rectangle(0, 0, 2147483647, 2147483647));
		setTitle("ADMINISTRADOR DE LA COMUNIDAD ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Administrador.class.getResource("/ud/prog3/Comunio/img/comunioIcono.jpg")));
		setBackground(new Color(0,128,0));
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 11, 316, 631);
		getContentPane().add(scrollPane);
		
		
		JList <DefaultListModel>lista = new JList<DefaultListModel>();
		DefaultListModel modelo=new DefaultListModel();
		lista.setModel(modelo);
		scrollPane.setViewportView(lista);
		
		JLabel lblEstosSonLos = new JLabel("Estos son los jugadores que hay");
		lblEstosSonLos.setBounds(441, 11, 217, 14);
		getContentPane().add(lblEstosSonLos);
		
		
		Statement st=BasesDeDatos.getStatement();
		String jugadores="";
		try {
			jugadores="select * from jugadores";
			ResultSet rs=st.executeQuery(jugadores);
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int columnCount = rsmd.getColumnCount();
			while(rs.next())
			{
				
			modelo.addElement(rs.getString("nombre")+"  ");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
