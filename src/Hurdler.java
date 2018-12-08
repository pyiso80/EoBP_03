
import stanford.karel.Karel;

public class Hurdler extends Karel {
   public void run() {
      jumpAllHurdle();
   }

   void jumpAllHurdle() {
      for (int i = 0; i < 8; i++) {
            jumpOneHurdle();
      }
   }

   void jumpOneHurdle() {
      jumpUp();
      move();
      jumpDown();
   }

   void jumpDown() {
      turnRight();
      while (frontIsClear()) {
         move();
      }
      turnLeft();
   }

   void jumpUp() {
      turnLeft();
      while (rightIsBlocked()) {
         move();
      }
      turnRight();
   }

   void turnRight() {
      turnLeft();
      turnLeft();
      turnLeft();
   }
}