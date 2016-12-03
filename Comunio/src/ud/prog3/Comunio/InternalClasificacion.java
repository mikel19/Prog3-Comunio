package ud.prog3.Comunio;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.FlowLayout;

public class InternalClasificacion extends JInternalFrame {
	private JTable tabla;
	private String[][] datos={{"lope","12","233"},};
	private String [] cabeceras={"id","puntos jornada","puntos totales"};

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
		setBounds(100, 100, 450, 300);

		tabla=new JTable(datos, cabeceras);
		tabla.setBounds(29, 53, 225, 16);
		JScrollPane scrol=new JScrollPane();
		getContentPane().setLayout(null);
		
		getContentPane().add(tabla);
	

	}
	
	
}
