package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vista.RegistroAutoNuevo;
import vista.RegistroAutoViejo;
import vista.RegistroCliente;
import vista.RegistroMecanico;
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
			//Cierre de la ventana secretario.
			 secretario.dispose();
			 //Apertura de la ventana registro de cliente.
			 RegistroCliente rC=new RegistroCliente();
			 rC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 rC.setVisible(true);
		}
		else
		{
			//Cierre de la ventana secretario.
			 secretario.dispose();
			 //Apertura de la ventana registro de registroMecanico.
			 RegistroMecanico rM=new RegistroMecanico();
			 rM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 rM.setVisible(true);
		}
		
		
		

	}

}
