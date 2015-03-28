import lejos.nxt.addon.*;
import lejos.nxt.*;

public class Buscar1{
    
   	private ColorSensor color;
    private IRSeekerV2 infra;
    private Motores m;
    private int direccion;
    public IRSeekerV2 getInfra(){  return infra;  }
    

    public Buscar1(IRSeekerV2 infrarrojo, Motores m, ColorSensor c){
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
				m.izqAB(900);
			}
 
			if( direccion == 2 ){
				m.izqAB(700);
			}
         
			if( direccion == 3 ){
				m.izqAB(600);
			}

			if( direccion == 4 ){
				m.izqAB(300);
			}
   
			if( direccion == 5 ){
				m.avanzarAB(750);
			}
        
			if( direccion == 6 ){
				m.derAB(300);
			}
 
			if( direccion == 7 ){
				m.derAB(600);
			}
         
			if( direccion == 8 ){
				m.derAB(700);
			}

			if( direccion == 9 ){
				m.derAB(900);
			}

				try{
				Thread.sleep(50);
			}
			catch(Exception e){}
		}
		}

		
		
    }
}
   
   
   
   

