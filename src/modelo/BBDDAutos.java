package modelo;

import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vista.Login;
import vista.RegistroAutoNuevo;
import vista.RegistroAutoViejo;

public class BBDDAutos {
	
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
			prepareCall("{call registrarAutoNuevo(?,?,?,?)}");
			
			 
			registrarAutoNuevo.setString(1,registroAutoNuevo.getMarca());
			registrarAutoNuevo.setString(2,registroAutoNuevo.getModelo());
			registrarAutoNuevo.setString(3,registroAutoNuevo.getColor());
			registrarAutoNuevo.setString(4,registroAutoNuevo.getCantidad());
			
			registrarAutoNuevo.execute();
			
			JOptionPane.showMessageDialog(null,"Registrado exitosamente", "Registro", 1, null);
			
			 
		}
		catch (SQLException e) {
			 
			JOptionPane.showMessageDialog(null,e.getMessage(), "ERROR", 2, null);
			 
			 
		}
	}
	
	public void registrarAutoViejo()
	{
		
	}
	

}
