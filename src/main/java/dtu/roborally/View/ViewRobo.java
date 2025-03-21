package dtu.roborally.View;
import dtu.roborally.utilities.*;
import dtu.roborally.controller.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class ViewRobo {

    // The name of MovingRobotsController need to change
    private RoboController RC;

    public ViewRobo(RoboController RC){
        this.RC = RC;
    }


    // RoboRallyGridPane is need to be change in utilities to GameLayout
    public GameScreen initialGUI() {
        GameBoardPane board = new GameBoardPane();
        PlayerDetails panel = new PlayerDetails(RC.getPlayerIDList());

        GameScreen layout = new GameScreen(panel, board);
        VBox hbox = new VBox(continueButton(), exitButton(),emptyButton());

        hbox.setAlignment(Pos.CENTER_LEFT);

        hbox.setSpacing(20);
        layout.add(hbox, 1, 1, 1, 3);

//        layout.add(exitButton(), 1, 4, 1, 3);

        return layout;
    }

    public Button continueButton() {
        Button button = new Button("CONTINUE");
        button.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, FontPosture.ITALIC, 24));
        button.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");

        button.setOnAction(value -> {
            RC.endRound();

        });
        button.setDefaultButton(true);

        return button;
    }

    public Button exitButton() {

        Button button1 = new Button("QUIT GAME");
        button1.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, FontPosture.ITALIC, 24));
        button1.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");

        button1.setOnAction(value -> {
            System.exit(0);
        });

        button1.setDefaultButton(true);

        return button1;

    }

    public Button emptyButton() {

        Button button1 = new Button("                                                    ");
        button1.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, FontPosture.ITALIC, 24));
        button1.setStyle("-fx-background-color: #F4F4F4");


        button1.setDefaultButton(true);

        return button1;

    }
}

