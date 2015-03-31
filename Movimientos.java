//INTELIROBOT ESCUELA DE ROBÓTICA SLP
//intelirobot.com.mx
//Programador por Yoalli y Diego

//libreria necesaria para motores
import lejos.nxt.*;

public class Movimientos
{
   //METODOS..............................................
   public void avanzarA(int vel)
   {
      Motor.A.setSpeed(vel);
      Motor.A.forward();
   }
   
   public void avanzarB(int vel)
   {
      Motor.B.setSpeed(vel);
      Motor.B.forward();
   }

   public void avanzarC(int vel)
   {
      Motor.C.setSpeed(vel);
      Motor.C.forward();
   }

   public void retrocederA(int vel)
   {
      Motor.A.setSpeed(vel);
      Motor.A.backward();
   }
   
   public void retrocederB(int vel)
   {
      Motor.B.setSpeed(vel);
      Motor.B.backward();
   }

   public void retrocederC(int vel)
   {
      Motor.C.setSpeed(vel);
      Motor.C.backward();
   }

   public void avanzarAB(int vel)
   {
      Motor.A.setSpeed(vel);
      Motor.A.forward();
      Motor.B.setSpeed(vel);
      Motor.B.forward();
   }

   public void avanzarAC(int vel)
   {
      Motor.A.setSpeed(vel);
      Motor.A.forward();
      Motor.C.setSpeed(vel);
      Motor.C.forward();
   }

   public void avanzarBC(int vel)
   {
      Motor.B.setSpeed(vel);
      Motor.B.forward();
      Motor.C.setSpeed(vel);
      Motor.C.forward();
   }

   public void retrocederAB(int vel)
   {
      Motor.A.setSpeed(vel);
      Motor.A.backward();
      Motor.B.setSpeed(vel);
      Motor.B.backward();
   }

   public void frontAbackB(int vel)
   {
      Motor.A.setSpeed(vel);
      Motor.A.forward();
      Motor.B.setSpeed(vel);
      Motor.B.backward();
   }
   
   public void retrocederAC(int vel)
   {
      Motor.A.setSpeed(vel);
      Motor.A.backward();
      Motor.B.setSpeed(vel);
      Motor.B.backward();
   }

   public void backAfrontB(int vel)
   {
      Motor.A.setSpeed(vel);
      Motor.A.backward();
      Motor.B.setSpeed(vel);
      Motor.B.forward();
   }

   public void frontBbackA(int vel)
   {
      Motor.A.setSpeed(vel);
      Motor.A.backward();
      Motor.B.setSpeed(vel);
      Motor.B.forward();
   }

   public void frontAbackC(int vel)
   {
      Motor.A.setSpeed(vel);
      Motor.A.forward();
      Motor.C.setSpeed(vel);
      Motor.C.backward();
   }

   public void retrocederBC(int vel)
   {
      Motor.B.setSpeed(vel);
      Motor.B.backward();
      Motor.C.setSpeed(vel);
      Motor.C.backward();
   }

   public void frontBbackC(int vel)
   {
      Motor.B.setSpeed(vel);
      Motor.B.forward();
      Motor.C.setSpeed(vel);
      Motor.C.backward();
   }

   public void detenerAB()
   {
      Motor.A.stop();
      Motor.B.stop();
   }
     public void detenerABC()
   {
      Motor.A.stop();
      Motor.B.stop();
      Motor.C.stop();
   }
   public void frontCbackB(int vel)
   {
      Motor.C.forward();
      Motor.C.setSpeed(vel);
      Motor.B.backward();
      Motor.B.setSpeed(vel); 
   }

   public void frontCbackA(int vel)
   {
      Motor.C.forward();
      Motor.C.setSpeed(vel);
      Motor.A.backward();
      Motor.C.setSpeed(vel); 
   }
 
   public void parar()
   {
      Motor.A.stop();
      Motor.B.stop();
      Motor.C.stop();
   }
 
   public void detenerA()
   {
      Motor.A.stop();
   }
 
   public void detenerB()
   {
      Motor.B.stop();
   }
   
   public void detenerC()
   {
      Motor.C.stop();
   }
}
