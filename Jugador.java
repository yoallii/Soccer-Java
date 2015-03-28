import lejos.nxt.addon.*;
import lejos.nxt.*;

public class Jugador
{
	public static void main(String[] args)
	{
		ColorSensor color=new ColorSensor(SensorPort.S2);
		IRSeekerV2 infra=new IRSeekerV2(SensorPort.S1 ,IRSeekerV2.Mode.AC);
		Motores m=new Motores();
 		Buscar1 buscar= new Buscar1(infra,m,color);
		buscar.buscaPelota();
	}
}