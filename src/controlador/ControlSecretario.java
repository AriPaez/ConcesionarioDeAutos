package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Secretario;

public class ControlSecretario implements ActionListener {

	private Secretario secretario;
	
	public ControlSecretario(Secretario s)
	{
		secretario=s;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	 
		Object botonSeleccionado=e.getSource();
		
		if(botonSeleccionado==secretario.getRegistrarAutoNuevo())
		{
			System.out.println("auto nuevo");
		}
		else if(botonSeleccionado==secretario.getRegistrarAutoViejo())
		{
			System.out.println("auto viejo");
		}
		else if(botonSeleccionado==secretario.getRegistrarCliente())
		{
			System.out.println("cliente");
		}
		else
		{
			System.out.println("mecanico");
		}
		
		
		

	}

}
