package dtu.roborally.controller;

import java.util.ArrayList;

import dtu.roborally.view.ViewNameOfPlayer;
import javafx.stage.Stage;

public class NameOfPlayerController
{
    private Controller controller;
    private Stage mainStage;
    private ViewNameOfPlayer viewNameOfPlayer;
    private ArrayList<String> nameOfPlayers;


    public NameOfPlayerController(Controller controller, Stage mainStage, ArrayList<String> nameOfPlayers)
    {
        this.controller = controller;
        this.mainStage = mainStage;
        this.nameOfPlayers = nameOfPlayers;
        this.viewNameOfPlayer = new ViewNameOfPlayer(this);
    }

    public void goodLuck() {
        controller.goodJob(mainStage);
    }


    //addPLayerName to newName
    public void newPlayer(int numberName, String name)
    {
        nameOfPlayers.add(numberName, name);
    }

    public void display()
    {
        mainStage.setScene(viewNameOfPlayer.initialGUI());
    }

    public void deletePlayer(int numberName)
    {
        nameOfPlayers.remove(numberName);
    }

    public void goBack()
    {
        controller.startApplication(mainStage);
    }
}
