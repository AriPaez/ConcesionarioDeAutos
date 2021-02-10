package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import modelo.BBDDSecretario;
import vista.Login;
import vista.RegistroSecretario;

public class ControlSecretario implements ActionListener {

	private RegistroSecretario registroSecretario;
	
	public ControlSecretario (RegistroSecretario rS)
	{
		registroSecretario=rS;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 
		Object botonSeleccionado=e.getSource();
		
		
		if(botonSeleccionado==registroSecretario.getRegistrarse())
		{
			BBDDSecretario lA=new BBDDSecretario(registroSecretario);
			
			lA.registrarSecretario();
			
		}
		else
		{
			//Cierre de la ventana registroSecretario.
			registroSecretario.dispose();
			//Apertura de la ventana login.
			Login l=new Login();
			l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			l.setVisible(true);
		}
		
	}
	
	
}
