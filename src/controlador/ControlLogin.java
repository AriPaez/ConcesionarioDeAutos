package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Login;

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
				
		}
		else
		{
			
		}
		
		
	}
	

}
