import stanford.karel.Karel;

public class StreetSweeper extends Karel {

   public void run() {
      sweepAllStreets();
   }

   private void sweepAllStreets() {
      while(leftIsClear()) {
         sweepUntilEnd();
         turnBack();
         turnToNxtSt();
      }
   }

   private void turnToNxtSt() {
      turnRight();
      move();
      turnRight();
   }

   private void turnBack() {
      turnLeft();
      turnLeft();
      while(frontIsClear()) {
         move();
      }
   }

   private void sweepUntilEnd() {
      while(frontIsClear()) {
         sweepOneCorner();
         move();
      }
      sweepOneCorner();
   }

   private void sweepOneCorner() {
      if(beepersPresent()) {
         pickBeeper();
      }
   }

   private void turnRight() {
      for(int i = 0; i < 3; i++) {
         turnLeft();
      }
   }
}
