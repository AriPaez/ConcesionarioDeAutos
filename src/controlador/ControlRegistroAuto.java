package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modelo.BBDDAutos;
import vista.Login;
import vista.RegistroAutoNuevo;
import vista.RegistroAutoViejo;
import vista.Secretario;

public class ControlRegistroAuto implements ActionListener{

	private RegistroAutoNuevo registroAutoNuevo;
	private BBDDAutos registroAuto;
	private RegistroAutoViejo registroAutoViejo;
	
	/* Con las variables booleanas registroAutoViejoEvento y
	   registroAutoNuevoEvento se determina en que clase
	   se ha producido el evento JButoon. Es decir, si en RegistroAutoNuevo
	   o en RegistroAutoViejo
	 */
	
	private boolean registroAutoViejoEvento;
	private boolean registroAutoNuevoEvento;
	
	public ControlRegistroAuto(RegistroAutoNuevo rAN)
	{
		registroAutoNuevo=rAN; 
		registroAuto=new BBDDAutos(rAN);
		registroAutoNuevoEvento=true;
	}
	
	
	public ControlRegistroAuto(RegistroAutoViejo rAV)
	{
		registroAutoViejo=rAV;
		registroAuto=new BBDDAutos(rAV);
		registroAutoViejoEvento=true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object botonElegido=e.getSource();
		 
		if(registroAutoNuevoEvento)
		{
			if(botonElegido==registroAutoNuevo.getRegistrarAutoNuevo())
			{
				registroAuto.registrarAutoNuevo();
			}
			else 
			{
				//Cierre de la ventana registroAutoNuevo.
				registroAutoNuevo.dispose();
				//Apertura de la ventana secretario.
				Secretario l=new Secretario();
				l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				l.setVisible(true);
			}
			
		}
		else
		{
			if(botonElegido==registroAutoViejo.getRegistrarAutoViejo())
			{
				registroAuto.registrarAutoViejo();
			}
			else
			{
				//Cierre de la ventana registroAutoViejo.
				registroAutoViejo.dispose();
				//Apertura de la ventana secretario.
				Secretario l=new Secretario();
				l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				l.setVisible(true);
			}
		}
		 
	}

}
