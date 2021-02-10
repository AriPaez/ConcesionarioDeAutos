package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.BBDDSecretario;
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
				  
				BBDDSecretario lA=new BBDDSecretario(login);
				
				//Si esta registrado el secretario ==> se abre 
				//la ventanaSecretario.
				if(lA.iniciarSesion())
				{
					
					JOptionPane.showMessageDialog(null,"Iniciado Correctamente", "Acceso", 
					1, null);

					//Cierre de la ventana login
					login.dispose();
					//Apertura de la VentanaSecretario.
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
