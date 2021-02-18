package modelo;

import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import vista.Login;
import vista.RegistroTaller;

public class BBDDRegistroTaller {
	
	private RegistroTaller registroTaller;
	private BBDD conexionBBDD;
	
	public BBDDRegistroTaller(RegistroTaller rT)
	{
		conexionBBDD=new BBDD();
		registroTaller=rT;
	}
	
	
	
	public void registrarTaller()
	{
		try 
		{
			CallableStatement registrarTaller=conexionBBDD.getConexionBBDD().
			prepareCall("{call registrarTaller(?,?)}");
			
			registrarTaller.setString(1,registroTaller.getCodigoTaller());
			registrarTaller.setString(2,registroTaller.getDescripcionTaller());
			
			registrarTaller.execute();
			
			JOptionPane.showMessageDialog(null,"Registrado exitosamente", "Registro", 1, null);
			
			//Reseteo de campos JTextField de registroTaller.
			registroTaller.setCodigoTaller("");
			registroTaller.setDescripcionTaller("");
		}
		catch (SQLException e ) {
			 
			JOptionPane.showMessageDialog(null,e.getMessage(), "ERROR", 2, null);
		
			//Reseteo de campos JTextField de registroTaller.
			registroTaller.setCodigoTaller("");
			registroTaller.setDescripcionTaller("");
		}
		
		
	}

}
