package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vista.RegistroAutoNuevo;
import vista.RegistroAutoViejo;
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
			 //Cierre de la ventana secretario.
			 secretario.dispose();
			 //Aperturda de la ventana registro de auto nuevo.
			 RegistroAutoNuevo rAN=new RegistroAutoNuevo();
			 rAN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 rAN.setVisible(true);
		}
		else if(botonSeleccionado==secretario.getRegistrarAutoViejo())
		{
			//Cierre de la ventana secretario.
			 secretario.dispose();
			 //Aperturda de la ventana registro de auto nuevo.
			 RegistroAutoViejo rAV=new RegistroAutoViejo();
			 rAV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 rAV.setVisible(true);
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
