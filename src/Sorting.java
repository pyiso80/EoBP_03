
import stanford.karel.Karel;

public class Sorting extends Karel {
   public void run() {
      goToEnd();
      //First row will be left as it is. This makes it easier to detect
      //end of the beeper columns.
      turnLeft();
      move();
      turnLeft();
      //Now Ready to pile beepers starting from 2nd row

      sortAsc();
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
   - Make rows of beepers on the left(i.e east side of Karel world) from
     consecutive beeper piles on a column.
   - Precondition: Karel is on the bottom-most pile facing north.
   - Postcondition: Each pile of beeper are spread to the left consecutively,
     starting from the left corner next to the pile.
    */
   void spreadBeeperPilesLeft() {
      while(beepersPresent()) {
         spreadABeeperPileLeft();
         comeBack();
         //move to next pile
         turnLeft();
         move();
      }
   }

   /*
   void sortDesc() {
      pileBeeperRows();

      goToTopPile();

      while (beepersPresent()) {
         spreadBeeperLeftToRight();
         goToTopPile();
      }
   }
   */

   /*
   void goToTopPile() {
      goToEnd();
      turnLeft();
      move();
      //go top
      while (beepersPresent()) {
         move();
      }

      turnLeft();
      turnLeft();
      move();
   }
   */

   /*
   void spreadBeeperLeftToRight() {
      while (beepersPresent()) {
         pickBeeper();
      }
      turnWest();
      moveToWall();
      turnEast();

      while (beepersInBag()) {
         putBeeper();
         move();
      }
   }
   */

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
         goToEnd();
         goToPilingCorner();
         pile();
         move(); //move to next row above
         turnLeft();//face west
         collectRow();
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

   void goToPilingCorner() {
      turnLeft();
      move();
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

   void spreadABeeperPileLeft() {
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