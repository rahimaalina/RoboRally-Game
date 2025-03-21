package dtu.roborally.utilities;

import dtu.roborally.*;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class PlayerDetails extends VBox {
    public PlayerDetails(ArrayList<String> playerNames) {
        super();
        setSpacing(30);

        // Label for indicating remaining lives
        Label label = new Label("Remaining Lives:");
        label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        getChildren().add(label); // Add the label to the VBox


        for(int PlayerIndicator = 0; PlayerIndicator < playerNames.size(); PlayerIndicator++) {


            Label name = new Label(playerNames.get(PlayerIndicator));
            name.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 28));

            // Load robot image
            ImageView robot = ImageHandler.loadFile("src/main/resources/robotImages/robot" + PlayerIndicator + ".png", "R"+PlayerIndicator, 40, 40);

            // Combine name and robot in an HBox
            HBox nameAndRobot = new HBox();
            nameAndRobot.getChildren().addAll(name, robot);

            VBox vbox = new VBox();
            vbox.setSpacing(10);
            vbox.getChildren().add(nameAndRobot);

            // Set lives
            HBox livesHB = new HBox();
            livesHB.setSpacing(10); // Set spacing between heart icons

            int lives = 10; // Default number of lives

            if(Game.getGame().getPlayers().get(PlayerIndicator).getRobot() != null) {
                lives = Game.getGame().getPlayers().get(PlayerIndicator).getRobot().getLives(); // Get lives of the player's robot
            }

            // Load heart icons for remaining lives
            for(int i = 0; i < lives; i++) {
                ImageView heartgraphics = ImageHandler.loadFile("src/main/resources/images/heart.png", "H", 20, 20);
                livesHB.getChildren().add(heartgraphics);
            }

            // now laod empty heart icons for remaining empty slots
            for(int i = 0; i < 10 - lives & i < 10; i++) {
                ImageView heartgraphics2 = ImageHandler.loadFile("src/main/resources/images/emptyHeart.png", "H1", 20, 20);
                livesHB.getChildren().add(heartgraphics2);
            }

            // we need to add lives to the VBox
            vbox.getChildren().add(livesHB);
            // add the VBox to the StatusOfPlayersConsole
            getChildren().add(vbox);
        }
    }
}
