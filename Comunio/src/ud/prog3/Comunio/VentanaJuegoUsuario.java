package ud.prog3.Comunio;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class VentanaJuegoUsuario extends JFrame
{
	public VentanaJuegoUsuario() {
		
		
		setBounds(400,300,500,400);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblFsfsdfsf = new JLabel("fsfsdfsf");
		GridBagConstraints gbc_lblFsfsdfsf = new GridBagConstraints();
		gbc_lblFsfsdfsf.insets = new Insets(0, 0, 5, 5);
		gbc_lblFsfsdfsf.gridx = 9;
		gbc_lblFsfsdfsf.gridy = 3;
		getContentPane().add(lblFsfsdfsf, gbc_lblFsfsdfsf);
		
		JLabel lblBienvenido = new JLabel("BIENVENIDO");
		lblBienvenido.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
		GridBagConstraints gbc_lblBienvenido = new GridBagConstraints();
		gbc_lblBienvenido.gridwidth = 3;
		gbc_lblBienvenido.gridheight = 2;
		gbc_lblBienvenido.insets = new Insets(0, 0, 5, 5);
		gbc_lblBienvenido.gridx = 4;
		gbc_lblBienvenido.gridy = 5;
		getContentPane().add(lblBienvenido, gbc_lblBienvenido);
		
		JLabel lblSadsadsad = new JLabel("sadsadsad");
		GridBagConstraints gbc_lblSadsadsad = new GridBagConstraints();
		gbc_lblSadsadsad.insets = new Insets(0, 0, 5, 5);
		gbc_lblSadsadsad.gridx = 7;
		gbc_lblSadsadsad.gridy = 8;
		getContentPane().add(lblSadsadsad, gbc_lblSadsadsad);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
}
