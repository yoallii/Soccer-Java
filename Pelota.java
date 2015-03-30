import lejos.nxt.addon.*;
import lejos.util.*;
import lejos.nxt.*;

public class Pelota
{
    
   	private ColorSensor color;
    private IRSeekerV2 infra;
    private CompassHTSensor brujula;
    private Movimientos m;
    private int direccion, orientacion;
    
    public IRSeekerV2 getInfra()
    { 
    
    	return infra;  

    }
    

    public Pelota(IRSeekerV2 infrarrojo, CompassHTSensor compas, Movimientos m, ColorSensor c)
    {
    
    	color = c;
		infra = infrarrojo;
		brujula = compas;
		this.m = m;
			 	  
    }

    public void buscaPelota()
    {
		
		while(!Button.ESCAPE.isDown())
		{

			LCD.drawInt(color.getColorID(),1,1);
			direccion = infra.getDirection();
			LCD.drawInt(direccion, 1,3);
			orientacion.resetCartesianZero();
			LCD.drawInt(orientacion, 1,5);
			LCD.clearDisplay();
			LCD.drawInt((int)sensor.getDegreesCartesian(),1,1);
			Delay.msDelay(100);			

			if (sensor.getDegreesCartesian() < 30)
			{
			
				m.frontAbackB(800);
			
			}
			
			if (sensor.getDegreesCartesian() > 120)
			{
			
				m.avanzarAC(800);
			
			}


			if (color.getColorID() == 1)
		    {
			    
			    m.detenerAB();
			    m.retrocederAB(900);
			    
			    try
			    {
				
					Thread.sleep(900);
				
				}
				
				catch (Exception e){}
		    
		    }
		    
		    else
		    {

            	if (direccion == 0)
            	{
            
            		m.detenerA();
            		m.frontCbackB(900);
            
            	}
		    
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
