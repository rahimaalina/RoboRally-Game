package dtu.roborally.CardTypes;

import dtu.roborally.Card;
import dtu.roborally.Robot;


public class Ucard extends Card {

    //North = 0, South = 2, East = 1, West = 3

    public Ucard() {
        super();
    }

    // Method to turn the robot u turn
    public void executeCard( Robot robot) {
        int x = robot.getx();
        int y = robot.gety();
        int direction = robot.getDirection();
        System.out.println("ucard");

        System.out.println("directionI: " + direction);
        direction += 2; // Add 2 for 180 degrees
        System.out.println("directionO: " + direction);

        if (direction > 3) {
            direction -= 4;
        }
        System.out.println("directionF: " + direction);

        robot.changeCoordinates(x,y,direction);
    }
    // Method to get the current orientation of the robot
}
