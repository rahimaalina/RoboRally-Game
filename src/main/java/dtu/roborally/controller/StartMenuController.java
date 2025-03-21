package dtu.roborally.controller;

import dtu.roborally.view.ViewStartMenu;
import javafx.stage.Stage;

//Controller responsible for managing the first scene where the number of players is set.
public class StartMenuController {
	
	private final Controller controller;
	private ViewStartMenu ViewStartMenu;
	private final Stage mainStage;

	public StartMenuController(Controller controller, Stage mainStage) {
		this.controller = controller;
		this.mainStage = mainStage;
		ViewStartMenu = new ViewStartMenu(this);

	}

	public void setName(int nbOfPlayers, int difficulty) {
		controller.newGame(nbOfPlayers, difficulty);
		controller.setName(mainStage);
	}


	public void display() {mainStage.setScene(ViewStartMenu.initialGUI());
	}


}