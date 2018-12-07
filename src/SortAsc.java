
import stanford.karel.Karel;

public class SortAsc extends Karel {
   public void run() {
      goToEnd();
      //First row will be left as it is. This makes it easier to detect
      //end of the beeper columns.
      turnLeft();
      move();
      turnLeft();
      //Now Ready to pile beepers starting from 2nd row
      collectRow();
      goToPilingCorner();
      pile();
      //sortAsc();
   }

   void sortAsc() {
      pileBeeperRows();
      goToEnd();
      //move to the first pile
      turnLeft();
      move();

      spreadBeeperPilesLeft();
   }

   /*
    - Pile beepers on each row at row end, here "end" means the first column on
      the right with no beepers initially.
    - Precondition: Karel is at the end of 2nd row, facing west.
    - Postcondition:Beepers on each row are piled at the end of respective rows.
      Karel is on the first row where(1) no beepers, facing against western wall.
    */
   void pileBeeperRows() {
      collectRow();
      while (beepersInBag()) {
         goToPilingCorner();
         pile();
         move(); //move to next row above
         turnLeft();//face west
         collectRow();
      }
   }

   /*
   - Make rows of beepers on the left(i.e east side of Karel world) from
     consecutive beeper piles on a column.
   - Precondition: Karel is on the bottom-most pile facing north.
   - Postcondition: Each pile of beeper are spread to the left consecutively,
     starting from the left corner next to the pile.
    */
   void spreadBeeperPilesLeft() {
      while(beepersPresent()) {
         convertPileToRow();
         comeBack();
         //move to next pile
         turnLeft();
         move();
      }
   }

   /*
   - Come back to the corner where the beeper pile was after spreading the beepers.
   - Precondition: Facing against western wall.
   - Postcondition: Karel is at the corner where the beeper pile was, facing east.
    */
   void comeBack() {
      turnLeft();
      turnLeft();
      while (beepersPresent()) {
         move();
      }
   }

   /*
   - Go to the corner where collected beepers from the row
   -
    */
   void goToPilingCorner() {
      goToEnd();
      //move to the bottom-most pile
      turnLeft();
      move();
      //move up to the corner above the top-most pile
      while (beepersPresent()) {
         move();
      }
   }

   /*
    - Go to the end of the bottom-most row of beepers.
    - Precondition: None
    - Postcondition: Karel is at the corner next to the last beeper on the
      bottom-most row.
    */
   void goToEnd() {
      positionAtOrigin();
      while(beepersPresent()) {
         move();
      }
   }

   void moveToWall() {
      while(frontIsClear()) {
         move();
      }
   }

   void convertPileToRow() {
      while(beepersPresent()) {
         pickBeeper();
      }
      turnLeft();
      while (beepersInBag()) {
         move();
         putBeeper();
      }
   }

   void collectRow() {
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

   void positionAtOrigin() {
      turnWest();
      moveToWall();
      turnSouth();
      moveToWall();
      turnEast();
   }


   void pile() {
      while(beepersInBag()) {
         putBeeper();
      }
   }

   void turnSouth() {
      while(notFacingSouth()) {
         turnLeft();
      }
   }

   void turnWest() {
      while(notFacingWest()) {
         turnLeft();
      }
   }

   void turnEast() {
      while (notFacingEast()) {
         turnLeft();
      }
   }
}
/*
Assumptions: Highest column is lower than the last row.
(1) Should ask the question how high each beeper column can be.


 */