package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modelo.BBDDReparacionAuto;
import vista.ReparacionAuto;
import vista.Secretario;

public class ControlReparacionAuto implements ActionListener{

	private ReparacionAuto reparacionAuto;
	private BBDDReparacionAuto bBDDReparacionAuto;
	
	public ControlReparacionAuto(ReparacionAuto rA)
	{
		reparacionAuto=rA;
		bBDDReparacionAuto=new BBDDReparacionAuto(rA);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 
		Object botonElegido=e.getSource();
		
		if(botonElegido==reparacionAuto.getRegistrar())
		{
			bBDDReparacionAuto.registrarReparacion();
		}
		else
		{
			reparacionAuto.dispose();
			Secretario s=new Secretario();
			s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			s.setVisible(true);
		}
		
	}

}
