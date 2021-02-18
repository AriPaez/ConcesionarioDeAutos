package modelo;

import java.awt.Image;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	//Permite determina a que metodo constructor se ha invocado.
	private boolean eventoCompraAuto;
	
	public BBDDCompraAuto(CompraAutoNuevo cAN) {
		conexionBBDD = new BBDD();
		compraAutoNuevo = cAN;
		eventoCompraAuto=true;
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
			

			JOptionPane.showMessageDialog(null,"COMPRA REALIZADA CON ÉXITO" ,"BBDD", 1, null);
			
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

	public void cargarJComboboxMarcaModeloAutoNuevo() {
			
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
	public void cambiarJComboboxModeloAutoNuevo(String comboBoxMarcaSeleccionado)
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
	
	public void cargarTablaMarcaModeloAutoNuevo(String comboBoxMarcaSeleccionado,String comboBoxModeloSeleccionado)
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
	
	 

	//Compra de auto viejo.
	 
	
	public void comprarAutoViejo() {

		try 
		{
			CallableStatement comprarAutoViejo = conexionBBDD.getConexionBBDD()
			.prepareCall("{call comprarAutoViejo(?,?,?,?)}");
			
			comprarAutoViejo.setString(1,compraAutoViejo.getDniCliente());
			comprarAutoViejo.setString(2,compraAutoViejo.getMarcaCompra());
			comprarAutoViejo.setString(3,compraAutoViejo.getModeloCompra());
			comprarAutoViejo.setString(4,compraAutoViejo.getColorCompra());
			
			comprarAutoViejo.execute();
			

			JOptionPane.showMessageDialog(null,"COMPRA REALIZADA CON ÉXITO" ,"BBDD", 1, null);
			
			compraAutoViejo.dispose();
			
			Secretario s=new Secretario();
			s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			s.setVisible(true);
			 
		}
		catch (SQLException e)
		{
		 
			JOptionPane.showMessageDialog(null,e.getMessage() ,"BBDD", 2, null);
			
		}
		
	}

	public void cargarJComboboxMarcaModeloAutoViejo() {
			
		ResultSet tablaMarcas=null;
		ResultSet tablaModelos=null;
		
		try 
		{
			CallableStatement mostrarMarcasAutosViejos = conexionBBDD.getConexionBBDD()
			.prepareCall("{call mostrarMarcasAutosViejos()}");
		
			tablaMarcas=mostrarMarcasAutosViejos.executeQuery();
			
			CallableStatement mostrarModelosAutosViejos = conexionBBDD.getConexionBBDD()
			.prepareCall("{call mostrarModelosAutosViejos()}");
				
			tablaModelos=mostrarModelosAutosViejos.executeQuery();
			
			 
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
				
				
				this.compraAutoViejo.getMarca().addItem(tablaMarcas.getString(1));
			}
			 
		
			while(tablaModelos.next())
			{
				conjuntoMarcas.add(tablaModelos.getString(1));
				conjuntoModelos.add(tablaModelos.getString(2));
				
				if(primerRegistroMarca.equals(tablaModelos.getString(1)))
				{
					this.compraAutoViejo.getModelo().addItem(tablaModelos.getString(2));
				}
			}
		 
			
		}
		catch (SQLException e)
		{
		 
			e.printStackTrace();
		}
	 
	}
	
	//Cambia los modelos de autos al detectar cambio de marca del JComboBox.
	public void cambiarJComboboxModeloAutoViejo(String comboBoxMarcaSeleccionado)
	{
			
			//Agrega los modelos de autos al combobox modelos.
			for(int i = 0; i < this.conjuntoMarcas.size(); i++)
			{
				if (comboBoxMarcaSeleccionado.equals(conjuntoMarcas.get(i)))
				{
					this.compraAutoViejo.getModelo().addItem(this.conjuntoModelos.get(i));
				}
			}
			  
	}
	
	public void cargarTablaMarcaModeloAutoViejo(String comboBoxMarcaSeleccionado,String comboBoxModeloSeleccionado)
	{
		ResultSet tablaAutoViejo;
		
		  
		 try 
			{
				CallableStatement mostrarAutoViejo = conexionBBDD.getConexionBBDD()
				.prepareCall("{call mostrarAutoViejo(?,?)}",ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
				
				mostrarAutoViejo.setString(1,comboBoxMarcaSeleccionado);
				mostrarAutoViejo.setString(2,comboBoxModeloSeleccionado);
				
				tablaAutoViejo=mostrarAutoViejo.executeQuery();
			
				modeloTabla=new ModeloTablas(tablaAutoViejo);

				compraAutoViejo.getTabla().setModel(modeloTabla);
				
				compraAutoViejo.getTabla().validate();
				
				
			} 
			catch (SQLException e)
			{
				
				e.printStackTrace();
			}
			 
	}
	
	
	public void mostrarImagenEnCompraAuto(int filaSeleccionada)
	{
		ResultSet tablaDireccionImagen=null;
		String directorioImagen = null;
		
			if(eventoCompraAuto)
			{
				try 
				{
					CallableStatement mostrarImagenAuto = conexionBBDD.getConexionBBDD()
					 .prepareCall("{call mostrarImagenAuto(?,?,?)}");
					
					mostrarImagenAuto.setString(1,(String)compraAutoNuevo.getTabla().getValueAt(filaSeleccionada, 0));
					mostrarImagenAuto.setString(2,(String)compraAutoNuevo.getTabla().getValueAt(filaSeleccionada, 1));
					mostrarImagenAuto.setString(3,(String)compraAutoNuevo.getTabla().getValueAt(filaSeleccionada, 2));
					
					tablaDireccionImagen=mostrarImagenAuto.executeQuery();
					
					while(tablaDireccionImagen.next())
					{
						directorioImagen=tablaDireccionImagen.getString(1);
					}
					
					Icon imagenAjustada=ajustarImagenAJLabel(new ImageIcon(directorioImagen));
					
					compraAutoNuevo.getFotoAuto().setIcon(imagenAjustada);
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				
			}
			else
			{
				try 
				{
					CallableStatement mostrarImagenAuto = conexionBBDD.getConexionBBDD()
					 .prepareCall("{call mostrarImagenAuto(?,?,?)}");
					
					mostrarImagenAuto.setString(1,(String)compraAutoViejo.getTabla().getValueAt(filaSeleccionada, 0));
					mostrarImagenAuto.setString(2,(String)compraAutoViejo.getTabla().getValueAt(filaSeleccionada, 1));
					mostrarImagenAuto.setString(3,(String)compraAutoViejo.getTabla().getValueAt(filaSeleccionada, 2));
					
					tablaDireccionImagen=mostrarImagenAuto.executeQuery();
					
					while(tablaDireccionImagen.next())
					{
						directorioImagen=tablaDireccionImagen.getString(1);
					}
					
					
					
					Icon imagenAjustada=ajustarImagenAJLabel(new ImageIcon(directorioImagen));
					
					compraAutoViejo.getFotoAuto().setIcon(imagenAjustada);
					
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
	}
	
	public Icon ajustarImagenAJLabel(ImageIcon  imagen)
	{
		
		CompraAutoNuevo cA=new CompraAutoNuevo();
		 
		Image imgEscalada = imagen.getImage().getScaledInstance(cA.getFotoAuto().getWidth(),
        cA.getFotoAuto().getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        
        return iconoEscalado ;		
	}
	
	public void cargarJTextFieldCompraAutoViejo(int filaSeleccionada)
	{
		compraAutoViejo.setMarcaCompra((String)compraAutoViejo.getTabla().getValueAt(filaSeleccionada, 0));
		compraAutoViejo.setModeloCompra((String)compraAutoViejo.getTabla().getValueAt(filaSeleccionada, 1));
		compraAutoViejo.setColorCompra((String)compraAutoViejo.getTabla().getValueAt(filaSeleccionada, 2));
	}

}
