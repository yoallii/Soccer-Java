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
    	brujula.resetCartesianZero();
		while(!Button.ESCAPE.isDown()) //mientras no se presione el boton ESCAPE
		{
			//SE RESETEA EL SENSOR COMPAS EN 0
			
            LCD.clearDisplay();//LIMPIAMOS LA PANTALLA
			//Imprimimos el id de color, IR, y grado de brujula
			LCD.drawInt(color.getColorID(),1,1);
			direccion = infra.getDirection(); //la direccion es lo que detecta el sensor IR
			LCD.drawInt(direccion, 1,3);
			orientacion=(int)brujula.getDegreesCartesian();//la orientacion es el grado que detecta el compas
			LCD.drawInt(orientacion, 1,5);
					
			//.........................

			//Si el sensor de color detecta un borde de la cancha
			if (color.getColorID() == 6)
		    {
 				m.detenerABC();
			    m.retrocederAB(900);
			    Delay.msDelay(800);
		    }
		    
		    //Si el sensor de color detecta la cancha
		    else
		    {
		    	//Y si detecta que la inclinacion es mayor de 30 grados
				if (brujula.getDegreesCartesian() > 30 && brujula.getDegreesCartesian()<330 )
				{
					if(brujula.getDegreesCartesian() >= 180)
					{
						m.retrocederAB(800);
					}
					else
					{
					    m.avanzarAB(800);		
					}

			    }
				//Y si esta acomodado.........
		    	else
		    	{
		    		//DEPENDIENDO DEL IR SE VA A MOVER EL ROBOT
		    		if(direccion==0)
		    		{
		    			m.detenerC();
		    			m.frontBbackA(700);
		    		}
					if (direccion == 1)
					{

						m.frontBbackC(700);
						m.detenerA();
					}
	 
					if (direccion == 2)
					{
						m.detenerB();
						m.frontAbackC(700);
					}
	         
					if (direccion == 3)
					{
						m.detenerB();
						m.frontAbackC(700);
					}

					if (direccion == 4)
					{
						m.detenerB();
						m.frontAbackC(700);
	   				}
				
					if (direccion == 5)
					{
						m.detenerC();
						m.frontAbackB(700);
					}
	        
					if (direccion == 6)
					{
						m.detenerA();
						m.frontCbackB(700);
					}
	 
					if(direccion == 7)
					{
						m.detenerA();
						m.frontCbackB(700);
					}
	         
					if(direccion == 8)
					{
						m.detenerA();
						m.frontCbackB(700);
					}

					if(direccion == 9)
					{
						m.detenerB();
						m.frontCbackA(700);
					}
				}
			}

		}

    }

}
