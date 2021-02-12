package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.BBDD;
import modelo.BBDDRegistroClienteYMecanico;
import vista.RegistroCliente;
import vista.RegistroMecanico;
import vista.Secretario;

public class RegistroClienteYMecanico implements ActionListener {

	private RegistroCliente registroCliente;
	private RegistroMecanico registroMecanico;
	private BBDDRegistroClienteYMecanico registroEnBBDD;
	//Con la clase claseBotonEvento se determina en que 
	//clase se ha producido el evento ActionEvent. (click boton)
	private boolean claseBotonEvento;
	
	public RegistroClienteYMecanico(RegistroCliente rC)
	{
		this.registroCliente=rC;
		registroEnBBDD=new BBDDRegistroClienteYMecanico(rC);
		claseBotonEvento=true;
	}
	
	public RegistroClienteYMecanico(RegistroMecanico rM)
	{	
		this.registroMecanico=rM;
		registroEnBBDD=new BBDDRegistroClienteYMecanico(rM);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		Object botonElegido=e.getSource();
		
		if(claseBotonEvento)
		{
			if(botonElegido==registroCliente.getRegistrar())
			{
				registroEnBBDD.registrarCliente();
			}
			else
			{
				registroCliente.dispose();
				Secretario s=new Secretario();
				s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				s.setVisible(true);
			}
		}
		else
		{
			if(botonElegido==registroMecanico.getRegistrar())
			{
				 
					registroEnBBDD.registrarMecanico();
				 
			}
			else
			{
				registroMecanico.dispose();
				Secretario s=new Secretario();
				s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				s.setVisible(true);
			}
			
		}
		 

	}

}
