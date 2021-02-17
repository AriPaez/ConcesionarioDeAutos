package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import modelo.BBDDCompraAuto;
import vista.CompraAutoNuevo;
import vista.CompraAutoViejo;
import vista.Secretario;

public class ControlCompraAuto extends WindowAdapter  implements ActionListener,ItemListener,MouseListener{
	
	
	private CompraAutoNuevo compraAutoNuevo ;
	private CompraAutoViejo compraAutoViejo;
	private BBDDCompraAuto compraAuto; 
	//La variable booleana compraAutoEvento permite determinar
	//en que clase se ha producido el evento, si en compraAutoNuevo
	//o en compraAutoViejo.
	private boolean compraAutoEvento;
	private int filaSeleccionada;
	
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
			else if(botonElegido==compraAutoNuevo.getCancelar())
			{
				compraAutoNuevo.dispose();
				Secretario s=new Secretario();
				s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				s.setVisible(true);
			}
		}
		else
		{
			//compra auto viejo
		}
		
	}
	
	 //Carga marca y todos sus modelos al abrirse por primera vez la ventana CompraAutoNuevo.
	 public void windowOpened(WindowEvent e)
	 {
		 compraAuto.cargarJComboboxMarcaModelo();
	 }


	 //Obtiene el modelo de auto seleccionado en el JComboBox.
	@Override
	public void itemStateChanged(ItemEvent e) {

		Object comboSeleccionado=e.getSource();
		
		String comboBoxMarcaSeleccionado=null;
		String comboBoxModeloSeleccionado=null;
		
		if(this.compraAutoNuevo.getMarca()==comboSeleccionado)
		{
			if (e.getStateChange() == ItemEvent.SELECTED)
			{ 
				
				
				comboBoxMarcaSeleccionado=(String) compraAutoNuevo.getMarca().getSelectedItem();
				 
				compraAutoNuevo.getModelo().removeAllItems();
				
				compraAuto.cambiarJComboboxModelo(comboBoxMarcaSeleccionado);
			}
		}
		else 
		{
			if (e.getStateChange() == ItemEvent.SELECTED)
			{
				comboBoxModeloSeleccionado=(String) compraAutoNuevo.getModelo().getSelectedItem();

				comboBoxMarcaSeleccionado=(String) compraAutoNuevo.getMarca().getSelectedItem();
				 
				compraAuto.cargarTablaMarcaModelo(comboBoxMarcaSeleccionado,comboBoxModeloSeleccionado);
			}	  
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		//Se determina la fila de tabla en la que se ha hecho click.
		this.filaSeleccionada=compraAutoNuevo.getTabla().rowAtPoint(e.getPoint());
		
		compraAuto.cargarJTextFieldCompraAutoNuevo(filaSeleccionada);
	}

	//Los siguientes metodos no son utlizados, sin embargo son sobreescritos
	//debido a que la interfaz MouseLister obliga implementarlos.
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e){}
	@Override
	public void mouseExited(MouseEvent e){}
 
	
}
