package modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vista.CompraAutoNuevo;
import vista.CompraAutoViejo;
import vista.Secretario;

public class BBDDCompraAuto {

	private BBDD conexionBBDD;
	private CompraAutoNuevo compraAutoNuevo;
	private CompraAutoViejo compraAutoViejo;
	private LinkedList<String> conjuntoMarcas;
	private LinkedList<String> conjuntoModelos;
	private ModeloTablas modeloTabla;
	
	public BBDDCompraAuto(CompraAutoNuevo cAN) {
		conexionBBDD = new BBDD();
		compraAutoNuevo = cAN;
		
	}

	public BBDDCompraAuto(CompraAutoViejo cAV) {
		compraAutoViejo = cAV;
		conexionBBDD = new BBDD();
	}

	public void comprarAutoNuevo() {

		try 
		{
			CallableStatement comprarAutoNuevo = conexionBBDD.getConexionBBDD()
			.prepareCall("{call comprarAutoNuevo(?,?,?,?)}");
			
			comprarAutoNuevo.setString(1,compraAutoNuevo.getDniCliente());
			comprarAutoNuevo.setString(2,compraAutoNuevo.getMarcaCompra());
			comprarAutoNuevo.setString(3,compraAutoNuevo.getModeloCompra());
			comprarAutoNuevo.setString(4,compraAutoNuevo.getColorCompra());
			
			comprarAutoNuevo.execute();
			

			JOptionPane.showMessageDialog(null,"COMPRA REALIZADA CON �XITO" ,"BBDD", 1, null);
			
			compraAutoNuevo.dispose();
			
			Secretario s=new Secretario();
			s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			s.setVisible(true);
			 
		}
		catch (SQLException e)
		{
		 
			JOptionPane.showMessageDialog(null,e.getMessage() ,"BBDD", 2, null);
			
		}
		
	}

	public void cargarJComboboxMarcaModelo() {
			
		ResultSet tablaMarcas=null;
		ResultSet tablaModelos=null;
		
		try 
		{
			CallableStatement mostrarMarcasAutosNuevos = conexionBBDD.getConexionBBDD()
			.prepareCall("{call mostrarMarcasAutosNuevos()}");
		
			tablaMarcas=mostrarMarcasAutosNuevos.executeQuery();
			
			CallableStatement mostrarModelosAutosNuevos = conexionBBDD.getConexionBBDD()
			.prepareCall("{call mostrarModelosAutosNuevos()}");
				
			tablaModelos=mostrarModelosAutosNuevos.executeQuery();
			
			 
			conjuntoModelos=new LinkedList<String>();
			conjuntoMarcas=new LinkedList<String>();
			 
			String primerRegistroMarca = null;
			boolean primerRegistroMarcaC=false;
			
			while(tablaMarcas.next())
			{
				if(!primerRegistroMarcaC)
				{
					primerRegistroMarca=tablaMarcas.getString(1);
					primerRegistroMarcaC=true;
				}
				
				
				this.compraAutoNuevo.getMarca().addItem(tablaMarcas.getString(1));
			}
			 
		
			while(tablaModelos.next())
			{
				conjuntoMarcas.add(tablaModelos.getString(1));
				conjuntoModelos.add(tablaModelos.getString(2));
				
				if(primerRegistroMarca.equals(tablaModelos.getString(1)))
				{
					this.compraAutoNuevo.getModelo().addItem(tablaModelos.getString(2));
				}
			}
		 
			
		}
		catch (SQLException e)
		{
		 
			e.printStackTrace();
		}
	 
	}
	
	//Cambia los modelos de autos al detectar cambio de marca del JComboBox.
	public void cambiarJComboboxModelo(String comboBoxMarcaSeleccionado)
	{
			
			//Agrega los modelos de autos al combobox modelos.
			for(int i = 0; i < this.conjuntoMarcas.size(); i++)
			{
				if (comboBoxMarcaSeleccionado.equals(conjuntoMarcas.get(i)))
				{
					this.compraAutoNuevo.getModelo().addItem(this.conjuntoModelos.get(i));
				}
			}
			  
	}
	
	public void cargarTablaMarcaModelo(String comboBoxMarcaSeleccionado,String comboBoxModeloSeleccionado)
	{
		ResultSet tablaAutoNuevo;
		
		  
		 try 
			{
				CallableStatement mostrarAutoNuevo = conexionBBDD.getConexionBBDD()
				.prepareCall("{call mostrarAutoNuevo(?,?)}",ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
				
				mostrarAutoNuevo.setString(1,comboBoxMarcaSeleccionado);
				mostrarAutoNuevo.setString(2,comboBoxModeloSeleccionado);
				
				tablaAutoNuevo=mostrarAutoNuevo.executeQuery();
			
				modeloTabla=new ModeloTablas(tablaAutoNuevo);

				compraAutoNuevo.getTabla().setModel(modeloTabla);
				
				compraAutoNuevo.getTabla().validate();
				
				
			} 
			catch (SQLException e)
			{
				
				e.printStackTrace();
			}
			 
	}
	
	
	public void cargarJTextFieldCompraAutoNuevo(int filaSeleccionada)
	{
		compraAutoNuevo.setMarcaCompra((String)compraAutoNuevo.getTabla().getValueAt(filaSeleccionada, 0));
		compraAutoNuevo.setModeloCompra((String)compraAutoNuevo.getTabla().getValueAt(filaSeleccionada, 1));
		compraAutoNuevo.setColorCompra((String)compraAutoNuevo.getTabla().getValueAt(filaSeleccionada, 2));
	}
	
	public void comprarAutoViejo() {

	}

	

}
