package dtu.roborally.view;

import dtu.roborally.Game;
import dtu.roborally.controller.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Scene for player names
 */
public class ViewNameOfPlayer {
	
	private NameOfPlayerController nameOfPlayerController;

	/**
	 * Constructor
	 * @param nameOfPlayerController (PlayerNameController)
	 */
	public ViewNameOfPlayer(NameOfPlayerController nameOfPlayerController) {
		this.nameOfPlayerController = nameOfPlayerController;
	}

	/**
	 * setup for scene with dimensions
	 * @return (Scene)
	 */
	public Scene initialGUI() {

		VBox PlayerNamesBo = new VBox();
        PlayerNamesBo.setSpacing(40);
        
        //add text fields
        for(int i = 0; i<Game.getGame().getPlayers().size(); i++) {
        	TextField textField = new TextField();
        	textField.setText("Player" + (i + 1));
        	setTextLimit(textField, 15);
        	nameOfPlayerController.newPlayer(i, textField.getText());
        	int PlayerIndex = i;
        	textField.textProperty().addListener((observable, oldValue, newValue) -> {
        		nameOfPlayerController.deletePlayer(PlayerIndex);
        		nameOfPlayerController.newPlayer(PlayerIndex, newValue);
        	});
        	PlayerNamesBo.getChildren().add(new VBox(textField));
			PlayerNamesBo.setAlignment(Pos.CENTER);
        }

        //add button
        Button ConfirmButton = new Button("CONFIRM");
		ConfirmButton.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
		ConfirmButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
		ConfirmButton.setPrefSize(150, 40);
		ConfirmButton.setOnAction(value -> nameOfPlayerController.goodLuck());
		ConfirmButton.setDefaultButton(true);

		Button BackButton = new Button("BACK");
		BackButton.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
		BackButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
		BackButton.setPrefSize(150, 40);
		BackButton.setOnAction(value -> {
			nameOfPlayerController.goBack();
		});
		
        PlayerNamesBo.getChildren().addAll(ConfirmButton, BackButton);
        PlayerNamesBo.setPadding(new Insets(20, 500, 0, 500));
		PlayerNamesBo.setAlignment(Pos.CENTER);
        
        return new Scene(PlayerNamesBo, 400, 200);
	}

	public static void setTextLimit(TextField textField, int length) {
			textField.setOnKeyTyped(event -> {
			String Name = textField.getText();

			if (Name.length() > length) {
				textField.setText(Name.substring(0, length));
				textField.positionCaret(Name.length());
				textField.setAlignment(Pos.CENTER);
			}
		});
	}

}
