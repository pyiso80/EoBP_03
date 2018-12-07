
public class FasterSweeper extends stanford.karel.Karel{
   public void run() {
      sweepAll();
   }

   private void sweepAll() {
      sweepTillEnd();
      turnNorth();
      while(frontIsClear()) {
         turnToNextStreet();
         sweepTillEnd();
         turnNorth();
      }
   }

   private void turnNorth() {
      if(facingEast()) {
         turnLeft();
      }else {
         turnLeft();
         turnLeft();
         turnLeft();
      }
   }

   private void turnToNextStreet() {
      if(rightIsBlocked()) {
         move();
         turnLeft();
      }else {
         move();
         turnRight();
      }
   }

   public void sweepTillEnd() {
      while(frontIsClear()) {
         sweepCorner();
         move();
      }
      sweepCorner();
   }

   private void sweepCorner() {
      if(beepersPresent()) {
         pickBeeper();
      }
   }

   private void turnRight() {
      turnLeft();
      turnLeft();
      turnLeft();
   }
}
