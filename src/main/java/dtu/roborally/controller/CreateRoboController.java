package dtu.roborally.controller;

import dtu.roborally.Game;
import dtu.roborally.Player;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CreateRoboController {

    private dtu.roborally.controller.Controller controller;
    private dtu.roborally.view.ViewCreateRobo viewCreateRobo;
    private Stage mainStage;
    private int numberOfPlayers;

    private ArrayList<Player> players;


    public CreateRoboController(dtu.roborally.controller.Controller controller, Stage mainStage, ArrayList<String> playerIDList){
        this.controller = controller;
        this.mainStage = mainStage;
        players = Game.getGame().getPlayers();

        int playerID = choosingOrder();
        viewCreateRobo = new dtu.roborally.view.ViewCreateRobo(this, playerID, playerIDList);
    }


    public void display() {
        mainStage.setScene(viewCreateRobo.initialGUI());
    }


    public void nextPlayer(){
        if(!checkingPlayers()){
            int playerID = choosingOrder();
            viewCreateRobo.nextPlayerStart(playerID);
            display();
            System.out.println("nextplayer");
        } else {
            controller.playersTurn(mainStage, numberOfPlayers);
        }
    }


    public int choosingOrder(){
        System.out.println("RANDOM");
        int order = (int)Math.floor(Math.random()*players.size());
        if(players.get(order).getRobot() != null){ //the player already has a robot
            return choosingOrder();
        } else {
            return order;
        }
    }


    public boolean checkingPlayers(){
        for(Player p: players){
            System.out.println("checker: " + p.getRobot());
            if(p.getRobot() == null){
                return false;
            }
        }
        return true;
    }


    public void pickingRobot(int playerID, int x, int y){
        controller.getRobot(players.get(playerID), x, y);
    }
}