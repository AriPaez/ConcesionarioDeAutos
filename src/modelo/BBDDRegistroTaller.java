package modelo;

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
		
	}

}
