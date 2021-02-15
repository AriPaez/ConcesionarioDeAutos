package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vista.CompraAutoNuevo;
import vista.Secretario;

public class ControlMenuSecretario implements ActionListener {

	private Secretario secretario;
	
	public ControlMenuSecretario(Secretario s)
	{
		secretario=s;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 
		Object subMenuElegido=e.getSource();
		
		
		if(subMenuElegido==secretario.getAutoNuevo())
		{
			CompraAutoNuevo cAN=new CompraAutoNuevo();
			cAN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cAN.setVisible(true);
		}
		else if(subMenuElegido==secretario.getAutoViejo())
		{
			CompraAutoNuevo cAN=new CompraAutoNuevo();
			cAN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cAN.setVisible(true);
		}
		else  
		{
			System.out.println("registro reparacion");
		}
		
		 
	}

}
