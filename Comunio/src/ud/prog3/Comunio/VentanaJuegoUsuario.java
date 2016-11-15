package ud.prog3.Comunio;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.JTextField;

public class VentanaJuegoUsuario extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tiempoUso;
	
	public VentanaJuegoUsuario() {
		
		
		setBounds(400,300,500,400);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		tiempoUso = new JTextField();
		tiempoUso.setSize(300, 100);
		GridBagConstraints gbc_tiempoUso = new GridBagConstraints();
		gbc_tiempoUso.gridwidth = 3;
		gbc_tiempoUso.insets = new Insets(0, 0, 5, 5);
		gbc_tiempoUso.fill = GridBagConstraints.HORIZONTAL;
		gbc_tiempoUso.gridx = 2;
		gbc_tiempoUso.gridy = 1;
		getContentPane().add(tiempoUso, gbc_tiempoUso);
		tiempoUso.setColumns(10);
		
		JLabel lblFsfsdfsf = new JLabel("fsfsdfsf");
		GridBagConstraints gbc_lblFsfsdfsf = new GridBagConstraints();
		gbc_lblFsfsdfsf.insets = new Insets(0, 0, 5, 5);
		gbc_lblFsfsdfsf.gridx = 10;
		gbc_lblFsfsdfsf.gridy = 3;
		getContentPane().add(lblFsfsdfsf, gbc_lblFsfsdfsf);
		
		JLabel lblBienvenido = new JLabel("BIENVENIDO");
		lblBienvenido.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		GridBagConstraints gbc_lblBienvenido = new GridBagConstraints();
		gbc_lblBienvenido.gridwidth = 4;
		gbc_lblBienvenido.gridheight = 2;
		gbc_lblBienvenido.insets = new Insets(0, 0, 5, 5);
		gbc_lblBienvenido.gridx = 4;
		gbc_lblBienvenido.gridy = 5;
		getContentPane().add(lblBienvenido, gbc_lblBienvenido);
		
		JLabel lblSadsadsad = new JLabel("sadsadsad");
		GridBagConstraints gbc_lblSadsadsad = new GridBagConstraints();
		gbc_lblSadsadsad.insets = new Insets(0, 0, 5, 5);
		gbc_lblSadsadsad.gridx = 8;
		gbc_lblSadsadsad.gridy = 8;
		getContentPane().add(lblSadsadsad, gbc_lblSadsadsad);
		
		
		
		Runnable r=new Runnable()
		{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<10;i++)
				{
				tiempoUso.setText("El tiempo uso: "+i);
				if(i==9)
				{
					tiempoUso.setText("Tiempo de expiracion - La conexi�n va a finalizar");
					try {
						Thread.sleep(4000);
						dispose();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			}
			
		};
		Thread mihilo=new Thread(r);
		mihilo.start();
	}

	

	
	
	
}
