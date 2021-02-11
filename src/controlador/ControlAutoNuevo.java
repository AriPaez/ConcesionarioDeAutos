package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modelo.BBDDAutos;
import vista.Login;
import vista.RegistroAutoNuevo;

public class ControlAutoNuevo implements ActionListener{

	private RegistroAutoNuevo registroAutoNuevo;
	private BBDDAutos registroAutoNuevoEnBBDD;
	
	public ControlAutoNuevo(RegistroAutoNuevo rAN)
	{
		registroAutoNuevo=rAN;
		registroAutoNuevoEnBBDD=new BBDDAutos(rAN);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object botonElegido=e.getSource();
		
		if(botonElegido==registroAutoNuevo.getRegistrarAutoNuevo())
		{
			registroAutoNuevoEnBBDD.registrarAutoNuevo();
		}
		else
		{
			//Cierre de la ventana registroAutoNuevo.
			registroAutoNuevo.dispose();
			//Apertura de la ventana login.
			Login l=new Login();
			l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			l.setVisible(true);
		}
		 
		
	}

}
