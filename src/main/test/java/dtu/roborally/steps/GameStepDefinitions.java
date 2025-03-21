package dtu.roborally.steps;

import dtu.roborally.controller.Controller;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import dtu.roborally.Game;
import dtu.roborally.Board;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dtu.roborally.Player;
import dtu.roborally.Robot;

import java.util.Objects;

public class GameStepDefinitions {



    Controller controller;



    Player player = new Player();
    Robot robot;
    Game game = Game.newGame(controller,1,1);
    Board board = new Board(0,0);


    @Given("a board")
    public void aBoard() {
        board.getBoard();
    }

    @And("number of players")
    public void numberOfPlayers() {
        game.getNumberOfPlayers();
    }


    @When("the player wants to")
    public void thePlayerWantsTo() {

    }

    @Then("clear the game")
    public void clearTheGame() {
        Game.clearGame();
    }





    @Given("a game")
    public void aGame() {
        game = new Game(1,1,controller);
    }

    @When("the robot is on the CheckPoint tile")
    public void theRobotIsOnTheCheckPointTile() {
        robot = new Robot(0,0,0);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Objects.equals(board.getTile(i, j).getID(), "Check Point")) {
                    robot.setRobot(i, j, 1);
                }
            }
        }

    }

    @Then("player wins")
    public void playerWins() {
        game.victory(0);
    }


}
