package dtu.roborally.CardTypes;

import dtu.roborally.Card;
import dtu.roborally.Robot;

public class Move2 extends Card {
    private int finalx;

    private int finaly;

    public Move2() {
        super();
    }

    // Method to turn the robot forward 2
    //0 is North, 1 is East, 2 is South and 3 is West
    public void executeCard( Robot robot) {
        int x = robot.getx();
        int y = robot.gety();
        int direction = robot.getDirection();

        if (direction==0){
            finalx=x;
            finaly-=2;
        }

        if (direction==1){
            finalx=x+2;
            finaly=y;
        }

        if (direction==2){
            finalx=x;
            finaly=y+2;
        }

        if (direction==3){
            finalx=x-2;
            finaly=y;
        }
        robot.changeCoordinates(finalx,finaly,direction);

    }
}
