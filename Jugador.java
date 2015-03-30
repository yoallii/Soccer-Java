//INTELIROBOT ESCUELA DE ROBÓTICA SLP
//intelirobot.com.mx
//Programador por Yoalli y Diego
import lejos.nxt.addon.*;
import lejos.nxt.*;

public class Jugador
{
	
	public static void main(String[] args)
	{
		
		ColorSensor color = new ColorSensor(SensorPort.S2);
		IRSeekerV2 infra = new IRSeekerV2(SensorPort.S1 ,IRSeekerV2.Mode.AC);
		CompassHTSensor brujula = new CompassHTSensor(SensorPort.S3);
		Movimientos m = new Movimientos();
 		Pelota buscar = new Pelota(infra, compas, m, color);
		
		buscar.buscaPelota();

	}

}