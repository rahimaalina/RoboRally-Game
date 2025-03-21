package dtu.roborally.utilities;

import java.util.ArrayList;

import dtu.roborally.*;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.image.ImageView;

public class GameBoardPane extends TilePane {

    private Board board;
    private int rows;
    private int cols = 10;

    private ArrayList<Player> players = Game.getGame().getPlayers();
    public GameBoardPane() {
        super();
        board = Game.getGame().getBoard();
        rows = board.getRows();
        cols = board.getColumns();

        // Set up the square pane and load the board squares
        GameBoardConstructor();
        // If players have robots, configure their positions on the board
        if (players.get(0).getRobot() != null) {
            RobotsConfiguration();
        }
    }


    public void GameBoardConstructor() {
        setPrefColumns(cols);
        setPrefRows(rows);

        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < cols; i++) {
                String squareID = board.getTile(i, j).getID();
                ImageView squareImageView = ImageHandler.loadFile("src/main/resources/tileImages/" + squareID + ".png", squareID, 50, 50);

                StackPane sp = new StackPane();
                sp.setId(squareID);
                sp.getChildren().add(squareImageView);

                getChildren().add(sp);
            }
        }
    }

    public void RobotsConfiguration() {
        for (int i = 0; i < players.size(); i++) {
            int x = players.get(i).getRobot().getx();
            int y = players.get(i).getRobot().gety();
            int o = players.get(i).getRobot().getDirection();

            int index = y * cols + x;

            ImageView robotImageView = ImageHandler.loadFile("src/main/resources/robotImages/robot" + i + ".png", "R" + i, 50, 50);
            robotImageView.setRotate(90 * o + 180);

            StackPane stack = (StackPane) getChildren().get(index);
            stack.getChildren().add(robotImageView);
        }
    }
}
