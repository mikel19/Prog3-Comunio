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
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Rectangle;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Administrador extends JFrame
{
	public Administrador() {
		setBounds(new Rectangle(0, 0, 2147483647, 2147483647));
		setTitle("ADMINISTRADOR DE LA COMUNIDAD ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Administrador.class.getResource("/ud/prog3/Comunio/img/comunioIcono.jpg")));
		setBackground(new Color(0,128,0));
		getContentPane().setLayout(null);
		
		ArrayList<Jugador>listaJ=new ArrayList<Jugador>();
		Jugador jugador;
		
		
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
		
		 JButton btnPuntuar = new JButton("PUNTUAR");
		btnPuntuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				Statement st=null;
				st=BasesDeDatos.getStatement();
				
				for(int i=1;i<75;i++)
				{
					Random puntos;
					puntos=new Random();
					String sentencia="update jugadores set puntosJornada='"+puntos.nextInt(15)+"' where id='"+i+"'";
					try {
						st.executeUpdate(sentencia);
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				JOptionPane.showMessageDialog(null, "Los puntos para esta jornada se han calculado");
				
				
			}
			
		});
		
		btnPuntuar.setBounds(451, 44, 89, 23);
		getContentPane().add(btnPuntuar);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{

				Statement st=null;
				st=BasesDeDatos.getStatement();
				int puntosJornada1=0;
				int puntosTotales1=0;
				int suma=0;
				
				
				
				for(int i=1;i<75;i++)
				{
					ResultSet puntosJornada;
					ResultSet puntosTotales;
					try {
						puntosJornada = st.executeQuery("select puntosJornada from jugadores" +" where (id='"+i+"')" );
						ResultSetMetaData rsmd1 = puntosJornada.getMetaData();
						int columnCount1 = rsmd1.getColumnCount();
						
						
						puntosTotales = st.executeQuery("select puntosTotales from jugadores" +" where (id='"+i+"')" );
						ResultSetMetaData rsmd2 = puntosJornada.getMetaData();
						int columnCount2 = rsmd2.getColumnCount();
						
						
						while(puntosJornada.next())
						{
							
						puntosJornada1=puntosJornada.getInt(columnCount1);
						puntosTotales1=puntosTotales.getInt(columnCount2);
						suma=puntosTotales1+puntosJornada1;
						
						String sentencia="update jugadores set  puntosTotales='"+suma+"'where id='"+i+"'";
						st.executeUpdate(sentencia);
						String sentencia1="update jugadores set  puntosJornada='0'where id='"+i+"'";
						st.executeUpdate(sentencia1);
						} 
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
				
				JOptionPane.showMessageDialog(null, "Los puntos de esta jornada ya se han actualizado en los puntos totales de cada jugador");
				
				
				
			}
		});
		label.setIcon(new ImageIcon(Administrador.class.getResource("/ud/prog3/Comunio/img/Button Fast Forward.png")));
		label.setBounds(464, 167, 39, 30);
		getContentPane().add(label);
		
		JLabel lblProximaJornada = new JLabel("Proxima Jornada");
		lblProximaJornada.setBounds(457, 140, 103, 14);
		getContentPane().add(lblProximaJornada);
		
		
		Statement st=BasesDeDatos.getStatement();
		String jugadores="";
		try {
			jugadores="select * from jugadores";
			ResultSet rs=st.executeQuery(jugadores);
			
			
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int columnCount = rsmd.getColumnCount();
			while(rs.next())
			{
				jugador=new Jugador();
				
				jugador.setNombre(rs.getString("nombre"));
				jugador.setEdad(rs.getInt("edad"));
				jugador.setEquipo(rs.getString("equipo"));
				jugador.setId(rs.getString("id"));
				jugador.setPuntosJornada(rs.getInt("puntosJornada"));
				jugador.setPuntosTotales(rs.getInt("puntosTotales"));
				jugador.setPosicion(rs.getString("posicion"));
				
				
				
			modelo.addElement(rs.getString("nombre")+"  ");
			
			listaJ.add(jugador);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<listaJ.size();i++)
		{
			System.out.println(listaJ.get(i).getNombre());
		}
	}
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
