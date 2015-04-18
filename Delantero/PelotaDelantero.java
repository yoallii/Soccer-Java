//INTELIROBOT ESCUELA DE ROBÓTICA SLP
//intelirobot.com.mx
//Programador por Yoalli y Diego

//LIBRERIAS NECESARIAS.............
import lejos.nxt.addon.*; 	//Para sensor infrarrojo y compas
import lejos.util.*; // Para delay
import lejos.nxt.*; // Para motores y sensores en general
//..................................

//Clase Pelota...................................
public class PelotaDelantero
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
    //Atributos necesarios...............................
    private int direccion, orientacion,numeroAleatorio;
    private int lineaBlanca =1;
    
   //CONSTRUCTOR DE LA CLASE
    public PelotaDelantero(IRSeekerV2 infrarrojo, CompassHTSensor compas, MovimientosMejorados m, ColorSensor c,TouchSensor tacto)
    {
    
    	color = c;
		infra = infrarrojo;
		brujula = compas;
		this.m = m;
		touch = tacto;
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
			if(color.getColorID()==6)
			{
				lineaBlanca*=-1;
			}
			//.........................
			if(!touch.isPressed())
			{

			  	// si la brujula ve mayor de 30 y menor que 330 significa que esta chueco   
				if (brujula.getDegreesCartesian() > 35 && brujula.getDegreesCartesian()<330)
				{
					if(brujula.getDegreesCartesian() >= 180)
					// si la brujula ve mayor o igual a 180
					{
						do{
							m.detenerC();
							m.retrocederAB(500); // Se  alineara
							
							
						}while(brujula.getDegreesCartesian() < 340 );
						
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
    					
    					//Si el sensor de color detecta un borde de la cancha
						if (lineaBlanca < 1)
					    {
					    	m.detenerABC();
					    	Delay.msDelay(250);
					    	m.enfrente(900);
					    	Delay.msDelay(1000);
	    					lineaBlanca*=-1;
					    }
    					else
    					{
	    					m.atras(800);
 						}
    				}
			
					if (direccion == 1)
					{
						//Si el sensor de color detecta un borde de la cancha
						if (lineaBlanca < 1)
					    {
					    	m.detenerABC();
					    	Delay.msDelay(250);
					    	m.enfrenteDiagonalDer(900);
					    	Delay.msDelay(1000);
							lineaBlanca*=-1;
					    }
    					else
    					{
	    					m.atrasDiagonalIzq(900);
	    				}
					}

					if (direccion == 2)
					{
						//Si el sensor de color detecta un borde de la cancha
						if (lineaBlanca < 1)
					    {
					    	m.detenerABC();
					    	Delay.msDelay(250);
					    	m.enfrenteDiagonalDer(900);
					    	Delay.msDelay(1000);
					    	lineaBlanca*=-1;
					    }
    					else
    					{
	    					m.atrasDiagonalIzq(800);
    					}	
					}
     
					if (direccion == 3)
					{
						//Si el sensor de color detecta un borde de la cancha
						if (lineaBlanca < 1)
					    {
					    	m.detenerABC();
					    	Delay.msDelay(250);
					    	m.atrasDiagonalDer(900);
					    	Delay.msDelay(1000);
					    	lineaBlanca*=-1;
							
					    }
    					else
    					{
	    					
							m.enfrenteDiagonalIzq(750);
    					}	
					}

					if (direccion == 4)
					{
						//Si el sensor de color detecta un borde de la cancha
						if (lineaBlanca < 1)
					    {
					    	m.detenerABC();
					    	Delay.msDelay(250);
					    	m.atrasDiagonalDer(900);
					    	Delay.msDelay(1000);
					    	lineaBlanca*=-1;
							
					    }
    					else
    					{
	    					
							m.enfrenteDiagonalIzq(750);
    					}	
					}
		
					if (direccion == 5)
					{
						
						//Si el sensor de color detecta un borde de la cancha
						if (lineaBlanca < 1)
					    {
					    	m.detenerABC();
					    	Delay.msDelay(250);
					    	m.atrasDiagonalDer(900);
					  		Delay.msDelay(1000);
							lineaBlanca*=-1;
					    }
    					else
    					{
	    					m.enfrenteDiagonalIzq(700);
    					}
	    					
					}
    
					if (direccion == 6)
					{	
						//Si el sensor de color detecta un borde de la cancha
						if (lineaBlanca < 1)
					    {
					    	m.detenerABC();
					    	Delay.msDelay(250);
					    	m.atrasDiagonalIzq(900);
							Delay.msDelay(1000);
							lineaBlanca*=-1;
					    }
    					else
    					{
	    					m.enfrenteDiagonalDer(750);
    					}
					}

					if (direccion == 7)
					{
						//Si el sensor de color detecta un borde de la cancha
						if (lineaBlanca < 1)
					    {
					    	m.detenerABC();
					    	Delay.msDelay(250);
					    	m.atrasDiagonalIzq(900);
							Delay.msDelay(1000);
							lineaBlanca*=-1;
					    }
    					else
    					{
	    					m.enfrenteDiagonalDer(750);
    					}
					}
     
					if (direccion == 8)
					{
						//Si el sensor de color detecta un borde de la cancha
						if (lineaBlanca < 1)
					    {
					    	m.detenerABC();
					    	Delay.msDelay(250);
					    	m.enfrenteDiagonalIzq(900);
							Delay.msDelay(1000);
							lineaBlanca*=-1;
					    }
    					else
    					{
	    					m.atrasDiagonalDer(800);
    					}
 					}

					if (direccion == 9)
					{
						//Si el sensor de color detecta un borde de la cancha
						if (lineaBlanca < 1)
					    {
					    	m.detenerABC();
					    	Delay.msDelay(250);
					    	m.enfrenteDiagonalIzq(800);
							Delay.msDelay(1000);
							lineaBlanca*=-1;
					    }
    					else
    					{
	    					m.atrasDiagonalDer(900);
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
