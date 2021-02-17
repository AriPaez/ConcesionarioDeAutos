package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import vista.RegistroAutoNuevo;
import vista.RegistroAutoViejo;

public class BBDDAutos{
	
	private RegistroAutoNuevo registroAutoNuevo;
	private RegistroAutoViejo registroAutoViejo;
	private BBDD conexionBBDD;
	 

	public BBDDAutos(RegistroAutoNuevo rAN)
	{
		registroAutoNuevo=rAN;
		conexionBBDD=new BBDD();
	}
	
	public BBDDAutos(RegistroAutoViejo rAV)
	{
		registroAutoViejo=rAV;
		conexionBBDD=new BBDD();
	}
	
	
	
	public void registrarAutoNuevo()
	{
		try 
		{
			CallableStatement registrarAutoNuevo=conexionBBDD.getConexionBBDD().
			prepareCall("{call registrarAutoNuevo(?,?,?,?,?)}");
			
			 
			registrarAutoNuevo.setString(1,registroAutoNuevo.getMarca());
			registrarAutoNuevo.setString(2,registroAutoNuevo.getModelo());
			registrarAutoNuevo.setString(3,registroAutoNuevo.getColor());
			registrarAutoNuevo.setString(4,registroAutoNuevo.getCantidad());
			registrarAutoNuevo.setString(5,registroAutoNuevo.getRutaDeImagen());
			registrarAutoNuevo.execute();
			
			JOptionPane.showMessageDialog(null,"Registrado exitosamente", "Registro", 1, null);
			
			//Reseto de los campos JTextField de registroAutoNuevo
			reseteoCamposRegistroAutoNuevo(); 
			 
		}
		catch (SQLException e) {
			 
			JOptionPane.showMessageDialog(null,e.getMessage(), "ERROR", 2, null);
			//Reseto de los campos JTextField de registroAutoNuevo
			reseteoCamposRegistroAutoNuevo(); 
		}
	}
	
	public void registrarAutoViejo()
	{
		try 
		{
			CallableStatement registrarAutoViejo=conexionBBDD.getConexionBBDD().
			prepareCall("{call registrarAutoViejo(?,?,?,?,?,?)}");
			
			 
			registrarAutoViejo.setString(1,registroAutoViejo.getMarca());
			registrarAutoViejo.setString(2,registroAutoViejo.getModelo());
			registrarAutoViejo.setString(3,registroAutoViejo.getColor());
			registrarAutoViejo.setString(4,registroAutoViejo.getMatricula());
			registrarAutoViejo.setFloat(5,registroAutoViejo.getCantidadKm());
			registrarAutoViejo.setString(6,registroAutoViejo.getDniDuenioAnterior());
			
			registrarAutoViejo.execute();
			
			JOptionPane.showMessageDialog(null,"Registrado exitosamente", "Registro", 1, null);
			
			//Reseto de los campos JTextField de registroAutoViejo.
			reseteoCamposRegistroAutoViejo();
			 
		}
		catch (SQLException e) {
			 
			JOptionPane.showMessageDialog(null,e.getMessage(), "ERROR", 2, null);
			
			//Reseto de los campos JTextField de registroAutoViejo.
			reseteoCamposRegistroAutoViejo();
		}
	}
	
	public void reseteoCamposRegistroAutoViejo()
	{
		registroAutoViejo.setMarca("");
		registroAutoViejo.setModelo("");
		registroAutoViejo.setColor("");
		registroAutoViejo.setMatricula("");
		registroAutoViejo.setCantidadKm("");
		registroAutoViejo.setDniDuenioAnterior("");
	}
	
	
	public void reseteoCamposRegistroAutoNuevo()
	{
		registroAutoNuevo.setMarca("");
		registroAutoNuevo.setModelo("");
		registroAutoNuevo.setColor("");
		registroAutoNuevo.setCantidad("");
	}
 

}
