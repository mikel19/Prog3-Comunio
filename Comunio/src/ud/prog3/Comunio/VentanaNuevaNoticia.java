package ud.prog3.Comunio;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class VentanaNuevaNoticia extends JFrame implements ActionListener
{
	
	JScrollPane scrollPane;
	JTextArea textArea;
	JLabel lblIntroduceLaNoticia;
	JButton btnGuardar;
	File fichero;
	final String RUTA="src\\data\\noticias.dat";
	AppendableOutputStream aos;
	ObjectOutputStream oos;
	Noticia noticia;
	
	public VentanaNuevaNoticia() 
	{
		getContentPane().setBackground(new Color(0, 128, 0));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaNuevaNoticia.class.getResource("/ud/prog3/Comunio/img/comunioIcono.jpg")));
	
		setBounds(300,300,300,300);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 254, 140);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		lblIntroduceLaNoticia = new JLabel("INTRODUCE LA NOTICIA A GUARDAR");
		lblIntroduceLaNoticia.setForeground(new Color(255, 255, 255));
		lblIntroduceLaNoticia.setBounds(10, 24, 254, 14);
		getContentPane().add(lblIntroduceLaNoticia);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(91, 216, 128, 23);
		getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("guardar");
	
	
	
	
	
	
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		case "guardar":
			
			if(textArea.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Por Favor, introduce una noticia");
				break;
			}
			else
			{
				introducirNoticia();
				JOptionPane.showMessageDialog(null, "noticia guardada correctamente");
				dispose();
				break;
			}
		}
		
	}


	private void introducirNoticia()
	{
		fichero=new File(RUTA);
		
		if(fichero.exists())
		{
			try{
				
				 aos=new AppendableOutputStream(new FileOutputStream(fichero,true));
			}
			catch(IOException e){
				
				e.printStackTrace();
				
				
			}
		}
		else
		{
			
			try
			{
				fichero.createNewFile();
				oos=new ObjectOutputStream(new FileOutputStream(fichero));
			}
			catch(FileNotFoundException e)
			{
				
				
			}
			catch(IOException e){
				e.printStackTrace();
			}
			
		}
		
		noticia=new Noticia();
		
		noticia.setNoticia(textArea.getText());
		
		try
		{
			if(oos!=null)
			{
				oos.writeObject(noticia);
					
					
			}
			else
			{
				if(aos!=null)
				{
					aos.writeObject(noticia);
				}
			}
		}
			catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		try {
			if(oos!=null)
			{
			oos.close();
			}
		
		
		
	else
	{
		if(aos!=null)
		{
			aos.close();
		}
	
	}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}
}


