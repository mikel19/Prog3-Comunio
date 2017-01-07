package ud.prog3.Comunio;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
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

public class Administrador extends JFrame implements ActionListener
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
DefaultListModel modeloUsuarios;
DefaultListModel modeloMercado;
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
ArrayList mercado;
ArrayList usuarios;
ArrayList puntosJornada;
Jugador jugador;
private JTextField textFieldNNombre;
private JTextField TextFieldNEquipo;
private JTextField textFieldNPosicion;
private JTextField textFieldEdad;
private JTextField textFieldPrecio;
private JLabel lblPrecio;
JList listMercado;
JList listUsuarios;
private JLabel lblJugadoresEnMercado;
private JScrollPane scrollPane_2;
JButton btnPuntuar;
JButton btnAadir;
JButton btnEliminarMercado;
JButton btnEliminarUsuarios;


	public Administrador() {
		
		
		BasesDeDatos.crearTablaMercadoDeFichajes();
		BasesDeDatos.crearTablaUsuarios();
		
		
		setBounds(new Rectangle(0, 0, 2147483647, 2147483647));
		setTitle("ADMINISTRADOR DE LA COMUNIDAD ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Administrador.class.getResource("/ud/prog3/Comunio/img/comunioIcono.jpg")));
		setBackground(new Color(0,128,0));
		getContentPane().setLayout(null);
		
		listaJ=new ArrayList<Jugador>();
		
		//añadirJugadoresALista();
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 11, 316, 631);
		getContentPane().add(scrollPane);
		
		
		lista = new JList<DefaultListModel>();
		
		modelo=new DefaultListModel();
		modeloUsuarios=new DefaultListModel();
		modeloMercado=new DefaultListModel();
		
		lista.setModel(modelo);
		
		
		scrollPane.setViewportView(lista);
		
		lista.addListSelectionListener(new ListSelectionListener()
		{

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int pos=0;
				if(e.getValueIsAdjusting()==false)
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
			
		});
		JLabel lblEstosSonLos = new JLabel("Estos son los jugadores que hay");
		lblEstosSonLos.setBounds(378, 13, 217, 14);
		getContentPane().add(lblEstosSonLos);
		
		btnPuntuar = new JButton("PUNTUAR");
		btnPuntuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				Statement st=null;
				st=BasesDeDatos.getStatement();
				
				int puntosEstaJornada=0;
				
				
				
				añadirJugadoresALista();
				
				for(int i=1;i<listaJ.size();i++)
				{
					Random puntos;
					puntos=new Random();
					
					
					
					String sentencia="update jugadores set puntosJornada='"+puntos.nextInt(15)+"' where id='"+i+"'";
					String num=""+i;
					
				
					
					//String PuntosJornada="insert into puntosjornada values ('"+num+"', '"+comprobarJornada()+"', '"+puntos.nextInt(15)+"')";
					

					
					
					
					try {
						st.executeUpdate(sentencia);
						
						
						//st.executeUpdate(PuntosJornada);
//						
//						ResultSet rs=st.executeQuery("select PuntosJornada1 from puntosjornada");
//						ResultSetMetaData rsmd1 = rs.getMetaData();
//						int columnCount1 = rsmd1.getColumnCount();
//						while(rs.next())
//						{
//						puntosEstaJornada=rs.getInt(columnCount1);
//						
//						//puntosJornada.add(puntosEstaJornada);
//						
//						
//						}
						}
						
					
					
				 catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
//				if(comprobarPuntos(puntosJornada)==true)
//				{
//					String alterarTable="alter table puntosjornada add PuntosJornada"+comprobarJornada()+"";
//					try {
//						st.executeUpdate(alterarTable);
//						
//						for(int i=1;i<75;i++)
//						{
//							
//							
//							
//							
//							String puntosACero="update puntosjornada set PuntosJornada"+comprobarJornada()+"='"+0+"' where "+i+"= '"+null+"'";
//							st.executeUpdate(puntosACero);
//						
//					  }
//						
//						
//						
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
				
				JOptionPane.showMessageDialog(null, "Los puntos para esta jornada se han calculado");
				
				
			}
			
		});
		
		btnPuntuar.setBounds(378, 80, 89, 23);
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
				
				
				añadirJugadoresALista();
				
				
				
				for(int i=1;i<listaJ.size();i++)
				{
					listaJ.get(i).setPuntosTotales(listaJ.get(i).getPuntosTotales()+listaJ.get(i).getPuntosJornada());
					try {
						st.executeUpdate("update jugadores set puntosTotales = '"+listaJ.get(i).getPuntosTotales()+"' where id = '"+i+"'");
						st.executeUpdate("update jugadores set puntosJornada = '"+0+"' where id = '"+i+"'");
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
					
//					try {
//						ResultSet puntosJornada = st.executeQuery("select puntosJornada from jugadores" +" where (id='"+i+"')" );
//						ResultSetMetaData rsmd1 = puntosJornada.getMetaData();
//						int columnCount1 = rsmd1.getColumnCount();
//						
//						
//						ResultSet puntosTotales=st.executeQuery("select puntosTotales from jugadores" +" where (id='"+i+"')" );
//						ResultSetMetaData rsmd2 = puntosJornada.getMetaData();
//						int columnCount2 = rsmd2.getColumnCount();
//						
//						
//						while(puntosJornada.next())
//						{
//							
//						puntosJornada1=puntosJornada.getInt(columnCount1);
//						
//						puntosTotales1=puntosTotales.getInt(columnCount2);
//						suma=puntosTotales1+puntosJornada1;
//						
//						String sentencia="update jugadores set puntosTotales = '"+suma+"' where id = '"+i+"'";
//						System.out.println(sentencia);
//						st.executeUpdate(sentencia);
//						String sentencia1="update jugadores set puntosJornada = '0' where id = '"+i+"'";
//						st.executeUpdate(sentencia1);
//						
//						
//						
//						} 
//						
//						añadirJugadoresALista();
//						
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//					
//					
//				}
//				
//				JOptionPane.showMessageDialog(null, "Los puntos de esta jornada ya se han actualizado en los puntos totales de cada jugador");
//				
//				dispose();
//				
			}
		});
		labelAñadir.setIcon(new ImageIcon(Administrador.class.getResource("/ud/prog3/Comunio/img/Button Fast Forward.png")));
		labelAñadir.setBounds(378, 171, 39, 30);
		getContentPane().add(labelAñadir);
		
		JLabel lblProximaJornada = new JLabel("2) PASAR A LA SIGUIENTE JORNADA");
		lblProximaJornada.setBounds(383, 135, 238, 14);
		getContentPane().add(lblProximaJornada);
		
		JLabel lblEstosSonLos_1 = new JLabel("Estos son los datos del jugador que has seleccionado");
		lblEstosSonLos_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEstosSonLos_1.setBounds(394, 424, 406, 14);
		getContentPane().add(lblEstosSonLos_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(394, 472, 60, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(614, 472, 46, 14);
		getContentPane().add(lblEquipo);
		
		JLabel lblPosicion = new JLabel("Posicion");
		lblPosicion.setBounds(800, 472, 60, 14);
		getContentPane().add(lblPosicion);
		
		JLabel lblPuntosDeEsta = new JLabel("Puntos de esta Jornada");
		lblPuntosDeEsta.setBounds(1047, 472, 149, 14);
		getContentPane().add(lblPuntosDeEsta);
		
		JLabel lblPuntosTotales = new JLabel("Puntos Totales");
		lblPuntosTotales.setBounds(1225, 472, 95, 14);
		getContentPane().add(lblPuntosTotales);
		
		textFieldNombre = new JTextField();
		
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(378, 515, 141, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldEquipo = new JTextField();
		textFieldEquipo.setEditable(false);
		textFieldEquipo.setColumns(10);
		textFieldEquipo.setBounds(545, 515, 190, 20);
		getContentPane().add(textFieldEquipo);
		
		textFieldPosicion = new JTextField();
		textFieldPosicion.setEditable(false);
		textFieldPosicion.setColumns(10);
		textFieldPosicion.setBounds(774, 515, 103, 20);
		getContentPane().add(textFieldPosicion);
		
		textFieldPuntosJornada = new JTextField();
		textFieldPuntosJornada.setEditable(false);
		textFieldPuntosJornada.setColumns(10);
		textFieldPuntosJornada.setBounds(1083, 515, 86, 20);
		getContentPane().add(textFieldPuntosJornada);
		
		textFieldPuntosTotales = new JTextField();
		textFieldPuntosTotales.setEditable(false);
		textFieldPuntosTotales.setColumns(10);
		textFieldPuntosTotales.setBounds(1219, 515, 86, 20);
		getContentPane().add(textFieldPuntosTotales);
		
		JLabel lblquieresAadirUn = new JLabel("\u00BFQuieres a\u00F1adir un jugador?");
		lblquieresAadirUn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblquieresAadirUn.setBounds(378, 212, 239, 14);
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
				btnAadir.setVisible(true);
				
				lblAdd.setIcon(new ImageIcon(Administrador.class.getResource("/ud/prog3/Comunio/img/Button Add-CL.png")));
				
				repaint();
				
			}
			
		});
		lblAdd.setIcon(new ImageIcon(Administrador.class.getResource("/ud/prog3/Comunio/img/Button Add.png")));
		lblAdd.setBounds(378, 253, 39, 30);
		getContentPane().add(lblAdd);
		
		lblNombre_1 = new JLabel("Nombre ");
		lblNombre_1.setBounds(495, 247, 61, 14);
		getContentPane().add(lblNombre_1);
		lblNombre_1.setVisible(false);
		
		lblEquipo_1 = new JLabel("Equipo");
		lblEquipo_1.setBounds(495, 290, 61, 14);
		getContentPane().add(lblEquipo_1);
		lblEquipo_1.setVisible(false);
		
		lblPosicion_1 = new JLabel("Posicion");
		lblPosicion_1.setBounds(495, 333, 61, 14);
		getContentPane().add(lblPosicion_1);
		lblPosicion_1.setVisible(false);
		
		textFieldNNombre = new JTextField();
		textFieldNNombre.setBounds(590, 243, 177, 23);
		getContentPane().add(textFieldNNombre);
		textFieldNNombre.setColumns(10);
		textFieldNNombre.setVisible(false);
		
		TextFieldNEquipo = new JTextField();
		TextFieldNEquipo.setColumns(10);
		TextFieldNEquipo.setBounds(590, 281, 177, 23);
		getContentPane().add(TextFieldNEquipo);
		TextFieldNEquipo.setVisible(false);
		
		textFieldNPosicion = new JTextField();
		textFieldNPosicion.setColumns(10);
		textFieldNPosicion.setBounds(590, 324, 177, 23);
		getContentPane().add(textFieldNPosicion);
		textFieldNPosicion.setVisible(false);
		
		btnAadir = new JButton("A\u00D1ADIR");
		btnAadir.setBounds(590, 205, 160, 30);
		getContentPane().add(btnAadir);
		btnAadir.addActionListener(this);
		btnAadir.setActionCommand("anyadir");
		btnAadir.setVisible(false);
		
		lblEdad_1 = new JLabel("Edad");
		lblEdad_1.setBounds(495, 378, 46, 14);
		getContentPane().add(lblEdad_1);
		lblEdad_1.setVisible(false);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 40, 1));
		spinner.setBounds(590, 375, 46, 20);
		getContentPane().add(spinner);
		spinner.setVisible(false);
		
		lblEdad= new JLabel("Edad");
		lblEdad.setBounds(949, 472, 46, 14);
		getContentPane().add(lblEdad);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setEditable(false);
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(912, 515, 103, 20);
		getContentPane().add(textFieldEdad);
		
		JButton btnNewButton = new JButton("A\u00D1ADIR A MERCADO DE FICHAJES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldNombre.getText().isEmpty()==true)
				{
					JOptionPane.showMessageDialog(null, "Por favor, selecciona un jugador para añadir al mercado de fichajes");
					return;
				}
				
				else
				{
					
					if(textFieldPrecio.isVisible()==false)
					{
						JOptionPane.showMessageDialog(null, "Introduce el precio de este jugador");
					textFieldPrecio.setVisible(true);
					lblPrecio.setVisible(true);
					return;
					}
					else
					{
					
					
					
					st=BasesDeDatos.getStatement();
					
					
					
					
					
					String sentencia="insert into mercadoDeFichajes values('"+checkearIdMercado(textFieldNombre.getText())+"' ,'"+textFieldNombre.getText()+"', '"+textFieldPrecio.getText()+"', '"+textFieldPuntosTotales.getText()+"')";
					
					 try {
						 
						 
							st.executeUpdate( sentencia );
							JOptionPane.showMessageDialog(null, textFieldNombre.getText()+" añadido correctamente en el mercado de fichajes" );
							 
							textFieldPrecio.setVisible(false);
							lblPrecio.setVisible(false);
							textFieldPrecio.setText("");
							textFieldNombre.setText("");
							
							modeloMercado.clear();
							cargarJugadoresMercado();
						
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
					
				
				
				}
				}

			
		});
		btnNewButton.setBounds(1025, 565, 280, 23);
		getContentPane().add(btnNewButton);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(803, 565, 177, 23);
		getContentPane().add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setVisible(false);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(715, 565, 66, 23);
		getContentPane().add(lblPrecio);
		
		JLabel lblPulsaEsteBoton = new JLabel("1) PULSA ESTE BOTON PARA PUNTUAR A LOS JUGADORES");
		lblPulsaEsteBoton.setBounds(378, 48, 323, 14);
		getContentPane().add(lblPulsaEsteBoton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(784, 65, 149, 286);
		getContentPane().add(scrollPane_1);
		
		listUsuarios = new JList();
		
		/**
		 * evento de la lista de usuarios. Creoque no es necesaria
		 */
		
		scrollPane_1.setViewportView(listUsuarios);
		listUsuarios.setModel(modeloUsuarios);
		cargarUsuariosRegistrados();
		
		
		JLabel lblListaDeUsuarios = new JLabel("Lista de USUARIOS REGISTRADOS");
		lblListaDeUsuarios.setBounds(784, 27, 215, 14);
		getContentPane().add(lblListaDeUsuarios);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(1067, 65, 177, 286);
		getContentPane().add(scrollPane_2);
		
		listMercado = new JList();
		scrollPane_2.setViewportView(listMercado);
		listMercado.setModel(modeloMercado);
		
		cargarJugadoresMercado();
		
		lblJugadoresEnMercado = new JLabel("Jugadores en MERCADO ");
		lblJugadoresEnMercado.setBounds(1089, 27, 190, 14);
		getContentPane().add(lblJugadoresEnMercado);
		
		btnEliminarUsuarios = new JButton("ELIMINAR ");
		btnEliminarUsuarios.setBounds(943, 93, 95, 23);
		getContentPane().add(btnEliminarUsuarios);
		btnEliminarUsuarios.addActionListener(this);
		btnEliminarUsuarios.setActionCommand("eliminarUsuarios");
		
		btnEliminarMercado = new JButton("ELIMINAR ");
		btnEliminarMercado.setBounds(1265, 93, 95, 23);
		getContentPane().add(btnEliminarMercado);
		btnEliminarMercado.addActionListener(this);
		btnEliminarMercado.setActionCommand("eliminarMercado");
		
		JLabel lblRepartoDineroA = new JLabel("REPARTO DINERO A USUARIOS");
		lblRepartoDineroA.setBounds(391, 598, 177, 14);
		getContentPane().add(lblRepartoDineroA);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
				RepartoDinero newWindow=new RepartoDinero();
				newWindow.setVisible(true);
			
				
				
			}
		});
		label.setForeground(Color.GRAY);
		label.setIcon(new ImageIcon(Administrador.class.getResource("/ud/prog3/Comunio/img/dinero.png")));
		label.setBounds(394, 634, 66, 58);
		getContentPane().add(label);
		
		lblPrecio.setVisible(false);
		
		cargarJugadoresEnLista();
	
		
	
		
		
		
		
		
	}
	
	


	
	private void cargarJugadoresEnLista() 
	{
		 st=BasesDeDatos.getStatement();
			String jugadores="";
			try {
				jugadores="select * from jugadores";
				ResultSet rs=st.executeQuery(jugadores);
				
				
				
//				ResultSetMetaData rsmd = rs.getMetaData();
//				int columnCount = rsmd.getColumnCount();
				while(rs.next())
				{
					jugador=new Jugador();
					
//					jugador.setNombre(rs.getString("nombre"));
//					jugador.setEdad(rs.getInt("edad"));
//					jugador.setEquipo(rs.getString("equipo"));
//					jugador.setId(rs.getString("id"));
//					jugador.setPuntosJornada(rs.getInt("puntosJornada"));
//					jugador.setPuntosTotales(rs.getInt("puntosTotales"));
//					jugador.setPosicion(rs.getString("posicion"));
					
					
					
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





	private void cargarUsuariosRegistrados()
	{
		st=BasesDeDatos.getStatement();
		usuarios=new ArrayList();
		
		String sentencia="select * from usuarios";
		
		try
		{
			ResultSet rs=st.executeQuery(sentencia);
			
			while(rs.next())
			{
				modeloUsuarios.addElement(rs.getString("id"));
				usuarios.add(rs.getInt("numIdentificador"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}





	





	private void cargarJugadoresMercado() 
	{
		mercado=new ArrayList();
		st=BasesDeDatos.getStatement();
		String sentencia="select * from mercadodefichajes";
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			
			while(rs.next())
			{
				modeloMercado.addElement(rs.getString("nombre"));
				mercado.add(rs.getString("idJugador") +" ");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}





	
	public int testJugadoresEnBaseDatos(ArrayList <Jugador>lista,Statement st)
	{
		st=BasesDeDatos.getStatement();
		lista.clear();
		
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
				
				lista.add(jugador);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista.size();
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
		break;
		
		case "eliminarUsuarios":
			
			if(listUsuarios.isSelectionEmpty())
			{
				JOptionPane.showMessageDialog(null, "Por favor, selecciona un Usuario de la lista para poder eliminarlo");
				break;
			}
			else
			{
				if(listUsuarios.isSelectionEmpty()==false)
				{
					String value=listUsuarios.getSelectedValue()+"";
					eliminarUsuario(value, listUsuarios.getSelectedIndex());
					
					
				}
			}
			
			repaint();
			break;
			
		case "eliminarMercado":
		
			if(listMercado.isSelectionEmpty())
			{
				JOptionPane.showMessageDialog(null, "Por favor, selecciona un jugador de la lista para poder eliminarlo del mercado");
				break;
			}
			else
			{
				if(listMercado.isSelectionEmpty()==false)
				{
					String valor=(String) listMercado.getSelectedValue();
					eliminarMercado(valor, listMercado.getSelectedIndex());
					
					
				}
			}
			
			repaint();
			break;
		
		
		
			
		}
		
	}





	




	private void eliminarMercado(String valor, int selectedIndex)
	{
		st=BasesDeDatos.getStatement();
		
		String sentencia="DELETE FROM mercadodefichajes WHERE nombre = '"+valor+"'";
		System.out.println(sentencia);
		try {
			st.executeUpdate(sentencia);
			modeloMercado.remove(selectedIndex);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		repaint();
	}





	





	private void eliminarUsuario(String value, int i)
	{
		st=BasesDeDatos.getStatement();
		
		String sentencia="DELETE FROM usuarios WHERE id = '"+value+"'";
		
		System.out.println(sentencia);
		try {
			
			st.executeUpdate(sentencia);
			modeloUsuarios.remove(i);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		repaint();
	}





	




	private int checkearId()
	{
		añadirJugadoresALista();
		return listaJ.size();
	}
	
	private String checkearIdMercado(String nombre)
	{
		String id="";
		añadirJugadoresALista();
		
		for(int i=0;i<listaJ.size();i++)
		{
			if(nombre.equals(listaJ.get(i).getNombre()))
			{
				id=listaJ.get(i).getId();
				break;
				
			}
		}
		
		return id;
		
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
}
