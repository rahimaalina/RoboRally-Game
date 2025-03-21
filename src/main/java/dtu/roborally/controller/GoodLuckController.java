package dtu.roborally.controller;

import dtu.roborally.Player;
import dtu.roborally.view.ViewGoodLuck;
import dtu.roborally.view.ViewCreateRobo;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GoodLuckController {

    private dtu.roborally.controller.Controller controller;

    private ViewCreateRobo viewCreateRobo;
    private ViewGoodLuck viewGoodLuck;
    private Stage mainStage;

    private ArrayList<Player> players;

    public GoodLuckController(dtu.roborally.controller.Controller controller, Stage mainStage, ArrayList<String> nameOfPlayers) {
        this.controller = controller;
        this.mainStage = mainStage;
        viewGoodLuck = new ViewGoodLuck(this, nameOfPlayers);
    }

    public void startPosition() {
            controller.initialPosition(mainStage);
    }

    public void display() {
        mainStage.setScene(viewGoodLuck.initialGUI());
    }




}
