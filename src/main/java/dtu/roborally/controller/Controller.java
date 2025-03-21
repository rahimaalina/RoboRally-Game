package dtu.roborally.controller;
import dtu.roborally.Game;
import dtu.roborally.Player;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Controller extends Application {

    private dtu.roborally.controller.StartMenuController startMenuController;
    private dtu.roborally.controller.NameOfPlayerController nameOfPlayerController;
    private dtu.roborally.controller.CreateRoboController createRoboController;
    private dtu.roborally.controller.PickingCardsController pickingCardsController;
    private dtu.roborally.controller.RoboController roboController;
    private dtu.roborally.controller.VictoryController victoryController;
    private dtu.roborally.controller.GoodLuckController goodLuckController;

    private boolean hasWinner;
    private String nameOfWinner;
    private ArrayList<String> playerNames;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        setStage(mainStage);
        startApplication(mainStage);
        mainStage.show();
    }

    public void setStage(Stage mainStage) {
        mainStage.setTitle("RoboRally");
        mainStage.setWidth(1300);
        mainStage.setHeight(830);
    }

    public void startApplication(Stage mainStage) {
        hasWinner = false;
        Game.clearGame();
        playerNames = new ArrayList<>();

        dtu.roborally.controller.StartMenuController startMenuController1 = new dtu.roborally.controller.StartMenuController(this, mainStage);
        startMenuController1.display();

    }

    public void newGame(int numberOfPlayers, int difficulty) {
        Game.newGame(this, numberOfPlayers, difficulty);
    }

    public void setName(Stage mainStage) {
        nameOfPlayerController = new dtu.roborally.controller.NameOfPlayerController(this, mainStage, playerNames);
        nameOfPlayerController.display();
    }





    public void initialPosition(Stage mainStage){
        createRoboController = new dtu.roborally.controller.CreateRoboController(this, mainStage, playerNames);
        createRoboController.display();
    }


    public void getRobot(Player player, int x, int y){
        player.initializeRobot(x, y, 1);
    }

    public void playersTurn(Stage mainStage, int numberOfPlayer) {
        if(numberOfPlayer < playerNames.size() && !hasWinner) {
            nextPlayer(mainStage, playerNames.get(numberOfPlayer), numberOfPlayer);
        } else {
            roboController = new dtu.roborally.controller.RoboController(this, mainStage, playerNames);
            Game.getGame().gameFlow();
            roboController.display();
        }
    }

    public void nextPlayer(Stage mainStage, String playerName, int numberOfPlayer) {
        pickCards(mainStage,numberOfPlayer);
    }


    public void pickCards(Stage mainStage, int numberOfPlayer) {
        Game.getGame().getPlayers().get(numberOfPlayer).getCards();
        pickingCardsController = new dtu.roborally.controller.PickingCardsController(this, mainStage, playerNames, numberOfPlayer);
        pickingCardsController.display();
    }


    public void notifyRobotMove() {
        roboController.addBoardToList();
    }

    public void goodJob(Stage mainStage){
        goodLuckController = new dtu.roborally.controller.GoodLuckController(this,mainStage,playerNames);
        goodLuckController.display();

    }



    public void notifyWin(int numberOfPlayer) {
        nameOfWinner = playerNames.get(numberOfPlayer);
        hasWinner = true;
    }

    public void crownWinner(Stage mainStage) {
        victoryController = new dtu.roborally.controller.VictoryController(this, mainStage, nameOfWinner);
        victoryController.display();
    }

    public boolean hasWinner() {
        return hasWinner;
    }


}

