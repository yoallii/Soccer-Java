public class MovimientosMejorados  extends Movimientos 
{
	public void atrasDiagonalIzq (int vel)
	{
		detenerA();
		frontBbackC(vel);
	}

	public void atrasDiagonalDer (int vel)
	{
		detenerB();
		frontCbackA(vel);
	}
	public void enfrenteDiagonalIzq (int vel)
	{
		detenerB();
		frontAbackC(vel);
	}
	public void enfrenteDiagonalDer (int vel)
	{	
		detenerA();
		frontCbackB(vel);
	}


}