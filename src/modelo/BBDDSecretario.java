package modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vista.Login;
import vista.RegistroSecretario;

public class BBDDSecretario {
	
	
	private BBDD conexionBBDD;
	private Login login;
	private RegistroSecretario registroSecretario;
	
	public BBDDSecretario(Login l)
	{
		login=l;
		conexionBBDD=new BBDD();
	}

	
	public BBDDSecretario(RegistroSecretario rS)
	{
		registroSecretario=rS;
		conexionBBDD=new BBDD();
	}

	
	public boolean existenciaSecretario()
	{
		
		try 
		{
			CallableStatement verificarLoginSecretario=conexionBBDD.getConexionBBDD().
			prepareCall("{call verificarLoginSecretario(?)}");
			
			verificarLoginSecretario.setString(1,login.getDni());
			
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
	
	public void registrarSecretario( )
	{
		try 
		{
			CallableStatement registrarSecretario=conexionBBDD.getConexionBBDD().
			prepareCall("{call registrarSecretario(?,?)}");
			
			registrarSecretario.setString(1,registroSecretario.getDni());
			registrarSecretario.setString(2,registroSecretario.getPassword());
			
			registrarSecretario.execute();
			
			JOptionPane.showMessageDialog(null,"Registrado exitosamente", "BBDD", 1, null);
			
			//Cierre de la ventana registroSecretario.
			registroSecretario.dispose();
			//Apertura de la ventana login.
			Login l=new Login();
			l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			l.setVisible(true);
				
			
		}
		catch (SQLException e) {
			 
			JOptionPane.showMessageDialog(null,e.getMessage(), "ERROR", 2, null);
			
			//Reseteo de JTextFiel dni y passowrd.
			registroSecretario.setDni("");
			registroSecretario.setPassword("");
			 
		}
	}
	
	
}
