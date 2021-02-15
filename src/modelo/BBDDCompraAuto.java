package modelo;

import vista.CompraAutoNuevo;
import vista.CompraAutoViejo;

public class BBDDCompraAuto {

	private BBDD conexionBBDD;
	private CompraAutoNuevo compraAutoNuevo ;
	private CompraAutoViejo compraAutoViejo;
	
	
	public BBDDCompraAuto (CompraAutoNuevo cAN)
	{
		conexionBBDD=new BBDD();
		compraAutoNuevo=cAN;
	}
	
	
	public BBDDCompraAuto(CompraAutoViejo cAV)
	{
		compraAutoViejo=cAV;
		conexionBBDD=new BBDD();
	}
	
	public void comprarAutoNuevo()
	{
		
	}
	
	public void buscarAutoNuevo()
	{
		
	}
	
	public void comprarAutoViejo()
	{
		
	}
	
	
	
}
