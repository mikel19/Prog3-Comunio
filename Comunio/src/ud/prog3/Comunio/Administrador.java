package ud.prog3.Comunio;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;
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
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Administrador extends JFrame implements ActionListener, ListSelectionListener
{

/**
 * 
 */
private static final long serialVersionUID = 1L;
private JTextField textFieldNombre;
private JTextField textFieldEquipo;
private JTextField textFieldPosicion;
private JTextField textFieldPuntosJornada;
private JTextField textFieldPuntosTotales;
JList <DefaultListModel>lista ;
DefaultListModel modelo;
JLabel lblNombre_1;
JLabel lblEquipo_1;
JLabel lblPosicion_1;
JLabel lblAdd ;
JLabel labelAñadir;
Statement st=null;
JLabel lblEdad;
JLabel lblEdad_1;
JSpinner spinner;
ArrayList<Jugador>listaJ;
ArrayList puntosJornada;
Jugador jugador;
private JTextField textFieldNNombre;
private JTextField TextFieldNEquipo;
private JTextField textFieldNPosicion;
private JTextField textFieldEdad;


	public Administrador() {
		setBounds(new Rectangle(0, 0, 2147483647, 2147483647));
		setTitle("ADMINISTRADOR DE LA COMUNIDAD ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Administrador.class.getResource("/ud/prog3/Comunio/img/comunioIcono.jpg")));
		setBackground(new Color(0,128,0));
		getContentPane().setLayout(null);
		
		listaJ=new ArrayList<Jugador>();
		
		añadirJugadoresALista();
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 11, 316, 631);
		getContentPane().add(scrollPane);
		
		
		lista = new JList<DefaultListModel>();
		
		modelo=new DefaultListModel();
		lista.setModel(modelo);
		
		scrollPane.setViewportView(lista);
		
		lista.addListSelectionListener(this);
		JLabel lblEstosSonLos = new JLabel("Estos son los jugadores que hay");
		lblEstosSonLos.setBounds(441, 11, 217, 14);
		getContentPane().add(lblEstosSonLos);
		
		 JButton btnPuntuar = new JButton("PUNTUAR");
		btnPuntuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				Statement st=null;
				st=BasesDeDatos.getStatement();
				BasesDeDatos.crearTablaPuntosJornada();
				int puntosEstaJornada=0;
				puntosJornada=new ArrayList();
				
				listaJ.clear();
				
				for(int i=1;i<75;i++)
				{
					Random puntos;
					puntos=new Random();
					
					
					
					String sentencia="update jugadores set puntosJornada='"+puntos.nextInt(15)+"' where id='"+i+"'";
					String num=""+i;
					
				
					
					//String PuntosJornada="insert into puntosjornada values ('"+num+"', '"+comprobarJornada()+"', '"+puntos.nextInt(15)+"')";
					

					
					
					
					try {
						st.executeUpdate(sentencia);
						añadirJugadoresALista();
						
						//st.executeUpdate(PuntosJornada);
						
						ResultSet rs=st.executeQuery("select PuntosJornada1 from puntosjornada");
						ResultSetMetaData rsmd1 = rs.getMetaData();
						int columnCount1 = rsmd1.getColumnCount();
						while(rs.next())
						{
						puntosEstaJornada=rs.getInt(columnCount1);
						
						puntosJornada.add(puntosEstaJornada);
						
						
						}
						}
						
					
					
				 catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				if(comprobarPuntos(puntosJornada)==true)
				{
					String alterarTable="alter table puntosjornada add PuntosJornada"+comprobarJornada()+"";
					try {
						st.executeUpdate(alterarTable);
						
						for(int i=1;i<75;i++)
						{
							
							
							
							
							String puntosACero="update puntosjornada set PuntosJornada"+comprobarJornada()+"='"+0+"' where "+i+"= '"+null+"'";
							st.executeUpdate(puntosACero);
						
					  }
						
						
						
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
		
		labelAñadir = new JLabel("");
		labelAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{

				labelAñadir.setIcon(new ImageIcon(Administrador.class.getResource("/ud/prog3/Comunio/img/Button Fast Forward-CL.png")));
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
						
						añadirJugadoresALista();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
				
				JOptionPane.showMessageDialog(null, "Los puntos de esta jornada ya se han actualizado en los puntos totales de cada jugador");
				
				dispose();
				
			}
		});
		labelAñadir.setIcon(new ImageIcon(Administrador.class.getResource("/ud/prog3/Comunio/img/Button Fast Forward.png")));
		labelAñadir.setBounds(464, 167, 39, 30);
		getContentPane().add(labelAñadir);
		
		JLabel lblProximaJornada = new JLabel("Proxima Jornada");
		lblProximaJornada.setBounds(457, 140, 103, 14);
		getContentPane().add(lblProximaJornada);
		
		JLabel lblEstosSonLos_1 = new JLabel("Estos son los datos del jugador que has seleccionado");
		lblEstosSonLos_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEstosSonLos_1.setBounds(382, 248, 406, 14);
		getContentPane().add(lblEstosSonLos_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(378, 285, 60, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(598, 285, 46, 14);
		getContentPane().add(lblEquipo);
		
		JLabel lblPosicion = new JLabel("Posicion");
		lblPosicion.setBounds(784, 285, 60, 14);
		getContentPane().add(lblPosicion);
		
		JLabel lblPuntosDeEsta = new JLabel("Puntos de esta Jornada");
		lblPuntosDeEsta.setBounds(1031, 285, 149, 14);
		getContentPane().add(lblPuntosDeEsta);
		
		JLabel lblPuntosTotales = new JLabel("Puntos Totales");
		lblPuntosTotales.setBounds(1209, 285, 95, 14);
		getContentPane().add(lblPuntosTotales);
		
		textFieldNombre = new JTextField();
		
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(362, 328, 141, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldEquipo = new JTextField();
		textFieldEquipo.setEditable(false);
		textFieldEquipo.setColumns(10);
		textFieldEquipo.setBounds(529, 328, 190, 20);
		getContentPane().add(textFieldEquipo);
		
		textFieldPosicion = new JTextField();
		textFieldPosicion.setEditable(false);
		textFieldPosicion.setColumns(10);
		textFieldPosicion.setBounds(758, 328, 103, 20);
		getContentPane().add(textFieldPosicion);
		
		textFieldPuntosJornada = new JTextField();
		textFieldPuntosJornada.setEditable(false);
		textFieldPuntosJornada.setColumns(10);
		textFieldPuntosJornada.setBounds(1067, 328, 86, 20);
		getContentPane().add(textFieldPuntosJornada);
		
		textFieldPuntosTotales = new JTextField();
		textFieldPuntosTotales.setEditable(false);
		textFieldPuntosTotales.setColumns(10);
		textFieldPuntosTotales.setBounds(1203, 328, 86, 20);
		getContentPane().add(textFieldPuntosTotales);
		
		JLabel lblquieresAadirUn = new JLabel("\u00BFQuieres a\u00F1adir un jugador?");
		lblquieresAadirUn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblquieresAadirUn.setBounds(382, 406, 239, 14);
		getContentPane().add(lblquieresAadirUn);
		
		lblAdd = new JLabel("");
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				lblNombre_1.setVisible(true);
				lblEquipo_1.setVisible(true);
				lblPosicion_1.setVisible(true);
				lblEdad_1.setVisible(true);
				textFieldNNombre.setVisible(true);
				TextFieldNEquipo.setVisible(true);
				textFieldNPosicion.setVisible(true);
				spinner.setVisible(true);
				
				lblAdd.setIcon(new ImageIcon(Administrador.class.getResource("/ud/prog3/Comunio/img/Button Add-CL.png")));
				
				repaint();
				
			}
			
		});
		lblAdd.setIcon(new ImageIcon(Administrador.class.getResource("/ud/prog3/Comunio/img/Button Add.png")));
		lblAdd.setBounds(382, 447, 39, 30);
		getContentPane().add(lblAdd);
		
		lblNombre_1 = new JLabel("Nombre ");
		lblNombre_1.setBounds(499, 441, 61, 14);
		getContentPane().add(lblNombre_1);
		lblNombre_1.setVisible(false);
		
		lblEquipo_1 = new JLabel("Equipo");
		lblEquipo_1.setBounds(499, 484, 61, 14);
		getContentPane().add(lblEquipo_1);
		lblEquipo_1.setVisible(false);
		
		lblPosicion_1 = new JLabel("Posicion");
		lblPosicion_1.setBounds(499, 527, 61, 14);
		getContentPane().add(lblPosicion_1);
		lblPosicion_1.setVisible(false);
		
		textFieldNNombre = new JTextField();
		textFieldNNombre.setBounds(594, 437, 194, 23);
		getContentPane().add(textFieldNNombre);
		textFieldNNombre.setColumns(10);
		textFieldNNombre.setVisible(false);
		
		TextFieldNEquipo = new JTextField();
		TextFieldNEquipo.setColumns(10);
		TextFieldNEquipo.setBounds(594, 475, 194, 23);
		getContentPane().add(TextFieldNEquipo);
		TextFieldNEquipo.setVisible(false);
		
		textFieldNPosicion = new JTextField();
		textFieldNPosicion.setColumns(10);
		textFieldNPosicion.setBounds(594, 518, 194, 23);
		getContentPane().add(textFieldNPosicion);
		textFieldNPosicion.setVisible(false);
		
		JButton btnAadir = new JButton("A\u00D1ADIR");
		btnAadir.setBounds(890, 511, 160, 30);
		getContentPane().add(btnAadir);
		btnAadir.addActionListener(this);
		btnAadir.setActionCommand("anyadir");
		
		lblEdad_1 = new JLabel("Edad");
		lblEdad_1.setBounds(499, 572, 46, 14);
		getContentPane().add(lblEdad_1);
		lblEdad_1.setVisible(false);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 40, 1));
		spinner.setBounds(594, 569, 29, 20);
		getContentPane().add(spinner);
		spinner.setVisible(false);
		
		lblEdad= new JLabel("Edad");
		lblEdad.setBounds(933, 285, 46, 14);
		getContentPane().add(lblEdad);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setEditable(false);
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(896, 328, 103, 20);
		getContentPane().add(textFieldEdad);
		
		
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
				
//				jugador.setNombre(rs.getString("nombre"));
//				jugador.setEdad(rs.getInt("edad"));
//				jugador.setEquipo(rs.getString("equipo"));
//				jugador.setId(rs.getString("id"));
//				jugador.setPuntosJornada(rs.getInt("puntosJornada"));
//				jugador.setPuntosTotales(rs.getInt("puntosTotales"));
//				jugador.setPosicion(rs.getString("posicion"));
				
				
				
				jugador.setNombre(rs.getString(2));
				jugador.setEdad(rs.getInt(5));
				jugador.setEquipo(rs.getString(3));
				jugador.setId(rs.getString(1));
				jugador.setPuntosJornada(rs.getInt(6));
				jugador.setPuntosTotales(rs.getInt(7));
				jugador.setPosicion(rs.getString(4));
				
				
				
			modelo.addElement(rs.getString("nombre")+"  ");
			
			listaJ.add(jugador);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	
		
		
		
		
		
	}
	
	


	
	@Override
	public void valueChanged(ListSelectionEvent arg0) 
	{
		
		int pos=0;
		if(arg0.getValueIsAdjusting()==false)
		{
			añadirJugadoresALista();
			pos=lista.getSelectedIndex();
			
			textFieldNombre.setText(""+listaJ.get(pos).getNombre());
			textFieldEquipo.setText(""+listaJ.get(pos).getEquipo());
			textFieldPosicion.setText(""+listaJ.get(pos).getPosicion());
			textFieldPuntosJornada.setText(""+listaJ.get(pos).getPuntosJornada());
			textFieldPuntosTotales.setText(""+listaJ.get(pos).getPuntosTotales());
			textFieldEdad.setText(""+listaJ.get(pos).getEdad());
			
			
			
			
		
			
			repaint();
			
			
			
		}
		
	}





	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
		case "anyadir":
			
			String jugadores="select * from jugadores";
			
			st=BasesDeDatos.getStatement();
			String sentencia="";
			sentencia="insert into jugadores values("+checkearId() +", '"+textFieldNNombre.getText()+"', '"+TextFieldNEquipo.getText()+"', '"+textFieldNPosicion.getText()+"', '"+(int)spinner.getValue()+"', '0', '0')";
			 
			try {
				st.executeUpdate(sentencia);
//				ResultSet rs=st.executeQuery(jugadores);
				
				
				modelo.addElement(textFieldNNombre.getText());
				
				
			}
				 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		JOptionPane.showMessageDialog(this, "Jugador "+textFieldNNombre.getText()+" añadido correctamente");
		
		textFieldNombre.setText("");
		textFieldEquipo.setText("");
		textFieldPosicion.setText("");
		textFieldPuntosJornada.setText("");
		textFieldPuntosTotales.setText("");
		textFieldEdad.setText("");
			
		repaint();
		
		
		
		
		
			
		}
		
	}





	private int checkearId()
	{
		añadirJugadoresALista();
		return listaJ.size();
	}





	private void añadirJugadoresALista() 
	{
		st=BasesDeDatos.getStatement();
		listaJ.clear();
		
		try {
			ResultSet rs=st.executeQuery("select * from jugadores");
			
			Jugador jugador=new Jugador();
			while(rs.next())
			{
				
				jugador=new Jugador();
				

				jugador.setNombre(rs.getString(2));
				jugador.setEdad(rs.getInt(5));
				jugador.setEquipo(rs.getString(3));
				jugador.setId(rs.getString(1));
				jugador.setPuntosJornada(rs.getInt(6));
				jugador.setPuntosTotales(rs.getInt(7));
				jugador.setPosicion(rs.getString(4));
				
				listaJ.add(jugador);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean comprobarPuntos(ArrayList puntos)
	{
		int contador=0;
		boolean comprobacion=true;
		
		for(int i=0;i<puntos.size();i++)
		{
			if((int)puntos.get(i)==0)
			{
				contador++;
			}
				
				
		}
		if(contador==puntos.size())
		{
			comprobacion=false;
		}
		
		
		return comprobacion;
		
	}
	
	public int comprobarJornada()
	{
		ResultSet rs;
		int jornada=1;
		try {
			rs = st.executeQuery("select numJornada from puntosjornada");
			ResultSetMetaData rsmd1 = rs.getMetaData();
			int columnCount1 = rsmd1.getColumnCount();
			
			while(rs.next())
			{
				
					jornada=rs.getInt(columnCount1)+1;
					break;
				
					
				
				
				
			}
			
		} catch (SQLException e) {
			
		}
		
		return jornada;
		
	}
	
	
	
	
}
