package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modelo.LoginAdministrador;
import vista.Login;
import vista.RegistroSecretario;
import vista.VentanaSecretario;

public class ControlLogin implements ActionListener {
	
	private Login login;
	
	public ControlLogin(Login l)
	{
		login=l;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	 
		Object botonSeleccionado=e.getSource();
		
		if(botonSeleccionado==login.getLogin())
		{
				  
				LoginAdministrador lA=
				new LoginAdministrador(login);
				
				//Si esta registrado el secretario ==> se abre 
				//la ventanaSecretario.
				if(lA.existenciaSecretario())
				{
					VentanaSecretario vS=new VentanaSecretario();
					vS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					vS.setVisible(true);
				}
				
		}
		else
		{
			
				//Cierre de la ventana login
				login.dispose();
				//Apertura de la ventana RegistroSecretario.
				RegistroSecretario vR=new RegistroSecretario ();
				vR.setVisible(true);
				vR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		
	}
	

}
