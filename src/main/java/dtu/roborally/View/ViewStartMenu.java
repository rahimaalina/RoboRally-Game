package dtu.roborally.view;

import dtu.roborally.controller.StartMenuController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * view for the SetNumberOfPlayer scene
 */
public class ViewStartMenu {

    private StartMenuController startMenuController;
    private int nbOfPlayers;

    /**
     * Constructor
     * @param PAC (SetNumberOfPlayersController)
     */
    public ViewStartMenu(StartMenuController PAC) {
        this.startMenuController = PAC;
    }

    /**
     * creates the Scene with a slider and a button to ask the controller to change Scene
     * @return Scene
     */
    public Scene initialGUI() {

        AtomicInteger buttonPlayer = new AtomicInteger(1);
        AtomicInteger buttonDifficulty = new AtomicInteger(1);

        Label roborally = new Label("Welcome to RoboRally!");
        roborally.setFont(Font.font("Comic Sans MS", 37));

        Label label1 = new Label("Choose number of players:");
        label1.setFont(Font.font("Comic Sans MS", 27));

        Label label2 = new Label("Choose difficulty:");
        label2.setFont(Font.font("Comic Sans MS", 27));

//        //set slider player amount
//        Slider sliderPlayer = new Slider(1, 4, 0);
//        sliderPlayer.setMajorTickUnit(1.0);
//        sliderPlayer.setMinorTickCount(0);
//        sliderPlayer.setSnapToTicks(true);
//        sliderPlayer.setShowTickMarks(true);
//        sliderPlayer.setShowTickLabels(true);
//
//        //set slider difficulty
//        Slider sliderDifficulty = new Slider(1, 3, 0);
//        sliderDifficulty.setMajorTickUnit(1.0);
//        sliderDifficulty.setMinorTickCount(0);
//        sliderDifficulty.setSnapToTicks(true);
//        sliderDifficulty.setShowTickMarks(true);
//        sliderDifficulty.setShowTickLabels(true);

        Button buttonPlayer1 = new Button("1");
        buttonPlayer1.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
        buttonPlayer1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 28));
        buttonPlayer1.setPrefSize(200, 50);
        buttonPlayer1.setDefaultButton(true);

        Button buttonPlayer2 = new Button("2");
        buttonPlayer2.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
        buttonPlayer2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 28));
        buttonPlayer2.setPrefSize(200, 50);
        buttonPlayer2.setDefaultButton(true);

        Button buttonPlayer3 = new Button("3");
        buttonPlayer3.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
        buttonPlayer3.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 28));
        buttonPlayer3.setPrefSize(200, 50);
        buttonPlayer3.setDefaultButton(true);

        Button buttonPlayer4 = new Button("4");
        buttonPlayer4.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
        buttonPlayer4.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 28));
        buttonPlayer4.setPrefSize(200, 50);
        buttonPlayer4.setDefaultButton(true);


        buttonPlayer1.setOnAction(value ->  {
            buttonPlayer1.setStyle("-fx-background-color: rgba(255,190,217,0.4); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonPlayer2.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonPlayer3.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonPlayer4.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");

            buttonPlayer.set(1);
        });
        buttonPlayer2.setOnAction(value ->  {
            buttonPlayer1.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonPlayer2.setStyle("-fx-background-color: rgba(255,190,217,0.4); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonPlayer3.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonPlayer4.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");

            buttonPlayer.set(2);
        });
        buttonPlayer3.setOnAction(value ->  {
            buttonPlayer1.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonPlayer2.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonPlayer3.setStyle("-fx-background-color: rgba(255,190,217,0.4); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonPlayer4.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");

            buttonPlayer.set(3);
        });
        buttonPlayer4.setOnAction(value ->  {
            buttonPlayer1.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonPlayer2.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonPlayer3.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonPlayer4.setStyle("-fx-background-color: rgba(255,190,217,0.4); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");

            buttonPlayer.set(4);
        });



        Button buttonDifficulty1 = new Button("1");
        buttonDifficulty1.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
        buttonDifficulty1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 28));
        buttonDifficulty1.setPrefSize(200, 50);
        buttonDifficulty1.setDefaultButton(true);


        Button buttonDifficulty2 = new Button("2");
        buttonDifficulty2.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
        buttonDifficulty2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 28));
        buttonDifficulty2.setPrefSize(200, 50);
        buttonDifficulty2.setDefaultButton(true);


        Button buttonDifficulty3 = new Button("3");
        buttonDifficulty3.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
        buttonDifficulty3.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 28));
        buttonDifficulty3.setPrefSize(200, 50);
        buttonDifficulty3.setDefaultButton(true);


        //set Button
        Button startGameButton = new Button("START GAME");
        startGameButton.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
        startGameButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 28));
        startGameButton.setPrefSize(250, 80);
        startGameButton.setDefaultButton(true);
        startGameButton.setOnAction(value ->  {

            startMenuController.setName(buttonPlayer.get(), buttonDifficulty.get());

        });

        buttonDifficulty1.setOnAction(value ->  {
            buttonDifficulty1.setStyle("-fx-background-color: rgba(255,190,217,0.4); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonDifficulty2.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonDifficulty3.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");

            buttonDifficulty.set(1);
        });
        buttonDifficulty2.setOnAction(value ->  {
            buttonDifficulty1.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonDifficulty2.setStyle("-fx-background-color: rgba(255,190,217,0.4); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonDifficulty3.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");

            buttonDifficulty.set(2);
        });
        buttonDifficulty3.setOnAction(value ->  {
            buttonDifficulty1.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonDifficulty2.setStyle("-fx-background-color: rgba(255,190,217,1); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
            buttonDifficulty3.setStyle("-fx-background-color: rgba(255,190,217,0.4); -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");

            buttonDifficulty.set(3);
        });



        VBox PlayerNamesBo = new VBox();
        PlayerNamesBo.setSpacing(40);

        //add nodes to the layout


        //add nodes to the layout
        VBox vbox1 = new VBox(roborally, label1);
        VBox vbox3 = new VBox(label2);
        VBox vbox4 = new VBox(startGameButton);

        HBox hboxP = new HBox(buttonPlayer1, buttonPlayer2, buttonPlayer3, buttonPlayer4);
        HBox hboxD = new HBox(buttonDifficulty1, buttonDifficulty2, buttonDifficulty3);
        vbox1.setAlignment(Pos.TOP_CENTER);
        vbox1.setSpacing(100);
        vbox3.setAlignment(Pos.TOP_CENTER);
        vbox3.setSpacing(50);
        vbox4.setAlignment(Pos.CENTER);
        vbox4.setSpacing(50);
        hboxP.setAlignment(Pos.CENTER);
        hboxP.setSpacing(50);
        hboxD.setAlignment(Pos.CENTER);
        hboxD.setSpacing(50);


        PlayerNamesBo.getChildren().addAll(vbox1,hboxP, vbox3, hboxD, vbox4);
        PlayerNamesBo.setPadding(new Insets(100, 150, 0, 150));

        return new Scene(PlayerNamesBo, 200, 200);
    }

}
