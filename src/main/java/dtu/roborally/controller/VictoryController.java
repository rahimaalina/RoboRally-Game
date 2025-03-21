package dtu.roborally.controller;

import dtu.roborally.view.ViewVictory;
import javafx.stage.Stage;

//this Controller is responsible for managing victory-related functionalites
public class VictoryController
{
    private dtu.roborally.controller.Controller controller; // this is the main controller
    private Stage mainStage; // Reference to the main stage
    private ViewVictory viewVictory; // View for displaying victory information


    // Constructor to initialize the VictoryController
    public VictoryController(dtu.roborally.controller.Controller controller, Stage mainStage, String winnerName)
    {
        this.controller = controller;
        this.mainStage = mainStage;
        viewVictory = new ViewVictory(this, winnerName);
    }

    //Method to start a new game, called when the user wants to start a new game

    //    public void newGame()
    public void newGame()
    {
        controller.startApplication(mainStage);
    }

    // Method to display the victory screen
    public void display()
    {
        mainStage.setScene(viewVictory.initialGUI());
    }
}
