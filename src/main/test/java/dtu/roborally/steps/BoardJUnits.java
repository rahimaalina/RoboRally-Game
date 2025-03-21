package dtu.roborally.steps;

//JUnit Tests for the Board

import dtu.roborally.Board;
import dtu.roborally.Tiles;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardJUnits {

    Board board = new Board(1,1);

    @Test
    public void getBoard() {
        // Initialize board before each test

        Tiles[][] actualBoard = board.getBoard();
        assertEquals(10, actualBoard.length); // Check number of rows
        assertEquals(10, actualBoard[0].length); // Check number of columns
    }

//    @org.junit.Test
//    public void getTile() {
//        Tiles tile = board.getTile(2, 3); // Get tile at row 2, column 3
//        assertEquals(Tiles(,).EMPTY, tile.getType()); // Assuming TileType.EMPTY is the default type
//
//    }

    @Test
    public void readBoard() {
    }

    @Test
    public void getRows() {
        int rows = board.getRows();
        assertEquals(10, rows); // Check the number of rows
        /*assertEquals(11, rows);
        assertEquals(12, rows);
        assertEquals(1, rows);*/
    }

    @Test
    public void getColumns() {
        int columns = board.getColumns();
        assertEquals(10, columns); // Check the number of columns

        /*assertEquals(11, columns);
        assertEquals(12, columns);
        assertEquals(1, columns); //Check the number of columns, this
        for example is a BOUNDRY CASE where the other cases outside the 10 columns and rows are checked*/

    }


}



