//INTELIROBOT ESCUELA DE ROBÓTICA SLP
//intelirobot.com.mx
import lejos.nxt.addon.*;
import lejos.nxt.*;

public class Jugador
{
	public static void main(String[] args)
	{
		ColorSensor color=new ColorSensor(SensorPort.S2);
		IRSeekerV2 infra=new IRSeekerV2(SensorPort.S1 ,IRSeekerV2.Mode.AC);
		Movimientos m=new Movimientos();
 		Pelota buscar= new Pelota(infra,m,color);
		buscar.buscaPelota();
	}
}