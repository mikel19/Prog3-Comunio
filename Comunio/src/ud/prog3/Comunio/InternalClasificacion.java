package ud.prog3.Comunio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class InternalClasificacion extends JFrame {
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
//	private String[][] datos={{"lope","12","233"},};
//	private String [] cabeceras={"id","puntos jornada","puntos totales"};
//	private static JTable table;
//static String total;
Statement st=null;
//private JTable tabla;
//private String[][]datos2= {{"1","juan","addas","Aasdasd"}};
//ArrayList<String>id=new ArrayList<String>();


ArrayList usuarios;
UsuarioJugador usu;
ArrayList<Jugador> jugadores;
ArrayList <Jugador>puntosJugadores;
ArrayList  <Jugador>puntosCadaUsuario;
ArrayList <UsuarioJugador> definitivo;
ArrayList <UsuarioJugador> usuj;
ArrayList<UsuarioJugador> ordenados;
Jugador jugador;
int suma=0;
int cantidad=0;
	int puntosTotalUsuario=0;
	 
	public InternalClasificacion()
	 {
	setBounds(300,300,300,300);
		
		jugadores=new ArrayList<Jugador>();
		puntosJugadores=new ArrayList<Jugador>();
		puntosCadaUsuario=new ArrayList<Jugador>();
		jugador=new Jugador();
		usuj=new ArrayList <UsuarioJugador>();
		definitivo=new ArrayList <UsuarioJugador>();
		usu=new UsuarioJugador();
		usuarios=new ArrayList();
		
		cargarUsuariosJugadores();
		cargarUsuarios();
		puntosCadaJugador();
		calcularPuntosTotalesCadaUsuario();
		Collections.sort(definitivo);
//		ordenar();
		
		
		//creamos el arreglo de objetos que contendra el
		//contenido de las columnas
		Object[] data = new Object[3];
		// creamos el modelo de Tabla
		
		DefaultTableModel dtm= new DefaultTableModel();
		// se crea la Tabla con el modelo DefaultTableModel
		final JTable table = new JTable(dtm);
		// insertamos las columnas
		for(int column = 1; column < 4; column++){
			if(column==1){
				dtm.addColumn("posicion");
			}
			if(column==2){
				dtm.addColumn("ID jugador");
			}
			if(column==3){
				dtm.addColumn("Puntos Totales");
			}
//		dtm.addColumn("Columna " + column);
		}
		for(int i=0;i<definitivo.size();i++){
			System.out.println("tamaño"+definitivo.get(i).getIdUsuario());
		}
		// insertamos el contenido de las columnas
//		for(int row = 0; row < definitivo.size(); row++) {
			for(int i=0;i<definitivo.size();i++){
		data[0]=i+1;
		data[1] = definitivo.get(i).getIdUsuario();
		data[2]=definitivo.get(i).getPuntosTotales();
		
		dtm.addRow(data);
			}
			
		
		
		
	
//		}
		//se define el tamaño
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(table);
		//Agregamos el JScrollPane al contenedor
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		//manejamos la salida
	
		
	
		
		
		
	
		
		
		
	 }

	 








		private void cargarUsuarios()
		{
			
			String sentencia="select * from usuarios";
			st=BasesDeDatos.getStatement();
			
			try {
				ResultSet rs=st.executeQuery(sentencia);
				
				while(rs.next())
				{
					usuarios.add(rs.getString("numIdentificador"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}










		private void calcularPuntosTotalesCadaUsuario() 
	    {
			

			for(int i=0;i<usuarios.size();i++)
			{
				usu=new UsuarioJugador();
				
				
				
					usu.setIdUsuario((String)usuarios.get(i));
					usu.setPuntosTotales(damePuntosUsuario((String)usuarios.get(i)));
					definitivo.add(usu);
				
			}
			
			for(int i=0;i<definitivo.size();i++)
			{
				System.out.println(definitivo.get(i).getIdUsuario()+": "+definitivo.get(i).getPuntosTotales());
			}
			
			
			} 
			
					
					
		
	    



		
	





		private int damePuntosUsuario(String idUsuario)
		{
			int contadorPuntos=0;
			for(int i=0;i<usuj.size();i++)
			{
				if(idUsuario.equalsIgnoreCase(usuj.get(i).getIdUsuario()))
						{
						contadorPuntos=contadorPuntos+jugadores.get(i).getPuntosTotales();
						}
			}
			
			return contadorPuntos;
			
			
		}










		private void puntosCadaJugador() 
	    {
	    	st=BasesDeDatos.getStatement();
	    	
	    	String sentencia="select * from jugadores";
	    	
	    	try {
				ResultSet rs=st.executeQuery(sentencia);
				while(rs.next())
				{
				jugador=new Jugador();
				jugador.setId(rs.getString("id"));
				jugador.setPuntosTotales(rs.getInt("puntosTotales"));
				
				puntosJugadores.add(jugador);
				}
				
				
				for(int i=0;i<jugadores.size();i++)
				{
						for(int e=0;e<puntosJugadores.size();e++)
						{
							
							if((jugadores.get(i).getId()).compareTo(puntosJugadores.get(e).getId())==0)
							{
								
								jugadores.get(i).setPuntosTotales(puntosJugadores.get(e).getPuntosTotales());
								
							}
							
						}
				}
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
		
		
	}





		private void cargarUsuariosJugadores()
	    {
		st=BasesDeDatos.getStatement();
		String sentencia="select * from usuariojugadores";
		
		
		
		try {
			ResultSet rs=st.executeQuery(sentencia);
			
			
			while(rs.next())
			{
				usu=new UsuarioJugador();
				
				usu.setIdUsuario(rs.getString("idUsuario"));
				usu.setIdJugador(rs.getString("idJugador"));
				usuj.add(usu);
				
				jugador=new Jugador();
//			usuarios.add(rs.getString("idUsuario"));
			jugador.setId(rs.getString("idJugador"));
			jugadores.add(jugador);
			
			
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
//		public void ordenar(){
//	ArrayList<UsuarioJugador>ayuda=new ArrayList<UsuarioJugador>();
//		for(int i=0;i<(definitivo.size()-1);i++){
//			for(int z=0;z<definitivo.size();z++){
//		if(definitivo.get(i).getPuntosTotales()>definitivo.get(z).getPuntosTotales()){
//			
////				ayuda.add(definitivo.get(i));
//		
//		}
//		if(definitivo.get(i).getPuntosTotales()<definitivo.get(z).getPuntosTotales()){
//			
//		ayuda.add(i,definitivo.get(i));
//		definitivo.remove(i);
//		definitivo.get(i).setIdUsuario(definitivo.get(z).getIdUsuario());
//		definitivo.get(i).setPuntosTotales(definitivo.get(z).getPuntosTotales());
//		
//		
//		definitivo.get(z).setIdUsuario(ayuda.get(i).getIdUsuario());
//		definitivo.get(z).setPuntosTotales(ayuda.get(i).getPuntosTotales());
//		
//		}	
//			}
//			
//		}
//			
//			
//			
//		}
//			
//		
//		
//		
//		
//		
//			
//			
		}
		
//		private void printDebugData(JTable table) {
//	        int numRows = table.getRowCount();
//	        int numCols = table.getColumnCount();
//	        javax.swing.table.TableModel model = table.getModel();
//	 
//	        System.out.println("Value of data: ");
//	        for (int i=0; i < numRows; i++) {
//	            System.out.print("    row " + i + ":");
//	            for (int j=0; j < numCols; j++) {
//	                System.out.print("  " + model.getValueAt(i, j));
//	            }
//	            System.out.println();
//	        }
//	        System.out.println("--------------------------");
//	    }
//		
		
		
		
		
		
		
		
//		
//		for(int i=0;i<idjugador().size();i++){
//			id.add(idjugador().get(i));
//			
//		}
//		//BasesDeDatos.crearTablaClasificacion();
//		
//		setBounds(100, 100, 450, 300);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.addMouseListener(new MouseAdapter() {
//
//		});
//		GroupLayout groupLayout = new GroupLayout(getContentPane());
//		groupLayout.setHorizontalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGroup(groupLayout.createSequentialGroup()
//					.addGap(29)
//					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
//					.addContainerGap())
//		);
//		groupLayout.setVerticalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGroup(groupLayout.createSequentialGroup()
//					.addGap(24)
//					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
//					.addContainerGap())
//		);
//		
//		table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//					
//					
//				
//				
//			},
//			
//	
//		 
//			new String[] {
//				"Posicion", "ID", "PuntosJornada", "PuntosTotales"
//			}
//		));
//		scrollPane.setViewportView(table);
//		getContentPane().setLayout(groupLayout);
//		JScrollPane scrol=new JScrollPane();
//		
//		
//		ArrayList<String>posicionlista=new ArrayList<String>();
//		for(int i=0;i<posicion().size();i++){
//			posicionlista.add(posicion().get(i));
//		}
//		
//		int numcolumns=table.getModel().getColumnCount();
//		Object[]fila=new Object[numcolumns];
//		
//		
//		
//	int Puntostotales=0;
////	Puntostotales=Integer.parseInt(VentanaAlineacion.valor2())+Puntostotales;
////	 total=String.valueOf(Puntostotales);
//	 for(int i=0;i<id.size();i++){
//		 fila[1]=idjugador(); 
//	 }
//				
//	fila[0]=posicion();
//	
//	fila[2]=VentanaAlineacion.valor2();
////	fila[3]=total;
//	
//	
//	
//		((DefaultTableModel)table.getModel()).addRow(fila);
//		
//		
//
//		//guardarclasificacion();


	
//	public void guardarclasificacion(){
//	
//		
//		st=BasesDeDatos.getStatement();
//		boolean resultado=true;
//		String posicion="";
//		ResultSet nombre;
//		try {
//			nombre = st.executeQuery("select idJugador from clasificacion");
//			ResultSetMetaData rsmd = nombre.getMetaData();
//			int columnCount = rsmd.getColumnCount();
//			while(nombre.next())
//			{
//				posicion=nombre.getString(columnCount);
//				if(posicion==VentanaAlineacion.valor1()){
//					resultado=false;
//				}
//				else{
//					resultado=true;
//				}
//			
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		if(resultado=true){
//		String sentSQL="insert into clasificacion values ('"+"1"+"','"+VentanaAlineacion.valor1()+"','"+VentanaAlineacion.valor2()+"','"+total+"')";
//		try {
//			st.executeUpdate(sentSQL);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}else{
//			
//		}
//		
//			
//	
		
	
	
	
//public static ArrayList<String> posicion() {
//
//		
//		ArrayList<String>lista=new ArrayList<String>();
//
//	
//		
//		
//		st=BasesDeDatos.getStatement();
//		String posicion="";
//		ResultSet nombre;
//		try {
//			nombre = st.executeQuery("select Posicion from clasificacion");
//			ResultSetMetaData rsmd = nombre.getMetaData();
//			int columnCount = rsmd.getColumnCount();
//			while(nombre.next())
//			{
//				posicion=nombre.getString(columnCount);
//				lista.add(posicion);
//			
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//		return lista;
//		
//	}
//public static ArrayList<String> idjugador(){
//		
//		
//		
//		
//ArrayList <String>id=new ArrayList<String>();
//	
//		
//		
//		st=BasesDeDatos.getStatement();
//		String posicion2="";
//		ResultSet nombre2;
//		try {
//			nombre2 = st.executeQuery("select idJugador from clasificacion");
//			ResultSetMetaData rsmd2 = nombre2.getMetaData();
//			int columnCount2 = rsmd2.getColumnCount();
//			while(nombre2.next())
//			{
//				posicion2=nombre2.getString(columnCount2);
//				id.add(posicion2);
//			
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	
//		
//		
//		return id;
//	}
////public void valor2(){
////	
////	
////	  String matris[][]=new String [id.size()][4];
////	  for(int i=0;i<id.size();i++){
////	  
////	  matris[i][2]=id.get(i);
////	  }
////	
////}
//
//
//
//
//
//@Override
//public String toString() {
//	return ;
//}
//
//

