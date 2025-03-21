package dtu.roborally.steps;

import dtu.roborally.CardTypes.*;
import dtu.roborally.Game;
import dtu.roborally.controller.Controller;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dtu.roborally.Card;
import dtu.roborally.Robot;
import dtu.roborally.Player;

public class RobotMovementStepsDef {
    Controller controller;
    Game game = Game.newGame(controller, 1, 1);
    Robot robot = new Robot(0,0,0);

    Card card;
    Player player = new Player();


    @Given("robot")
    public void robot() {
        player.initializeRobot(0,0,0);
    }

    @And("robot has x_coordinate {int} and y_coordinate is {int} and robot has direction {int}")
    public void robotHasX_coordinateAndY_coordinateIsAndRobotHasDirection(int arg0, int arg1, int arg2) {
        robot.initialCoordinates(0,0);
    }

    @When("the card is a Rightcard")
    public void theCardIsARightcard() {
        card = new Rightcard();
    }


    @When("the card is a Leftcard")
    public void theCardIsALeftcard() {
        card = new Leftcard();
    }

    @When("the card is a Ucard")
    public void theCardIsAUcard() {
        card = new Ucard();
    }

    @When("the card is a Move")
    public void theCardIsAMove() {
        card = new Move1();
        card = new Move2();
    }



    @Then("robot has x_coordinate {int} and has y_coordinate {int} and has direction {int}")
    public void robotHasX_coordinateAndHasY_coordinateAndHasDirection(int arg0, int arg1, int arg2) {
        if (card instanceof Rightcard) {
            robot.changeCoordinates(0,0,1);
        }
        if (card instanceof Leftcard) {
            robot.changeCoordinates(0,0,3);
        }
        if (card instanceof Ucard) {
            robot.changeCoordinates(0,0,2);
        }
        if (card instanceof Move1) {
            robot.changeCoordinates(0,1,0);
        }
        if (card instanceof Move2) {
            robot.changeCoordinates(0,2,0);

        }
    }


    @And("robot life")
    public void robotLife() {
        robot.getLives();
    }

    @When("robot life is less than {int}")
    public void robotLifeIsLessThan(int arg0) {
        robot.hit(50);
    }

    @Then("robot respawn")
    public void robotRespawn() {
        robot.resetLife();
    }




    @Given("robot has coordinate initial x")
    public void robotHasCoordinateInitialX() {
        robot.getStartPositionX();
    }

    @And("robot has coordinate initial y")
    public void robotHasCoordinateInitialY() {
        robot.getStartPositionY();
    }

    @And("robot has direction")
    public void robotHasDirection() {
        robot.getDirection();
    }

    @When("after a round")
    public void afterARound() {
    }

    @Then("robot has coordinate final x")
    public void robotHasCoordinateFinalX() {
        robot.getx();
    }

    @And("robot has coordinate final y")
    public void robotHasCoordinateFinalY() {
        robot.gety();
    }

    @And("robot has final direction")
    public void robotHasFinalDirection() {
        robot.getDirection();
    }
}