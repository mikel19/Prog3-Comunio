package ud.prog3.Comunio;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MercadoFichajes extends JInternalFrame  {

	/**
	 * Launch the application.
	 */
	String [] columnNames={"ID",
			  "Nombre",
			  "Equipo",
			  "Valor",
			  "puja"};
		Object[][] data = {
				{"Kathy", "Smith",
					"Snowboarding","122222", ""},
				{"John", "Doe",
						"Rowing", "122222", ""},
				{"Sue", "Black",
					"Knitting", "122222", ""},
					{"Jane", "White",
					"Speed reading", "122222", ""},
				{"Joe", "Brown",
					"Pool", "122222", ""}
						};
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MercadoFichajes frame = new MercadoFichajes();
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
	public MercadoFichajes() {
		setBounds(100, 100, 450, 300);

			
			
			
			JTable table = new JTable(data, columnNames);
		table.setBounds(29, 53, 225, 16);

			 JScrollPane scrollPane = new JScrollPane(table);
			 table.add(scrollPane);
			 table.setFillsViewportHeight(true);
		getContentPane().setLayout(null);
			 getContentPane().add(table);

	}
}

