import lejos.nxt.addon.*;
import lejos.nxt.*;

public class Pelota{
    
   	private ColorSensor color;
    private IRSeekerV2 infra;
    private int direccion;
    private Movimientos m;
    
    public Pelota(IRSeekerV2 infrarrojo, Motores m, ColorSensor c){
    	color=c;
		infra = infrarrojo;
		this.m = m;
			 	  
    }

    public void buscaPelota(){
		
		while( !Button.ESCAPE.isDown() ){



			LCD.drawInt(color.getColorID(),1,1);
			direccion = infra.getDirection();
					 
		    if (color.getColorID() == 1)
		    {
			    m.detenerAB();
			    m.retrocederAB(900);
			    try{
					Thread.sleep(900);
				}
				catch(Exception e){}
		    }
		    else{

		    
			if( direccion == 1 ){
				m.avanzarAB(350);
			}
 
			if( direccion == 2 ){
				m.avanzarAC(400);
				
			}
         
			if( direccion == 3 ){
				m.frontAbackB(450);
			}

			if( direccion == 4 ){
				m.frontAbackB(500);
   			}
			if( direccion == 5 ){
				m.backAfrontB(550);
						}
        
			if( direccion == 6 ){
				m.frontAC(500);
			}
 
			if( direccion == 7 ){
				m.frontAbackC(450);
			}
         
			if( direccion == 8 ){
				m.retrocederAC(400);
			}

			if( direccion == 9 ){
				m.frontAbackC(350);
			}

				try{
				Thread.sleep(50);
			}
			catch(Exception e){}
		
		}

		
		}
    }
}
   
   
   
   

