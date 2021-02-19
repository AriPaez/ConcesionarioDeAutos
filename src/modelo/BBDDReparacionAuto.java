package modelo;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vista.ReparacionAuto;
import vista.Secretario;

public class BBDDReparacionAuto {

	private BBDD conexionBBDD;
	private ReparacionAuto reparacionAuto;
	
	
	public BBDDReparacionAuto(ReparacionAuto rA)
	{
		conexionBBDD = new BBDD();
		reparacionAuto=rA;
	}
	
	
	public void registrarReparacion()
	{
		
		
		try 
		{
			CallableStatement registrarReparacion = conexionBBDD.getConexionBBDD()
			.prepareCall("{call registrarReparacion(?,?,?,?)}"); 
			registrarReparacion.setTime(1,reparacionAuto.getCantidadHoras());
			registrarReparacion.setDate(2,new Date(reparacionAuto.getFechaReparacion().getTime()));
			registrarReparacion.setString(3,reparacionAuto.getMatriculaAutoReparado());
			registrarReparacion.setString(4,reparacionAuto.getDniMecanico());
			
			registrarReparacion.execute();
			

			JOptionPane.showMessageDialog(null,"REGISTRO DE REPARACIÓN REALIZADA CON ÉXITO" ,"BBDD", 1, null);
			
			reseteoJTextFieldReparacionAuto();
		}
		catch (SQLException e)
		{
		 
			JOptionPane.showMessageDialog(null,e.getMessage() ,"BBDD", 2, null);
			reseteoJTextFieldReparacionAuto();
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null,""
					+ "ERROR. INGRESE VALORES ENTEROS EN hs y min.","BBDD", 2, null);
			reseteoJTextFieldReparacionAuto();
		}
		catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog(null,"NO HA INGRESADO LA FECHA", "ERROR", 2, null);
			
		}
		 
		
	}
	
	public void reseteoJTextFieldReparacionAuto()
	{
		reparacionAuto.setCantidadHoras("");
		reparacionAuto.setCantidadMinutos("");
		reparacionAuto.setDniMecanico("");
		reparacionAuto.setMatriculaAutoReparado("");
	}
	
}
