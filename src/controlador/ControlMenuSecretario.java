package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vista.CompraAutoNuevo;
import vista.CompraAutoViejo;
import vista.RegistroTaller;
import vista.ReparacionAuto;
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
			secretario.dispose();
			CompraAutoNuevo cAN=new CompraAutoNuevo();
			cAN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cAN.setVisible(true);
			
		}
		else if(subMenuElegido==secretario.getAutoViejo())
		{
			secretario.dispose();
			CompraAutoViejo cAN=new CompraAutoViejo();
			cAN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cAN.setVisible(true);
		}
		else if(subMenuElegido==secretario.getRegistrarReparacion())
		{
			secretario.dispose();
			ReparacionAuto rA=new ReparacionAuto();
			rA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			rA.setVisible(true);
			 
		}
		else
		{
			secretario.dispose();
			RegistroTaller rT=new RegistroTaller();
			rT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			rT.setVisible(true);
		}
		
		 
	}
	
	

}
