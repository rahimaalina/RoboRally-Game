package dtu.roborally.CardTypes;

import dtu.roborally.Card;
import dtu.roborally.Robot;

public class Move1 extends Card {
    private int finalx;
    private int finaly;

    // The current orientation
    //North = 0, South = 2, East = 1, West = 4

    public Move1() {
        super();
    }

    // Method to move one place the robot
    public void executeCard(Robot robot) {

        int x = robot.getx();
        int y = robot.gety();
        int direction = robot.getDirection();
        if (direction == 0) {
            finalx = x ;
            finaly = y - 1;
        }

        if (direction == 1) {
            finalx = x + 1;
            finaly = y;
        }

        if (direction == 2) {
            finalx = x;
            finaly = y + 1;
        }

        if (direction == 3) {
            finalx = x - 1;
            finaly = y;
        }

        robot.changeCoordinates(finalx,finaly,direction);

    }
}
