//INTELIROBOT ESCUELA DE ROBÓTICA SLP
//intelirobot.com.mx
//Programador por Yoalli y Diego

//LIBRERIAS NECESARIAS.............
import lejos.nxt.addon.*; 	//Para sensor infrarrojo y compas
import lejos.util.*; // Para delay
import lejos.nxt.*; // Para motores y sensores en general
//..................................

//CLASE PRINCIPAL JUGADOR....................
public class Jugador
{
	//MAIN...............................
	public static void main(String[] args)
	{
		//Se instancia el sensor de color puerto 2..........
		ColorSensor color = new ColorSensor(SensorPort.S4);
		//Se instancia el sensor de infrarrojo puerto 1..........
		IRSeekerV2 infra = new IRSeekerV2(SensorPort.S1 ,IRSeekerV2.Mode.AC);
		//Se instancia el sensor de compas puerto 3..........
		CompassHTSensor brujula = new CompassHTSensor(SensorPort.S3);
		//Se instancea el objeto m de la clase de movimientos
		Movimientos m = new Movimientos();
		//Se instancia el sensor de tacto
		TouchSensor tacto = new TouchSensor(SensorPort.S2);
		//Se instancea el objeto buscar de la clase Pelota
 		Pelota buscar = new Pelota(infra, brujula , m, color, tacto);//Se mandan los argumentos necesarios al constructor
		//Se manda llamar el metodo buscaPelota de la clase Pelota
		buscar.buscaPelota();

	}
}