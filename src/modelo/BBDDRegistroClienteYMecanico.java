package modelo;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vista.Login;
import vista.RegistroCliente;
import vista.RegistroMecanico;
import vista.Secretario;

public class BBDDRegistroClienteYMecanico {
	
	private RegistroCliente registroCliente;
	private RegistroMecanico registroMecanico;
	private BBDD conexionBBDD;
	
	public BBDDRegistroClienteYMecanico(RegistroCliente rC)
	{
		registroCliente=rC;
		conexionBBDD=new BBDD();
	}
	
	public BBDDRegistroClienteYMecanico(RegistroMecanico rM)
	{
		registroMecanico=rM;
		conexionBBDD=new BBDD();
	}
	
	public void registrarCliente()
	{
		try 
		{
			CallableStatement registrarCliente=conexionBBDD.getConexionBBDD().
			prepareCall("{call registrarCliente(?,?,?,?,?,?,?)}");
			
			registrarCliente.setString(1,registroCliente.getDni()); 
			registrarCliente.setString(2,Login.getDni());  
			registrarCliente.setString(3,registroCliente.getPrimerNombre()); 
			registrarCliente.setString(4,registroCliente.getSegundoNombre()); 
			registrarCliente.setString(5,registroCliente.getApellido()); 
			registrarCliente.setString(6,registroCliente.getDireccion()); 
			registrarCliente.setString(7,registroCliente.getTelefono());
			
			registrarCliente.execute();
			
			JOptionPane.showMessageDialog(null,"Registrado exitosamente", "Registro", 1, null);
			
			//Cierre de la ventana registroCliente.
			registroCliente.dispose();
			//apertura de la ventana secretario.
			abriVentanaSecretario();
			 
			 
		}
		catch (SQLException e ) {
			 
			JOptionPane.showMessageDialog(null,e.getMessage(), "ERROR", 2, null);
			//Reseteo de los campos JTextField.
			registroCliente.setDni("");
			registroCliente.setPrimerNombre("");
			registroCliente.setSegundoNombre("");
			registroCliente.setApellido("");
			registroCliente.setDireccion("");
			registroCliente.setTelefono("");
			
		}
		
	}
	
	public void registrarMecanico() 
	{
		try 
		{
			CallableStatement registrarMecanico=conexionBBDD.getConexionBBDD().
			prepareCall("{call registrarMecanico(?,?,?,?,?,?,?,?)}");
			
			registrarMecanico.setString(1,this.registroMecanico.getDni());
			registrarMecanico.setString(2,"94712223");
			registrarMecanico.setString(3,this.registroMecanico.getIdTaller());
			registrarMecanico.setString(4,this.registroMecanico.getPrimerNombre());
			registrarMecanico.setString(5,this.registroMecanico.getSegundoNombre());
			registrarMecanico.setString(6,this.registroMecanico.getApellido());
			registrarMecanico.setDate(7,new Date(registroMecanico.getFechaContrato().getTime()));
			registrarMecanico.setFloat(8,this.registroMecanico.getSalario());
			registrarMecanico.execute();
			
			JOptionPane.showMessageDialog(null,"Registrado exitosamente", "Registro", 1, null);
			
			//cierre de la ventanaRegistroMecanico.
			this.registroMecanico.dispose();
			abriVentanaSecretario();
			 
		}
		catch (SQLException e) {
			 
			JOptionPane.showMessageDialog(null,e.getMessage(), "ERROR", 2, null);
		 
		}
		catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog(null,"NO HA INGRESADO LA FECHA", "ERROR", 2, null);
			
		}
		 
	}
	
	public void abriVentanaSecretario()
	{
		Secretario s=new Secretario();
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setVisible(true);
		
	}
	 
}
