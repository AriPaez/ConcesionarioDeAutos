package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vista.CompraAutoNuevo;
import vista.CompraAutoViejo;
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

			System.out.println("registro reparacion");
		}
		else
		{
			System.out.println("registrar taller");
		}
		
		 
	}
	
	

}
