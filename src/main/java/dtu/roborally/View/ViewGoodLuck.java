package dtu.roborally.view;

import dtu.roborally.controller.GoodLuckController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ViewGoodLuck {
    private GoodLuckController goodLuckController;

    private ArrayList<String> nameOfPlayers;


    public ViewGoodLuck(GoodLuckController goodLuckController, ArrayList<String> nameOfPlayers) {
        this.goodLuckController = goodLuckController;
        this.nameOfPlayers = nameOfPlayers;

    }


    public Scene initialGUI() {


        Button ThankYouButton = new Button("GOOD LUCK!");
        ThankYouButton.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
        ThankYouButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        ThankYouButton.setPrefSize(150, 40);
        ThankYouButton.setOnAction(value -> goodLuckController.startPosition());
        ThankYouButton.setDefaultButton(true);


        return new Scene(ThankYouButton, 30, 50);


    }



}
