package modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import vista.Login;

public class LoginAdministrador {
	
	private String dniSecretario;
	private BBDD conexionBBDD;
	private Login login;
	
	public LoginAdministrador(Login l)
	{
		login=l;
		conexionBBDD=new BBDD();
	}

	
	public boolean existenciaSecretario()
	{
		
		try 
		{
			CallableStatement verificarLoginSecretario=conexionBBDD.getConexionBBDD().
			prepareCall("{call verificarLoginSecretario(?)}");
			
			verificarLoginSecretario.setString(1,this.dniSecretario);
			
			ResultSet tabla=verificarLoginSecretario.executeQuery();
			
			//Si existe usuario ==> existe filas en el ResultSet.
			//por lo que retorna true.
			return tabla.next();
			
			
		}
		catch (SQLException e) {
			 
			JOptionPane.showMessageDialog(null,e.getMessage(), "ERROR", 2, null);
			
			//Reseto de JTexField dni y password.
			login.setDni("");
			login.setPassword("");
		}
		  
		
		return false;
	}
	
	
}
