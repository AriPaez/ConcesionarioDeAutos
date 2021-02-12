package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Secretario;

public class VentaAutos implements ActionListener {

	private Secretario secretario;
	
	public VentaAutos(Secretario s)
	{
		secretario=s;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 
		Object subMenuElegido=e.getSource();
		
		
		if(subMenuElegido==secretario.getAutoNuevo())
		{
			System.out.println("compra auto nuevo");
		}
		else  
		{
			System.out.println("compra auto viejo");
		}
		
		
		
		
	}

}
