//INTELIROBOT ESCUELA DE ROBÓTICA SLP
//intelirobot.com.mx
//Programador por Yoalli y Diego

//LIBRERIAS NECESARIAS.............
import lejos.nxt.addon.*; 	//Para sensor infrarrojo y compas
import lejos.util.*; // Para delay
import lejos.nxt.*; // Para motores y sensores en general
import java.util.*; //Para numeros RANDOM
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
    private MovimientosMejorados m;
    //Clase para numeros RANDOM......................
    private Random rand;
    //Atributos necesarios...............................
    private int direccion, orientacion,numeroAleatorio;
    
   //CONSTRUCTOR DE LA CLASE
    public Pelota(IRSeekerV2 infrarrojo, CompassHTSensor compas, Movimientos m, ColorSensor c,TouchSensor tacto)
    {
    
    	color = c;
		infra = infrarrojo;
		brujula = compas;
		this.m = m;
		touch = tacto;
		rand = new Random();
    }
   	
   	//Metodo para buscar la pelota...........................
    public void buscaPelota()
    {
    	//SE RESETEA EL SENSOR COMPAS EN 0
    	brujula.resetCartesianZero();//Se inicializa en 0 ,fuera de ciclo
    	    	
		while(true) //mientras no se presione el boton ESCAPE
		{
			LCD.clearDisplay();//LIMPIAMOS LA PANTALLA 
			//Imprimimos el id de color, IR, y grado de brujula
			LCD.drawInt(color.getColorID(),1,1);
			direccion = infra.getDirection(); //la direccion es lo que detecta el sensor IR
			LCD.drawInt(direccion, 1,3);
			orientacion=(int)brujula.getDegreesCartesian();//la orientacion es el grado que detecta el compas
			LCD.drawInt(orientacion, 1,5);
					
			//.........................
			if(!touch.isPressed())
			{

			  	// si la brujula ve mayor de 30 y menor que 330 significa que esta chueco   
				if (brujula.getDegreesCartesian() > 35 && brujula.getDegreesCartesian()<330 )
				{
					if(brujula.getDegreesCartesian() >= 180)// si la brujula ve mayor o igual a 180
					{
						do{
							m.detenerC();
							m.retrocederAB(500); // Se  alineara
							
							
						}while(brujula.getDegreesCartesian() < 340);
						
					}
					else
					{
						do{
							 m.detenerC();
							 m.avanzarAB(500);	//Se alineara
						}while(brujula.getDegreesCartesian() > 15);
					   
					}
				}
	    
	    		//Y si esta acomodado.........
    			else
    			{
    				//DEPENDIENDO DEL IR SE VA A MOVER EL ROBOT
    				if (direccion == 0)
    				{
    					numeroAleatorio=rand.nextInt(2);
    					//Si el sensor de color detecta un borde de la cancha
						if (color.getColorID() == 6)
					    {
					    	if (numeroAleatorio==0) 
	    					{
	    						m.atrasDiagonalIzq(850);
								Delay.msDelay(400);
	    					}
	    					else
	    					{
	    						m.atrasDiagonalDer(850);
								Delay.msDelay(400);
	    					}

					    }
    					else
    					{
	    					if (numeroAleatorio==0) 
	    					{
	    						m.atrasDiagonalDer(900);
	    					}
	    					else
	    					{
	    						m.atrasDiagonalIzq(900);
	    					}
    						
    					}
    				}
			
					if (direccion == 1)
					{
						//Si el sensor de color detecta un borde de la cancha
						if (color.getColorID() == 6)
					    {
					    	enfrenteDiagonalDer(850);
							Delay.msDelay(400);
					    }
    					else
    					{
	    					m.atrasDiagonalIzq(800);
	    				}
					}

					if (direccion == 2)
					{
						//Si el sensor de color detecta un borde de la cancha
						if (color.getColorID() == 6)
					    {
					    	m.atrasDiagonalDer(850);
							Delay.msDelay(400);
					    }
    					else
    					{
	    					m.atrasDiagonalIzq(750);
    					}	
					}
     
					if (direccion == 3)
					{
						//Si el sensor de color detecta un borde de la cancha
						if (color.getColorID() == 6)
					    {
					    	m.enfrenteDiagonalDer(850);
							Delay.msDelay(400);
					    }
    					else
    					{
	    					
							m.enfrenteDiagonalIzq(850);
    					}	
					}

					if (direccion == 4)
					{
						//Si el sensor de color detecta un borde de la cancha
						if (color.getColorID() == 6)
					    {
					    	m.enfrenteDiagonalIzq(850);
							Delay.msDelay(400);
					    }
    					else
    					{
	    					
							m.enfrenteDiagonalDer (700);
    					}	
					}
		
					if (direccion == 5)
					{
						numeroAleatorio=rand.nextInt(2);
						//Si el sensor de color detecta un borde de la cancha
						if (color.getColorID() == 6)
					    {
					    	if(numeroAleatorio==0)
    						{
    							m.enfrenteDiagonalIzq(850);
								Delay.msDelay(400);
    						}
    						else
    						{
    							m.enfrenteDiagonalDer(850);
								Delay.msDelay(400);	
    						}
					    }
    					else
    					{
    						if(numeroAleatorio==0)
    						{
    							m.enfrenteDiagonalDer(700);
    						}
    						else
    						{
    						
								m.enfrenteDiagonalIzq(700);	
    						}
	    					
    					}	
					}
    
					if (direccion == 6)
					{	
						//Si el sensor de color detecta un borde de la cancha
						if (color.getColorID() == 6)
					    {
					    	m.enfrenteDiagonalDer(850);
							Delay.msDelay(400);
					    }
    					else
    					{
	    					m.enfrenteDiagonalIzq(500);
    					}
					}

					if (direccion == 7)
					{
						//Si el sensor de color detecta un borde de la cancha
						if (color.getColorID() == 6)
					    {
					    	m.enfrenteDiagonalIzq(850);
						    Delay.msDelay(400);
					    }
    					else
    					{
	    					m.enfrenteDiagonalDer(800);
							Delay.msDelay(400);
    					}
					}
     
					if (direccion == 8)
					{
						//Si el sensor de color detecta un borde de la cancha
						if (color.getColorID() == 6)
					    {
					    	m.atrasDiagonalIzq(850);
							Delay.msDelay(400);
					    }
    					else
    					{
	    					m.atrasDiagonalDer(850);
    					}
 					}

					if (direccion == 9)
					{
						//Si el sensor de color detecta un borde de la cancha
						if (color.getColorID() == 6)
					    {
					    	m.atrasDiagonalIzq(850);
							Delay.msDelay(400);
					    }
    					else
    					{
	    					m.atrasDiagonalDer(900);
    					}
					}
				}	
			}
			else
			
				//DETENER MOTORES
				m.parar();	
			}				
		}
    }

}
