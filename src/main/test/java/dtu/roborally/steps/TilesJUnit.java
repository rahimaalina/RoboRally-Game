package dtu.roborally.steps;

import dtu.roborally.*;
import org.junit.Test;
import static org.junit.Assert.*;



public class TilesJUnit {

    // Create Tiles objects for testing
    Tiles emptyTile = new Tiles("Empty",0);
    Tiles wallTile = new Tiles("Wall",0);
    Tiles bombTile = new Tiles("Bomb",1);
    Tiles lavaTile = new Tiles("Lava",4);
    Tiles lifeTile = new Tiles("Life",-3);
    Tiles startPointTile = new Tiles("Start Point",0);

    @Test
    public void testGetDamage() {
        // Create Tiles objects for testing

        // Check damage values for different tile types
        assertEquals(0, emptyTile.getDamage());
        assertEquals(1, bombTile.getDamage());
        assertEquals(4, lavaTile.getDamage());
    }

    @Test
    public void testGetID() {
        // Create Tiles objects for testing

        // Check IDs for different tile types
        assertEquals("Empty", emptyTile.getID());
        assertEquals("Life", lifeTile.getID());
        assertEquals("Start Point", startPointTile.getID());
    }

//    @Test
//    public void testRobotEnterExit() {
//
//        // Test robotEnter() and robotExit() methods for different tile types
//        assertTrue(emptyTile.robotEnter(0));
//        assertFalse(wallTile.robotEnter(0));
//
//        assertTrue(emptyTile.robotExit(1));
//        assertFalse(wallTile.robotExit(0));
//    }


//    @Test
//    public void testOccupiedRobot() {
//        // Create Tiles objects for testing
//        Tiles emptyTile = new Empty();
//        Tiles bombTile = new Bomb();
//
//        // Create Robot objects for testing
//        Robot robot1 = new Robot(0, 0, 0);
//        Robot robot2 = new Robot(1, 1, 1);
//
//        // Initially, occupied robot should be null
//        assertNull(emptyTile.getOccupiedRobot());
//        assertNull(bombTile.getOccupiedRobot());
//
//        // Set and check occupied robot
//        emptyTile.setOccupiedRobot(robot1);
//        assertEquals(robot1, emptyTile.getOccupiedRobot());
//
//        bombTile.setOccupiedRobot(robot2);
//        assertEquals(robot2, bombTile.getOccupiedRobot());
//
//        /* In the testOccupiedRobot() method, the initial menthods assertNull(emptyTile.getOccupiedRobot()) and
//    assertNull(bombTile.getOccupiedRobot()) are expected to pass, indicating that the getOccupiedRobot() method
//    should return null for both emptyTile and bombTile which makes sense as to why this test doesn't run and test true.*/
//    }
}
