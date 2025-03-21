package dtu.roborally.Model;

public class Robot {
    private int robotlife;


    private int x;
    private int y;
    private int direction;
    private int finalx;
    private int finaly;
    private int playerNumber;

    private int colour;

    private int initrow;

    private int initcolumn;
    //init is initial

    private int finalrow;

    private int finalcolumn;

    private Player player;
    private Tiles obstacles;
    private Board board;

    public Robot(int x, int y, int ori) {
    }

    public void initialCoordinates(int initrow, int initcolumn) {
        this.initrow = initrow;
        this.initcolumn = initcolumn;

    }

    public void finalCoordinates(int finalrow, int finalcolumn) {
        this.finalrow = finalrow;
        this.finalcolumn = finalcolumn;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public void changeCoordinates(int x, int y, int direction) {
        this.x=x;
        this.y=y;
        this.direction=direction;
    }

    private int getplayerName(Player player) {
        return playerNumber;
    }

    public int getcolour() {
        return colour;
    }

    public Robot(Player player) {
        // player number refers to the order
        this.player = player;
    }

    //METHODS FOR ROBOT LIFE
    void setLives() {
        this.robotlife=10;
    }

    boolean hasLives() {
        if (robotlife>0) {
            return true;
        } else {
            return false;
        }
    }



    //If robot stays at ex lava for 2 turns, then it gets damage again even if it doesnt move.
    int hit() {
        robotlife -= obstacles.getDamage();
        return robotlife;
    }

    public int resetLife() {
        return robotlife = 10;
    }

    int getLives() {
        return robotlife;
    }

    public void move(int finalx, int finaly) {
        x = finalx;
        y = finaly;
        obstacles = board.getTile(x,y);
        hit();


    }

//    int move(int x1, int y1) {
//        Board board = new Board();
//        return board.move();
//    }


//    public static void main(String[] args) {
//        Robot r =  new Robot(new Player("Dimitra"));
//        r.setLives(10);
//
//
//        while(r.hasLives()) {
//            Obstacle laser = new Laser();
//            if (laser.equals(true)) {
//                System.out.println("Omg i got lazered");
//                laser.setIntensity(1);
//                r.hit(laser);
//            }
//
//            Obstacle lava = new Lava();
//            if (lava.equals(true)) {
//                System.out.println("i got burned");
//                lava.setIntensity((5));
//                r.hit(lava);
//            }
//
//            Obstacle oilspill = new oilSpill();
//            if (oilspill.equals(true)) {
//                System.out.println("i got oiled");
//                oilspill.setIntensity(3);
//                r.hit(oilspill);
//            }
//
//            Obstacle pothole = new Pothole();
//            if (pothole.equals(true)) {
//                System.out.println("i fell");
//                pothole.setIntensity(4);
//                r.hit(pothole);
//            }
//
//            Obstacle bomb = new Bomb();
//            if (bomb.equals(true)) {
//                System.out.println("I got bombed");
//                bomb.setIntensity(6);
//                r.hit(bomb);
//            }
//            System.out.println("Robot has now " + r.getLives() + " lives.");

//
//        }
//    }




}