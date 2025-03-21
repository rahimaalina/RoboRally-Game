package dtu.roborally.steps;

import dtu.roborally.*;
import dtu.roborally.controller.Controller;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardStepsDef {
    Controller controller;
    Game game = Game.newGame(controller,1,1);
    Player player = new Player();
    Board board = Game.getGame().getBoard();

    @Given("a board with <number_of_players> player\\(s) and difficulty level <difficulty>")
    public void aBoardWithNumber_of_playersPlayerSAndDifficultyLevelDifficulty() {
        board = new Board(2, 2);
    }

    @When("the board is initialized")
    public void theBoardIsInitialized() {
        board = Game.getGame().getBoard();
    }

    @Then("the board should be populated correctly based on specified difficulty")
    public void theBoardShouldBePopulatedCorrectlyBasedOnSpecifiedDifficulty() {
        assertEquals(1,board.getDifficulty());
    }

    @And("the robot moves out of the boundaries")
    public void theRobotMovesOutOfTheBoundaries() {
        player.initializeRobot(0,0,0);
        player.getRobot().changeCoordinates(-1,0,0);
        
    }

    @Then("robot stays in board")
    public void robotStaysInBoard() {
        assertEquals(0,player.getRobot().getx());
    }
}


