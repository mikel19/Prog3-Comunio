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

public class InternalClasificacion extends JInternalFrame {
	private String[][] datos={{"lope","12","233"},};
	private String [] cabeceras={"id","puntos jornada","puntos totales"};
	private static JTable table;
static String total;
static Statement st=null;
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
		
		int numcolumns=table.getModel().getColumnCount();
		Object[]fila=new Object[numcolumns];
		
		
		
	int Puntostotales=0;
	Puntostotales=Integer.parseInt(VentanaAlineacion.valor2())+Puntostotales;
	 total=String.valueOf(Puntostotales);
				
	fila[0]=valor1();
//	fila[1]=VentanaAlineacion.valor1();
//	fila[2]=VentanaAlineacion.valor2();
//	fila[3]=total;
	
	
	
		((DefaultTableModel)table.getModel()).addRow(fila);
		guardarclasificacion();

	}
	
	public void guardarclasificacion(){
	
		BasesDeDatos.crearTablaClasificacion();;
		st=BasesDeDatos.getStatement();
		
		String sentSQL="insert into clasificacion values ('"+"1"+"','"+VentanaAlineacion.valor1()+"','"+VentanaAlineacion.valor2()+"','"+total+"')";
		
		try {
			st.executeUpdate(sentSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sentSQL);
	}
	public static String valor1() {
		int numcolumns=table.getModel().getColumnCount();
		Object[]fila=new Object[numcolumns];
		
		
		


	
	
	
		
		
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
				fila[0]=posicion;
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		((DefaultTableModel)table.getModel()).addRow(fila);
		
		
		return posicion;
		
	}
	

}
