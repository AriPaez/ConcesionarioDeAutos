package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modelo.BBDDCompraAuto;
import vista.CompraAutoNuevo;
import vista.CompraAutoViejo;
import vista.Secretario;

public class ControlCompraAuto implements ActionListener{
	
	
	private CompraAutoNuevo compraAutoNuevo ;
	private CompraAutoViejo compraAutoViejo;
	private BBDDCompraAuto compraAuto;
	//La variable booleana compraAutoEvento permite determinar
	//en que clase se ha producido el evento, si en compraAutoNuevo
	//o en compraAutoViejo.
	private boolean compraAutoEvento;
	
	public ControlCompraAuto(CompraAutoNuevo cAN)
	{
		compraAutoEvento=true;
		compraAutoNuevo=cAN;
		compraAuto=new BBDDCompraAuto(cAN);
	}

	
	public ControlCompraAuto(CompraAutoViejo cAV)
	{
		compraAutoViejo=cAV;
		compraAuto=new BBDDCompraAuto(cAV);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		 
		Object botonElegido=e.getSource();
		
		if(compraAutoEvento)
		{
			if(botonElegido==compraAutoNuevo.getComprar())
			{
				 compraAuto.comprarAutoNuevo();
			}
			else if(botonElegido==compraAutoNuevo.getBuscarAuto())
			{
				compraAuto.buscarAutoNuevo();
			}
			else if(botonElegido==compraAutoNuevo.getCancelar())
			{
				Secretario s=new Secretario();
				s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				s.setVisible(true);
			}
		}
		else
		{
			
		}
		
	}
	
	
}
