import stanford.karel.Karel;

public class StreetSweeper extends Karel {

   public void run() {
      sweepAllStreets();

   }

   void sweepAllStreets() {
      while(leftIsClear()) {
         sweepFwd();
         comeBackToStartOfStreet();
         turnRight();
         move();
         turnRight();
      }
      sweepFwd();
   }
   void comeBackToStartOfStreet() {
      turnLeft();
      turnLeft();
      while(frontIsClear()) {
         move();
      }
   }

   void turnRight() {
      turnLeft();
      turnLeft();
      turnLeft();
   }



   void sweepFwd() {
      while(frontIsClear()) {
         if(beepersPresent()) {
            pickBeeper();
         }
         move();
      }
      if(beepersPresent()) {
         pickBeeper();
      }
   }



}
