//INTELIROBOT ESCUELA DE ROBÓTICA SLP
//intelirobot.com.mx
//Programador por Yoalli y Diego

//LIBRERIAS NECESARIAS.............
import lejos.nxt.addon.*; 	//Para sensor infrarrojo y compas
import lejos.util.*; // Para delay
import lejos.nxt.*; // Para motores y sensores en general
//..................................

//Clase Pelota...................................
public class Pelota
{
    //Declaraciones necesarias...............
    //Sensor de color................
   	private ColorSensor color;
   	//Sensor infrarrojo
    private IRSeekerV2 infra;
    //Sensor de compas
    private CompassHTSensor brujula;
    //Clase programada por YOLO para motores
    private Movimientos m;
    //Atributos necesarios...............................
    private int direccion, orientacion;
    
   //CONSTRUCTOR DE LA CLASE
    public Pelota(IRSeekerV2 infrarrojo, CompassHTSensor compas, Movimientos m, ColorSensor c)
    {
    
    	color = c;
		infra = infrarrojo;
		brujula = compas;
		this.m = m;
			 	  
    }

    //Metodo para buscar la pelota...........................
    public void buscaPelota()
    {
		while(!Button.ESCAPE.isDown()) //mientras no se presione el boton ESCAPE
		{
			//SE RESETEA EL SENSOR COMPAS EN 0
			brujula.resetCartesianZero();

			//Imprimimos el id de color, IR, y grado de brujula
			LCD.drawInt(color.getColorID(),1,1);
			direccion = infra.getDirection(); //la direccion es lo que detecta el sensor IR
			LCD.drawInt(direccion, 1,3);
			orientacion=brujula.getDegreesCartesian();//la orientacion es el grado que detecta el compas
			LCD.drawInt(orientacion, 1,5);
			LCD.clearDisplay();//LIMPIAMOS LA PANTALLA
			Delay.msDelay(100);//hacemos una pausa de 100 milisegundos			
			//.........................

			//Si el sensor de color detecta un borde de la cancha
			if (color.getColorID() == 1)
		    {
 				m.detenerABC();
			    m.retrocederAB(900);
			    Delay.msDelay(900);
		    }
		    
		    //Si el sensor de color detecta la cancha
		    else
		    {
		    	//Y si detecta que la inclinacion es mayor de 30 grados
				if (orientacion > 30)
				{
					m.frontAbackB(800); //Que se acomode
				}
				//Y si detecta que la inclinacion es menor que 300 grados
				if (orientacion < 300)
				{
					m.avanzarAC(800);//Se va a linear
				}
				//Y si esta acomodado.........
		    	if(orientacion >= 300 && orientacion<=30)
		    	{
		    		//DEPENDIENDO DEL IR SE VA A MOVER EL ROBOT
					if (direccion == 1)
					{
						m.detenerB();
						m.frontCbackA(300);
					}
	 
					if (direccion == 2)
					{
						m.detenerC();
						m.frontBbackA(400);
					}
	         
					if (direccion == 3)
					{
						m.detenerC();
						m.frontBbackA(600);
					}

					if (direccion == 4)
					{
						m.detenerC();
						m.frontBbackA(800);
	   				}
				
					if (direccion == 5)
					{
						m.detenerA();
						m.frontBbackC(650);
					}
	        
					if (direccion == 6)
					{
						m.detenerA();
						m.frontCbackB(650);
					}
	 
					if(direccion == 7)
					{
						m.detenerB();
						m.frontCbackB(750);
					}
	         
					if(direccion == 8)
					{
						m.detenerB();
						m.frontAbackC(650);
					}

					if(direccion == 9)
					{
						m.detenerC();
						m.frontAbackB(500);
					}
				}
			}

		}

    }

}
