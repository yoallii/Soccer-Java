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
    //Sensor de tacto 
    private TouchSensor touch;
    //Sensor de compas
    private CompassHTSensor brujula;
    //Clase programada por YOLO para motores
    private Movimientos m;
    //Atributos necesarios...............................
    private int direccion, orientacion;
    
   //CONSTRUCTOR DE LA CLASE
    public Pelota(IRSeekerV2 infrarrojo, CompassHTSensor compas, Movimientos m, ColorSensor c,TouchSensor tacto )
    {
    
    	color = c;
		infra = infrarrojo;
		brujula = compas;
		this.m = m;
		touch=tacto;
			 	  
    }


    //Metodo para buscar la pelota...........................
    public void buscaPelota()
    {
    	//SE RESETEA EL SENSOR COMPAS EN 0
    	brujula.resetCartesianZero();// Se inicializa en 0 ,fuera de ciclo s
    	    	
		while(!Button.ESCAPE.isDown()) //mientras no se presione el boton ESCAPE
		{
			if(!touch.isPressed())
			{
				LCD.clearDisplay();//LIMPIAMOS LA PANTALLA 
				//Imprimimos el id de color, IR, y grado de brujula
				LCD.drawInt(color.getColorID(),1,1);
				direccion = infra.getDirection(); //la direccion es lo que detecta el sensor IR
				LCD.drawInt(direccion, 1,3);
				orientacion=(int)brujula.getDegreesCartesian();//la orientacion es el grado que detecta el compas
				LCD.drawInt(orientacion, 1,5);
						
				//.........................

				//Si el sensor de color detecta un borde de la cancha
				if (color.getColorID() == 6 )
			    {
			    	if(direccion>=5)
			    	{
			    		m.detenerB();
						m.frontAbackC(700);
			    		Delay.msDelay(800);
			    	}
			    	else
			    	{
			    		m.detenerA();
						m.frontCbackB(700);
						Delay.msDelay(800);
			    	}
	 				
	 				
			    }
			    
			    //Si el sensor de color detecta la cancha
			    else
			    {
			    	// si la brujula ve mayor de 30 y menor que 330 significa que esta chueco   
					if (brujula.getDegreesCartesian() > 50 && brujula.getDegreesCartesian()<310 )
					{
						if(brujula.getDegreesCartesian() >= 180)// si la brujula ve mayor o igual a 180
						{
							m.retrocederAB(800); // Se  alineara
						}
						else
						{
						    m.avanzarAB(800);	//Se alineara
						}

				    }
					//Y si esta acomodado.........
			    	else
			    	{
			    		//DEPENDIENDO DEL IR SE VA A MOVER EL ROBOT
			    		if(direccion==0)
			    		{
			    			m.frontBbackC(700);
							m.detenerA();
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

			else
				{
					//DETENER MOTORES
					m.detenerABC();
				}
            

		}

    }

}
