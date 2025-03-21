package dtu.roborally.CardTypes;

import dtu.roborally.Card;
import dtu.roborally.Robot;

public class Leftcard extends Card {
    //North = 0, South = 2, East = 1, West = 3

    public Leftcard() {
        super();
    }

    // Method to turn the robot left
    public void executeCard(Robot robot) {
        int x = robot.getx();
        int y = robot.gety();
        int direction = robot.getDirection();
        direction -= 1; // Subtract 1 to turn left

        if (direction < 0) {
            direction += 4;
        }
        robot.changeCoordinates(x,y,direction);
    }
    // Method to get the current orientation of the robot
}
