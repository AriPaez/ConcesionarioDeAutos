package modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class ModeloTablas extends AbstractTableModel
{


	private ResultSet tabla;
	private ResultSetMetaData datosBBDD;
	
	
	public ModeloTablas(ResultSet unResulset)
	{
		tabla=unResulset;
		
		try
		{
			datosBBDD=tabla.getMetaData();
		}
		catch (SQLException e)
		{
			 
			e.printStackTrace();
		}
	} 
	
	
	@Override
	public int getRowCount() {
	 
		try 
		{
		 
			 tabla.last();
			 
			 
			return tabla.getRow();
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
	
		
	}
	
	@Override
	public int getColumnCount() 
	{
		 
		try
		{
			return datosBBDD.getColumnCount();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public String getColumnName(int c)
	{
		 
		try 
		{
			return 	datosBBDD.getColumnName(c+1);
		} 
		catch (SQLException e)
		{
			 
			e.printStackTrace();
			return null;
		}
		  
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		 
		try
		{
			tabla.absolute(rowIndex+1);
			return tabla.getObject(columnIndex+1);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		} 
	}

}
