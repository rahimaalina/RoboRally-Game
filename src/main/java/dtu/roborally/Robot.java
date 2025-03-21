package dtu.roborally;

import static java.lang.Math.abs;

public class Robot {
    private int robotlife;


    private int x;
    private int y;
    private int direction;
    private int playerNumber;


    private int initX;

    private int initY;
    //init is initial


    public void initialCoordinates(int initX, int initY) {
        this.initX = initX;
        this.initY = initY;

    }


    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }
    public int getStartPositionX() {
        return initX;
    }
    public int getStartPositionY() {
        return initY;
    }

    public int getDirection() {
        return direction;
    }

    public boolean changeCoordinates(int x, int y, int direction) {
        int changeInX = x - this.x;
        int changeInY = y - this.y;
        int changeInDirection = this.direction - direction;


        Board board = Game.getGame().getBoard();

        // Check if there's a rotation (change in orientation)
        if (changeInDirection != 0) {
            this.direction = direction;
            return true;
        }

        // Direction is a 1D variable. It can either be +1 or -1. Used to identify which side it faces
        int face = (changeInX < 0 || changeInY < 0) ? -1 : 1;


        // A variable (change) is used to show if change occurs
        // the onX_Axis boolean variable is used to show if it is on the X or Y axis
        int change = 0;

        boolean onX_Axis;
        if (changeInX != 0)
        {
            change = changeInX;
            onX_Axis = true;
        }
        else if (changeInY != 0)
        {
            change = changeInY;
            onX_Axis = false;
        }
        else
        {
            onX_Axis = false;
            System.out.println("An error has occurred in calculating the changed position of the robot");
        }

        for (int i = 0; i < Math.abs(change); i++)
        {
            if (moveStep(face, onX_Axis, board))
            {
                System.out.println("test");

                hit(board.getTile(this.x,this.y).getDamage());
            }
            else
            {
                return false;
            }
        }
        return true;

    }

    private boolean moveStep(int face, boolean onX_axis, Board board)
    {
        int NTX;
        int NTY;
        Tiles nextTile;

        Tiles currentTile = board.getTile(this.x, this.y);

        if (onX_axis)
        {
            NTX = this.x + face;
            NTY = this.y;
        }
        else
        {
            NTX = this.x;
            NTY = this.y + face;
        }
        System.out.println("test1");
        System.out.println("x: " + this.x + " nexty: " + this.y + " face: " + face);
        System.out.println("test2");
        System.out.println("nextx: " + NTX + " nexty: " + NTY);


        if (!board.boundaryCheck(NTX, NTY)) {
            System.out.println("ttttt");
            resetLife();
            System.out.println("Error: The robot cannot leave the board's perimeter.");
            return false;
        }
        System.out.println("why");

        nextTile = board.getTile(NTX, NTY);

        // Determine the orientation of the movement. It starts facing north and turn clockwise
        int moveOri;

        if (onX_axis)
        {
            // If moving on the X-axis
            moveOri = face > 0 ? 1 : 3; // Set orientation based on direction
        }
        else
        {
            // If moving on the Y-axis
            moveOri = face > 0 ? 0 : 2; // Set orientation based on direction
        }

        // Two boolean variables are created showing the +/- values to enter and leave a square
        boolean moveIn = nextTile.robotEnter(moveOri);
        boolean moveOut = currentTile.robotExit(moveOri);

        if (!moveIn || !moveOut)
        {
            return false;
        }


        if (moveIn)
        {
            this.x = NTX;
            this.y = NTY;
            currentTile.setOccupied(false);
            nextTile.setOccupied(true);
            nextTile.setOccupiedRobot(this);
        }
        return true;
    }






    public void setRobot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }





    public Robot(int initialX, int initialY, int Ori)
    {
        initialCoordinates(initialX, initialY);
        setRobot(initialX, initialY, Ori);
        this.robotlife = 10;
    }


    //If robot stays at ex lava for 2 turns, then it gets damage again even if it doesnt move.
    public void hit(int damage) {
        robotlife -= damage;

        if (robotlife <= 0) {
            x = initX;
            y = initY;
            resetLife();
        }
    }


    public void resetLife() {
        this.x = getStartPositionX();
        this.y = getStartPositionY();
        this.direction = 1;
        this.robotlife = 10;
    }
    public int getLives() {
        return robotlife;
    }
}