package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modelo.BBDDRegistroTaller;
import vista.RegistroTaller;
import vista.Secretario;

public class ControlRegistroTaller implements ActionListener {

	private RegistroTaller registroTaller;
	private BBDDRegistroTaller bBDDRegistroTaller;
	
	public ControlRegistroTaller(RegistroTaller rT) 
	{
		bBDDRegistroTaller=new BBDDRegistroTaller(rT);
		registroTaller=rT;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		Object botonElegido=e.getSource();
		
		if(botonElegido==this.registroTaller.getRegistrarTaller())
		{
			bBDDRegistroTaller.registrarTaller();
		}
		else
		{
			registroTaller.dispose();
			Secretario s=new Secretario();
			s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			s.setVisible(true);
		}
		

	}

}
