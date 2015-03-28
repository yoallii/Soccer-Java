import lejos.nxt.*;

public class Motores{

   private int velocidad;
   

   public int getVelocidad(){  return velocidad;  }
   
   public void setVelocidad(int vel){
      velocidad = vel;
      Motor.A.setSpeed(velocidad);
      Motor.B.setSpeed(velocidad);
   }



   public void avanzarA(int vel){
      Motor.A.setSpeed(vel);
      Motor.A.forward();
   }
   
   public void avanzarB(int vel){
      Motor.B.setSpeed(vel);
      Motor.B.forward();
   }

   public void avanzarC(int vel){
      Motor.C.setSpeed(vel);
      Motor.C.forward();
   }



   public void retrocederA(int vel){
      Motor.A.setSpeed(vel);
      Motor.A.backward();
   }
   
   public void retrocederB(int vel){
      Motor.B.setSpeed(vel);
      Motor.B.backward();
   }

   public void retrocederC(int vel){
      Motor.C.setSpeed(vel);
      Motor.C.backward();
   }
 

  
   public void detenerA(){
      Motor.A.stop();
   }
   
   public void detenerB(){
      Motor.B.stop();
   }

   public void detenerC(){
      Motor.C.stop();
   }


   public void detenerAB(){
      detenerA();
      detenerB();
   }
   
   public void detenerAC(){
      detenerA();
      detenerC();
   }

   public void detenerBC(){
      detenerB();
      detenerC();
   }


   public void avanzarAB(int vel){
      setVelocidad(vel);
      Motor.A.forward();
      Motor.B.forward();
   }

   public void avanzarAC(int vel){
      setVelocidad(vel);
      Motor.A.forward();
      Motor.C.forward();
   }

   public void avanzarBC(int vel){
      setVelocidad(vel);
      Motor.B.forward();
      Motor.C.forward();
   }



   public void retrocederAB(int vel){
      setVelocidad(vel);
      Motor.A.backward();
      Motor.B.backward();
   }

   public void retrocederAC(int vel){
      setVelocidad(vel);
      Motor.A.backward();
      Motor.C.backward();
   }

   public void retrocederBC(int vel){
      setVelocidad(vel);
      Motor.B.backward();
      Motor.C.backward();
   }


   
   public void izqAB(int vel){
      setVelocidad(vel);
      Motor.A.backward();
      Motor.B.forward();
   }

   public void izqAC(int vel){
      setVelocidad(vel);
      Motor.A.backward();
      Motor.C.forward();
   }

   public void izqBC(int vel){
      setVelocidad(vel);
      Motor.B.backward();
      Motor.C.forward();
   }



   public void derAB(int vel){
      setVelocidad(vel);
      Motor.A.forward();
      Motor.B.backward();
   }

   public void derAC(int vel){
      setVelocidad(vel);
      Motor.A.forward();
      Motor.C.backward();
   }

   public void derBC(int vel){
      setVelocidad(vel);
      Motor.B.forward();
      Motor.C.backward();
   }

}
