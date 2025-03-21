package dtu.roborally.Model;

public abstract class Tiles {
    private Robot robot;
    private int intensity;
    private int damage;
    private String id;

    public Tiles() {

    }
    public int getDamage() {
        return damage;
    }

    void setIntensity(int intensity) {
        this.intensity = intensity;
        damage=intensity*damage;
    }

    public Tiles(String id, int damage) {
        this.damage = damage;
        this.id = id;
    }

    public boolean robotEnter(int directionRobot) {
        return true;
    }
    public boolean robotExit(int direction) {
        return true;
    }

    public void moveConveyor(int direction) {

    }

    public abstract void conveyorMovement(Robot robot);
//
//    //create damage method in robot
//    public void conveyorMovement(Robot robot) {
//
//    }

}


class Empty extends Tiles {
    public Empty() {
        super("Empty", 0);
    }

    @Override
    public void conveyorMovement(Robot robot) {

    }


}

class Life extends Tiles {
    public Life() {
        super("Life", -3);
    }

    @Override
    public void conveyorMovement(Robot robot) {

    }


}


class Bomb extends Tiles {
    public Bomb() {
        super("Bomb", 1);
    }

    @Override
    public void conveyorMovement(Robot robot) {

    }


}

class LaserLine extends Tiles {
    private int direction;
    public LaserLine(int direction) {
        super("Laser" + direction, 1);
    }

    @Override
    public void conveyorMovement(Robot robot) {

    }
}

class WallLaser extends Tiles {
    private int direction;
    public WallLaser(int direction) {
        super("WallLaser" + direction,1);
    }

    @Override
    public boolean robotEnter(int directionRobot) {
        if (direction == 0) {
            if (directionRobot == 2) {
                return false;
            }
        }
        if (direction == 1) {
            if (directionRobot == 3) {
                return false;
            }
        }
        if (direction == 2) {
            if (directionRobot == 0) {
                return false;
            }
        }
        if (direction == 3) {
            if (directionRobot == 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean robotExit(int directionRobot) {
        if (direction != directionRobot) {
            return false;
        }
        return true;
    }

    @Override
    public void conveyorMovement(Robot robot) {

    }
}


class Lava extends Tiles {
    public Lava() {
        super("Lava", 4);

    }

    @Override
    public void conveyorMovement(Robot robot) {

    }
}

class OilSpill extends Tiles {
    public OilSpill() {
        super("Oil",1);
    }

    @Override
    public void conveyorMovement(Robot robot) {

    }

}

class Pithole extends Tiles {
    public Pithole() {
        super("Pithole",10); //Robot dies and goes back to start.
    }

    @Override
    public void conveyorMovement(Robot robot) {

    }

}

class Wall extends Tiles {
    private int direction;

    public Wall(int direction) {
        super("Wall" + direction, 0);
    }

    public boolean robotEnter(int directionRobot) {
        if (direction == 0) {
            if (directionRobot == 2) {
                return false;
            }
        }
        if (direction == 1) {
            if (directionRobot == 3) {
                return false;
            }
        }
        if (direction == 2) {
            if (directionRobot == 0) {
                return false;
            }
        }
        if (direction == 3) {
            if (directionRobot == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean robotExit(int directionRobot) {
        if (direction != directionRobot) {
            return false;
        }
        return true;
    }

    @Override
    public void conveyorMovement(Robot robot) {

    }

}

class ConveyorBelt1 extends Tiles {
    // its prolly going through walls fix later

    private int finaly;
    private int finalx;
    private int x;
    private int y;
    private int directionTiles;
    private int directionRobot;
    public ConveyorBelt1(int directionTiles) {
        super("Conveyor Belt 1" + directionTiles,0);
        this.directionTiles=directionTiles;
    }


    @Override
    public void conveyorMovement(Robot robot) {
        this.x=robot.getx();
        this.y= robot.gety();
        this.directionRobot=robot.getDirection();

        if (directionTiles == 0) {
            finalx = x ;
            finaly = y + 1;
        }
        if (directionTiles == 1) {
            finalx = x + 1;
            finaly = y;
        }
        if (directionTiles == 2) {
            finalx = x;
            finaly = y - 1;
        }
        if (directionTiles == 3) {
            finalx = x - 1;
            finaly = y;
        }

        robot.changeCoordinates(finalx,finaly,directionRobot);
    }

}

class ConveyorBelt2 extends Tiles {
    // its prolly going through walls fix later

    private int finaly;
    private int finalx;
    private int x;
    private int y;
    private int directionTiles;
    private int directionRobot;
    public ConveyorBelt2(int directionTiles) {
        super("Conveyor Belt 2" + directionTiles,0);
        this.directionTiles=directionTiles;
    }


    @Override
    public void conveyorMovement(Robot robot) {
        this.x=robot.getx();
        this.y= robot.gety();
        this.directionRobot=robot.getDirection();

        if (directionTiles == 0) {
            finalx = x ;
            finaly = y + 2;
        }
        if (directionTiles == 1) {
            finalx = x + 2;
            finaly = y;
        }
        if (directionTiles == 2) {
            finalx = x;
            finaly = y - 2;
        }
        if (directionTiles == 3) {
            finalx = x - 2;
            finaly = y;
        }

        robot.changeCoordinates(finalx,finaly,directionRobot);
    }

}

class CheckPoint extends Tiles {
    public CheckPoint() {
        super("Check Point", 0);
    }

    @Override
    public void conveyorMovement(Robot robot) {

    }
}

class StartPoint extends Tiles {
    public StartPoint() {
        super("Start Point",0);

    }

    @Override
    public void conveyorMovement(Robot robot) {

    }
}

