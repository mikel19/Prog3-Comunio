package ud.prog3.Comunio;

import java.awt.EventQueue;

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

public class InternalClasificacion extends JInternalFrame {
	private String[][] datos={{"lope","12","233"},};
	private String [] cabeceras={"id","puntos jornada","puntos totales"};
	private static JTable table;
static String total;
static Statement st=null;
private JTable tabla;
private String[][]datos2= {{"1","juan","addas","Aasdasd"}};
ArrayList<String>id=new ArrayList<String>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InternalClasificacion frame = new InternalClasificacion();
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
	public InternalClasificacion() {
		
		
		
		for(int i=0;i<idjugador().size();i++){
			id.add(idjugador().get(i));
			
		}
		BasesDeDatos.crearTablaClasificacion();
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {

		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
					
					
				
				
			},
			
	
		 
			new String[] {
				"Posicion", "ID", "PuntosJornada", "PuntosTotales"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		JScrollPane scrol=new JScrollPane();
		
		
		ArrayList<String>posicionlista=new ArrayList<String>();
		for(int i=0;i<posicion().size();i++){
			posicionlista.add(posicion().get(i));
		}
		
		int numcolumns=table.getModel().getColumnCount();
		Object[]fila=new Object[numcolumns];
		
		
		
	int Puntostotales=0;
//	Puntostotales=Integer.parseInt(VentanaAlineacion.valor2())+Puntostotales;
//	 total=String.valueOf(Puntostotales);
	 for(int i=0;i<id.size();i++){
		 fila[1]=idjugador(); 
	 }
				
	fila[0]=posicion();
	
	fila[2]=VentanaAlineacion.valor2();
//	fila[3]=total;
	
	
	
		((DefaultTableModel)table.getModel()).addRow(fila);
		
		

		guardarclasificacion();

	}
	
	public void guardarclasificacion(){
	
		
		st=BasesDeDatos.getStatement();
		boolean resultado=true;
		String posicion="";
		ResultSet nombre;
		try {
			nombre = st.executeQuery("select idJugador from clasificacion");
			ResultSetMetaData rsmd = nombre.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while(nombre.next())
			{
				posicion=nombre.getString(columnCount);
				if(posicion==VentanaAlineacion.valor1()){
					resultado=false;
				}
				else{
					resultado=true;
				}
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(resultado=true){
		String sentSQL="insert into clasificacion values ('"+"1"+"','"+VentanaAlineacion.valor1()+"','"+VentanaAlineacion.valor2()+"','"+total+"')";
		try {
			st.executeUpdate(sentSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			
		}
		
			
	
		
	
	}
	
public static ArrayList<String> posicion() {

		
		ArrayList<String>lista=new ArrayList<String>();

	
		
		
		st=BasesDeDatos.getStatement();
		String posicion="";
		ResultSet nombre;
		try {
			nombre = st.executeQuery("select Posicion from clasificacion");
			ResultSetMetaData rsmd = nombre.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while(nombre.next())
			{
				posicion=nombre.getString(columnCount);
				lista.add(posicion);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return lista;
		
	}
public static ArrayList<String> idjugador(){
		
		
		
		
ArrayList <String>id=new ArrayList<String>();
	
		
		
		st=BasesDeDatos.getStatement();
		String posicion2="";
		ResultSet nombre2;
		try {
			nombre2 = st.executeQuery("select idJugador from clasificacion");
			ResultSetMetaData rsmd2 = nombre2.getMetaData();
			int columnCount2 = rsmd2.getColumnCount();
			while(nombre2.next())
			{
				posicion2=nombre2.getString(columnCount2);
				id.add(posicion2);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
		
		return id;
	}
//public void valor2(){
//	
//	
//	  String matris[][]=new String [id.size()][4];
//	  for(int i=0;i<id.size();i++){
//	  
//	  matris[i][2]=id.get(i);
//	  }
//	
//}

}
