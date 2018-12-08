
public class FasterSweeper extends stanford.karel.Karel{
   public void run() {
      sweepAll();
   }

   void sweepAll() {
      sweepTillEnd();
      turnNorth();
      while(frontIsClear()) {
         turnToNextStreet();
         sweepTillEnd();
         turnNorth();
      }
   }

   /*
   - Precondition: Karel is facing east or west.
   - Postcondition: Karel face in the north direction.
    */
   void turnNorth() {
      if(facingEast()) {
         turnLeft();
      }else {
         turnLeft();
         turnLeft();
         turnLeft();
      }
   }

   /*
   - Karel move to the next street. He'll be facing east if he is on the 1st
     column. He will be facing west if he is on the last column.
   - Precondition: Karel is at the first corner or last corner on a street,
     facing north.
   - Postcondition: Karel is on the next street, on the same column. He will
     be facing east if he is on the 1st column. He will be facing west if he
     is on last column.
    */
   void turnToNextStreet() {
      if(rightIsBlocked()) {
         move();
         turnLeft();
      }else {
         move();
         turnRight();
      }
   }

   /*
   - Karel sweep all beepers on a street.
   - Precondition: Karel is at the first corner on a street, facing east.
   - Postcondition: Karel is at the last corner on the same street, facing east.
    */
   void sweepTillEnd() {
      while(frontIsClear()) {
         sweepCorner();
         move();
      }
      sweepCorner();
   }

   void sweepCorner() {
      if(beepersPresent()) {
         pickBeeper();
      }
   }

   void turnRight() {
      turnLeft();
      turnLeft();
      turnLeft();
   }
}
