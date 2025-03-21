package dtu.roborally.controller;

import dtu.roborally.View.ViewRobo;
import dtu.roborally.utilities.GameScreen;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class RoboController {

    private Controller controller;
    private ViewRobo viewRobo;
    private Stage mainStage;


    private ArrayList<String> playerIDList;
    private ArrayList<GameScreen> GridPane = new ArrayList<>();
    private Pane root = new Pane();
    private Scene primaryscene = new Scene(root);

    public RoboController(Controller controller, Stage mainStage, ArrayList<String> playerIDList) {
        this.controller = controller;
        this.mainStage = mainStage;
        this.playerIDList = playerIDList;

        viewRobo = new ViewRobo(this);
    }

    public void display() {
    	Timeline timeline = new Timeline();
    	timeline.setCycleCount(GridPane.size());
    	
    	KeyFrame kf = new KeyFrame(Duration.seconds(1), event -> primaryscene.setRoot(GridPane.remove(0)));
    	
    	timeline.getKeyFrames().add(kf);
    	timeline.play();
    	
    	mainStage.setScene(primaryscene);
    }

    public void addBoardToList() {
    	GridPane.add(viewRobo.initialGUI());
    }

    public void endRound() {
    	if(!controller.hasWinner()) {
            controller.playersTurn(mainStage, 0);
    	} else {
            controller.crownWinner(mainStage);
    	}
    }

    public ArrayList<String> getPlayerIDList(){
        return playerIDList;
    }
}