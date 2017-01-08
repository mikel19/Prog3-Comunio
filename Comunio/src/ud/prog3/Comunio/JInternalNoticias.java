package ud.prog3.Comunio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class JInternalNoticias extends JFrame implements ActionListener
{
	JLabel lblNoticia;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	JButton btnCancelar;
	ArrayList<Noticia> listaNoticias;
	Noticia noticia;
	ObjectInputStream ois;
	final String RUTA="src\\data\\noticias.dat";
	File fichero;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public JInternalNoticias() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JInternalNoticias.class.getResource("/ud/prog3/Comunio/img/comunioIcono.jpg")));
		getContentPane().setBackground(new Color(0, 128, 0));
		setForeground(new Color(0, 128, 0));
	
				listaNoticias=new ArrayList <Noticia>();
				noticia=new Noticia();
		
		setBackground(new Color(0, 128, 0));
		setResizable(true);
		
		setBounds(100, 100, 515, 395);
		getContentPane().setLayout(null);
		
		lblNoticia = new JLabel("Noticias");
		lblNoticia.setFont(new Font("Tunga", Font.BOLD, 18));
		lblNoticia.setBounds(133, 28, 121, 14);
		getContentPane().add(lblNoticia);
		
		btnCancelar = new JButton("CERRAR");
	
		btnCancelar.setBounds(110, 322, 144, 24);
		getContentPane().add(btnCancelar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 55, 330, 228);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("cancelar");
		textArea.setEditable(false);
		
		cargarNoticias();
		
		pasarNoticiasALista();

	}

	private void pasarNoticiasALista() 
	{
		for(int i=0;i<listaNoticias.size();i++)
		{
			textArea.append(listaNoticias.get(i).toString());
			
		}
		
	}

	private void cargarNoticias() 
	{
	fichero=new File(RUTA);
	
	if(fichero.exists()==false)
	{
		JOptionPane.showMessageDialog(null, "De momento no hay noticias");
		dispose();
	}
	if(fichero.exists())
	{
	
		try{
			ois=new ObjectInputStream(new FileInputStream(fichero));
	
		}
		catch (FileNotFoundException e)
		{

			JOptionPane.showMessageDialog(null, "De momento no hay noticias");
			
			
			
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	listaNoticias=new ArrayList<Noticia>();
	noticia=new Noticia();
	try
	{
		
		while(ois!=null)
		{
			noticia=(Noticia) ois.readObject();
			listaNoticias.add(noticia);
		}
				
		
		
		
	} 
	catch (IOException e)
	{
		// TODO Auto-generated catch block
		if(noticia==null) 
		{
			System.out.println(e.getMessage());
		}
	}
	catch (ClassNotFoundException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	catch (FileEndException e)
//	{
//		e.toString();
//	}
	
	
	

	try {
		if(ois!=null)
		{
			
		ois.close();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		switch(arg0.getActionCommand())
		{
		case "cancelar":
			
			dispose();
			
		}
		
	}

}
