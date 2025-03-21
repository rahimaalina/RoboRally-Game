package dtu.roborally.CardTypes;

import dtu.roborally.Card;
import dtu.roborally.Robot;

public class Rightcard extends Card {
    public Rightcard() {
        super();
    }

    // Method to turn the robot right
    public void executeCard(Robot robot) {
        int x = robot.getx();
        int y = robot.gety();
        int direction = robot.getDirection();
        direction += 1; // Add 1 to turn right

        if (direction > 3) {
            direction -= 4;
        }
        robot.changeCoordinates(x,y,direction);
    }

}
