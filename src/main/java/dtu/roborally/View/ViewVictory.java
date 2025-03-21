package dtu.roborally.view;

import dtu.roborally.controller.VictoryController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * View for the win scene
 */
public class ViewVictory {
	
	private VictoryController GC;
	private String winnerName;

//
	public ViewVictory(VictoryController GC, String WinnerName) {
		this.GC = GC;
		this.winnerName = winnerName;
	}

//

	//create
	public Scene initialGUI() {

		
		HBox Lay = new HBox();
		Lay.setAlignment(Pos.CENTER);

		VBox Button = new VBox();
		Button.setSpacing(40);

		Label label = new Label("Congratulations " + winnerName + "!");
		label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));

		Button exit = new Button("EXIT");
		exit.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
		exit.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
		exit.setAlignment(Pos.CENTER);
		exit.setPrefSize(250, 20);

		exit.setOnAction(value -> {
			System.exit(0);
		});

		Button playAgain = new Button("PLAY AGAIN");
		playAgain.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 28));
	    playAgain.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");
	    playAgain.setAlignment(Pos.CENTER);
		playAgain.setPrefSize(250, 20);

		playAgain.setOnAction(value -> GC.newGame());


		Button.getChildren().addAll(playAgain, exit);
		Button.setAlignment(Pos.CENTER);
		Lay.getChildren().addAll(label, Button);
		Lay.setSpacing(80);

		return new Scene(Lay);
	}
}
